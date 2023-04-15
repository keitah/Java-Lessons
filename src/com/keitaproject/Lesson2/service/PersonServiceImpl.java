package com.keitaproject.Lesson2.service;
import com.keitaproject.Lesson2.model.Person;
import com.keitaproject.Lesson2.storage.PersonStorage;
import java.util.List;
public class PersonServiceImpl implements PersonService {
    private final PersonStorage personStorage;
    public PersonServiceImpl(PersonStorage personStorage) {
        this.personStorage = personStorage;
    }
    @Override
    public void add(String firstName, String lastName, String middleName, int age, String dateOfBirth) {
        personStorage.add(firstName, lastName, middleName, age, dateOfBirth);
    }
    @Override
    public void update(int id, String firstName, String lastName, String middleName, int age, String dateOfBirth) {
        personStorage.update(id, firstName, lastName, middleName, age, dateOfBirth);
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
    public List<Person> searchById(int id) {
        return personStorage.searchById(id);
    }
}