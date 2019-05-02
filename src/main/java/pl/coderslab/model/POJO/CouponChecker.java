package pl.coderslab.model.POJO;

import org.springframework.stereotype.Component;
import pl.coderslab.model.entities.Coupon;
import pl.coderslab.model.entities.MatchProgress;

@Component
public class CouponChecker {

    public CouponChecker(){
    }

    public boolean checkTheCouponMatch(Coupon coupon, MatchProgress matchProgress){
        String volleyballMatch = matchProgress.getTeam1() + ":" + matchProgress.getTeam2();
        boolean hasWon = false;
        if(coupon.getMatches().equals(volleyballMatch)) {
            if(coupon.getMatchType()==1){
                if(matchProgress.getSetsTeam1() > matchProgress.getPointsTeam2()){
                    hasWon = true;
                }
                else{
                    hasWon = false;
                }
            }
            else{
                if(matchProgress.getSetsTeam2() > matchProgress.getPointsTeam1()){
                    hasWon = true;
                }
                else{
                    hasWon = false;
                }
            }
        }
        return hasWon;
    }
}
