package com.keitaproject.Lesson3.model;
public class Person {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String dateOfBirth;
    public Person(int id, String firstName, String lastName, String middleName, int age, String dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }
    public int getId() {
        return id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return firstName;
    }
}