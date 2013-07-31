package com.kn.groupBuilder.Main;

import java.util.Locale;
import java.util.ResourceBundle;

import com.kn.groupBuilder.Storage.Pojo;

public class LanguageChooser {

    public void chooseLanguage(final Pojo pojo) {

        final String pojoLanguage = pojo.getSettings().getLanguage();
        String language = "";
        String country = "";

        if (pojoLanguage.equals("English")) {
            language = new String("en");
            country = new String("US");
        } else if (pojoLanguage.equals("German")) {
            language = new String("de");
            country = new String("US");
        } else {
            language = new String("en");
            country = new String("US");
        }
        pojo.setMessages(ResourceBundle.getBundle("Properties/LanguageFile", new Locale(language, country)));
        new dennis.markmann.MyLibraries.General.LanguageChooser().chooseLanguage(pojoLanguage);
        // this.repaintMLJComponents();
    }

    // public static void repaintMLJComponents() {
    // final Vector validate = recursiveFindMLJComponents(MainFrame.getInstance());
    // for (final Enumeration e = validate.elements(); e.hasMoreElements();) {
    // final JComponent jcomp = (JComponent) e.nextElement();
    // jcomp.revalidate();
    // jcomp.repaint();
    // }
    // }

    // private static Vector recursiveFindMLJComponents(final Container root) {
    // // java.awt.Container.getComponents() doesn't return null!
    // final Component[] tmp = root.getComponents();
    // final Vector v = new Vector();
    // for (final Component element : tmp) {
    // if (element instanceof JComponent) {
    // final JComponent jcomp = (JComponent) element;
    // if (jcomp.getComponentCount() == 0) {
    // v.add(jcomp);
    // } else {
    // v.addAll(recursiveFindMLJComponents(jcomp));
    // }
    // } else if (element instanceof Container) {
    // v.addAll(recursiveFindMLJComponents((Container) element));
    // }
    // }
    // return v;
    // }
}
