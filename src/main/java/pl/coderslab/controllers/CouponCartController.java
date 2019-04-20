package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.POJO.Cart;
import pl.coderslab.model.entities.CouponMatch;
import pl.coderslab.repositories.CouponMatchRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CouponCartController {

    @Autowired
    CouponMatchRepository couponMatchRepository;

    @GetMapping("/coupon/add/{id}")
    public String addCart(@PathVariable long id,@PathVariable long choice, HttpSession session){
        CouponMatch couponMatch = couponMatchRepository.findOne(id);
        Cart cart = new Cart();
        List<Cart> selectedMatches = (List<Cart>) session.getAttribute("selectedMatches");
        if(selectedMatches== null){
            selectedMatches = new ArrayList<>();
        }
        if(couponMatch != null){
            cart.toCart(couponMatch);
            session.setAttribute("selectedMatches", selectedMatches);
        }
        return "/coupon/userCoupon";
    }

}
