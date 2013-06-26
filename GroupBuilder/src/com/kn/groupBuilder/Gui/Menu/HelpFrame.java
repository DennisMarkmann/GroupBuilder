package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Interfaces.DefaultFrame;
import com.kn.groupBuilder.Gui.Interfaces.MyWindowAdapter;
import com.kn.groupBuilder.Gui.Menu.Listener.HelpFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public class HelpFrame extends JFrame implements DefaultFrame {

    private static HelpFrame instance = null;
    private static final long serialVersionUID = 416901635761617562L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();

    private HelpFrame(final Pojo pojo) {
        this.builder.setDefaultFrameSettings(this, "Help");
        this.addWindowListener(new MyWindowAdapter(this));
        this.builder.createLabel(this, "HelpText", 1, 2);
        final JButton closeButton = this.builder.createButton(this, "closeButton", "close", 0, 3);

        final HelpFrameListener listener = new HelpFrameListener(this);

        closeButton.addActionListener(listener);

    }

    public static HelpFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new HelpFrame(pojo);
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
