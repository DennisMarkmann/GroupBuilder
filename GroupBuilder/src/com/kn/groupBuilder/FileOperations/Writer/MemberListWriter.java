package com.kn.groupBuilder.FileOperations.Writer;

import java.io.File;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to create the mmemberList.xml file and to store member information in it.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class MemberListWriter {

    final void createXmlFile(final Pojo pojo) {

        try {
            int memberNumber = 0;

            final FileWriteHelper helper = new FileWriteHelper();
            final Document doc = helper.createDocument();
            final Element memberListElement = helper.createMainElement(doc, "MemberList");

            helper.createElement(doc, memberListElement, "MemberListSize", pojo.getMemberList().size() + "");

            for (final Member member : pojo.getMemberList()) {

                final Element memberElement = helper.createElement(doc, memberListElement, "Member", null);
                helper.createAttribute(doc, memberElement, "id", memberNumber + "");
                helper.createElement(doc, memberElement, "FirstName", member.getFirstName());
                helper.createElement(doc, memberElement, "LastName", member.getLastName());
                helper.createElement(doc, memberElement, "EmailAdress", member.getEMailAdress());

                memberNumber++;

            }

            // write the content into xml file
            File file = new File(pojo.getSettings().getPath());
            file.mkdirs();
            file = new File(pojo.getSettings().getPath() + "MemberList" + ".xml");

            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(file));

        } catch (final TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
