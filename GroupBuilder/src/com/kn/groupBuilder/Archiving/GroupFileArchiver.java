package com.kn.groupBuilder.Archiving;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GroupFileArchiver {

    public final void archivGroupFiles(final String defaultPath) {

        final String archivPath = this.createArchivFolder(defaultPath);

        final File[] files = new File(defaultPath + "//Groups//").listFiles();

        for (final File file : files) {
            new FileCopy().copy(file.getAbsolutePath(), archivPath + file.getName());
        }
    }

    private final String createArchivFolder(final String defaultPath) {
        final String archivPath = defaultPath + "//Archive//" + "//" + this.getDate() + "//";
        new File(archivPath).mkdirs();
        return archivPath;

    }

    public final String getDate() {
        final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        final Calendar c = df.getCalendar();
        c.setTimeInMillis(System.currentTimeMillis());

        return +(c.get(Calendar.DAY_OF_MONTH)) + "." + (c.get(Calendar.MONTH) + 1) + "." + (c.get(Calendar.YEAR)) + "_"
                + (c.get(Calendar.HOUR_OF_DAY)) + "" + (c.get(Calendar.MINUTE) + 1) + "" + c.get(Calendar.SECOND);

    }

}
