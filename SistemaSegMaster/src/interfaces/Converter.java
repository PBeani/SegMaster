package interfaces;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Converter {
	public static LocalDate toLocalDate(String data){		
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(data,formatter);
            return date;
	}
	public static LocalDate profileToLocalDate(String data){		
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(data,formatter);
            return date;
	}
        
        public static String dateToString(LocalDate data) {
            String date = data.toString();
            String[] parts = date.split("-");
            date = parts[2] + "/" + parts[1] + "/" + parts[0];
            return date;
        }
}