package org.example;

import java.util.*;

public class StudentList {

    private Student[] studentsList;

    public StudentList(Student[] studentsList) {
        this.studentsList = studentsList;
    }

    public void setStudentsList(Student[] studentsList) {
        this.studentsList = studentsList;
    }

//    public static StudentList fromFile(String path) {
//        ArrayList<Student> students = new ArrayList<>();
//        ArrayList<String> fileLines = FileReader.getContentAsArray(path);
//
//        fileLines.remove(0);
//        fileLines.remove(0);
//
//        fileLines.forEach(x -> {
//            String[] elements = x.split(" ");
//            if (elements.length < 4) throw new AssertionError("Invalid file format");
//            double gratesSum = Arrays.asList(elements).subList(3, elements.length).stream().mapToDouble(Double::parseDouble).sum();
//            students.add(new Student(
//                    Integer.parseInt(elements[2].replaceAll("[()]", "")),
//                    elements[1],
//                    elements[0],
//                    gratesSum / (elements.length - 3)
//            ));
//        });
//
//        return new StudentList(students);
//    }

    public void printAllStudents() {
        ArrayIterator<Student> iter = new ArrayIterator<>(studentsList);
        while (iter.hasNext())
            iter.next().print();
    }

    public void printStudentsBetterThan(double minAvgGrade) {
        ArrayIterator<Student> iter = new ArrayIterator<>(studentsList);
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getAvgGrades() > minAvgGrade)
                student.print();
        }
    }

    public void changeStudentGrateAvg(int index, double newGrateAvg) {
        ArrayIterator<Student> iter = new ArrayIterator<>(studentsList);
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getIndex() == index)
                student.setAvgGrades(newGrateAvg);
        }
    }
//
//    public StudentList getStudentsBelow3() {
//        ArrayList<Student> newStudents = new ArrayList<>();
//        Iterator<Student> iter = studentsList.iterator();
//        while (iter.hasNext()) {
//            Student student = iter.next();
//            if (student.getAvgGrades() < 3)
//                newStudents.add(new Student(
//                        student.getIndex(),
//                        student.getFirstname(),
//                        student.getSurname(),
//                        student.getAvgGrades()
//                ));
//        }
//        return new StudentList(newStudents);
//    }
//
//    public StudentList getStudentsAboveOrEquals3() {
//        ArrayList<Student> newStudents = new ArrayList<>();
//        Iterator<Student> iter = studentsList.iterator();
//        while (iter.hasNext()) {
//            Student student = iter.next();
//            if (student.getAvgGrades() >= 3)
//                newStudents.add(new Student(
//                        student.getIndex(),
//                        student.getFirstname(),
//                        student.getSurname(),
//                        student.getAvgGrades()
//                ));
//        }
//        return new StudentList(newStudents);
//    }

}
