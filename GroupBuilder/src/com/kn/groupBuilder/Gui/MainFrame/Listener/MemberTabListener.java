package com.kn.groupBuilder.Gui.MainFrame.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Popups.CreateMemberFrame;
import com.kn.groupBuilder.Storage.Member;

public class MemberTabListener implements ActionListener {

    private final ArrayList<Member> memberList;

    public MemberTabListener(final ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("addButton") == 0) {
            new CreateMemberFrame(this.memberList);

        }
    }
}
