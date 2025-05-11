package org.example.studentManagement;

import org.example.databaseManagement.StudentDao;
import org.example.inputManagement.InputCollector;

import java.util.List;

public class StudentManager implements StudentModification, StudentDisplay {
    private static final InputCollector inputCollector = InputCollector.getInstance();
    private static final StudentDao studentDao = StudentDao.getInstance();
    private static StudentManager instance;

    public static StudentManager getInstance() {
        if (instance == null) instance = new StudentManager();
        return instance;
    }

    private StudentManager() {
    }

    @Override
    public void addNewStudent() {
        Student newStudent = new Student(inputCollector.getName(), inputCollector.getIdToAdd(), inputCollector.getGrade());
        studentDao.addStudentToDb(newStudent);
        System.out.println("New student added!");
    }

    @Override
    public void removeStudent(int id) {
        Student toBeRemoved = studentDao.loadStudentById(id);

        if (toBeRemoved == null) {
            System.out.println("No such id.");
            return;
        }

        studentDao.removeStudentFromDb(id);
        System.out.println("Student removed!");
    }

    @Override
    public void getSortedStudents() {
        studentDao.loadStudentsSorted()
                .forEach(student -> System.out.println(student.toString()));
        if (studentDao.loadStudentsSorted().isEmpty()) System.out.println("No students found.");
    }

    @Override
    public void getStudentById(int id) {
        Student toBeFound = studentDao.loadStudentById(id);

        if (toBeFound == null) {
            System.out.println("No such id.");
            return;
        }

        System.out.println(toBeFound.toString());
    }

    public List<Student> getStudents() {
        return studentDao.loadStudentsSorted();
    }
}