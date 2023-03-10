package org.example;

import java.util.Scanner;

public class Main {

    private static void demo() {
//        Scanner scanner = new Scanner(System.in);
//        String baseFilePath = "input/";
//        System.out.println("Prosze podac nazwe pliku w folderze 'input', ktory ma zostac wczytany");
//        String fileName = scanner.nextLine();
//        scanner.close();
//        StudentList studentList = StudentList.fromFile(baseFilePath + fileName);

        StudentList studentList = new StudentList(new Student[]{
                new Student(123456, "Jan", "Nowak", 4.5),
                new Student(654321, "Adam", "Kowalski", 4.0),
                new Student(111321, "Andrzej", "Kwiatkowski", 3.0),
                new Student(879312, "Kornelia", "Krol", 3.5)
        });

        System.out.println("\nOto lista wszystkich studentow wczytanych z pliku:");
        studentList.printAllStudents();

        System.out.println("\nWyswietlamy studentow o sredniej ocen wyzszej niz podana w parametrze (przykladowy parametr = 4)");
        studentList.printStudentsBetterThan(4);

        System.out.println("\nZmieniamy srednia ocen studenta o indeksie 654321 na 5.0 i wyswietlamy cala liste wszytskich studentow");
        studentList.changeStudentGrateAvg(654321, 5);
        studentList.printAllStudents();

//        System.out.println("\nTworzymy nowa liste studentow z ocenemi ponizej 3.0 i wyswietlamy ja");
//        StudentList studentsBelow3 = studentList.getStudentsBelow3();
//        studentsBelow3.printAllStudents();

//        System.out.println("\nTworzymy nowa liste studentow z ocenemi powyzej lub rowno 3.0 i wyswietlamy ja");
//        StudentList studentsAboveOrEquals3 = studentList.getStudentsAboveOrEquals3();
//        studentsAboveOrEquals3.printAllStudents();

    }

    public static void main(String[] args) {
        demo();
    }

}