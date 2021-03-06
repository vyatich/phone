package com.phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Application {

    private static PhoneBook phoneBook = new PhoneBook();
    private static String user;

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please enter name of user");
            user = reader.readLine();
        } catch (IOException e) {
            System.out.println("Input|output error");
        }
        writePhones();
    }

    private static void writePhones() {
        ArrayList<String> resultPhones = phoneBook.getPhonesAll(phoneBook.getListsOfArrayListPhone(user));
        if (resultPhones.size() == 0) {
            System.out.println("Information not found, please, try again");
        } else {
            for (int phoneNumber = 0; phoneNumber < resultPhones.size(); phoneNumber++) {
                System.out.println(phoneNumber + 1 + ". " + resultPhones.get(phoneNumber));
            }
        }
    }

}
