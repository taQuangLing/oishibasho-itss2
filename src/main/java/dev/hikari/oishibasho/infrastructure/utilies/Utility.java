package dev.hikari.oishibasho.infrastructure.utilies;

import org.apache.coyote.Request;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utility {
    public static Integer random(Integer a, Integer b){
        Random random = new Random();

        // Sinh số ngẫu nhiên trong phạm vi từ a đến b
        return random.nextInt(b - a + 1) + a;
    }

    public static double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
        // Bán kính trái đất ở đơn vị km
        double earthRadius = 6371.0;

        // Chuyển đổi về radian
        double radiansLat1 = Math.toRadians(lat1);
        double radiansLon1 = Math.toRadians(lon1);
        double radiansLat2 = Math.toRadians(lat2);
        double radiansLon2 = Math.toRadians(lon2);

        // Sự chênh lệch giữa các vĩ độ và kinh độ
        double deltaLat = radiansLat2 - radiansLat1;
        double deltaLon = radiansLon2 - radiansLon1;

        // Công thức Haversine
        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                Math.cos(radiansLat1) * Math.cos(radiansLat2) *
                        Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Khoảng cách
        double distance = earthRadius * c;

        return distance;
    }
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
