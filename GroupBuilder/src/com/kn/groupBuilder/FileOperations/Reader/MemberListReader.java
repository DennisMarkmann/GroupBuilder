package com.kn.groupBuilder.FileOperations.Reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.kn.groupBuilder.Jobs.MemberCreator;
import com.kn.groupBuilder.Storage.Pojo;

public class MemberListReader {

	public void readXmlFile(Pojo pojo) {

		try {

			File file = new File(pojo.getDefaultPath() + "MemberList.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList list = doc.getElementsByTagName("MemberList");
			Node node = list.item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) node;

				@SuppressWarnings("unused")
				String memberListSize = element
						.getElementsByTagName("MemberListSize").item(0)
						.getTextContent();

			}
			String firstName = "";
			String lastName = "";
			String eMailAdress = "";
			MemberCreator creator = new MemberCreator();

			NodeList nList = doc.getElementsByTagName("Member");
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					firstName = eElement.getElementsByTagName("FirstName")
							.item(0).getTextContent();
					lastName = eElement.getElementsByTagName("LastName")
							.item(0).getTextContent();
					eMailAdress = eElement.getElementsByTagName("EmailAdress")
							.item(0).getTextContent();

					creator.createMember(firstName, lastName, eMailAdress, pojo);

				}
			}

		} catch (IOException e) {
			// nothing to do.

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}