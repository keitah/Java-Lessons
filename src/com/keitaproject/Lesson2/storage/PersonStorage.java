package com.keitaproject.Lesson2.storage;
import com.keitaproject.Lesson2.model.Person;
import java.util.List;
public interface PersonStorage {
    void add(String name, int age);
    void update(int id, String name, int age);
    void delete(int id);
    List<Person> list();
    List<Person> search(String name);
}