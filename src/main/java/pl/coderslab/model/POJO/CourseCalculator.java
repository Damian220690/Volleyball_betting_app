package pl.coderslab.model.POJO;

import org.springframework.stereotype.Component;

@Component
public class CourseCalculator {

    private double minCourse = 1.0;


    public double calculateCourse(int positionInTable){
        double currentCourse = minCourse + positionInTable/10.0;
        return currentCourse;
    }
}
