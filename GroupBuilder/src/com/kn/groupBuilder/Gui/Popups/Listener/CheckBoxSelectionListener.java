package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JCheckBox;

public class CheckBoxSelectionListener implements ItemListener {

    final List<JCheckBox> checkBoxList;

    public CheckBoxSelectionListener(final List<JCheckBox> checkBoxList) {
        this.checkBoxList = checkBoxList;
    }

    @Override
    public void itemStateChanged(final ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            final String sourceName = e.getItemSelectable().toString();

            for (final JCheckBox checkBox : this.checkBoxList) {
                if (sourceName.contains(checkBox.getName())) {
                    this.deselectAllOthers(checkBox.getName());
                }
            }
        }
    }

    private void deselectAllOthers(final String checkBoxName) {
        for (final JCheckBox checkBox : this.checkBoxList) {
            if (!checkBox.getName().equals(checkBoxName)) {
                checkBox.setSelected(false);
            }
        }
    }
}
