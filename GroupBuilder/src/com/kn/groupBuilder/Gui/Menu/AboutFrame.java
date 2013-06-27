package com.kn.groupBuilder.Gui.Menu;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Interfaces.DefaultFrame;
import com.kn.groupBuilder.Gui.Interfaces.MyWindowAdapter;
import com.kn.groupBuilder.Gui.Menu.Listener.AboutFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public final class AboutFrame extends JFrame implements DefaultFrame {

    private static AboutFrame instance = null;
    private static final long serialVersionUID = -7650216557475857971L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();

    private AboutFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this, "About");
        this.addWindowListener(new MyWindowAdapter(this));
        this.builder.createLabel(this, "Designed by Dennis Markmann", 1, 2);
        final JButton closeButton = this.builder.createButton(this, "closeButton", "close", 0, 3);

        final ActionListener listener = new AboutFrameListener(this);

        closeButton.addActionListener(listener);
    }

    public static AboutFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new AboutFrame(pojo);
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
