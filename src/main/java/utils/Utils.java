package main.java.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Utils {
    
    private static SimpleDateFormat oldTimeFormat = new  SimpleDateFormat("HH:mm");
    private static SimpleDateFormat newTimeFormat = new SimpleDateFormat("h:mm a");
    private static SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMM,  yy");

    public static String convertTimeFormat (String time) {
        String newTime = null;
        
        try{
            Date d = oldTimeFormat.parse(time);
            newTime = newTimeFormat.format(d).toUpperCase();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return newTime;
    }

    public static String convertIntToDay (int i) {
        return DayOfWeek.of(i).toString();
    }

    public static String getNextDateOfDay(String s){
        String date = null;
        String day = s.toUpperCase();
        date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.valueOf(day))).toString();

        return date;
    }

    public static String formatDate(String dateToFormat) {
        String date = null;

        try{
            Date formattedDate = oldDateFormat.parse(dateToFormat);
            date =  newDateFormat.format(formattedDate);
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
