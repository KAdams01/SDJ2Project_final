package model;

import java.io.Serializable;

public class Member implements Serializable {
	
	private MemberState memState;
	private String firstName;
	private String lastName;
	private int memberID;
	private MyDate signUpDate;
	
	public Member(String firstName, String lastName, int iD) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.memState = new Unpaid();
		memberID = iD;
		signUpDate = MyDate.getInstance();
	}
	void setState(MemberState state) {
		this.memState = state;
	}
	public String checkState() {
		return memState.getStatus();
	}
	public String changeState() {
		memState.changeState(this);
		return "State changed to " + memState.getStatus();
	}
	public int getID() {
		return memberID;
	}
	public String toString() {
		return firstName + " " + lastName + " " + getID() + " " + checkState();
	}
}