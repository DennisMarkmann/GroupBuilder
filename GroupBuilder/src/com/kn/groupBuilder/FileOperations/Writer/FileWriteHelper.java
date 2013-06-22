package com.kn.groupBuilder.FileOperations.Writer;

import com.kn.groupBuilder.Archiving.GroupFileArchiver;
import com.kn.groupBuilder.Storage.Pojo;

public class FileWriteHelper {

    public void createXMLFiles(final Pojo pojo) {
        new MemberListWriter().createXmlFile(pojo);
        new GroupListWriter().createXmlFile(pojo);
        new GroupFileWriter().initializeXMLPrint(pojo);
        new GroupFileArchiver().archivGroupFiles(pojo);
    }

}
