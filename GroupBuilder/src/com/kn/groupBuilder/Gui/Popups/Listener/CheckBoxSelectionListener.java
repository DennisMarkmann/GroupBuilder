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
        final String sourceName = e.getItemSelectable().toString();
        String checkBoxName = "";
        if (sourceName.contains("buildCompleteCheckBox")) {
            checkBoxName = "buildCompleteCheckBox";
        } else if (sourceName.contains("buildSelectedCheckBox")) {
            checkBoxName = "buildSelectedCheckBox";
        } else if (sourceName.contains("buildUnassignedCheckBox")) {
            checkBoxName = "buildUnassignedCheckBox";
        } else if (sourceName.contains("buildSingleCheckBox")) {
            checkBoxName = "buildSingleCheckBox";
        }
        if (e.getStateChange() == ItemEvent.SELECTED) {
            this.deselectAllOthers(checkBoxName);
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
