package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.POJO.Cart;
import pl.coderslab.model.POJO.CourseCalculator;
import pl.coderslab.model.POJO.Round;
import pl.coderslab.model.POJO.RoundManager;
import pl.coderslab.model.entities.Coupon;
import pl.coderslab.model.entities.MatchProgress;
import pl.coderslab.model.entities.User;
import pl.coderslab.model.entities.VolleyballTeam;
import pl.coderslab.repositories.CouponRepository;
import pl.coderslab.repositories.RoundDao;
import pl.coderslab.repositories.UserRepository;
import pl.coderslab.repositories.VolleyballTeamRepository;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Controller
public class CouponCartController {

    private int idCounter = 0;
    private double fullCourse = 1;
    private Cart cart;


    @Autowired
    RoundManager roundManager;

    @Autowired
    CouponRepository couponRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VolleyballTeamRepository volleyballTeamRepository;

    @Autowired
    CourseCalculator courseCalculator;

    @GetMapping("/coupon")
    public String getCoupon(HttpSession session) {
        return "/coupon/userCoupon";
    }

    @GetMapping("/coupon/add/{roundNumber}/{matchNumber}/{choice}")
    public String addCart(@PathVariable long roundNumber, @PathVariable long matchNumber, @PathVariable int choice, HttpSession session) {

        List<Round> rounds = roundManager.getRounds();
        String match = RoundDao.findMatchInSpecificRound(rounds, roundNumber, matchNumber);
        Set<Cart> selectedMatches = (HashSet<Cart>) session.getAttribute("selectedMatches");
        String uuid;
        double betCourse = 0;
        fullCourse = 1;

        List<VolleyballTeam> orderedLeagueTable = volleyballTeamRepository.findAllByOrderByMainPointsDescAndWinSetsDesc();
        String[] teams = match.split("-");
        String selectedTeam = teams[choice - 1].trim();
        for (int i = 0; i < orderedLeagueTable.size(); i++) {
            orderedLeagueTable.get(i).setPlaceInTable(i + 1);
        }

        for (VolleyballTeam team : orderedLeagueTable) {
            if (team.getTeamMembers().equals(selectedTeam)) {
                betCourse = courseCalculator.calculateCourse((int) team.getPlaceInTable());
            }
        }
        if (selectedMatches == null || selectedMatches.size() == 0) {
            if (session.getAttribute("couponNumber") == null) {
                uuid = String.valueOf(UUID.randomUUID());
                session.setAttribute("couponNumber", uuid);
            } else {
                uuid = (String) session.getAttribute("couponNumber");
            }
            idCounter = 0;

            cart = new Cart(idCounter++, match, betCourse, choice);
            selectedMatches = new HashSet<>();
            selectedMatches.add(cart);

        } else {
            cart = new Cart(idCounter++, match, betCourse, choice);
            if (selectedMatches.contains(cart)) {
                for (Cart c : selectedMatches) {
                    if (c.getMatch().equals(cart.getMatch())) {
                        c.setChoice(cart.getChoice());
                        c.setSingleCourse(cart.getSingleCourse());
                    }
                }
            } else {
                selectedMatches.add(cart);
            }
        }
        for(Cart c : selectedMatches){
            fullCourse *= c.getSingleCourse();
        }
        session.setAttribute("fullCourse", Math.ceil((fullCourse * 100)) / 100);
        session.setAttribute("selectedMatches", selectedMatches);
        return "/coupon/userCoupon";
    }

    @GetMapping("/coupon/delete/{matchId}")
    public String deleteFromCart(@PathVariable long matchId, HttpSession session) {
        Set<Cart> selectedMatches = (HashSet<Cart>) session.getAttribute("selectedMatches");
        Cart cart = selectedMatches.stream().filter(item -> item.getId() == (int) matchId).findFirst().get();
        fullCourse /= cart.getSingleCourse();
        selectedMatches.remove(cart);
        session.setAttribute("fullCourse", fullCourse);
        return "/coupon/userCoupon";
    }

    @PostMapping("/coupon/**")
    public String processForm(@RequestParam double deposit, @RequestParam double possibleWin,
                              @RequestParam String couponNumber, HttpSession session) {
        Set<Cart> selectedMatches = (HashSet<Cart>) session.getAttribute("selectedMatches");
        User user = (User) session.getAttribute("loggedInUser");
        for (Cart cart : selectedMatches) {
            Coupon coupon = new Coupon(couponNumber, cart.getMatch(), cart.getChoice(), deposit, possibleWin, user);
            couponRepository.save(coupon);
        }
        if (user.getCash() > deposit) {
            double roundedDeposit = Math.floor((user.getCash() - deposit) * 100) / 100;
            user.setCash(roundedDeposit);
        }
        String newUUID = String.valueOf(UUID.randomUUID());
        session.setAttribute("loggedInUser", user);
        userRepository.save(user);
        session.setAttribute("couponNumber", newUUID);
        return "/coupon/userCoupon";
    }

    @GetMapping("/api/coupon")
    @ResponseBody
    public double getDepositValue(HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        return user.getCash();
    }

    @GetMapping("/coupon/deleteAll")
    public String removeAllMatchesFromCart(HttpSession session){
        Set<Cart> selectedMatches = (HashSet<Cart>) session.getAttribute("selectedMatches");
        selectedMatches.clear();
        session.setAttribute("selectedMatches",selectedMatches);
        return "/coupon/userCoupon";
    }

}
