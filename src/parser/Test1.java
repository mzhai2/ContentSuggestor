package parser;


public class Test1 {

	public static void main(String[] args) {
		XMLparser parser = new XMLparser();
		parser.parseXmlFile("Interstellar.fdx.xml");
		parser.printData();
	}

}
