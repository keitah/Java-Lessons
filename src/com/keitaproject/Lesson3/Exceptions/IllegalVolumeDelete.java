package com.keitaproject.Lesson3.Exceptions;

public class IllegalVolumeDelete extends RuntimeException {
    public IllegalVolumeDelete(String message) {
        super(message);
    }
}