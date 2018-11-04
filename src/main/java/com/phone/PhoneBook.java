package com.phone;

import java.util.*;

public class PhoneBook {

    private HashMap<String, ArrayList> phones;

    public PhoneBook() {
        HashMap<String, ArrayList> allPhones = new HashMap<String, ArrayList>();
        ArrayList cache = new ArrayList();
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
}
