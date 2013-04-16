package com.kn.groupBuilder.Storage;

import java.util.ArrayList;

public class Pojo {

	private String defaultPath = System.getProperty("user.home")
			+ "\\Desktop\\" + "\\GroupBuilder\\";

	private ArrayList<Member> memberList = new ArrayList<Member>();;
	private ArrayList<Group> groupList = new ArrayList<Group>();

	public String getDefaultPath() {
		return defaultPath;
	}

	public void setDefaultPath(String defaultPath) {
		this.defaultPath = defaultPath;
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}

	public ArrayList<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(ArrayList<Group> groupList) {
		this.groupList = groupList;
	}
}
