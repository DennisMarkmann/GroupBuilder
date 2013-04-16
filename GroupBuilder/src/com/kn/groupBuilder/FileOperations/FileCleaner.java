package com.kn.groupBuilder.FileOperations;

import java.io.File;

public class FileCleaner {

	public void cleanFiles(String defaultPath) {

		new File(defaultPath + "GroupList.xml").delete();
		new File(defaultPath + "MemberList.xml").delete();

		this.cleanFolder(defaultPath + "\\Groups\\");
	}

	public void cleanFolder(String path) {

		File filePath = new File(path);
		try {
			for (File file : filePath.listFiles()) {
				if (!file.isDirectory()) {
					file.delete();
				} else {
					cleanFolder(file.getAbsolutePath());
				}
			}
			filePath.delete();
		} catch (java.lang.NullPointerException e) {
		}
	}
}
