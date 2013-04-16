package com.kn.groupBuilder.Archiving;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GroupFileArchiver {

	public void archivGroupFiles(String defaultPath) {

		String archivPath = this.createArchivFolder(defaultPath);

		File[] files = new File(defaultPath + "//Groups//").listFiles();

		for (File file : files) {
			new FileCopy().copy(file.getAbsolutePath(),
					archivPath + file.getName());
		}
	}

	public String createArchivFolder(String defaultPath) {
		String archivPath = defaultPath + "//Archive//" + "//" + this.getDate()
				+ "//";
		new File(archivPath).mkdirs();
		return archivPath;

	}

	public String getDate() {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Calendar c = df.getCalendar();
		c.setTimeInMillis(System.currentTimeMillis());

		return +(c.get(Calendar.DAY_OF_MONTH)) + "."
				+ (c.get(Calendar.MONTH) + 1) + "." + (c.get(Calendar.YEAR))
				+ "_" + (c.get(Calendar.HOUR_OF_DAY)) + ""
				+ (c.get(Calendar.MINUTE) + 1) + "" + c.get(Calendar.SECOND);

	}

}
