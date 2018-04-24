package model;

public abstract class MemberState {
	
	public abstract void changeState(Member member);
	
	public String getStatus() {
		return getClass().getSimpleName();
	}

}
