package com.excelconverterweb.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
    SimpleDateFormat format;
    Date date;

    public String getDate() {
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        date = new Date();
        return format.format(date);
    }
}
