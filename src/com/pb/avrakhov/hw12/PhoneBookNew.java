package com.pb.avrakhov.hw12;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PhoneBookNew {
    public static List<ContactNew> contacts = new ArrayList<>();
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        //Default data
        contacts.add(new ContactNew("Ivanov", "01.01.2001", Arrays.asList("380501111111", "380505555555"), "Ukraine"));
        contacts.add(new ContactNew("Sidorov", "02.02.2002", Arrays.asList("3805012345678", "3806798765432"), "Turkey"));
        contacts.add(new ContactNew("Agafonov", "04.04.2004", Arrays.asList("380502222222", "380673579514"), "Poland"));

        Scanner scan = new Scanner(System.in);

        //Main menu
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
            String json;

            switch (option) {
                case "1":       //Add Contact
                    addContact(scan);
                    break;
                case "2":       //Delete Contact
                    System.out.println("Enter a Name to delete:");
                    String delName = scan.nextLine();
                    boolean myCase = contacts.removeIf(item -> Objects.equals(item.getName(), delName));
                    System.out.println(myCase ? "Contact " + delName + " was delete." : "Contact not found!");
                    break;
                case "3":       //Search Contact
                    System.out.println("Enter a Name for Search:");
                    String searchName = scan.nextLine();
                    String searchContact = contacts.stream().filter(item -> Objects.equals(item.getName(), searchName)).findFirst().map(ContactNew::toString).orElse(null);
                    System.out.println(searchContact != null ? searchContact : "Contact not found!");
                    break;
                case "4":       //Sort by Name
                    System.out.println("Before sort:");
                    contacts.forEach(System.out::println);
                    contacts.sort(Comparator.comparing(ContactNew::getName));
                    System.out.println("After sort:");
                    contacts.forEach(System.out::println);
                    break;
                case "5":       //Sort by edited Date
                    System.out.println("Before sort:");
                    contacts.forEach(System.out::println);
                    contacts.sort(Comparator.comparing(ContactNew::getDateNTime));
                    System.out.println("After sort:");
                    contacts.forEach(System.out::println);
                    break;
                case "6":       //Edit Contact
                    editContact(scan);
                    break;
                case "7":       //Add JSON to File
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);
                    json = mapper.writeValueAsString(contacts);

                    try (Writer writer = new FileWriter("src\\com\\pb\\avrakhov\\hw12\\files\\json.txt")) {
                        writer.write(json);
                    }

                    System.out.println(json);
                    break;
                case"8":        //Read JSON from File
                    json = new String(Files.readAllBytes(Paths.get("src\\com\\pb\\avrakhov\\hw12\\files\\json.txt")), StandardCharsets.UTF_8);
                    mapper.readValue(json, List.class).forEach(System.out::println);
                    break;
                case "9":       //Show All Contacts
                    contacts.forEach(System.out::println);
                    break;
                case "0":       //Exit
                    System.out.println("Bye!");
                    return;
                default:        //Error
                    System.out.println("Wrong menu number!");
            }
        }
    }

    //Add contact to Phone Book
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

            if(Objects.equals(choice, "2")) myCase = false;
        }

        System.out.println("Enter your address:");
        String address = scan.nextLine();

        contacts.add(new ContactNew(name, DOB, phones, address));
    }

    //Edit contact
    public static void editContact(Scanner scan) {
        System.out.println("Enter a Name for Edit:");
        String name = scan.nextLine();
        String field = "";

        while (!Objects.equals(field, "4")) {
            System.out.println("Which field to edit: \n1. Date of birth.\n2. Phone.\n3. Address.\n4. Exit.");
            field = scan.nextLine();

            switch (field) {
                case "1":
                    System.out.println("Enter a new DOB:");
                    String newDOB = scan.nextLine();
                    contacts.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().ifPresent(item -> item.setDOB(newDOB));
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

                        if(Objects.equals(choice, "2")) myCase = false;
                    }

                    contacts.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().ifPresent(item -> item.setPhones(phones));
                    break;
                case "3":
                    System.out.println("Enter a new Address:");
                    String newAddress = scan.nextLine();
                    contacts.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().ifPresent(item -> item.setAddress(newAddress));
                    break;
                case "4":
                    System.out.println("Contact is change.");
                    break;
                default:
                    System.out.println("Wrong menu number!");
            }

            Date date = new Date();
            contacts.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().ifPresent(item -> item.setDateNTime(date));
        }
    }
}
