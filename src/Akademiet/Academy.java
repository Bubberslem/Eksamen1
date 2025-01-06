package Akademiet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Academy {
    private ArrayList<Student> students;
    private ArrayList<Course> availableCourses;

    public Academy() {
        students = new ArrayList<>();
        availableCourses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        availableCourses.add(course);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void printDiploma(Student student) {
        System.out.println(student.getName());
        for (Map.Entry<Course,Integer> entry : student.getCourseGrades().entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
        System.out.println("Average Grade: " + student.getAverageGrade());
    }

    public List<Student> getHighest(int amount) {
        students.sort((s1, s2) -> Double.compare(s2.getAverageGrade(), s1.getAverageGrade()));
        return students.subList(0, Math.min(amount, students.size()));
    }

    public List<Student> getLowest(int amount) {
        students.sort(Comparator.comparingDouble(Student::getAverageGrade));
        return students.subList(0, Math.min(amount, students.size()));
    }
}
