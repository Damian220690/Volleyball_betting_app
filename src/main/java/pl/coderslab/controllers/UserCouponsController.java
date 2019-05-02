package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.model.POJO.CouponChecker;
import pl.coderslab.model.entities.Coupon;
import pl.coderslab.model.entities.MatchProgress;
import pl.coderslab.model.entities.User;
import pl.coderslab.repositories.CouponRepository;
import pl.coderslab.repositories.MatchesProgressRepository;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserCouponsController {

    @Autowired
    CouponChecker couponChecker;

    @Autowired
    CouponRepository couponRepository;

    @Autowired
    MatchesProgressRepository matchesProgressRepository;

    @GetMapping("/user/coupons")
    public String getUsersCoupons(Model model) {
//        Coupon coupon = couponRepository.findOne(1L);
//        System.out.println(coupon.getMatches());
//        MatchProgress matchProgress = matchesProgressRepository.findByTeam1AndTeam2("Jacek Dębowski / Damian Niewęgłowski", "Wojciech Biały / Dominik Kaliszewski");
//        System.out.println(matchProgress);
//        boolean b = couponChecker.checkTheCouponMatch(coupon, matchProgress);
//        System.out.println(b);
        List<Coupon> coupons = couponRepository.findAll();
        System.out.println(coupons);
        Set<Coupon> couponSet = new LinkedHashSet();
        System.out.println(coupons.get(0));
        System.out.println(coupons.get(1));
        System.out.println(coupons.get(0).equals(coupons.get(0)));

        System.out.println(couponSet);
        model.addAttribute("coupons",couponSet);
        return "coupon/userCouponsHistory";
    }

    @GetMapping("user/coupons/1")
    public String getDetailsAboutCoupon() {

        return "coupon/couponDetails";
    }

}
