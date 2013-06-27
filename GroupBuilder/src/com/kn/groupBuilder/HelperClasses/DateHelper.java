package com.kn.groupBuilder.HelperClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    private final Calendar c = new SimpleDateFormat("dd.MM.yyyy").getCalendar();

    public DateHelper() {
        this.c.setTimeInMillis(System.currentTimeMillis());
    }

    public final String getFullDate(final int daysToAdd) {
        final StringBuilder sb = new StringBuilder();

        sb.append(this.getDate(daysToAdd));
        sb.append("_");
        sb.append(this.c.get(Calendar.HOUR_OF_DAY));
        sb.append(".");
        sb.append(this.c.get(Calendar.MINUTE));
        sb.append(".");
        sb.append(this.c.get(Calendar.SECOND));

        return sb.toString();
    }

    public final String getDate(final int daysToAdd) {
        final StringBuilder sb = new StringBuilder();

        this.c.add(Calendar.DAY_OF_MONTH, daysToAdd);
        sb.append(this.c.get(Calendar.DAY_OF_MONTH));
        sb.append(".");
        if (Calendar.MONTH < 10) {
            sb.append("0");
        }
        sb.append(this.c.get(Calendar.MONTH) + 1);
        sb.append(".");
        sb.append(this.c.get(Calendar.YEAR));

        return sb.toString();
    }

    public final Date parseStringToDate(final String dateString) {

        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

}
