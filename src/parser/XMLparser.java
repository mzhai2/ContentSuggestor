package parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLparser {

	private Document dom;
	private List<Paragraph> paraList = new ArrayList<>();

	protected void parseXmlFile(String a){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(a);
			parseDocument();
		}
		catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	private void parseDocument(){
		Element docEle = dom.getDocumentElement();
		NodeList nl = docEle.getElementsByTagName("Paragraph");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the Paragraph element (character/dialogue)
				Element p = (Element)nl.item(i);

				//get the Paragraph object (text object)
				Paragraph e = getParagraph(p);

				//add it to list
				paraList.add(e);
			}
		}
	
	}

	private Paragraph getParagraph(Element el) {
		// TODO Auto-generated method stub
		Paragraph p = null;
		if(el.getAttribute("Type")=="Character"){
			String character = getTextValue(el,"Text");
			String type = el.getAttribute("Type");
			p = new Paragraph(type,character);
			
		}
		if(el.getAttribute("Type")=="Dialogue"){
			String dialogue = getTextValue(el,"Text");
			String type = el.getAttribute("Type");
			p = new Paragraph(type,dialogue);
		}
		return p;
	}

	private String getTextValue(Element el, String string) {
		// TODO Auto-generated method stub
		String textVal = null;
		NodeList nl = el.getElementsByTagName(string);
		if(nl != null && nl.getLength() > 0) {
			Element ele = (Element)nl.item(0);
			textVal = ele.getFirstChild().getNodeValue();
		}

		return textVal;
	}
	protected void printData(){

		System.out.println("Paragraph'" + paraList.size() + "'.");

		java.util.Iterator<Paragraph> it = paraList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}


}
