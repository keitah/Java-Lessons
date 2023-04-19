package com.keitaproject.Lesson3.storage;
import com.keitaproject.Lesson3.model.Person;
import java.util.ArrayList;
import java.util.List;
public class PersonStorageImpl implements PersonStorage {
    private final List<Person> persons = new ArrayList<>();
    private int idCounter = 1;
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
    public boolean exists(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean delete(int id) {
        if (!exists(id)) { // Проверяем, существует ли пользователь с таким id
            return false; // Если не существует, возвращаем false
        } else {
            // Если существует, то удаляем пользователя
            // ...
            return true;
        }
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