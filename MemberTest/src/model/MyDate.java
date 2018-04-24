package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class MyDate implements Serializable{
	private Calendar calendar;
	private static MyDate myDate;

	private MyDate() {
		calendar = Calendar.getInstance();
	}

	public static MyDate getInstance() {
		if (myDate == null) {
			return new MyDate();
		}
		return myDate;
	}

	public int getDay() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public int getMonth() {
		return calendar.get(Calendar.MONTH);
	}

	public int getYear() {
		return calendar.get(Calendar.YEAR);
	}

	public Date getDate() {
		Date date = calendar.getTime();
		return date;
	}
	public String toString() {
		return getDay() + "/" + (getMonth()+1) + "/" + getYear();
	}
}
