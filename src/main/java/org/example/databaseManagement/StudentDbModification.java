package org.example.databaseManagement;

import org.example.studentManagement.Student;

public interface StudentDbModification {
    void addStudentToDb(Student student);
    void removeStudentFromDb(int id);
}