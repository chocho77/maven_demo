package com.example;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        
        // Създаваме обект Gson
        Gson gson = new Gson();

        // Създаваме обикновена Java Map (данни)
        Map<String, String> data = new HashMap<>();
        data.put("Status", "Success");
        data.put("Message", "Maven работи отлично с Java 25!");
        data.put("Library", "Gson");

        // Превръщаме обекта в JSON стринг
        String json = gson.toJson(data);

        // Принтираме резултата
        System.out.println("--- Твоят първи JSON от Maven ---");
        System.out.println(json);
    }
}
