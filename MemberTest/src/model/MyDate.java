package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class MyDate implements Serializable{
	private static Calendar calendar;
	private static MyDate myDate;

	private MyDate() {
		calendar = Calendar.getInstance();
	}

	public synchronized static MyDate getInstance() {
		if (myDate == null) {
			System.out.println("FirstMyDate");
			myDate = new MyDate();
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
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		ois.defaultReadObject();
		myDate = this;
	}
	private Object readResolve() {
		return myDate;
	}
	
}
