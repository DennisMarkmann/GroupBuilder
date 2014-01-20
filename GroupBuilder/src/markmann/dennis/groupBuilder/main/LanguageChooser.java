package markmann.dennis.groupBuilder.main;

import java.util.Locale;
import java.util.ResourceBundle;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Used to change the language for the application. Default language is English.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class LanguageChooser {

    public final void chooseLanguage(final Pojo pojo) {

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
        pojo.setLanguageBundle(ResourceBundle.getBundle("languageFiles/languageFile", new Locale(language, country)));
    }
}
