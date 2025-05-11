package org.example.databaseManagement;

import org.example.studentManagement.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentDao implements StudentDbModification, StudentDbExtraction {
    private static final String JDBC_URL = "jdbc:postgresql://ep-wispy-resonance-abpe120g-pooler.eu-west-2.aws.neon.tech:5432/neondb?sslmode=require";
    private static final String USER = "neondb_owner";
    private static final String PASSWORD = "npg_A0jYFJhGt1Eo";

    private static StudentDao instance;
    private Connection connection;

    public static StudentDao getInstance() {
        if(instance == null) instance = new StudentDao();
        return instance;
    }

    private StudentDao() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Successfully connected to database.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> loadStudentsSorted() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, name, grade FROM students";

        try (var pstmt = connection.prepareStatement(sql);
             var rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int grade = rs.getInt("grade");

                Student student = new Student(name, id, grade);
                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Error while fetching students from DB:");
            e.printStackTrace();
        }

        students.sort(Comparator.comparing(Student::getName));
        return students;
    }

    @Override
    public void addStudentToDb(Student student) {
        String prompt = "INSERT INTO students (id, name, grade) VALUES (?, ?, ?)";

        try (var pstmt = connection.prepareStatement(prompt)) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getGrade());
            pstmt.executeUpdate();
            loadStudentsSorted().add(student);

        } catch (SQLException e) {
            System.out.println("Error while adding student to DB:");
            e.printStackTrace();
        }
    }

    @Override
    public void removeStudentFromDb(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (var pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                loadStudentsSorted().removeIf(student -> student.getId() == id);
            } else {
                System.out.println("No student found with ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error while removing student from DB:");
            e.printStackTrace();
        }
    }

    @Override
    public Student loadStudentById(int id) {
        return loadStudentsSorted()
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }
}