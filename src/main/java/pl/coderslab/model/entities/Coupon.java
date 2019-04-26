package pl.coderslab.model.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID couponsNumber;
    private String matches;
    private int matchType;
    private double deposit;
    private double possibleWin;
    @ManyToOne
    private User user;

    public Coupon() {
    }

    public Coupon(UUID couponsNumber, String matches, int matchType, double deposit, double possibleWin, User user) {
        this.couponsNumber = couponsNumber;
        this.matches = matches;
        this.matchType = matchType;
        this.deposit = deposit;
        this.possibleWin = possibleWin;
        this.user = user;
    }

    public UUID getCouponsNumber() {
        return couponsNumber;
    }

    public void setCouponsNumber(UUID couponsNumber) {
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

    public int getMatchType() {
        return matchType;
    }

    public void setMatchType(int matchType) {
        this.matchType = matchType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
