package parser;

import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;



public class Test1 {

	public static void main(String[] args) throws Exception {
		XMLparser parser = new XMLparser();
		parser.parseXmlFile("Interstellar.fdx.xml");
		
		PrintStream fout = new PrintStream(new BufferedOutputStream(new FileOutputStream("/Users/mike/Desktop/tmp.txt")));
		parser.printData(fout);
		fout.close();
//		System.out.println(parser.toString());
		
		StringTokenizer toke = new StringTokenizer(parser.toString(), " \t\n\r\f-.");

		System.out.println("I tokenized it, this is how many tokens I have: " + toke.countTokens());
		Int2ObjectMap<String> map = new Int2ObjectLinkedOpenHashMap<>();
		int i = 0;
		while (toke.hasMoreTokens()) {
			map.put(i, toke.nextToken());
			i++;
		}
		for (Integer key : map.keySet()) {
			System.out.println(map.get(key) + " ");
		}
	}

}
