package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.POJO.RoundManager;
import pl.coderslab.model.entities.MatchProgress;
import pl.coderslab.repositories.MatchesProgressRepository;

import java.util.List;

@Controller
public class VolleyballMatchController {

    @Autowired
    private MatchesProgressRepository matchesProgressRepository;

    @Autowired
    RoundManager roundManager;

    @GetMapping("/schedule")
    public String getMatchesSchedule(Model model) {
        model.addAttribute("rounds", roundManager.getRounds());
        return "matches/liveMatchesList";
    }

    @GetMapping("/api/schedule")
    @ResponseBody
    public List<MatchProgress> getMatchesResult() {
        List<MatchProgress> allMatches = matchesProgressRepository.findAll();
        return allMatches;
    }



    //    @GetMapping("api/schedule")
//    @ResponseBody
//    public String scheduleAsJson() {
//        String result = player.pointsIncrement();
//        Gson g = new Gson();
//        String str = g.toJson(result);
//        return str;
//    }

}
