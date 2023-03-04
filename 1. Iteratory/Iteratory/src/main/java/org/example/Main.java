package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        ArrayList<Student> students = new ArrayList<>();
//        students.add(new Student(252111, "Jan", "Kowalski", 4.75));
//        students.add(new Student(212333, "Adam", "Nowak", 3));
//
//        StudentList studentList = new StudentList(students);

//        studentList.printAllStudents();
//        System.out.println();
//
//        studentList.printStudentsBetterThan(4);
//        System.out.println();
//
//        studentList.changeStudentGrateAvg(212333, 4.5);
//        studentList.printAllStudents();
//
//        StudentList newStudentList = studentList.getStudentsBetterThanAlt(3);
//        newStudentList.changeStudentGrateAvg(252111, 7);
//        newStudentList.printAllStudents();
//
//        System.out.println();
//        studentList.printAllStudents();

        StudentList studentList = StudentList.fromFile("input/sample.txt");
        studentList.printAllStudents();

    }
}