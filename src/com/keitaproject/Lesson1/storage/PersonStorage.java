//v1
package com.keitaproject.Lesson1.storage;
import com.keitaproject.Lesson1.model.Person;
import java.util.ArrayList;
import java.util.List;
public class PersonStorage implements PersonStorageInterface {
    private List<Person> people;
    private int nextId;
    public PersonStorage() {
        people = new ArrayList<>();
        nextId = 1;
    }
    @Override
    public void addPerson(Person person) {
        person.setId(nextId);
        people.add(person);
        nextId++;
    }
    @Override
    public void updatePerson(Person person) {
        int index = findPersonIndexById(person.getId());
        if (index != -1) {
            people.set(index, person);
        }
    }
    @Override
    public void deletePerson(int id) {
        int index = findPersonIndexById(id);
        if (index != -1) {
            people.remove(index);
        }
    }
    @Override
    public List<Person> getAllPeople() {
        return new ArrayList<>(people);
    }
    private int findPersonIndexById(int id) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}