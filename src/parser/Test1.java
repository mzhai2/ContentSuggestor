package parser;

import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import edu.emory.clir.clearnlp.tokenization.EnglishTokenizer;



public class Test1 {

	public static void main(String[] args) throws Exception {
		XMLparser parser = new XMLparser();
		parser.parseXmlFile("Interstellar.fdx.xml");
		
		PrintStream fout = new PrintStream(new BufferedOutputStream(new FileOutputStream("/Users/mike/Desktop/tmp.txt")));
		parser.printData(fout);
		fout.close();
//		System.out.println(parser.toString());
		
//		StringTokenizer toke = new StringTokenizer(parser.toString(), " \t\n\r\f-.,?!");
		InputStream stream = new ByteArrayInputStream(parser.toString().getBytes(StandardCharsets.UTF_8));
		EnglishTokenizer toke = new EnglishTokenizer();
		List<List<String>> tokens = toke.segmentize(stream);
		
		
		System.out.println("I tokenized it, this is how many sentences I have: " + tokens.size());
//		Int2ObjectMap<String> map = new Int2ObjectLinkedOpenHashMap<>();
//		int i = 0;
//		while (toke.hasMoreTokens()) {
//			String token = toke.nextToken();
//			if (map.containsValue(token))
//				continue;
//			map.put(i, token);
//			i++;
//		}
//		for (Integer key : map.keySet()) {
//			System.out.println(map.get(key));
//		}
	}

}
