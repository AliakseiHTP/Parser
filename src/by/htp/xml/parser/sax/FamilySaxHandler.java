package by.htp.xml.parser.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FamilySaxHandler extends DefaultHandler{

	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement");
		switch(localName){
			case "mother":
				System.out.println("Mother " +localName);
				break;
			case "father":
				System.out.println("Mother " +localName);
				break;
			case "Children":
				System.out.println("Children " +localName);
				break;
			case "Child":
				System.out.println("Child " +localName);
				break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("endElement");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("characters: " + new StringBuilder().append(ch, start, length));
	}

}
