package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.model.POJO.CouponsContainer;
import pl.coderslab.model.entities.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ControllerAdvice
public class DepositControllerAdvice {

    @Autowired
    CouponsContainer couponsContainer;


    @ModelAttribute
    public void showUserDeposit(Model model, HttpSession session){
        User user = (User) session.getAttribute("loggedInUser");
        if(user !=null) {
            HashMap<String,Double> winningsValue = couponsContainer.getWinningsValue();

            for(Iterator<Map.Entry<String, Double>> it = winningsValue.entrySet().iterator(); it.hasNext(); ){
                Map.Entry<String, Double> entry = it.next();
                user.setCash(user.getCash() + entry.getValue());
                entry.setValue(0.0);
            }
            double cash = user.getCash();
            model.addAttribute("deposit", cash);
        }
    }
}
