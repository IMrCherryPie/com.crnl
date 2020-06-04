package com.crnl.service;

import sun.util.calendar.LocalGregorianCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@org.springframework.stereotype.Service
public class Service {

    public int daysBetween(java.sql.Date d1, java.sql.Date d2) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

        Date date1 = sdf.parse(d1.toString());
        Date date2 = sdf.parse(d2.toString());

        return (int)( (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
