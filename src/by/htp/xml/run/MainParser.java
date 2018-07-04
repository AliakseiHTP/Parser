package by.htp.xml.run;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.htp.xml.entity.Families;
import by.htp.xml.parser.dom.FamilyDomParser;


public class MainParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        FamilyDomParser familyDomParser = new FamilyDomParser();
        Families families = familyDomParser.parseFamilyDoc("resources/family.xml");
        System.out.println(families);

    }
}
