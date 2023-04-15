package com.keitaproject.Lesson1.controller;
import com.keitaproject.Lesson1.service.PersonService;
import com.keitaproject.Lesson1.service.PersonServiceInterface;
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PersonServiceInterface personService = new PersonService();
        System.out.println("Введите команду: add, update, delete, list или exit");
        String command = scanner.nextLine();
        while (!command.equals("exit")) {
            switch (command) {
                case "add":
                    System.out.println("Введите имя:");
                    String name = scanner.nextLine();
                    System.out.println("Введите возраст:");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    personService.addPerson(name, age);
                    break;
                case "update":
                    System.out.println("Введите Id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите имя:");
                    name = scanner.nextLine();
                    System.out.println("Введите возраст:");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    personService.updatePerson(id, name, age);
                    break;
                case "delete":
                    System.out.println("Введите Id:");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    personService.deletePerson(id);
                    break;
                case "list":
                    personService.listPeople();
                    break;
                default:
                    System.out.println("Команда не распознана");
            }
            System.out.println("Введите команду: add, update, delete, list или exit");
            command = scanner.nextLine();
        }
        scanner.close();
    }
}