package com.kn.groupBuilder.Gui.Menu;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Menu.Listener.AboutFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.Gui.DefaultFrameClasses.DefaultFrame;
import dennis.markmann.MyLibraries.Gui.DefaultFrameClasses.MyWindowAdapter;

public final class AboutFrame extends JFrame implements DefaultFrame {

    private static AboutFrame instance = null;
    private static final long serialVersionUID = -7650216557475857971L;

    private AboutFrame(final Pojo pojo) {

        BUILDER.setDefaultFrameSettings(this, "About");
        this.setSize(600, 230);
        this.addWindowListener(new MyWindowAdapter(this));
        BUILDER.createLabel(this, "This Software is designed by Dennis Markmann.", 1, 0);
        BUILDER.createLabel(this, "If you have any problems or suggested improvements please contanct me via E-Mail.", 1, 1);
        BUILDER.createLabel(this, "Address: dennismarkmann@hotmail.de", 1, 2);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", "close", 2, 4);

        final ActionListener listener = new AboutFrameListener(this);

        closeButton.addActionListener(listener);
    }

    public static AboutFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new AboutFrame(pojo);
        } else {
            instance.toFront();
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
