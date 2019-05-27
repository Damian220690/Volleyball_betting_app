package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.POJO.Cart;
import pl.coderslab.model.POJO.Round;
import pl.coderslab.model.POJO.RoundManager;
import pl.coderslab.model.entities.Coupon;
import pl.coderslab.model.entities.MatchProgress;
import pl.coderslab.model.entities.User;
import pl.coderslab.repositories.CouponRepository;
import pl.coderslab.repositories.RoundDao;
import pl.coderslab.repositories.UserRepository;

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
        if (selectedMatches == null || selectedMatches.size() == 0) {
            if (session.getAttribute("couponNumber") == null) {
                uuid = String.valueOf(UUID.randomUUID());
                session.setAttribute("couponNumber", uuid);
            } else {
                uuid = (String) session.getAttribute("couponNumber");
            }

            fullCourse = 1;
            idCounter = 0;
            cart = new Cart(idCounter++, match, 2.0, choice);
            selectedMatches = new HashSet<>();
            selectedMatches.add(cart);

        } else {
            cart = new Cart(idCounter++, match, 2.0, choice);
            selectedMatches.add(cart);
        }
        fullCourse *= cart.getSingleCourse();
        session.setAttribute("fullCourse", fullCourse);
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
        else if (user.getCash() < deposit) {

            // when cash smaller than couponDeposit set max value on the form input to cash value
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

}
