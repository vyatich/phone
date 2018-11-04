package com.phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String user;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please enter second name by user");
            user = reader.readLine();
            ArrayList listsOfArrayListPhone = phoneBook.getPhones().entrySet()
                    .stream()
                    .filter(x -> x.getKey().equals(user))
                    .map(x -> x.getValue())
                    .collect(Collectors.toCollection(ArrayList::new));
            ArrayList<String> result = phoneBook.getPhonesAll(listsOfArrayListPhone);
            if (result.size() == 0) {
                System.out.println("Information not found, please, try again");
            } else {
                for (int phoneNumber = 0; phoneNumber < result.size(); phoneNumber++) {
                    System.out.println(phoneNumber + 1 + ". " + result.get(phoneNumber));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
