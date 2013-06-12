package com.kn.groupBuilder.HelperClasses;

import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuiBuilder {

    public JButton createButton(
            final JFrame frame,
            final String buttonName,
            final String buttonText,
            final GridBagConstraints c,
            final int gridxValue,
            final int gridyValue) {

        final JButton button = new JButton(buttonText);
        this.setName(button, buttonName);
        this.setPosition(frame, c, gridxValue, gridyValue, button);

        return button;
    }

    public JLabel createLabel(
            final JFrame frame,
            final String labelText,
            final GridBagConstraints c,
            final int gridxValue,
            final int gridyValue) {

        final JLabel label = new JLabel(labelText);
        this.setPosition(frame, c, gridxValue, gridyValue, label);

        return label;
    }

    public JTextField createTextField(
            final JFrame frame,
            final int textFieldSize,
            final GridBagConstraints c,
            final int gridxValue,
            final int gridyValue) {

        final JTextField textField = new JTextField(textFieldSize);
        this.setPosition(frame, c, gridxValue, gridyValue, textField);

        return textField;
    }

    private void setName(final Component object, final String objectName) {
        object.setName(objectName);
    }

    private void setPosition(
            final JFrame frame,
            final GridBagConstraints c,
            final int gridxValue,
            final int gridyValue,
            final Component object) {

        c.gridx = gridxValue;
        c.gridy = gridyValue;
        frame.add(object, c);
    }
}
