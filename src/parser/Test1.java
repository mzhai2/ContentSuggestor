package parser;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;



public class Test1 {

	public static void main(String[] args) throws Exception {
		XMLparser parser = new XMLparser();
		parser.parseXmlFile("Interstellar.fdx.xml");
		
		PrintStream fout = new PrintStream(new BufferedOutputStream(new FileOutputStream("/Users/mike/Desktop/tmp.txt")));
		parser.printData(fout);
		fout.close();
//		System.out.println(parser.toString());
		
		StringTokenizer toke = new StringTokenizer(parser.toString(), " \t\n\r\f-");

		System.out.println("I tokenized it, this is how many tokens I have");
		System.out.println(toke.countTokens());

//		List<String> s = parser.getTextList();
//		System.out.println(s.get(2));
	}

}
