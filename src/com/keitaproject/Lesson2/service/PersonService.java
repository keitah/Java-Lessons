package com.keitaproject.Lesson2.service;
import com.keitaproject.Lesson2.model.Person;
import java.util.List;
public interface PersonService {
    void add(String name, int age);
    void update(int id, String name, int age);
    void delete(int id);
    List<Person> list();
    List<Person> search(String name);
}