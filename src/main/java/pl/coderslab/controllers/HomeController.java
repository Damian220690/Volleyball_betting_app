package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



    @GetMapping("/privBet")
    public String showHomePage() {
        return "home/home";
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
