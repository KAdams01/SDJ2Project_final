package model;

import java.io.Serializable;

public class Paid extends MemberState implements Serializable{

	@Override
	public void changeState(Member member) {
		member.setState(new Unpaid());
	}

}
