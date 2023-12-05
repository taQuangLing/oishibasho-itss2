package dev.hikari.oishibasho.infrastructure.utilies;

import org.apache.coyote.Request;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility {
    public static Pageable paginationAndSorting(int page, int size, String sortBy){
        if (sortBy == null)return PageRequest.of(page, size);
        Pageable pageable;
        if (typeOfSort(sortBy).equals("desc")){
            pageable = PageRequest.of(page, size, Sort.by(getFieldOfSort(sortBy)).descending());
        }else{
            pageable = PageRequest.of(page, size);
        }
        return pageable;
    }
    public static LocalDate formatToDate(String date, String form){
        if (form == null)form = "dd/MM/yyyy";
        if (date == null)return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(form);

       return LocalDate.parse(date, formatter);
    }
    public static LocalDateTime formatToDateTime(String dateTime, String form){
        if (form == null)form = "dd/MM/yyyy HH:mm:ss";
        if (dateTime == null)return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(form);

        return LocalDateTime.parse(dateTime, formatter);
    }
    public static String formatDateTimeToString(LocalDateTime dateTime, String form){
        if (form == null)form = "dd/MM/yyyy HH:mm:ss";
        if (dateTime == null)return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(form);

       return dateTime.format(formatter);
    }
    public static String formatDateTimeToString(LocalDate dateTime, String form){
        if (form == null)form = "dd/MM/yyyy";
        if (dateTime == null)return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(form);

        return dateTime.format(formatter);
    }
    public static String typeOfSort(String sortBy){
        if (sortBy == null)return null;
        return sortBy.substring(sortBy.indexOf(':') + 1);
    }
    public static String getFieldOfSort(String sortBy){
        if (sortBy == null)return null;
        return  sortBy.substring(0, sortBy.indexOf(':'));
    }

    public static void main(String[] args) {
        System.out.println(getFieldOfSort("add:desc"));
    }
}
