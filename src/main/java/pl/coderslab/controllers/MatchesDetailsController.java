package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.repositories.VolleyballTeamRepository;

@Controller
public class MatchesDetailsController {

    @Autowired
    VolleyballTeamRepository volleyballTeamRepository;

    @GetMapping("/teamsTable")
    public String showPageAfterLogin(Model model){
        model.addAttribute("volleyballTeams", volleyballTeamRepository.findAll());
        return "pagesAfterLogin/teamsTable";
    }
}
