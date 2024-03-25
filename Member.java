package Library_System;
import java.time.LocalDate;


public class Member {
	private String fName;
	private String lName;
	private String phone;
	private int memberID;
	private LocalDate joined;
	
	
	public Member(String fName, String lName, String phone, int memberID) {
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.memberID = memberID;
	}
	
	public String getFName() {
		return fName;
	}
	
	public void setFName(String fName) {
		this.fName = fName;
	}
	
	public String getLName() {
		return lName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getMemberID() {
		return memberID;
	}
	
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	public LocalDate getJoined() {
		return joined;
	}
	
	public void setJoined(LocalDate joined) {
		this.joined = joined;
	}
	
	public void printMember() {
		System.out.println("Member ID: " + memberID + " First Name: " + fName + " Last Name: " + lName + " Phone Number: " + phone + " Date Joined: " + joined);
	}
	
}
