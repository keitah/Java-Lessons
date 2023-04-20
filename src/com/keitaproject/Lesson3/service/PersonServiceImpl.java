package com.keitaproject.Lesson3.service;
import com.keitaproject.Lesson3.model.Person;
import com.keitaproject.Lesson3.storage.PersonStorage;
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
    public boolean delete(int id) {
        if (exists(id)) {
            personStorage.delete(id);
            return true;
        }
        return false;
    }
    @Override
    public List<Person> list() {
        return personStorage.list();
    }
    @Override
    public List<Person> searchById(int id) {
        return personStorage.searchById(id);
    }
    @Override
    public List<Person> findAll() {
        return personStorage.list();
    }
    @Override
    public boolean exists(int id) {
        List<Person> persons = personStorage.list();
        for (Person person : persons) {
            if (person.getId() == id) {
                return true;
            }
        }
        return false;
    }
}