package com.phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook {

    private HashMap<String, ArrayList> phones;

    public PhoneBook() {
        HashMap<String, ArrayList> allPhones = new HashMap<String, ArrayList>();
        allPhones.put("Иванов И.И.", getPhonesAsArrayList("+8 800 2000 500,+8 800 200 600"));
        allPhones.put("Петров П.П.", getPhonesAsArrayList("+8 800 2000 700"));
        allPhones.put("Сидоров С.С.", getPhonesAsArrayList("+8 800 2000 800,+8 800 2000 900,+8 800 2000 000"));
        this.phones = allPhones;
    }

    public HashMap<String, ArrayList> getPhones() {
        return phones;
    }

    private ArrayList getPhonesAsArrayList(String input) {
        String[] strValues = input.split(",");
        return new ArrayList<String>(Arrays.asList(strValues));
    }

    public ArrayList<String> getPhonesAll(ArrayList<ArrayList<String>> listsOfArrayListPhone) {
        ArrayList<String> phones = listsOfArrayListPhone
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toCollection(ArrayList::new));
        return phones;
    }

    public ArrayList<ArrayList<String>> getListsOfArrayListPhone(String user) {
        ArrayList listsOfArrayListPhone = this.getPhones().entrySet()
                .stream()
                .filter(x -> x.getKey().equals(user))
                .map(x -> x.getValue())
                .collect(Collectors.toCollection(ArrayList::new));
        return listsOfArrayListPhone;
    }
}
