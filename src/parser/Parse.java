package parser;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc = null;
		try {
			doc = Jsoup.connect(
					"http://www.imsdb.com/scripts/500-Days-of-Summer.html")
					.get();
		} catch (IOException e) {
			System.out.println("Foooo");
			e.printStackTrace();
		}
		String titleString = doc.title();
		Elements srctext = doc.getElementsByClass("scrtext");
		srctext.toArray();
		// String a = srctext.toString();
		// System.out.println(a);
	}

}
