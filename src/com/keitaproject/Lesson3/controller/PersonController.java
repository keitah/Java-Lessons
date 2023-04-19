package com.keitaproject.Lesson3.controller;
import com.keitaproject.Lesson3.model.Person;
import com.keitaproject.Lesson3.service.PersonService;
import com.keitaproject.Lesson3.service.PersonServiceImpl;
import com.keitaproject.Lesson3.storage.PersonStorageImpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class PersonController {
    private final Scanner scanner = new Scanner(System.in);
    private final PersonService personService = new PersonServiceImpl(new PersonStorageImpl());
    public void start() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("""
                    Выберите действие:
                    1. Добавить запись
                    2. Редактировать запись
                    3. Список всех записей
                    4. Удалить запись
                    5. Поиск записи
                    6. Выйти из программы
                    """);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> add();
                case 2 -> update();
                case 3 -> list();
                case 4 -> delete();
                case 5 -> search();
                case 6 -> isExit = true;
                default -> System.out.println("Некорректный выбор, попробуйте еще раз.");
            }
        }
    }
    private void add() {
        try {
            scanner.nextLine();
            System.out.println("Введите имя:");
            String firstName = scanner.nextLine();
            System.out.println("Введите фамилию:");
            String lastName = scanner.nextLine();
            System.out.println("Введите отчество:");
            String middleName = scanner.nextLine();
            System.out.println("Введите дату рождения в формате гггг-мм-дд:");
            String dateOfBirth = scanner.nextLine();
            LocalDate.parse(dateOfBirth);
            int age = Period.between(LocalDate.parse(dateOfBirth), LocalDate.now()).getYears();
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            }
            personService.add(firstName, lastName, middleName, age, dateOfBirth);
            System.out.println("Запись добавлена.");
        } catch (DateTimeParseException e) {
            System.out.println("Произошла ошибка: Неправильный формат даты рождения. Запись не добавлена.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage() + ". Запись не добавлена.");
        }
    }
    private void update() {
        try {
            List<Person> persons = personService.findAll();
            int maxId = persons.size() - 1;
            System.out.println("Введите id записи для редактирования (от 0 до " + maxId + "):");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id < 0 || id > maxId) {
                throw new IllegalArgumentException("Введенный id не существует");
            }
            System.out.println("Введите новое имя:");
            String firstName = scanner.nextLine();
            System.out.println("Введите новую фамилию:");
            String lastName = scanner.nextLine();
            System.out.println("Введите новое отчество:");
            String middleName = scanner.nextLine();
            System.out.println("Введите дату рождения в формате гггг-мм-дд:");
            String dateOfBirth = scanner.nextLine();
            LocalDate.parse(dateOfBirth);
            int age = Period.between(LocalDate.parse(dateOfBirth), LocalDate.now()).getYears();
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            }
            personService.update(id, firstName, lastName, middleName, age, dateOfBirth);
            System.out.println("Запись изменена.");
        } catch (DateTimeParseException e) {
            System.out.println("Произошла ошибка: Неправильный формат даты рождения. Запись не добавлена.");
        } catch (ClassCastException e) {
            System.out.println("Произошла ошибка: Вы ввели некорректный id записи.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private void delete() {
        try {
            List<Person> personList = personService.list();
            if (personList.isEmpty()) {
                throw new Exception("Список пользователей пуст!");
            }
            List<Person> persons = personService.findAll();
            int maxId = persons.size();
            System.out.println("Введите id записи для удаления (от 1 до " + maxId + "):");
            int id = scanner.nextInt();
            Person personToDelete = null;
            for (Person person : personList) {
                if (person.getId() == id) {
                    personToDelete = person;
                    break;
                }
            }
            if (personToDelete == null) {
                throw new Exception("Ошибка: Запись с id " + id + " не найдена");
            } else {
                boolean isDeleted = personService.delete(id);
                if (isDeleted) {
                    personList.remove(personToDelete);
                    System.out.println("Запись удалена");
                    for (int i = id - 1; i < personList.size(); i++) {
                        personList.get(i).setId(i + 1);
                    }
                } else {
                    throw new Exception("Ошибка: Не удалось удалить запись с id " + id);
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Ошибка: Введено неверное значение");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void list() {
        try {
            List<Person> persons = personService.list();
            if (persons.isEmpty()) {
                throw new Exception("Список пользователей пуст!");
            }
            System.out.println("Список всех записей:");
            persons.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void search() {
        scanner.nextLine();
        System.out.println("Введите id пользователя для поиска:");
        String id = scanner.nextLine();
        try {
            List<Person> searchResult = personService.searchById(Integer.parseInt(id));
            if (searchResult.isEmpty()) {
                System.out.println("Такого пользователя не существует или список пользователей пустой");
            } else {
                System.out.println("Ваш пользователь ниже:");
                searchResult.forEach(System.out::println);
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат id пользователя");
        }
    }
}