package com.keitaproject.Lesson2.controller;
import com.keitaproject.Lesson2.service.PersonService;
import com.keitaproject.Lesson2.service.PersonServiceImpl;
import com.keitaproject.Lesson2.storage.PersonStorage;
import com.keitaproject.Lesson2.storage.PersonStorageImpl;
import java.util.Scanner;
public class PersonController {
    private Scanner scanner = new Scanner(System.in);
    private PersonService personService = new PersonServiceImpl(new PersonStorageImpl());
    public void start() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберите действие:\n" +
                    "1. Добавить запись\n" +
                    "2. Редактировать запись\n" +
                    "3. Список всех записей\n" +
                    "4. Удалить запись\n" +
                    "5. Поиск записи\n" +
                    "6. Выйти из программы\n");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    list();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    isExit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор, попробуйте еще раз.");
            }
        }
    }
    private void add() {
        scanner.nextLine();
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите возраст:");
        int age = scanner.nextInt();
        personService.add(name, age);
        System.out.println("Запись добавлена.");
    }
    private void update() {
        System.out.println("Введите Id записи для редактирования:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите новое имя:");
        String name = scanner.nextLine();
        System.out.println("Введите новый возраст:");
        int age = scanner.nextInt();
        personService.update(id, name, age);
        System.out.println("Запись изменена.");
    }
    private void list() {
        personService.list().forEach(System.out::println);
    }
    private void delete() {
        System.out.println("Введите Id записи для удаления:");
        int id = scanner.nextInt();
        personService.delete(id);
        System.out.println("Запись удалена.");
    }
    private void search() {
        scanner.nextLine();
        System.out.println("Введите имя для поиска:");
        String name = scanner.nextLine();
        personService.search(name).forEach(System.out::println);
        System.out.println("Если вы увидели результат выше - то такой пользователь существует.");
    }
}