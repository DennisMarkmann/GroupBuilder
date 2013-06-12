package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.kn.groupBuilder.Gui.Popups.CreateMemberFrame;
import com.kn.groupBuilder.Storage.Member;

public class CreateMemberListener implements ActionListener {

    private final CreateMemberFrame createMemberFrame;
    private final ArrayList<Member> memberList;

    public CreateMemberListener(final CreateMemberFrame createMemberFrame, final ArrayList<Member> memberList) {

        this.createMemberFrame = createMemberFrame;
        this.memberList = memberList;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
