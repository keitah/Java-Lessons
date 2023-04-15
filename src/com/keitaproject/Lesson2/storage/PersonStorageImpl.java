package com.keitaproject.Lesson2.storage;
import com.keitaproject.Lesson2.model.Person;
import java.util.ArrayList;
import java.util.List;
public class PersonStorageImpl implements PersonStorage {
    private List<Person> persons = new ArrayList<>();
    private int idCounter = 0;
    @Override
    public void add(String name, int age) {
        Person person = new Person(idCounter, name, age);
        persons.add(person);
        idCounter++;
    }
    @Override
    public void update(int id, String name, int age) {
        for (Person person : persons) {
            if (person.getId() == id) {
                person.setName(name);
                person.setAge(age);
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
    public List<Person> search(String name) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                result.add(person);
            }
        }
        return result;
    }
}