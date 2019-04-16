package pl.coderslab.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.POJO.Player;
import pl.coderslab.model.POJO.Round;
import pl.coderslab.model.POJO.RoundManager;
import pl.coderslab.repositories.VolleyballTeamRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    VolleyballTeamRepository volleyballTeamRepository;

    @GetMapping("/privBet")
    public String showHomePage() {
        return "home/home";
    }

    @GetMapping("/schedule")
    public String getMatchesSchedule(Model model) {
        RoundManager roundManager = new RoundManager();
        List<Round> rounds = roundManager.generateRounds(volleyballTeamRepository);
        model.addAttribute("rounds", rounds);

        return "pagesAfterLogin/liveMatchesList";
    }

    @GetMapping("api/schedule")
    @ResponseBody
    public String scheduleAsJson() {
        Player player = new Player();
        String result = player.pointsIncrement();
        Gson g = new Gson();
        String str = g.toJson(result);
        return str;
    }

}
