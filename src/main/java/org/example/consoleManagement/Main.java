package org.example.consoleManagement;

import studentManagement.StudentManager;
import org.example.inputManagement.InputCollector;

public class Main {
    public static void main(String[] args) {
        new ProgramRunner(StudentManager.getInstance(), StudentManager.getInstance(), InputCollector.getInstance()).run();
    }
}