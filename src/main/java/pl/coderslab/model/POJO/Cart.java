package pl.coderslab.model.POJO;

public class Cart {
    private int id;
    private String match;
    private double singleCourse;
    private int choice;

    public Cart() {
    }

    public Cart(int id, String match, double singleCourse, int choice) {
        this.id = id;
        this.match = match;
        this.singleCourse = singleCourse;
        this.choice = choice;
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


    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", match='" + match + '\'' +
                ", singleCourse=" + singleCourse +
                ", choice=" + choice +
                '}';
    }

    @Override
    public int hashCode() {
        return getMatch().hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cart) {
            Cart cart = (Cart) obj;
            return this.getMatch().equals(cart.getMatch());
        }
        return false;
    }
}
