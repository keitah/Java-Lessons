package com.keitaproject.Lesson3.Exceptions;

public class IfListEmpty extends RuntimeException {
    public IfListEmpty(String message) {
        super(message);
    }
}
