package pl.coderslab.model.POJO;

import pl.coderslab.model.entities.CouponMatch;

public class Cart {
    private long id;
    private String match;
    private double singleCourse;

    public Cart() {
    }

    public Cart(int id, String match, double singleCourse) {
        this.id = id;
        this.match = match;
        this.singleCourse = singleCourse;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public double getSingleCourse() {
        return singleCourse;
    }

    public void setSingleCourse(double singleCourse) {
        this.singleCourse = singleCourse;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getId() == ((Cart) obj).getId();
    }

    public void toCart(CouponMatch couponMatch){
        this.id = couponMatch.getId();
        this.match = couponMatch.getVolleyballMatch();
        this.singleCourse = couponMatch.getMatchCourse();
    }
}
