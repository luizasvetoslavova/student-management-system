package org.example.inputManagement;

public interface InputValidation {
    //methods take id and grade parameters as strings so that they can check if input is numeric
    boolean isIdValid(String id);
    boolean isGradeValid(String grade);
}