package com.kn.groupBuilder.FileOperations.Reader;

import com.kn.groupBuilder.Storage.Pojo;

public class FileReaderHelper {

    public final void readXMLFiles(final Pojo pojo) {

        new GroupListReader().readXmlFile(pojo);
        new MemberListReader().readXmlFile(pojo);
        new GroupFileReader().readFiles(pojo);
    }

}
