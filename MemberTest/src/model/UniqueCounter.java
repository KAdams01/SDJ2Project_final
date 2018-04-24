package model;

import java.io.Serializable;

public class UniqueCounter implements Serializable{
	
	private int count;
	
	public UniqueCounter() {
		count = 0;
	}

	public int getCount() {
		count++;
		return count;
	}

}
