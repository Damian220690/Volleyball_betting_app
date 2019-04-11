package pl.coderslab.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long couponsNumber;
    private String match;
    private double deposit;
    private double possibleWin;
    @ManyToOne
    private User user;

    public Coupon() {
    }

    public Coupon(String match, double deposit, double possibleWin, User user) {
        this.match = match;
        this.deposit = deposit;
        this.possibleWin = possibleWin;
        this.user = user;
    }

    public long getCouponsNumber() {
        return couponsNumber;
    }

    public void setCouponsNumber(long couponsNumber) {
        this.couponsNumber = couponsNumber;
    }


    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPossibleWin() {
        return possibleWin;
    }

    public void setPossibleWin(double possibleWin) {
        this.possibleWin = possibleWin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
