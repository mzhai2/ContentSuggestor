package parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class XMLparser {

	public static void main(String[] args) {
		parseXmlFile("Interstellar.fdx.xml");
	}
	private static void parseXmlFile(String path){
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			Document dom = db.parse(path);
			Element docEle = dom.getDocumentElement();
			NodeList nl = docEle.getElementsByTagName("Paragraph");
			List<Paragraph> paraList = new ArrayList<>();
			if (nl != null && nl.getLength() > 0) {
				for(int i=0;i<nl.getLength();i++) {
					// get element
					Element eP = (Element)nl.item(i); 
					Paragraph P = Paragraph.getParagraph(eP);
					paraList.add(P);
				}
			}
			System.out.println("yo");

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
