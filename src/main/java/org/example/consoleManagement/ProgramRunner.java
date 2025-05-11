package org.example.consoleManagement;

import studentManagement.StudentDisplay;
import studentManagement.StudentModification;
import org.example.inputManagement.InputCollection;

import java.util.Scanner;

public class ProgramRunner {
    private final StudentModification studentModification;
    private final StudentDisplay studentDisplay;
    private final InputCollection inputCollection;
    private final Scanner scanner;

    public ProgramRunner(StudentModification studentModification, StudentDisplay studentDisplay,
                         InputCollection inputCollection, Scanner scanner) {
        this.studentModification = studentModification;
        this.studentDisplay = studentDisplay;
        this.inputCollection = inputCollection;
        this.scanner = scanner;
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
                studentModification.addNewStudent();
                break;
            case "2":
                studentModification.removeStudent(inputCollection.getIdToRemove());
                break;
            case "3":
                studentDisplay.getSortedStudents();
                break;
            case "4":
                studentDisplay.getStudentById(inputCollection.getIdToSearch());
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