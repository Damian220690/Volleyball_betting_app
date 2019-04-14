package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.POJO.Player;
import pl.coderslab.model.POJO.Round;
import pl.coderslab.model.POJO.RoundManager;
import pl.coderslab.repositories.VolleyballTeamRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class CouponControllers {

    @Autowired
    VolleyballTeamRepository volleyballTeamRepository;

    @GetMapping("/addCoupon")
    public String addCoupon(Model model){
        RoundManager roundManager = new RoundManager();
        List<Round> rounds = roundManager.generateRounds(volleyballTeamRepository);
        model.addAttribute("rounds", rounds);
        return "/coupon/addCoupon";
    }
}
