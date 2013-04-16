package com.kn.groupBuilder.Storage;

import java.util.ArrayList;

public class Group {

	private String name = "";
	private ArrayList<Member> memberList = new ArrayList<Member>();
	private int fixSize = 0;
	private String description = "";

	public Group(String name) {
		this.name = name;
	}

	public Group(String name, int fixSize) {
		this(name);
		this.fixSize = fixSize;
	}

	public Group(String name, String description) {
		this(name);
		this.description = description;
	}

	public Group(String name, int fixSize, String descrition) {
		this(name, fixSize);
		this.description = descrition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}

	public int getFixSize() {
		return fixSize;
	}

	public void setFixSize(int fixSize) {
		this.fixSize = fixSize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
