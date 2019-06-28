package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.POJO.CouponsContainer;
import pl.coderslab.model.entities.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
