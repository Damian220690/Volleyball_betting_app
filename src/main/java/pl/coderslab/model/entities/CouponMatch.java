package pl.coderslab.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "couponMatches")
public class CouponMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String volleyballMatch;
    private double matchCourse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVolleyballMatch() {
        return volleyballMatch;
    }

    public void setVolleyballMatch(String volleyballMatch) {
        this.volleyballMatch = volleyballMatch;
    }

    public double getMatchCourse() {
        return matchCourse;
    }

    public void setMatchCourse(double matchCourse) {
        this.matchCourse = matchCourse;
    }
}
