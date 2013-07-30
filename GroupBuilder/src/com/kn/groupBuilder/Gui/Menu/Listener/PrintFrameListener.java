package com.kn.groupBuilder.Gui.Menu.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import com.kn.groupBuilder.Gui.Menu.PrintFrame;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the printFrame. Used to start the printing operation and to close the window.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PrintFrameListener implements ActionListener {

    private final PrintFrame printFrame;
    private final Pojo pojo;
    private final ArrayList<JCheckBox> checkBoxList;

    public PrintFrameListener(final PrintFrame printFrame, final Pojo pojo, final ArrayList<JCheckBox> checkBoxList) {
        this.printFrame = printFrame;
        this.pojo = pojo;
        this.checkBoxList = checkBoxList;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("printButton") == 0) {
            final ArrayList<Group> groupList = new ArrayList<Group>();
            for (final JCheckBox checkBox : this.checkBoxList) {
                if (checkBox.isSelected()) {
                    groupList.add(this.pojo.getGroupByName(checkBox.getName()));
                }
            }
            ConfirmationFrame.getInstance(this.pojo, this.pojo.getMessages("Print"), groupList);
        } else if (buttonClicked.getName().compareTo("selectAllButton") == 0) {
            boolean select = true;
            if (this.printFrame.isSelected()) {
                select = false;
            }
            this.printFrame.setSelected(select);

            for (final JCheckBox checkBox : this.checkBoxList) {
                checkBox.setSelected(select);
            }
            return;
        }
        this.printFrame.closeWindow();

    }

}
