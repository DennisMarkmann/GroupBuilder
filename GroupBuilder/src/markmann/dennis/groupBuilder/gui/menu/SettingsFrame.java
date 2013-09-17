package markmann.dennis.groupBuilder.gui.menu;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import markmann.dennis.groupBuilder.gui.menu.listener.SettingsFrameListener;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.storage.Pojo;
import markmann.dennis.groupBuilder.storage.Settings;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to change information concerning the behavior of the application.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class SettingsFrame extends JFrame implements DefaultFrame {

    private static SettingsFrame instance = null;
    private static final long serialVersionUID = 3141095634381522203L;
    private Pojo pojo = null;

    private SettingsFrame(final Pojo pojo) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getTranslation("Settings"));
        this.addWindowListener(new MyWindowAdapter(this));
        this.setSize(555, 370);

        // path
        final JPanel pathPanel = BUILDER.createCombiPanel(
                this,
                "pathButton",
                pojo.getTranslation("ChangePath"),
                "pathField",
                37,
                0,
                0);

        final JTextField pathField = (JTextField) pathPanel.getComponent(0);
        final JButton pathButton = (JButton) pathPanel.getComponent(1);

        // language
        BUILDER.createLabel(this, pojo.getTranslation("Language"), 0, 1);
        final JComboBox<String> languageBox = BUILDER.createComboBox(this, "languageBox", pojo.getLanguageList(), 1, 1);

        // archiving
        BUILDER.createLabel(this, pojo.getTranslation("Archiving"), 0, 2);
        final JCheckBox archivingBox = BUILDER.createCheckBox(this, "archivingBox", "", 1, 2);
        BUILDER.createLabel(this, pojo.getTranslation("Duration"), 0, 3);
        final JTextField archiveField = BUILDER.createTextField(this, "archiveField", TEXT_FIELD_SIZE, 1, 3);

        // printer
        final JPanel printerPanel = BUILDER.createCombiPanel(
                this,
                "printerButton",
                pojo.getTranslation("ChangePrinter"),
                "printerField",
                35,
                0,
                4);
        final JTextField printerField = (JTextField) printerPanel.getComponent(0);
        final JButton printerButton = (JButton) printerPanel.getComponent(1);

        BUILDER.createLabel(this, "", 0, 5);

        // automatic
        final JCheckBox printOutAutomatically = BUILDER.createCheckBox(
                this,
                "printOutAutomatically",
                pojo.getTranslation("PrintAutomatically"),
                1,
                6);

        final JCheckBox sendMailsAutomatically = BUILDER.createCheckBox(
                this,
                "sendMailsAutomatically",
                pojo.getTranslation("SendEmailsAutomatically"),
                0,
                6);

        BUILDER.createLabel(this, "", 0, 7);
        BUILDER.createLabel(this, "", 0, 8);
        // close
        final JButton saveButton = BUILDER.createButton(this, "saveButton", pojo.getTranslation("Save"), 0, 9);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", pojo.getTranslation("Close"), 1, 9);

        final SettingsFrameListener listener = new SettingsFrameListener(
                this,
                pojo,
                pathField,
                languageBox,
                archivingBox,
                archiveField,
                printerField,
                sendMailsAutomatically,
                printOutAutomatically);

        pathButton.addActionListener(listener);
        printerButton.addActionListener(listener);
        closeButton.addActionListener(listener);
        saveButton.addActionListener(listener);

        this.updateFrame(
                pojo,
                pathField,
                languageBox,
                archivingBox,
                archiveField,
                printerField,
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
            final JTextField printerField,
            final JCheckBox sendMailsAutomaticallyBox,
            final JCheckBox printOutAutomaticallyBox) {

        final Settings settings = pojo.getSettings();

        this.updatePathField(pathField, settings.getPath());
        languageBox.setSelectedItem(settings.getLanguage());
        archivingBox.setSelected(this.readCheckSettings(settings.isArchived()));
        archiveField.setText(settings.getArchivingDays() + "");
        this.updatePrinterField(printerField, settings.getPrinter());
        sendMailsAutomaticallyBox.setSelected(this.readCheckSettings(settings.isSendMailAutomatically()));
        printOutAutomaticallyBox.setSelected(this.readCheckSettings(settings.isPrintAutomatically()));

    }

    public void updatePrinterField(final JTextField printerField, final String printer) {
        printerField.setText(printer);
    }

    public void updatePathField(final JTextField pathField, final String path) {
        pathField.setText(path);
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
        } else {
            instance.toFront();
        }
        return instance;
    }

    @Override
    public void openClosingDialog(final String text) {
        ConfirmationFrame.getInstance(this.pojo, text, this);
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
