//v1
package com.keitaproject.Lesson1.service;
public interface PersonServiceInterface {
    void addPerson(String name, int age);
    void updatePerson(int id, String name, int age);
    void deletePerson(int id);
    void listPeople();
}