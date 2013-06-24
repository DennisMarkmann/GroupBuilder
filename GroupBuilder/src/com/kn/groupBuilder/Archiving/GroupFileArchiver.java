package com.kn.groupBuilder.Archiving;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.kn.groupBuilder.Storage.Pojo;

public class GroupFileArchiver {

    public final void archivGroupFiles(final Pojo pojo) {

        final String archivPath = this.createArchivFolder(pojo.getSettings().getPath());

        final File[] files = new File(pojo.getSettings().getPath() + "Groups//").listFiles();

        for (final File file : files) {
            new FileCopy().copy(file.getAbsolutePath(), archivPath + file.getName());
        }
    }

    private String createArchivFolder(final String path) {
        final String archivPath = path + "//Archive//" + "//" + this.getDate() + "//";
        new File(archivPath).mkdirs();
        return archivPath;

    }

    public final String getDate() {
        final Calendar c = new SimpleDateFormat("dd.MM.yyyy").getCalendar();
        c.setTimeInMillis(System.currentTimeMillis());
        final StringBuilder sb = new StringBuilder();

        sb.append(c.get(Calendar.DAY_OF_MONTH));
        sb.append(".");
        sb.append(c.get(Calendar.MONTH) + 1);
        sb.append(".");
        sb.append(c.get(Calendar.YEAR));
        sb.append("_");
        sb.append(c.get(Calendar.HOUR_OF_DAY));
        sb.append(".");
        sb.append(c.get(Calendar.MINUTE));
        sb.append(".");
        sb.append(c.get(Calendar.SECOND));

        return sb.toString();
    }

}
