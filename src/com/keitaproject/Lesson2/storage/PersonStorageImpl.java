package com.keitaproject.Lesson2.storage;
import com.keitaproject.Lesson2.model.Person;
import java.util.ArrayList;
import java.util.List;
public class PersonStorageImpl implements PersonStorage {
    private final List<Person> persons = new ArrayList<>();
    private int idCounter = 0;
    @Override
    public void add(String firstName, String lastName, String middleName, int age, String dateOfBirth) {
        Person person = new Person(idCounter, firstName, lastName, middleName, age, dateOfBirth);
        persons.add(person);
        idCounter++;
    }
    @Override
    public void update(int id, String firstName, String lastName, String middleName, int age, String dateOfBirth) {
        for (Person person : persons) {
            if (person.getId() == id) {
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setMiddleName(middleName);
                person.setAge(age);
                person.setDateOfBirth(dateOfBirth);
            }
        }
    }
    @Override
    public void delete(int id) {
        persons.removeIf(person -> person.getId() == id);
    }
    @Override
    public List<Person> list() {
        return persons;
    }
    @Override
    public List<Person> searchById(int id) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getId() == id) {
                result.add(person);
            }
        }
        return result;
    }
}