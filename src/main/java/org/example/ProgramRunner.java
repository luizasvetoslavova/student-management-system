package org.example;

import java.util.Scanner;

public class ProgramRunner {
    private final StudentManagement studentManagement;
    private final InputManagement inputManagement;
    private final Scanner scanner;

    public ProgramRunner(StudentManagement studentManagement, InputManagement inputManagement) {
        this.studentManagement = studentManagement;
        this.inputManagement = inputManagement;
        scanner = InputManager.getScanner();
    }

    public void run() {
        greet();
        while (true) {
            displayOptions();
            manageChoice(scanner.nextLine());
        }
    }

    private void manageChoice(String choice) {
        switch (choice) {
            case "1":
                studentManagement.addNewStudent();
                break;
            case "2":
                studentManagement.removeStudent(inputManagement.getIdToRemove());
                break;
            case "3":
                studentManagement.displaySortedStudents();
                break;
            case "4":
                studentManagement.getStudentById(inputManagement.getIdToSearch());
                break;
            default:
                System.out.println("Invalid choice. Please try again. ");
                break;
        }
    }

    private void displayOptions() {
        System.out.print("Choose an option: \n" +
                "1. Add new student \n" +
                "2. Remove student by id \n" +
                "3. Display all students, sorted by name \n" +
                "4. Search for a student by id \n" +
                "Your choice: ");
    }

    private void greet() {
        System.out.println("Welcome to the student management system!");
    }
}