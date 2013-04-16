package com.kn.groupBuilder.FileOperations.Writer;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class MemberListWriter {

	public void createXmlFile(Pojo pojo) {

		try {

			int memberNumber = 0;

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			// member elements
			Element memberListElement = doc.createElement("MemberList");
			Element memberListSizeElement = doc.createElement("MemberListSize");

			doc.appendChild(memberListElement);

			memberListSizeElement.appendChild(doc.createTextNode(pojo
					.getMemberList().size() + ""));
			memberListElement.appendChild(memberListSizeElement);

			for (Member member : pojo.getMemberList()) {

				String firstName = member.getFirstName();
				String lastName = member.getLastName();
				String emailAdress = member.getEMailAdress();

				Element memberElement = doc.createElement("Member");
				memberListElement.appendChild(memberElement);

				// set attribute to member element
				Attr attr = doc.createAttribute("id");
				attr.setValue(memberNumber + "");
				memberElement.setAttributeNode(attr);

				// firstname elements
				Element firstNameElement = doc.createElement("FirstName");
				firstNameElement.appendChild(doc.createTextNode(firstName));
				memberElement.appendChild(firstNameElement);

				// lastname elements
				Element lastNameElement = doc.createElement("LastName");
				lastNameElement.appendChild(doc.createTextNode(lastName));
				memberElement.appendChild(lastNameElement);

				// email elements
				Element emailElement = doc.createElement("EmailAdress");
				emailElement.appendChild(doc.createTextNode(emailAdress));
				memberElement.appendChild(emailElement);

				memberNumber++;

			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			File file = new File(pojo.getDefaultPath());
			file.mkdirs();

			file = new File(pojo.getDefaultPath() + "//MemberList" + ".xml");

			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
