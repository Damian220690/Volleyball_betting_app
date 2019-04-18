package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.model.entities.CouponMatch;
import pl.coderslab.repositories.CouponMatchRepository;

import java.util.List;

@Controller
public class CouponCartController {

    @Autowired
    CouponMatchRepository couponMatchRepository;

    @GetMapping("/newCoupon")
    public String getCouponPanel(Model model){
        List<CouponMatch> selectedMatches = couponMatchRepository.findAll();
        model.addAttribute("selectedMatches", selectedMatches);
        return "/coupon/userCoupon";
    }

}
