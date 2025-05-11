package studentManagement;

import org.example.inputManagement.InputCollector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager implements StudentModification, StudentDisplay {
    private static StudentManager instance;
    private static final InputCollector inputCollector = InputCollector.getInstance();
    private static List<Student> students;

    public static StudentManager getInstance() {
        if (instance == null) instance = new StudentManager();
        return instance;
    }

    private StudentManager() {
        students = new ArrayList<>();
    }

    @Override
    public void addNewStudent() {
        students.add(new Student(inputCollector.getName(), inputCollector.getIdToAdd(), inputCollector.getGrade()));
        System.out.println("New student added!");
    }

    @Override
    public void removeStudent(int id) {
        Student toBeRemoved = students.stream()
                .filter(student -> student.getId() == id).findFirst().orElse(null);

        if (toBeRemoved == null) {
            System.out.println("No such id.");
            return;
        }

        students.remove(toBeRemoved);
        System.out.println("Student removed!");
    }

    @Override
    public void getSortedStudents() {
        students.sort(Comparator.comparing(Student::getName));
        students.forEach(student -> System.out.println(student.toString()));
        if (students.isEmpty()) System.out.println("No students found.");
    }

    @Override
    public void getStudentById(int id) {
        Student toBeFound = students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);

        if (toBeFound == null) {
            System.out.println("No such id.");
            return;
        }

        System.out.println(toBeFound.toString());
    }

    public List<Student> getStudents() {
        return students;
    }
}