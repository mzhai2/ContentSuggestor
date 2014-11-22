package parser;

import org.w3c.dom.*;

public class Paragraph {
	private String type;
	private String text;

	public Paragraph(String startType, String startText) {
		setType(startType);
		setText(startText);
	}

	public static Paragraph getParagraph(Element eP) {
		// for each paragraph get type and text
		String type = eP.getAttribute("Type");
		String text = getTextValue(eP, "Text");

		Paragraph p = new Paragraph(type, text);
		return p;

	}

	private static String getTextValue(Element eP, String tagName) {
		String textVal = null;
		NodeList nl = eP.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
