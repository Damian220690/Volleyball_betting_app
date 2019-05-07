package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.POJO.CouponChecker;
import pl.coderslab.model.POJO.CouponDetails;
import pl.coderslab.model.POJO.CouponStatus;
import pl.coderslab.model.entities.Coupon;
import pl.coderslab.model.entities.MatchProgress;
import pl.coderslab.model.entities.User;
import pl.coderslab.repositories.CouponRepository;
import pl.coderslab.repositories.MatchesProgressRepository;

import javax.servlet.http.HttpSession;
import java.util.*;

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
        List<Coupon> coupons = couponRepository.findAll();
        List<Coupon> couponsWithoutDuplicates = new ArrayList<>();

        for (Coupon coupon : coupons) {
            List<Coupon> tempList = ((List) ((ArrayList) couponsWithoutDuplicates).clone());
            if (couponsWithoutDuplicates.size() == 0) {
                couponsWithoutDuplicates.add(coupon);
            } else {
                if (!(coupon.getCouponsNumber().equals(tempList.get(tempList.size() - 1).getCouponsNumber()))) {
                    couponsWithoutDuplicates.add(coupon);
                }
            }
        }
        model.addAttribute("coupons", couponsWithoutDuplicates);
        return "coupon/userCouponsHistory";
    }


    @GetMapping("/user/coupons/app")
    @ResponseBody
    public List<CouponDetails> processUsersCoupons(Model model, HttpSession session) {
        List<Coupon> coupons = couponRepository.findAll();
        List<Coupon> couponsWithoutDuplicates = new ArrayList<>();
        List<MatchProgress> allMatchesProgress = matchesProgressRepository.findAll();
        User user = (User) session.getAttribute("loggedInUser");
        CouponDetails couponDetails = new CouponDetails();
        double value = 0;

        for (Coupon coupon : coupons) {
            List<Coupon> tempList = ((List) ((ArrayList) couponsWithoutDuplicates).clone());
            List<CouponStatus> statuses = new ArrayList<>();

            String couponNumber = coupon.getCouponsNumber();
            List<Coupon> allByCouponsNumber = couponRepository.findAllByCouponsNumber(couponNumber);
            List<CouponDetails> infoAboutUserCoupons = couponDetails.getInfoAboutUserCoupons(allByCouponsNumber, allMatchesProgress);
            for(CouponDetails detail : infoAboutUserCoupons){
                    statuses.add(detail.getCouponStatus());
            }
            if (!statuses.contains(null) && !statuses.contains(CouponStatus.LOST)) {
                for (CouponDetails detail : infoAboutUserCoupons) {
                    detail.setCouponStatus(CouponStatus.WON);
                }
                value = coupon.getPossibleWin();
            }
            else if (statuses.contains(CouponStatus.LOST)) {
                for (CouponDetails detail : infoAboutUserCoupons) {
                    detail.setCouponStatus(CouponStatus.LOST);
                }
            }

            if (couponsWithoutDuplicates.size() == 0) {
                couponsWithoutDuplicates.add(coupon);
            } else {
                if (!(coupon.getCouponsNumber().equals(tempList.get(tempList.size() - 1).getCouponsNumber()))) {
                    couponsWithoutDuplicates.add(coupon);
                }
            }

        }
//        user.setCash(user.getCash() + value);
//        session.setAttribute("loggedInUser",user);
//        System.out.println("value: "+ value);
//        System.out.println("user "+user.getCash());
        List<CouponDetails> infoAboutUserCoupons = couponDetails.getInfoAboutUserCoupons(couponsWithoutDuplicates, allMatchesProgress);
        model.addAttribute("coupons", infoAboutUserCoupons);
        return infoAboutUserCoupons;
    }

    @GetMapping("user/coupons/{couponNumber}/app")
    @ResponseBody
    public List<CouponDetails> processDetailsAboutCoupon(@PathVariable String couponNumber, Model model) {
        List<Coupon> chosenCoupons = couponRepository.findAllByCouponsNumber(couponNumber);
        List<MatchProgress> allMatchesProgress = matchesProgressRepository.findAll();

        CouponDetails couponDetails = new CouponDetails();
        List<CouponDetails> fullDetailsAboutCouponMatch = couponDetails.getFullDetailsAboutCouponMatch(chosenCoupons, allMatchesProgress);
        return fullDetailsAboutCouponMatch;
    }

    @GetMapping("user/coupons/{couponNumber}")
    public String getDetailsAboutCoupon(@PathVariable String couponNumber, Model model) {
        List<Coupon> chosenCoupons = couponRepository.findAllByCouponsNumber(couponNumber);
        double possibleWin = chosenCoupons.get(chosenCoupons.size() - 1).getPossibleWin();
        double deposit = chosenCoupons.get(chosenCoupons.size() - 1).getDeposit();
        double fullCourse = possibleWin / deposit;

        CouponDetails couponDetails = new CouponDetails();
        List<CouponDetails> fullDetailsAboutCouponMatch = couponDetails.getInitialDetailsAboutCouponMatch(chosenCoupons);
        model.addAttribute("fullDetailsAboutCouponMatch", fullDetailsAboutCouponMatch);
        model.addAttribute("fullCourse", fullCourse);
        model.addAttribute("deposit", deposit);
        model.addAttribute("possibleWin", possibleWin);
        return "coupon/couponDetails";
    }

}
