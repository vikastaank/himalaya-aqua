package com.himalaya.aqua.aqua.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;

public class DateFormatter {

	// Date Format is Lock in LocalDateTimeSerializer, so we have to use this format
	// to all application.
	private static final SimpleDateFormat input_formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm");
	private static final SimpleDateFormat input_formatter_with_out_time = new SimpleDateFormat("yyyy-mm-dd");

	public static String format(String strDate, String format) throws HimalayaAquaException {
		SimpleDateFormat output_formatter = new SimpleDateFormat(format);

		Date date = null;
		try {
			date = input_formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			try {
				date = input_formatter_with_out_time.parse(strDate);
			} catch (ParseException e1) {
				e.printStackTrace();
				throw new HimalayaAquaException(e1);
			}
		}
		return output_formatter.format(date);
	}
}
