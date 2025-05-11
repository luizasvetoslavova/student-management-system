package org.example;

import java.util.Scanner;

public class InputManager implements InputManagement, Validation {
    private static InputManagement instance;
    private static final StudentManager studentManager = StudentManager.getInstance();
    private static Scanner scanner;

    public static InputManagement getInstance() {
        if(instance == null) instance = new InputManager();
        return instance;
    }

    private InputManager() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getName() {
        System.out.print("Student name: ");
        return scanner.nextLine();
    }

    @Override
    public int getIdToAdd() {
        System.out.print("Student id: ");
        String idAsText = scanner.nextLine();

        while(!isIdValid(idAsText) || idExists(Integer.parseInt(idAsText))) {
            System.out.print("Wrong id, please try again: ");
            idAsText = scanner.nextLine();
        }

        return Integer.parseInt(idAsText);
    }

    @Override
    public int getIdToRemove() {
        System.out.print("Student id: ");
        String idAsText = scanner.nextLine();

        while(!isIdValid(idAsText) || !idExists(Integer.parseInt(idAsText))) {
            System.out.print("Wrong id, please try again: ");
            idAsText = scanner.nextLine();
        }

        return Integer.parseInt(idAsText);
    }

    @Override
    public int getGrade() {
        System.out.print("Student grade: ");
        String gradeAsText = scanner.nextLine();

        while(!isGradeValid(gradeAsText)) {
            System.out.print("Wrong grade, please try again: ");
            gradeAsText = scanner.nextLine();
        }

        return Integer.parseInt(gradeAsText);
    }

    @Override
    public boolean isIdValid(String id) {
        return isPositiveNumber(id);
    }

    @Override
    public boolean isGradeValid(String grade) {
        return isPositiveNumber(grade) && isGradeInRange(Integer.parseInt(grade));
    }

    private boolean isPositiveNumber(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        if (!input.matches("\\d+")) {
            return false;
        }
        try {
            int value = Integer.parseInt(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isGradeInRange(int grade) {
        return grade > 0 && grade < 13;
    }

    private boolean idExists(int id) {
        return studentManager.getStudents().stream().anyMatch(student -> student.getId() == id);
    }

    public static Scanner getScanner() {
        return scanner;
    }
}