package by.htp.xml.parser.sax;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.xml.entity.Families;
import by.htp.xml.parser.FamilyParser;


public class FamilySaxParser implements FamilyParser {

	@Override
	public Families familyParse(String path) {

		try {

			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(new FamilySaxParserHandler());
			xmlReader.parse(path);
			FamilySaxParserHandlerObject familySAXParserHandlerObject = new FamilySaxParserHandlerObject();
			xmlReader.setContentHandler(familySAXParserHandlerObject);
			xmlReader.parse(path);
			Families families = familySAXParserHandlerObject.getInstance();
			
			System.out.println(families);

		} catch (SAXException e) {
			System.out.println("Cannot create SaxParser");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Cannot find XMLFile");
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Families parseFamilyDoc(String path) {
		return null;
	}
}
