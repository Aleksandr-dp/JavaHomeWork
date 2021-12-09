package com.pb.avrakhov.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Создать в пакете hw11 консольное приложение "Телефонная книга". Каждый элемент должен иметь:
 * ФИО; дата рождения; телефоны (количество не ограничено); адрес; дата и время редактирования
 *
 * Обеспечить следующий функционал: добавление элемента; удаление элемента; поиск элементов; вывод всех записей с
 * сортировкой по указанному полю (можно ограничиться двумя на выбор); редактирование элемента; запись в файл всех
 * данных; загрузка из файла всех данных
 */
public class PhoneBook {
    public static List<Contact> contacts = new ArrayList<>();
    public static final String path = "src\\com\\pb\\avrakhov\\hw11\\files\\";

    public static void main(String[] args) throws Exception {
        //Default data
        contacts.add(new Contact("Ivanov", "01.01.2001", Arrays.asList("380501111111", "380505555555"), "Ukraine"));
        contacts.add(new Contact("Sidorov", "02.02.2002", Arrays.asList("3805012345678", "3806798765432"), "Turkey"));
        contacts.add(new Contact("Agafonov", "04.04.2004", Arrays.asList("380502222222", "380673579514"), "Poland"));

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nMake a choice:");
            System.out.println("1. Add Contact.");
            System.out.println("2. Delete Contact.");
            System.out.println("3. Search Contact.");
            System.out.println("4. Sort by Name.");
            System.out.println("5. Sort by edited date.");
            System.out.println("6. Edit Contact.");
            System.out.println("7. Add to file.");
            System.out.println("8. Load from file.");
            System.out.println("9. Show Phone Book.");
            System.out.println("0. Exit.");

            String option = scan.nextLine();

            switch (option) {
                case "1":
                    addContact(scan);
                    break;
                case "2":
                    delContact(scan);
                    break;
                case "3":
                    search(scan);
                    break;
                case "4":
                    sortByName(scan);
                    break;
                case "5":
                    sortByDate(scan);
                    break;
                case "6":
                    editContact(scan);
                    break;
                case "7":
                    addToFile();
                    break;
                case"8":
                    loadFromFile();
                    break;
                case "9":
                    for(Contact i: contacts) {
                        System.out.println(i);
                    }
                    break;
                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Wrong menu number!");
            }
        }
    }

    public static void addContact(Scanner scan) {
        System.out.println("Enter your full name:");
        String name = scan.nextLine();

        System.out.println("Enter your date of birth:");
        String DOB = scan.nextLine();

        boolean myCase = true;
        List<String> phones = new ArrayList<>();

        while (myCase) {
            System.out.println("Enter your phone:");
            String phone = scan.nextLine();
            phones.add(phone);

            System.out.println("Make a choice:");
            System.out.println("1. Add another phone.");
            System.out.println("2. Exit.");

            String choice = scan.nextLine();

            if(Objects.equals(choice, "2")) {
                myCase = false;
            }
        }

        System.out.println("Enter your address:");
        String address = scan.nextLine();

        contacts.add(new Contact(name, DOB, phones, address));
    }

    public static void delContact(Scanner scan) {
        System.out.println("Enter a Name to delete:");
        String name = scan.nextLine();

        boolean myCase = contacts.removeIf(item -> Objects.equals(item.getName(), name));

        if(myCase) {
            System.out.println("Contact " + name + " was delete.");
        } else {
            System.out.println("Contact not found!");
        }
    }

    public static void search(Scanner scan) {
        System.out.println("Enter a Name for Search:");
        String name = scan.nextLine();
        String searchContact = null;

        for(Contact item: contacts) {
            if(Objects.equals(item.getName(), name)) {
                searchContact = item.toString();
                break;
            }
        }

        if(searchContact == null) {
            System.out.println("Contact not found!");
        } else {
            System.out.println(searchContact);
        }
    }

    public static void sortByName(Scanner scan) {
        System.out.println("Before sort:");
        for(Contact i: contacts) {
            System.out.println(i);
        }

        contacts.sort(Comparator.comparing(Contact::getName));

        System.out.println("After sort:");
        for(Contact i: contacts) {
            System.out.println(i);
        }
    }

    public static void sortByDate(Scanner scan) {
        System.out.println("Before sort:");
        for(Contact i: contacts) {
            System.out.println(i);
        }

        contacts.sort(Comparator.comparing(Contact::getDateNTime));

        System.out.println("After sort:");
        for(Contact i: contacts) {
            System.out.println(i);
        }
    }

    public static void editContact(Scanner scan) {
        System.out.println("Enter a Name for Edit:");
        String name = scan.nextLine();
        String field = "";

        while (!Objects.equals(field, "4")) {
            System.out.println("Which field to edit:");
            System.out.println("1. Date of birth.\n2. Phone.\n3. Address.\n4. Exit.");
            field = scan.nextLine();

            switch (field) {
                case "1":
                    System.out.println("Enter a new DOB:");
                    String newDOB = scan.nextLine();
                    for(Contact item: contacts) {
                        if(Objects.equals(item.getName(), name)) {
                            item.setDOB(newDOB);
                            break;
                        }
                    }
                    break;
                case "2":
                    boolean myCase = true;
                    List<String> phones = new ArrayList<>();

                    while (myCase) {
                        System.out.println("Enter your phone:");
                        String phone = scan.nextLine();
                        phones.add(phone);

                        System.out.println("Make a choice:");
                        System.out.println("1. Add another phone.");
                        System.out.println("2. Exit.");

                        String choice = scan.nextLine();

                        if(Objects.equals(choice, "2")) {
                            myCase = false;
                        }
                    }

                    for(Contact item: contacts) {
                        if(Objects.equals(item.getName(), name)) {
                            item.setPhones(phones);
                            break;
                        }
                    }
                    break;
                case "3":
                    System.out.println("Enter a new Address:");
                    String newAddress = scan.nextLine();
                    for(Contact item: contacts) {
                        if(Objects.equals(item.getName(), name)) {
                            item.setAddress(newAddress);
                            break;
                        }
                    }
                    break;
                case "4":
                    System.out.println("Contact is change.");
                    break;
                default:
                    System.out.println("Wrong menu number!");
            }

            Date date = new Date();
            for(Contact item: contacts) {
                if(Objects.equals(item.getName(), name)) {
                    item.setDateNTime(date);
                    break;
                }
            }
        }
    }

    public static void addToFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(contacts);

        try(Writer writer = new FileWriter("src\\com\\pb\\avrakhov\\hw11\\files\\json.txt")) {
            writer.write(json);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(json);
    }

    public static void loadFromFile() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Path path = Paths.get("src\\com\\pb\\avrakhov\\hw11\\files\\json.txt");
            List<String> json = Files.readAllLines(path, StandardCharsets.UTF_8);
            List<Contact> newContacts = mapper.readValue(json.toString(), List.class);

            System.out.println(newContacts.toString());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
