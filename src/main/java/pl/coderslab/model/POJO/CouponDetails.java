package pl.coderslab.model.POJO;

import pl.coderslab.model.entities.Coupon;
import pl.coderslab.model.entities.MatchProgress;

import java.util.ArrayList;
import java.util.List;

public class CouponDetails {
    private long matchId;
    private String match;
    private int matchType;
    private int setTeam1;
    private int setTeam2;
    private String matchStatus;
    private CouponStatus couponStatus;
    private String couponNumber;


    public CouponDetails(long matchId, String match, int matchType, int setTeam1, int setTeam2, String matchStatus,String couponNumber) {
        this.matchId = matchId;
        this.match = match;
        this.matchType = matchType;
        this.setTeam1 = setTeam1;
        this.setTeam2 = setTeam2;
        this.matchStatus = matchStatus;
        this.couponNumber = couponNumber;
    }

    public CouponDetails() {
    }

    public List<CouponDetails> getFullDetailsAboutCouponMatch(List<Coupon> coupons, List<MatchProgress> matchProgresses) {
        List<CouponDetails> fullDetailsAboutCouponMatch = new ArrayList<>();

        for (Coupon coupon : coupons) {
            String[] teams = coupon.getMatches().split("-");
            String team1 = teams[0];
            String team2 = teams[1];
            for (MatchProgress matchProgress : matchProgresses) {
                if (team1.equals(matchProgress.getTeam1()) && team2.equals(matchProgress.getTeam2())) {
                    {
                        fullDetailsAboutCouponMatch.add(new CouponDetails(coupon.getId(), coupon.getMatches(), coupon.getMatchType(),
                                matchProgress.getSetsTeam1(), matchProgress.getSetsTeam2(), matchProgress.getMatchStatus(), coupon.getCouponsNumber()));
                    }
                }
            }
        }
        return fullDetailsAboutCouponMatch;
    }

    public List<CouponDetails> getInitialDetailsAboutCouponMatch(List<Coupon> coupons) {
        List<CouponDetails> initialDetailsAboutCouponMatch = new ArrayList<>();
        for (Coupon coupon : coupons) {
            initialDetailsAboutCouponMatch.add(new CouponDetails(coupon.getId(), coupon.getMatches(), coupon.getMatchType(), 0, 0, "FUTURE",coupon.getCouponsNumber()));
        }
        return initialDetailsAboutCouponMatch;
    }



    public List<CouponDetails> getInfoAboutUserCoupons(List<Coupon> coupons, List<MatchProgress> matchProgresses) {
        List<CouponDetails> detailsAboutCoupon = new ArrayList<>();

        for (Coupon coupon : coupons) {
            String[] teams = coupon.getMatches().split("-");
            String team1 = teams[0];
            String team2 = teams[1];
            for (MatchProgress matchProgress : matchProgresses) {
                if (team1.equals(matchProgress.getTeam1()) && team2.equals(matchProgress.getTeam2())) {
                    detailsAboutCoupon.add(new CouponDetails(coupon.getId(), coupon.getMatches(), coupon.getMatchType(),
                                matchProgress.getSetsTeam1(), matchProgress.getSetsTeam2(), matchProgress.getMatchStatus(),
                                coupon.getCouponsNumber()));
                        if (matchProgress.getMatchStatus().equals("1 WINNER") && coupon.getMatchType() == 2) {
                            detailsAboutCoupon.get(detailsAboutCoupon.size() - 1).setCouponStatus(CouponStatus.LOST);
                        } else if (matchProgress.getMatchStatus().equals("2 WINNER") && coupon.getMatchType() == 1) {
                            detailsAboutCoupon.get(detailsAboutCoupon.size() - 1).setCouponStatus(CouponStatus.LOST);
                        }
                        else if (matchProgress.getMatchStatus().equals("1 WINNER") && coupon.getMatchType() == 1) {
                            detailsAboutCoupon.get(detailsAboutCoupon.size() - 1).setCouponStatus(CouponStatus.WON);
                        }
                        else if (matchProgress.getMatchStatus().equals("2 WINNER") && coupon.getMatchType() == 2) {
                            detailsAboutCoupon.get(detailsAboutCoupon.size() - 1).setCouponStatus(CouponStatus.WON);
                        }
                }

            }
        }
        return detailsAboutCoupon;
    }




    public boolean checkCouponStatus( List<CouponDetails> detailsAboutCoupon ){
        List<CouponStatus> statuses = new ArrayList<>();
        boolean hasCouponWon;
        for(CouponDetails detail : detailsAboutCoupon){
            statuses.add(detail.couponStatus);
        }
        if(statuses.contains(CouponStatus.LOST)){
            hasCouponWon = false;
        }
        else {
            hasCouponWon = true;
        }
        return hasCouponWon;
    }

    @Override
    public String toString() {
        return "CouponDetails{" +
                "matchId=" + matchId +
                ", match='" + match + '\'' +
                ", matchType=" + matchType +
                ", setTeam1=" + setTeam1 +
                ", setTeam2=" + setTeam2 +
                ", matchStatus='" + matchStatus + '\'' +
                ", couponStatus=" + couponStatus +
                ", couponNumber='" + couponNumber + '\'' +
                '}';
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public int getMatchType() {
        return matchType;
    }

    public void setMatchType(int matchType) {
        this.matchType = matchType;
    }

    public int getSetTeam1() {
        return setTeam1;
    }

    public void setSetTeam1(int setTeam1) {
        this.setTeam1 = setTeam1;
    }

    public int getSetTeam2() {
        return setTeam2;
    }

    public void setSetTeam2(int setTeam2) {
        this.setTeam2 = setTeam2;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public CouponStatus getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(CouponStatus couponStatus) {
        this.couponStatus = couponStatus;
    }

    public String getCouponNumber() {
        return couponNumber;
    }

    public void setCouponNumber(String couponNumber) {
        this.couponNumber = couponNumber;
    }



}
