package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.model.POJO.Cart;
import pl.coderslab.model.POJO.Round;
import pl.coderslab.model.POJO.RoundManager;
import pl.coderslab.repositories.CouponMatchRepository;
import pl.coderslab.repositories.RoundDao;
import pl.coderslab.repositories.VolleyballTeamRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CouponCartController {

    private int idCounter = 0;
    private double fullCourse = 1;
    Cart cart;


    @Autowired
    CouponMatchRepository couponMatchRepository;

    @Autowired
    VolleyballTeamRepository volleyballTeamRepository;

    @GetMapping("/coupon")
    public String getCoupon(HttpSession session){
        List<Cart> selectedMatches = (List<Cart>) session.getAttribute("selectedMatches");
        return "/coupon/userCoupon";
    }

    @GetMapping("/coupon/add/{roundNumber}/{matchNumber}/{choice}")
    public String addCart(@PathVariable long roundNumber, @PathVariable long matchNumber, @PathVariable int choice, HttpSession session) {
        RoundManager roundManager = new RoundManager();
        List<Round> rounds = roundManager.generateRounds(volleyballTeamRepository);
        String match = RoundDao.findMatchInSpecificRound(rounds, roundNumber, matchNumber);
        List<Cart> selectedMatches = (List<Cart>) session.getAttribute("selectedMatches");
        if (selectedMatches == null || selectedMatches.size() == 0) {
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
        session.setAttribute("fullCourse",fullCourse);
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
        session.setAttribute("fullCourse",fullCourse);
        return "/coupon/userCoupon";
    }

}
