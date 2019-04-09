package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.model.POJO.MatchesSchedule;
import pl.coderslab.model.entities.VolleyballTeam;
import pl.coderslab.repositories.VolleyballTeamRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    VolleyballTeamRepository volleyballTeamRepository;

    @GetMapping("/")
    public String showHomePage(){
        return "home/home";
    }

    @GetMapping("/t")
    public String getMatchesSchedule(Model model){
        MatchesSchedule matchesSchedule = new MatchesSchedule();
        List<VolleyballTeam> teams = volleyballTeamRepository.findAll();
        List<String> teamMembers = new ArrayList<>();
        for(VolleyballTeam team : teams){
            teamMembers.add(team.getTeamMembers());
        }
        int counter = 2;
        model.addAttribute("numberOfRounds", counter);

        List<String[]> matches = matchesSchedule.generateMatchesSchedule(teamMembers);
        model.addAttribute("matches",matches);
        return "pagesAfterLogin/liveMatchesList";
    }

}
