package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.POJO.RoundManager;
import pl.coderslab.model.entities.MatchProgress;
import pl.coderslab.repositories.MatchesProgressRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class CouponControllers {

    @Autowired
    RoundManager roundManager;

    @Autowired
    MatchesProgressRepository matchesProgressRepository;

    @GetMapping("api/matches")
    @ResponseBody
    public List<MatchProgress> getMatchesStatus(){
        List<MatchProgress> matchesProgress = matchesProgressRepository.findAll();
        return matchesProgress;
    }

    @GetMapping("/matches")
    public String addCoupon(Model model){
        model.addAttribute("rounds", roundManager.getRounds());
        return "/coupon/couponCreator";
    }

}
