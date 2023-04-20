package com.keitaproject.Lesson3.controller;
import com.keitaproject.Lesson3.Exceptions.IfListEmpty;
import com.keitaproject.Lesson3.Exceptions.IllegalVolumeDelete;
import com.keitaproject.Lesson3.model.Person;
import com.keitaproject.Lesson3.service.PersonService;
import com.keitaproject.Lesson3.service.PersonServiceImpl;
import com.keitaproject.Lesson3.storage.PersonStorageImpl;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
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
    public void add() {
        try {
            scanner.nextLine();
            System.out.println("Введите имя:");
            String firstName = scanner.nextLine();
            while (firstName.matches(".*\\d.*") || firstName.contains(" ")) {
            System.out.println("Имя не должно содержать цифры и пробелы. Пожалуйста, введите имя ещё раз:");
            firstName = scanner.nextLine();
        }
            System.out.println("Введите фамилию:");
            String lastName = scanner.nextLine();
            while (lastName.matches(".*\\d.*") || lastName.contains(" ")) {
            System.out.println("Фамилия не должна содержать цифры и пробелы. Пожалуйста, введите фамилию ещё раз:");
            lastName = scanner.nextLine();
        }
            System.out.println("Введите отчество:");
            String middleName = scanner.nextLine();
            while (middleName.matches(".*\\d.*") || middleName.contains(" ")) {
            System.out.println("Отчество не должно содержать цифры и пробелы. Пожалуйста, введите отчество ещё раз:");
            middleName = scanner.nextLine();
        }
            System.out.println("Введите дату рождения в формате гггг-мм-дд:");
            String dateOfBirth = scanner.nextLine();
            while (!dateOfBirth.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$") || dateOfBirth.contains(" ")) {
            System.out.println("Дата рождения должна содержать только цифры в формате гггг-мм-дд и не должна содержать пробелы. Пожалуйста, введите дату рождения ещё раз:");
            dateOfBirth = scanner.nextLine();
        }
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
            List<Person> personList = personService.list();
            if (personList.isEmpty()) {
                throw new IfListEmpty("Список пользователей пуст!");
            }
            List<Person> persons = personService.findAll();
            int maxId = persons.size();
            System.out.print("Доступные id пользователей для редактирования (от 1 до " + maxId + ")" +  ".\nID после двоеточия вы можете использовать для редактирования: ");
            for (Person person : persons) {
                System.out.print(person.getId() + " ");
            }
            System.out.println();
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id < 0 || id > maxId) {
                throw new IllegalArgumentException("Введенный id не существует");
            }
            System.out.println("Введите имя:");
            String firstName = scanner.nextLine();
            while (firstName.matches(".*\\d.*") || firstName.contains(" ")) {
            System.out.println("Имя не должно содержать цифры и пробелы. Пожалуйста, введите имя ещё раз:");
            firstName = scanner.nextLine();
            }
            System.out.println("Введите фамилию:");
            String lastName = scanner.nextLine();
            while (lastName.matches(".*\\d.*") || lastName.contains(" ")) {
            System.out.println("Фамилия не должна содержать цифры и пробелы. Пожалуйста, введите фамилию ещё раз:");
            lastName = scanner.nextLine();
            }
            System.out.println("Введите отчество:");
            String middleName = scanner.nextLine();
            while (middleName.matches(".*\\d.*") || middleName.contains(" ")) {
            System.out.println("Отчество не должно содержать цифры и пробелы. Пожалуйста, введите отчество ещё раз:");
            middleName = scanner.nextLine();
            }
            System.out.println("Введите дату рождения в формате гггг-мм-дд:");
            String dateOfBirth = scanner.nextLine();
            while (!dateOfBirth.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$") || dateOfBirth.contains(" ")) {
            System.out.println("Дата рождения должна содержать только цифры в формате гггг-мм-дд и не должна содержать пробелы. Пожалуйста, введите дату рождения ещё раз:");
            dateOfBirth = scanner.nextLine();
            }
            LocalDate.parse(dateOfBirth);
            int age = Period.between(LocalDate.parse(dateOfBirth), LocalDate.now()).getYears();
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            }
            personService.update(id, firstName, lastName, middleName, age, dateOfBirth);
            System.out.println("Запись изменена.");
        } catch (DateTimeParseException e) {
            System.out.println("Произошла ошибка: Неправильный формат даты рождения. Запись не обновлена.");
        } catch (InputMismatchException e) {
            System.out.println("Произошла ошибка: Введён некорректный ID. Запись не обновлена.");
            scanner.nextLine();
        } catch (IllegalArgumentException | IfListEmpty e) {
            System.out.println(e.getMessage());
        }
    }
    private void delete() {
        try {
            List<Person> personList = personService.list();
            if (personList.isEmpty()) {
                throw new IfListEmpty("Список пользователей пуст!");
            }
            List<Person> persons = personService.findAll();
            System.out.print("Доступные id пользователей для удаления - введите, тот который нужен: ");
            for (Person person : persons) {
                System.out.print(person.getId() + " ");
            }
            System.out.println();
            int maxId = persons.size();
            System.out.println("Всего id пользователей доступных для удаления 1 из " + maxId + "):");
            int id = scanner.nextInt();
            Person personToDelete = null;
            for (Person person : personList) {
                if (person.getId() == id) {
                    personToDelete = person;
                    break;
                }
            }
            if (personToDelete == null) {
                throw new IllegalVolumeDelete("Ошибка: Запись с id " + id + " не найдена");
            } else {
                System.out.println("Вы действительно хотите удалить пользователя " + personToDelete.getName() + " под id" + personToDelete.getId()  + "?" + " (Да/Нет)");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("Да")) {
                    boolean isDeleted = personService.delete(id);
                    if (isDeleted) {
                        personList.remove(personToDelete);
                        System.out.println("Запись удалена");
                        for (int i = id - 1; i < personList.size(); i++) {
                            personList.get(i).setId(i + 1);
                        }
                    } else {
                        throw new IllegalVolumeDelete("Ошибка: Не удалось удалить запись с id " + id);
                    }
                } else if (answer.equalsIgnoreCase("Нет")) {
                    System.out.println("Удаление отменено");
                } else {
                    throw new IllegalArgumentException("Ошибка: Некорректный ответ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Некорректный ввод, введите число");
            scanner.next();
        } catch (IfListEmpty | IllegalVolumeDelete | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private void list() {
        try {
            List<Person> persons = personService.list();
            if (persons.isEmpty()) {
                throw new IfListEmpty("Список пользователей пуст!");
            }
            System.out.println("Список всех записей:");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Хотите отсортировать список по имени? (Да/Нет)");
            String answer = scanner.nextLine();
            if (answer.equals("Да")) {
                persons.sort(Comparator.comparing(Person::getName));
            }
            persons.forEach(System.out::println);
        } catch (IfListEmpty e) {
            System.out.println(e.getMessage());
        }
    }
    private void search() {
        try {
            List<Person> foundPersons = personService.list();
            if (foundPersons.isEmpty()) {
                System.out.println("Список пользователей пуст!");
            } else {
                List<Person> persons = personService.findAll();
                int maxId = persons.size();
                System.out.print("Доступные id пользователей для поиска (от 1 до " + maxId + ")" +  ".\nID после двоеточия вы можете использовать для поиска: ");
                for (Person person : persons) {
                    System.out.print(person.getId() + " ");
                }
                System.out.println();
                scanner.nextLine();
                String id = scanner.nextLine();
                foundPersons = personService.searchById(Integer.parseInt(id));
                if (foundPersons.isEmpty()) {
                    System.out.println("Пользователь не найден");
                } else {
                    foundPersons.forEach(System.out::println);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: некорректный id пользователя");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}