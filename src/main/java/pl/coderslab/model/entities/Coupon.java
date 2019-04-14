package pl.coderslab.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long couponsNumber;
    private String matches;
    private double deposit;
    private double possibleWin;
    @ManyToOne
    private User user;

    public Coupon() {
    }

    public long getCouponsNumber() {
        return couponsNumber;
    }

    public void setCouponsNumber(long couponsNumber) {
        this.couponsNumber = couponsNumber;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
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
