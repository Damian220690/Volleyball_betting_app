package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.entities.VolleyballTeam;
import pl.coderslab.repositories.VolleyballTeamRepository;

import java.util.List;

@Controller
public class MatchesDetailsController {

    @Autowired
    VolleyballTeamRepository volleyballTeamRepository;

    @GetMapping("/teamsTable")
    public String showPageAfterLogin(Model model){
        model.addAttribute("volleyballTeams", volleyballTeamRepository.findAllByOrderByMainPointsDescAndWinSetsDesc());
        return "pagesAfterLogin/teamsTable";
    }




}
