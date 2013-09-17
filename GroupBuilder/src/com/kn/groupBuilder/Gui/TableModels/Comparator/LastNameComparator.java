package com.kn.groupBuilder.Gui.TableModels.Comparator;

import java.util.Comparator;

import com.kn.groupBuilder.Storage.Member;

public class LastNameComparator implements Comparator<Member> {

	@Override
	public int compare(final Member member1, final Member member2) {
		int result = member1.getLastName().compareTo(member2.getLastName());
		if (result == 0) {
			result = member1.getFirstName().compareTo(member2.getFirstName());
		}
		return result;
	}

}