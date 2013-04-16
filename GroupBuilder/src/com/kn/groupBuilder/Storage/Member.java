package com.kn.groupBuilder.Storage;

import java.util.ArrayList;

public class Member {

	private String firstName = "";
	private String lastName = "";
	private ArrayList<Group> groupList = new ArrayList<Group>();
	private String eMailAdress = "";

	public Member(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Member(String firstName, String lastName, String eMailAdress) {
		this(firstName, lastName);
		this.eMailAdress = eMailAdress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(ArrayList<Group> groupList) {
		this.groupList = groupList;
	}

	public String getEMailAdress() {
		return eMailAdress;
	}

	public void setEMailAdress(String eMailAdress) {
		this.eMailAdress = eMailAdress;
	}

}
