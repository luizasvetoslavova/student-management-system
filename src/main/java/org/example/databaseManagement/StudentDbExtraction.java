package org.example.databaseManagement;

import org.example.studentManagement.Student;

import java.util.List;

public interface StudentDbExtraction {
    List<Student> loadStudentsSorted();
    Student loadStudentById(int id);
}