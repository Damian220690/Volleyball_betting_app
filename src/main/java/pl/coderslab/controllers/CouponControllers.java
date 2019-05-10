package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.POJO.RoundManager;

@Controller
@RequestMapping("/")
public class CouponControllers {

    @Autowired
    RoundManager roundManager;

    @GetMapping("/matches")
    public String addCoupon(Model model){
        model.addAttribute("rounds", roundManager.getRounds());
        return "/coupon/couponCreator";
    }

}
