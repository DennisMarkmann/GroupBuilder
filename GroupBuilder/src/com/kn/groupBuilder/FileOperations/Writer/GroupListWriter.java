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

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupListWriter {

	public void createXmlFile(Pojo pojo) {

		try {

			int groupNumber = 0;

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			// member elements
			Element groupListElement = doc.createElement("GroupList");
			Element groupListSizeElement = doc.createElement("GroupListSize");

			doc.appendChild(groupListElement);

			groupListSizeElement.appendChild(doc.createTextNode(pojo
					.getGroupList().size() + ""));
			groupListElement.appendChild(groupListSizeElement);

			for (Group group : pojo.getGroupList()) {

				String groupName = group.getName();
				int fixSize = group.getFixSize();
				String description = group.getDescription();

				Element groupElement = doc.createElement("Group");
				groupListElement.appendChild(groupElement);

				// set attribute to group element
				Attr attr = doc.createAttribute("id");
				attr.setValue(groupNumber + "");
				groupElement.setAttributeNode(attr);

				// groupName elements
				Element groupNameElement = doc.createElement("GroupName");
				groupNameElement.appendChild(doc.createTextNode(groupName));
				groupElement.appendChild(groupNameElement);

				// fixSize elements
				Element fixSizeElement = doc.createElement("FixSize");
				fixSizeElement.appendChild(doc.createTextNode(fixSize + ""));
				groupElement.appendChild(fixSizeElement);

				// description elements
				Element descriptionElement = doc.createElement("Description");
				descriptionElement.appendChild(doc.createTextNode(description));
				groupElement.appendChild(descriptionElement);

				groupNumber++;

			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			File file = new File(pojo.getDefaultPath());
			file.mkdirs();

			file = new File(pojo.getDefaultPath() + "//GroupList" + ".xml");

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
