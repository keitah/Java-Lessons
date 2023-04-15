package com.keitaproject.Lesson2.service;
import com.keitaproject.Lesson2.model.Person;
import com.keitaproject.Lesson2.storage.PersonStorage;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    private PersonStorage personStorage;
    public PersonServiceImpl(PersonStorage personStorage) {
        this.personStorage = personStorage;
    }
    @Override
    public void add(String name, int age) {
        personStorage.add(name, age);
    }
    @Override
    public void update(int id, String name, int age) {
        personStorage.update(id, name, age);
    }
    @Override
    public void delete(int id) {
        personStorage.delete(id);
    }
    @Override
    public List<Person> list() {
        return personStorage.list();
    }
    @Override
    public List<Person> search(String name) {
        return personStorage.search(name);
    }
}