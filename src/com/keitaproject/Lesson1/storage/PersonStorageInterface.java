//v1
package storage;
import model.Person;
import java.util.List;
public interface PersonStorageInterface {
    void addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(int id);

    List<Person> getAllPeople();
}