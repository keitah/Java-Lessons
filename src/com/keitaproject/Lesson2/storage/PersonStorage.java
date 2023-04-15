package com.keitaproject.Lesson2.storage;
import com.keitaproject.Lesson2.model.Person;
import java.util.List;
public interface PersonStorage {
    void add(String firstName, String lastName, String middleName, int age, String dateOfBirth);
    void update(int id, String firstName, String lastName, String middleName, int age, String dateOfBirth);
    void delete(int id);
    List<Person> list();
    List<Person> searchById(int id);
}