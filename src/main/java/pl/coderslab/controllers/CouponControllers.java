package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.POJO.MatchesSchedule;
import pl.coderslab.model.entities.VolleyballTeam;
import pl.coderslab.repositories.VolleyballTeamRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CouponControllers {

    @Autowired
    VolleyballTeamRepository volleyballTeamRepository;

    @GetMapping("/addCoupon")
    public String addCoupon(Model model){
        MatchesSchedule matchesSchedule = new MatchesSchedule();
        List<VolleyballTeam> teams = volleyballTeamRepository.findAll();
        List<String> teamMembers = new ArrayList<>();
        for(VolleyballTeam team : teams){
            teamMembers.add(team.getTeamMembers());
        }

        List<String[]> matches = matchesSchedule.generateMatchesSchedule(teamMembers);
        System.out.println("matches");
        model.addAttribute("matches",matches);
        return "/coupon/addCoupon";
    }
}
