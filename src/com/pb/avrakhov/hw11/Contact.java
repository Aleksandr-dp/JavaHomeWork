package com.pb.avrakhov.hw11;

import java.util.Date;
import java.util.List;

/**
 * Каждый элемент должен иметь: ФИО; дата рождения; телефоны (количество не ограничено); адрес; дата и время редактирования
 */
public class Contact implements Comparable<Contact> {
    private final String name;
    private String DOB;
    private List<String> phones;
    private String address;
    private Date DateNTime = new Date();

    public Contact(String name, String DOB, List<String> phones, String address) {
        this.name = name;
        this.DOB = DOB;
        this.phones = phones;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

    public List<String> getPhones() {
        return phones;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateNTime() {
        return DateNTime;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateNTime(Date dateNTime) {
        DateNTime = dateNTime;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", DOB='" + DOB + '\'' +
                ", phones=" + phones +
                ", address='" + address + '\'' +
                ", DateNTime='" + DateNTime + '\'' +
                '}';
    }

    @Override
    public int compareTo(Contact o) {
        return 0;
    }
}
