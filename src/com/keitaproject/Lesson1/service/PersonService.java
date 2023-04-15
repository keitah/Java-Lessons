//v1
package com.keitaproject.Lesson1.service;
import com.keitaproject.Lesson1.storage.PersonStorage;
import com.keitaproject.Lesson1.storage.PersonStorageInterface;
import model.Person;
import java.util.List;
public class PersonService implements PersonServiceInterface {
    private PersonStorageInterface personStorage;
    public PersonService() {
        personStorage = new PersonStorage();
    }
    @Override
    public void addPerson(String name, int age) {
        Person person = new Person(name, age);
        personStorage.addPerson(person);
    }
    @Override
    public void updatePerson(int id, String name, int age) {
        Person person = new Person(id, name, age);
        personStorage.updatePerson(person);
    }
    @Override
    public void deletePerson(int id) {
        personStorage.deletePerson(id);
    }
    @Override
    public void listPeople() {
        List<Person> people = personStorage.getAllPeople();
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
