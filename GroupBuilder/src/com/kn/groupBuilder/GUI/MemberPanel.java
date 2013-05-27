package com.kn.groupBuilder.GUI;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.kn.groupBuilder.Storage.Member;

public class MemberPanel {

    public MemberPanel(final JTabbedPane tabBar, final ArrayList<Member> memberList) {

        final JPanel memberPanel = new JPanel();
        final JTextArea textArea = new JTextArea(50, 25);
        this.fillTextArea(textArea, memberList);
        memberPanel.add(textArea);

        memberPanel.add(new JButton("Button des memberPanels"));
        tabBar.addTab("Member", memberPanel);

    }

    public final void fillTextArea(final JTextArea textArea, final ArrayList<Member> memberList) {

        for (final Member member : memberList) {
            textArea.append(member.getFirstName() + " " + member.getLastName() + System.getProperty("line.separator"));
        }

    }
}
