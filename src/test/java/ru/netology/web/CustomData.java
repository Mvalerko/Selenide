package ru.netology.web;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CustomData {

    protected String today() {

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        String dateString = formatForDateNow.format(date);

        return dateString;

    }

    protected String future(int addDayOpt) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        calendar.add(Calendar.DAY_OF_MONTH, addDayOpt);
        String dateString = formatForDateNow.format(calendar.getTime());

        return dateString;

    }

    protected String futureLocalDate (int addDayOpt) {

            return LocalDate.now().plusDays(addDayOpt).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }
}
