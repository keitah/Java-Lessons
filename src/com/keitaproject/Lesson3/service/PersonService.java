package com.keitaproject.Lesson3.service;
import com.keitaproject.Lesson3.model.Person;
import java.util.List;
public interface PersonService {
    void add(String firstName, String lastName, String middleName, int age, String dateOfBirth);
    void update(int id, String firstName, String lastName, String middleName, int age, String dateOfBirth);
    boolean delete(int id);
    List<Person> list();
    List<Person> searchById(int id);
    List<Person> findAll();
    boolean exists(int id);
}