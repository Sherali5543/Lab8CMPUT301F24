package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return city
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Create a city
     * Assert city does not exist in list
     * Add city to list
     * Assert city exists in list
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * Ensures cannot delete a city that doesn't exist
     * Ensures deletes city
     */
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        City city = new City("Edmonton", "AB");
        list.deleteCity(city);
        assertEquals(list.getCount(), listSize);
        list.addCity(city);
        listSize = list.getCount();
        list.deleteCity(city);
        assertEquals(list.getCount(), listSize-1);
    }

    /**
     * Checks no cities in list
     * Checks 1 city in list
     */
    @Test
    public void countCitiesTest(){
        list = MockCityList();
        int listSize = list.getCount();
        assertEquals(list.countCities(), listSize);
        list.addCity(new City("Edmonton","AB"));
        assertEquals(list.countCities(), listSize+1);
    }
}