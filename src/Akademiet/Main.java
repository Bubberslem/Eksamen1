package Akademiet;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Academy academy = new Academy();
        Course databases = new Course("Databases");
        Course webProgramming = new Course("Web Programming");
        Course systemDevelopment = new Course("System Development");

        academy.addCourse(databases);
        academy.addCourse(webProgramming);
        academy.addCourse(systemDevelopment);

        Student mads = new Student("Mads");
        mads.addCourse(databases, 4);
        mads.addCourse(webProgramming, 7);
        mads.addCourse(systemDevelopment, 10);

        academy.addStudent(mads);


        Student marcus = new Student("Marcus");
        marcus.addCourse(databases, 7);
        marcus.addCourse(webProgramming, 10);
        marcus.addCourse(systemDevelopment, 10);
        academy.addStudent(marcus);

        boolean running = true;
        while (running) {
            System.out.println("=== Academy ===");
            System.out.println("1. Show students with the highest average.");
            System.out.println("2. Show students with the lowest average.");
            System.out.println("3. Print diploma of a student.");
            System.out.println("4. Exit");


            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("Students with the highest average: ");
                    List<Student> highest = academy.getHighest(2);
                    for (Student student : highest) {
                        System.out.println(student.getName() + ": " + student.getAverageGrade());
                    }
                    break;

                case 2:
                    System.out.println("Students with the lowest average: ");
                    List<Student> lowest = academy.getLowest(2);
                    for (Student student : lowest) {
                        System.out.println(student.getName() + ": " + student.getAverageGrade());
                    }
                    break;

                case 3:
                    System.out.println("Type name of student: ");
                    String name = scanner.nextLine();
                    Student foundStudent = null;

                    for (Student student : academy.getStudents()) {
                        if (student.getName().equalsIgnoreCase(name)) {
                            foundStudent = student;
                            break;
                        }
                    }
                    if (foundStudent != null) {
                        academy.printDiploma(foundStudent);
                    } else {
                        System.out.println("Student not found");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    running = false;
                    break;
                default:
                    System.out.println("Incorrect choice.");
                    break;
            }
        }
    }
}
