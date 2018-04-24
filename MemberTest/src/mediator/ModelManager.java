package mediator;

import java.io.Serializable;
import java.util.ArrayList;

import model.Member;
import model.MemberList;
import model.UniqueCounter;

public class ModelManager implements Serializable{
	private MemberList memberList;
	private String returnMessage;

	public ModelManager() {
		memberList = new MemberList();
		returnMessage = "";
	}

	public void payFee(int memberID) {
		Member member = memberList.dequeueMember(memberID);
		if (member != null) {
			if (member.checkState().equalsIgnoreCase("paid")) {
				setReturnMessage("Already paid");
			} else {
				setReturnMessage(member.changeState());
			}
			memberList.addMember(member);
		} else {
			setReturnMessage("Member not found!");
		}
		sendReturnMessage();
	}

	public void setReturnMessage(String message) {
		returnMessage = message;
	}

	public String sendReturnMessage() {
		return returnMessage;
	}

	public void addMemberToList(String firstName, String lastName) {
		memberList.addMember(firstName, lastName);
	}

	public ArrayList<String> getUnpaidMembers() {
		return memberList.getAllUnpaid();
	}

	public MemberList getMemberList() {
		return memberList;
	}

	public void setMemberList(MemberList memberList) {
		this.memberList = memberList;
	}
}
