package ru.netology.web;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        CustomData customData = new CustomData();

        System.out.println("Майновая дата " + customData.today());
        System.out.println("Майновая дата на три дня вперед " + customData.future(2));
    }
}