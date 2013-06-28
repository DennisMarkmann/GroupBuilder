package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Interfaces.DefaultFrame;
import com.kn.groupBuilder.Gui.Interfaces.MyWindowAdapter;
import com.kn.groupBuilder.Gui.Menu.Listener.SettingsFrameListener;
import com.kn.groupBuilder.Storage.Pojo;
import com.kn.groupBuilder.Storage.Settings;

public final class SettingsFrame extends JFrame implements DefaultFrame {

    private static SettingsFrame instance = null;
    private static final long serialVersionUID = 3141095634381522203L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();
    private static final int TEXT_FIELD_SIZE = 5;

    private SettingsFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this, "Settings");
        this.addWindowListener(new MyWindowAdapter(this));

        this.setSize(500, 370);

        // path
        this.builder.createLabel(this, "Path:", 0, 0);
        final JTextField pathField = this.builder.createTextField(this, "pathField", TEXT_FIELD_SIZE, 1, 0);
        final JButton pathButton = this.builder.createButton(this, "pathButton", "Change Path", 2, 0);

        // language
        this.builder.createLabel(this, "Language:", 0, 1);
        final JComboBox<String> languageBox = this.builder.createComboBox(this, "languageBox", pojo.getLanguageList(), 1, 1);

        // archiving
        this.builder.createLabel(this, "Archiving:", 0, 2);
        final JCheckBox archivingBox = this.builder.createCheckBox(this, "archivingCheckBox", "", 1, 2);
        this.builder.createLabel(this, "Duration [in days]:", 0, 3);
        final JTextField archiveField = this.builder.createTextField(this, "archiveField", TEXT_FIELD_SIZE, 1, 3);

        // format
        this.builder.createLabel(this, "Output format:", 0, 4);
        final JComboBox<String> outputFormatBox = this.builder.createComboBox(
                this,
                "outputFormatBox",
                pojo.getFormatList(),
                1,
                4);

        // automatic
        final JCheckBox sendMailsAutomatically = this.builder.createCheckBox(
                this,
                "sendMailsAutomatically",
                "Send e-Mails automatically: ",
                0,
                5);
        final JCheckBox printOutAutomatically = this.builder.createCheckBox(
                this,
                "printOutAutomatically",
                "Print automatically: ",
                1,
                5);

        // close
        final JButton saveButton = this.builder.createButton(this, "saveButton", "Save", 0, 6);
        final JButton closeButton = this.builder.createButton(this, "closeButton", "Close", 1, 6);

        final SettingsFrameListener listener = new SettingsFrameListener(
                this,
                pojo,
                pathField,
                languageBox,
                archivingBox,
                archiveField,
                outputFormatBox,
                sendMailsAutomatically,
                printOutAutomatically);

        pathButton.addActionListener(listener);
        closeButton.addActionListener(listener);
        saveButton.addActionListener(listener);

        this.updateFrame(
                pojo,
                pathField,
                languageBox,
                archivingBox,
                archiveField,
                outputFormatBox,
                sendMailsAutomatically,
                printOutAutomatically);

        this.setVisible(true);
    }

    private void updateFrame(
            final Pojo pojo,
            final JTextField pathField,
            final JComboBox<String> languageBox,
            final JCheckBox archivingBox,
            final JTextField archiveField,
            final JComboBox<String> outputFormatBox,
            final JCheckBox sendMailsAutomaticallyBox,
            final JCheckBox printOutAutomaticallyBox) {

        final Settings settings = pojo.getSettings();

        this.updatePathField(pathField, pojo);
        archivingBox.setSelected(this.readCheckSettings(settings.isArchived()));
        archiveField.setText(settings.getArchivingDays() + "");
        sendMailsAutomaticallyBox.setSelected(this.readCheckSettings(settings.isSendMailAutomatically()));
        printOutAutomaticallyBox.setSelected(this.readCheckSettings(settings.isPrintAutomatically()));
    }

    public void updatePathField(final JTextField pathField, final Pojo pojo) {
        pathField.setText(pojo.getSettings().getPath());
    }

    private boolean readCheckSettings(final boolean checked) {
        if (checked) {
            return true;
        }
        return false;
    }

    public static SettingsFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new SettingsFrame(pojo);
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
