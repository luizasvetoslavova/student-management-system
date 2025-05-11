package org.example.consoleManagement;

import studentManagement.StudentManager;
import org.example.inputManagement.InputCollector;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new ProgramRunner(StudentManager.getInstance(), StudentManager.getInstance(),
                InputCollector.getInstance(), scanner).run();
    }
}