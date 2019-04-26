package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.POJO.Cart;
import pl.coderslab.model.POJO.Round;
import pl.coderslab.model.POJO.RoundManager;
import pl.coderslab.model.entities.Coupon;
import pl.coderslab.model.entities.User;
import pl.coderslab.repositories.CouponRepository;
import pl.coderslab.repositories.RoundDao;
import pl.coderslab.repositories.VolleyballTeamRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class CouponCartController {

    private int idCounter = 0;
    private double fullCourse = 1;
    private Cart cart;


    @Autowired
    VolleyballTeamRepository volleyballTeamRepository;

    @Autowired
    CouponRepository couponRepository;

    @GetMapping("/coupon")
    public String getCoupon(HttpSession session) {
        List<Cart> selectedMatches = (List<Cart>) session.getAttribute("selectedMatches");
        return "/coupon/userCoupon";
    }

    @GetMapping("/coupon/add/{roundNumber}/{matchNumber}/{choice}")
    public String addCart(@PathVariable long roundNumber, @PathVariable long matchNumber, @PathVariable int choice, HttpSession session) {
        RoundManager roundManager = new RoundManager();
        List<Round> rounds = roundManager.generateRounds(volleyballTeamRepository);
        String match = RoundDao.findMatchInSpecificRound(rounds, roundNumber, matchNumber);
        List<Cart> selectedMatches = (List<Cart>) session.getAttribute("selectedMatches");
        UUID uuid;
        if (selectedMatches == null || selectedMatches.size() == 0) {
            if(session.getAttribute("couponNumber") == null){
                uuid = UUID.randomUUID();
                session.setAttribute("couponNumber", uuid);
            }
            else{
                uuid = (UUID) session.getAttribute("couponNumber");
            }

            fullCourse = 1;
            idCounter = 0;
            cart = new Cart(idCounter++, match, 2.0, choice);
            selectedMatches = new ArrayList<>();
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
        List<Cart> selectedMatches = (List<Cart>) session.getAttribute("selectedMatches");
        System.out.println(matchId);
        Cart cart = selectedMatches.get((int) matchId);
        fullCourse /= cart.getSingleCourse();
        selectedMatches.remove(cart);
        session.setAttribute("fullCourse", fullCourse);
        return "/coupon/userCoupon";
    }

    @PostMapping("/coupon/**")
    @ResponseBody
    public String processForm(@RequestParam double deposit, @RequestParam double possibleWin,
                              @RequestParam String couponNumber, HttpSession session) {
        List<Cart> selectedMatches = (List<Cart>) session.getAttribute("selectedMatches");
        User user = (User) session.getAttribute("loggedInUser");
        for(Cart cart : selectedMatches){
            Coupon coupon = new Coupon(UUID.fromString(couponNumber), cart.getMatch(),cart.getChoice(), deposit, possibleWin, user);
            couponRepository.save(coupon);
        }
        UUID newUUID = UUID.randomUUID();
        session.setAttribute("couponNumber", newUUID);
        return null;
    }
}
