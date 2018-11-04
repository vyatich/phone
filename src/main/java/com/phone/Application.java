package com.phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String user;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please enter second name by user");
            user = reader.readLine();
            phoneBook.getPhones().entrySet()
                    .stream().filter(x -> x.getKey().equals(user))
                    .forEach(System.out :: println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
