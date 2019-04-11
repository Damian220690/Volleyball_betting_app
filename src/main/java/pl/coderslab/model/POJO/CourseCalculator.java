package pl.coderslab.model.POJO;

public class CourseCalculator {

    private double minCourse = 1.0;


    public double calculateCourse(int positionInTable, double deposit){
        double currentCourse = minCourse + positionInTable/10;
        return currentCourse;
    }
}
