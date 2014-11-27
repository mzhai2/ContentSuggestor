package parser;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLparser {

	private Document dom;
	private List<List<Paragraph>> convoList = new ArrayList<>();
	private String character;

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
		//System.out.println("Value of 1st node: " + nl.item(0).getTextContent());
		if(nl != null && nl.getLength() > 0) {
			List<Paragraph> convo = new ArrayList<>();
			for(int i = 0 ; i < nl.getLength();i++) {
				//get the Paragraph element (character/dialogue)
				Element p = (Element)nl.item(i);
				

				//get the Paragraph object (text object)
				Paragraph e = getParagraph(p);
				//add it to conversation
				if (e!=null && !e.getText().equals("split scene")) {
					convo.add(e);
				}
				// if scene transition, add to convolist create new convo
				if(e!=null && e.getText().equals("split scene")){
					if (convo.size() > 0)
						convoList.add(convo);
					convo = new ArrayList<>();
				}
			}
		}
	
	}

	private Paragraph getParagraph(Element el) {
		Paragraph p = null;
		if(el.getAttribute("Type").equals("Character")){
			character = getTextValue(el,"Text");
		}
		if(el.getAttribute("Type").equals("Dialogue")){
			String dialogue = getTextValue(el,"Text");
			p = new Paragraph(character,dialogue);
		}
		if(el.getAttribute("Type").equals("Scene Heading")){
			p = new Paragraph("","split scene");
		}
		return p;
	}

	private String getTextValue(Element el, String string) {
		String textVal = null;
		NodeList nl = el.getElementsByTagName(string);
		if(nl != null && nl.getLength() > 0) {
			Element ele = (Element)nl.item(0);
			textVal = ele.getFirstChild().getNodeValue();
		}

		return textVal;
	}
	public String toString(){
		String a = new String();
		for (List<Paragraph> paraList : convoList) {  
			Iterator<Paragraph> it = paraList.iterator();
			while(it.hasNext()) {
				Paragraph curr = it.next();
				a+=(curr.getText().toLowerCase() + "\n");
			}
		}
		return a;
	}
	
	protected void printData(PrintStream out){
		for (List<Paragraph> paraList : convoList) {  
			Iterator<Paragraph> it = paraList.iterator();
			while(it.hasNext()) {
				Paragraph curr = it.next();
				out.print(curr.getType() + ": " + curr.getText() + "\n");
			}
			out.println();
		}
	}
	
	
//	public List<List<String>> getTextLists() {
//		List<String> s = new ArrayList<>();
//		Iterator<Paragraph> it = convoList.iterator();
//		while(it.hasNext()) {
//			Paragraph curr = it.next();
//			s.add(curr.getText());
//		}
//		return s;
//	}


}
