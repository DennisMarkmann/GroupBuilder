package com.kn.groupBuilder.Gui.Popups;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import com.kn.groupBuilder.Storage.Pojo;

public class PathChooser {

    public void changePath(final Pojo pojo) {
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(final File file) {
                return file.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Directory";
            }
        });

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            pojo.getSettings().setPath(fc.getSelectedFile().getAbsolutePath());
        }
    }
}
