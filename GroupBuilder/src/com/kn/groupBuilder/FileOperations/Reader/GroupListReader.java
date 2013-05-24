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

import com.kn.groupBuilder.Jobs.GroupCreator;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupListReader {

	public void readXmlFile(Pojo pojo) {

		try {

			File file = new File(pojo.getDefaultPath() + "GroupList.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList list = doc.getElementsByTagName("GroupList");
			Node node = list.item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) node;

				@SuppressWarnings("unused")
				String groupListSize = element
						.getElementsByTagName("GroupListSize").item(0)
						.getTextContent();
			}

			String groupName = "";
			int fixSize = 0;
			String description = "";
			GroupCreator creator = new GroupCreator();

			NodeList nList = doc.getElementsByTagName("Group");
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					groupName = eElement.getElementsByTagName("GroupName")
							.item(0).getTextContent();
					fixSize = Integer.parseInt(eElement
							.getElementsByTagName("FixSize").item(0)
							.getTextContent());
					description = eElement.getElementsByTagName("Description")
							.item(0).getTextContent();

					creator.createGroupsManually(groupName, fixSize,
							description, pojo);
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