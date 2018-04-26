package model;

import java.io.Serializable;
import java.util.ArrayList;

public class MemberList implements Serializable {

	private ArrayList<Member> listOfMembers;
	private UniqueCounter count;

	public MemberList() {
		listOfMembers = new ArrayList<Member>();
		count = new UniqueCounter();
	}

	public void setMemberList(ArrayList<Member> memList) {
		this.listOfMembers = memList;
	}

	public ArrayList<String> getAllUnpaid() {
		ArrayList<String> unpaid = new ArrayList<String>();
//		unpaid.add("First Name " + "Last Name " + " ID " + " Status");
		for (int i = 0; i < listOfMembers.size(); i++) {
			if (listOfMembers.get(i).checkState().equalsIgnoreCase("unpaid")) {
				unpaid.add(listOfMembers.get(i).toString());
			}
		}
		unpaid.add("");
		return unpaid;
	}

	public void addMember(String fName, String lName) {
		Member memb = new Member(fName, lName, count.getCount());
		listOfMembers.add(memb);
	}

	public void addMember(Member member) {
		listOfMembers.add(member);
	}

	public Member dequeueMember(int memberID) {
		for (int i = 0; i < listOfMembers.size(); i++) {
			if (memberID == listOfMembers.get(i).getID()) {
				Member temp = listOfMembers.get(i);
				listOfMembers.remove(i);
				return temp;
			}
		}
		return null;
	}

	public Member findMember(int memberID) {
		for (int i = 0; i < listOfMembers.size(); i++) {
			if (memberID == listOfMembers.get(i).getID()) {
				return listOfMembers.get(i);
			}
		}
		return null;
	}

}
