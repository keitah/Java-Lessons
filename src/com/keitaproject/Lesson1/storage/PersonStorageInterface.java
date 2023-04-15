//v1
package com.keitaproject.Lesson1.storage;
import com.keitaproject.Lesson1.model.Person;
import java.util.List;
public interface PersonStorageInterface {
    void addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(int id);

    List<Person> getAllPeople();
}