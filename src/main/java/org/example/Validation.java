package org.example;

public interface Validation {
    //takes id and grade as strings so that it can check if they're numeric
    boolean isIdValid(String id);
    boolean isGradeValid(String grade);
}