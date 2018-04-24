package model;

import java.io.Serializable;

public class Unpaid extends MemberState implements Serializable{

	@Override
	public void changeState(Member member) {
		member.setState(new Paid());
	}

}
