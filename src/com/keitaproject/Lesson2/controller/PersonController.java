package com.keitaproject.Lesson2.controller;
import com.keitaproject.Lesson2.service.PersonService;
import com.keitaproject.Lesson2.service.PersonServiceImpl;
import com.keitaproject.Lesson2.storage.PersonStorageImpl;
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
        scanner.nextLine();
        System.out.println("Введите имя:");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Введите отчество:");
        String middleName = scanner.nextLine();
        System.out.println("Введите возраст:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите дату рождения в формате гггг-мм-дд:");
        String dateOfBirth = scanner.nextLine();
        personService.add(firstName, lastName, middleName, age, dateOfBirth);
        System.out.println("Запись добавлена.");
    }
    private void update() {
        System.out.println("Введите id записи для редактирования:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите новое имя:");
        String firstName = scanner.nextLine();
        System.out.println("Введите новую фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Введите новое отчество:");
        String middleName = scanner.nextLine();
        System.out.println("Введите новый возраст:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите дату рождения в формате гггг-мм-дд:");
        String dateOfBirth = scanner.nextLine();
        personService.update(id, firstName, lastName, middleName, age, dateOfBirth);
        System.out.println("Запись изменена.");
    }
    private void list() {
        System.out.println("Список всех записей:");
        personService.list().forEach(System.out::println);
    }
    private void delete() {
        System.out.println("Введите id записи для удаления:");
        int id = scanner.nextInt();
        personService.delete(id);
        System.out.println("Запись удалена, если она существовала. Проверьте это через - 3");
    }
    private void search() {
        scanner.nextLine();
        System.out.println("Введите id пользователя для поиска:");
        String id = scanner.nextLine();
        personService.searchById(Integer.parseInt(id)).forEach(System.out::println);
        System.out.println("Если вы увидели результат выше - то такой пользователь существует.");
    }
}