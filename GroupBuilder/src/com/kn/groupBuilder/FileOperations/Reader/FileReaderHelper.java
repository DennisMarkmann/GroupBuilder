package com.kn.groupBuilder.FileOperations.Reader;

import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Pojo;

public class FileReaderHelper {

    public final void readXMLFiles(final Pojo pojo) {

        new GroupListReader().readXmlFile(pojo);
        new MemberListReader().readXmlFile(pojo);
        new GroupFileReader().readFiles(pojo);
        new SettingsFileReader().readXmlFile(pojo);
    }

    public String getElementValue(final Element element, final String name) {
        return element.getElementsByTagName(name).item(0).getTextContent();
    }
}
