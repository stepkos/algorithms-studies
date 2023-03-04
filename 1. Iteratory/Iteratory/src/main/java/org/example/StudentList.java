package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {
    private ArrayList<Student> studentsList;

    public StudentList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public void printAllStudents() {
        Iterator<Student> iter = studentsList.iterator();
        while (iter.hasNext())
            iter.next().print();
    }

    public void printStudentsBetterThan(double minAvgGrade) {
        Iterator<Student> iter = studentsList.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getAvgGrades() > minAvgGrade)
                student.print();
        }
    }

    public void changeStudentGrateAvg(int index, double newGrateAvg) {
        Iterator<Student> iter = studentsList.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getIndex() == index)
                student.setAvgGrades(newGrateAvg);
        }
    }

    public StudentList getStudentsBelow3() {
        ArrayList<Student> newStudents = new ArrayList<>();
        Iterator<Student> iter = studentsList.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getAvgGrades() < 3)
                newStudents.add(new Student(
                        student.getIndex(),
                        student.getFirstname(),
                        student.getSurname(),
                        student.getAvgGrades()
                ));
        }
        return new StudentList(newStudents);
    }
    public StudentList getStudentsAbove3() {
        ArrayList<Student> newStudents = new ArrayList<>();
        Iterator<Student> iter = studentsList.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getAvgGrades() > 3)
                newStudents.add(new Student(
                        student.getIndex(),
                        student.getFirstname(),
                        student.getSurname(),
                        student.getAvgGrades()
                ));
        }
        return new StudentList(newStudents);
    }


}
