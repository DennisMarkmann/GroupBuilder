package com.kn.groupBuilder.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kn.groupBuilder.Storage.Member;

public class MemberTab extends JPanel {

    private static final long serialVersionUID = 3210114640051532404L;

    public MemberTab(final ArrayList<Member> memberList) {

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

    }

    public final void fillTextArea(final JTextArea textArea, final ArrayList<Member> memberList) {

        for (final Member member : memberList) {
            textArea.append(member.getFirstName() + " " + member.getLastName() + System.getProperty("line.separator"));
        }

    }
}
