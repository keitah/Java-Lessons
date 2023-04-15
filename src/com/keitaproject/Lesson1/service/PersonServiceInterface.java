//v1
package service;
public interface PersonServiceInterface {
    void addPerson(String name, int age);
    void updatePerson(int id, String name, int age);
    void deletePerson(int id);
    void listPeople();
}