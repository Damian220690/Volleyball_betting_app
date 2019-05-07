package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.entities.User;

import javax.servlet.http.HttpSession;

@Controller
public class UserAccountController {

    @GetMapping("/user/account")
    public String getUserAccount(){
        return "user/userAccount";
    }

    @PostMapping("/user/account")
    public String processUserAccount(@RequestParam double boost, HttpSession session){
        User user = (User) session.getAttribute("loggedInUser");
        double userCash = user.getCash() + boost;
        session.setAttribute("loggedInUser", user);
        return "redirect:/teamsTable";
    }
}
