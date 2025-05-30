package org.example.inputManagement;

import org.example.studentManagement.StudentManager;

import java.util.Scanner;

public class InputCollector implements InputCollection, InputValidation {
    private static final int MINIMUM_GRADE = 1;
    private static final int MAX_GRADE = 12;
    private static final StudentManager studentManager = StudentManager.getInstance();
    private static InputCollector instance;
    private final Scanner scanner;

    public static InputCollector getInstance() {
        if (instance == null) instance = new InputCollector();
        return instance;
    }

    private InputCollector() {
        this.scanner = new Scanner(System.in);
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

        while (!isIdValid(idAsText) || idExists(Integer.parseInt(idAsText))) {
            System.out.print("Wrong id, please try again: ");
            idAsText = scanner.nextLine();
        }

        return Integer.parseInt(idAsText);
    }

    @Override
    public int getIdToRemove() {
        System.out.print("Student id: ");
        String idAsText = scanner.nextLine();

        while (!isIdValid(idAsText) || !idExists(Integer.parseInt(idAsText))) {
            System.out.print("Wrong id, please try again: ");
            idAsText = scanner.nextLine();
        }

        return Integer.parseInt(idAsText);
    }

    @Override
    public int getIdToSearch() {
        //same logic, different name for clarity
        return getIdToRemove();
    }

    @Override
    public int getGrade() {
        System.out.print("Student grade: ");
        String gradeAsText = scanner.nextLine();

        while (!isGradeValid(gradeAsText)) {
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
        return grade >= MINIMUM_GRADE && grade <= MAX_GRADE;
    }

    private boolean idExists(int id) {
        return studentManager.getStudents().stream().anyMatch(student -> student.getId() == id);
    }
}