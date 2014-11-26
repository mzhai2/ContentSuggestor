package parser;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;



public class Test1 {

	public static void main(String[] args) throws Exception {
		XMLparser parser = new XMLparser();
		parser.parseXmlFile("Interstellar.fdx.xml");
		
		PrintStream fout = new PrintStream(new BufferedOutputStream(new FileOutputStream("/Users/mike/Desktop/tmp.txt")));
		parser.printData(fout);
		fout.close();
//		
//		List<String> s = parser.getTextList();
//		System.out.println(s.get(2));
	}

}
