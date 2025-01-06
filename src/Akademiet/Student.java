package Akademiet;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Map<Course,Integer> courseGrades;

    public Student(String name) {
        this.name = name;
        this.courseGrades = new HashMap();
    }
    public String getName() {
        return name;
    }
    public void addCourse(Course course, int grade) {
        if (grade == -3 || grade == 0 || grade == 2 || grade == 4 || grade == 7 || grade == 10 || grade == 12) {
            if (!courseGrades.containsKey(course)) {
                courseGrades.put(course, grade);
            } else {
                System.out.println("Student is already in this course.");
            }
        } else {
            System.out.println("Invalid grade.");
        }
    }

    public Map<Course, Integer> getCourseGrades() {
        return courseGrades;
    }

    public double getAverageGrade() {
        double sum = 0;
        if (courseGrades.size() > 0) {
            for (int grade : courseGrades.values()) {
                sum += grade;
            }

            return sum / courseGrades.size();
        }else{
            return 0;
        }
    }
}

