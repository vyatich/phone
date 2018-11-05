package com.phone;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class PhoneBookTest {

    private final PhoneBook phoneBook = new PhoneBook();
    private ArrayList phones = new ArrayList();
    private ArrayList<ArrayList<String>> phonesAll = new ArrayList<>();
    private String phonesByUser;
    private String user;

    @Before
    public void setUp() {
        phones.add("+8 800 2000 500");
        phones.add("+8 800 200 600");
        phonesByUser = "+8 800 2000 500,+8 800 200 600";
        user = "Иванов И.И.";
        phonesAll.add(phones);
    }


    @Test
    public void getPhones_shouldHashMap() {
        final HashMap<String, ArrayList> expectedValue = new HashMap<>();

        final HashMap<String, ArrayList> actualValue = phoneBook.getPhones();

        assertEquals(expectedValue.getClass(), actualValue.getClass());
    }

    @Test
    public void getPhones_notNull() {
        final HashMap<String, ArrayList> actualValue = phoneBook.getPhones();

        assertNotNull(actualValue);
    }

    @Test
    public void getPhonesAll_notNull() {
        final ArrayList<String> actualValue = phoneBook.getPhonesAll(phonesAll);

        assertNotNull(actualValue);
    }

    @Test
    public void getPhonesAll_shouldPhonesList() {
        final ArrayList<ArrayList<String>> expectedValue = phones;

        final ArrayList<String> actualValue = phoneBook.getPhonesAll(phonesAll);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getListsOfArrayListPhone_notNull(){
        final ArrayList<ArrayList<String>> actualValue = phoneBook.getListsOfArrayListPhone(user);

        assertTrue(actualValue.size() != 0);
    }

    @Test
    public void getListsOfArrayListPhone_shouldBeList(){
        final ArrayList<ArrayList<String>> expectedValue = phonesAll;

        final ArrayList<ArrayList<String>> actualValue = phoneBook.getListsOfArrayListPhone(user);

        assertEquals(expectedValue, actualValue);
    }

}
