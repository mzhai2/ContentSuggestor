package parser;

import java.util.List;


public class Test1 {

	public static void main(String[] args) {
		XMLparser parser = new XMLparser();
		parser.parseXmlFile("Interstellar.fdx.xml");
		parser.printData();
//		
//		List<String> s = parser.getTextList();
//		System.out.println(s.get(2));
	}

}
