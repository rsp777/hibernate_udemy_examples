package com.hiberatetutorial.dateutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static LocalDate parsed(String dateStr) throws ParseException {
		LocalDate theDate = LocalDate.parse(dateStr,formatter);
		
		return theDate;
	}
	
//	public static String formatDate(Date theDate) {
//		String result = null;
//		
//		if(theDate !=null) {
//			result = formatter.format(theDate);
//		}
//		
//		return result;
//	}

}
