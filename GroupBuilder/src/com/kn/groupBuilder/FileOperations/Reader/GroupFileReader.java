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

public class GroupFileReader {

	public void readFiles(String path) {

		try {

			File[] files = new File(path).listFiles();

			for (File file : files) {

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(file);
				doc.getDocumentElement().normalize();

				NodeList list = doc.getElementsByTagName("Group");
				Node node = list.item(0);
				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;

					String groupName = element
							.getElementsByTagName("GroupName").item(0)
							.getTextContent();
					String groupSize = element
							.getElementsByTagName("GroupSize").item(0)
							.getTextContent();
					String description = element
							.getElementsByTagName("Description").item(0)
							.getTextContent();

				}

				NodeList nList = doc.getElementsByTagName("Member");
				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;

						String memberID = eElement.getAttribute("id");
						String firstName = eElement
								.getElementsByTagName("FirstName").item(0)
								.getTextContent();
						String lastName = eElement
								.getElementsByTagName("LastName").item(0)
								.getTextContent();
						String eMailAdress = eElement
								.getElementsByTagName("EmailAdress").item(0)
								.getTextContent();
					}
				}
			}

		} catch (IOException e) {
			// nothing to do.
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}