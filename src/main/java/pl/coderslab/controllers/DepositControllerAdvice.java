package pl.coderslab.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.model.entities.User;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class DepositControllerAdvice {
    @ModelAttribute
    public void showUserDeposit(Model model, HttpSession session){
        User user = (User) session.getAttribute("loggedInUser");
        if(user !=null) {
            double cash = user.getCash();
            model.addAttribute("deposit", cash);
        }
    }
}
