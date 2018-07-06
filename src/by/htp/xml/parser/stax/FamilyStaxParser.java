package by.htp.xml.parser.stax;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import by.htp.xml.entity.Child;
import by.htp.xml.entity.Families;
import by.htp.xml.entity.Family;
import by.htp.xml.entity.Father;
import by.htp.xml.entity.Human;
import by.htp.xml.entity.Mother;
import by.htp.xml.parser.FamilyParser;

public class FamilyStaxParser implements FamilyParser, Closeable {
	private Families families;
	private Family family;
	private Human human;

	private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

	private XMLStreamReader reader;

	private void printFamilies() {
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println(families);
	}

	@Override
	public Families familyParse(String path) {
		try {
			InputStreamReader is = new InputStreamReader(new FileInputStream(path));
			reader = FACTORY.createXMLStreamReader(is);
			while (reader.hasNext()) {
				int event = reader.next();
				if (event == XMLEvent.START_ELEMENT) {
					switch (reader.getLocalName()) {
					case "families":
						families = new Families();
						break;
					case "family":
						family = new Family();
						family.setId(Integer.valueOf(reader.getAttributeValue(0)));
						families.addFamily(family);
						break;
					case "mother":
						human = new Mother();
						Mother mother = (Mother) human;
						mother.setMaidenName(reader.getAttributeValue(0));
						family.setMother(mother);
						break;
					case "father":
						human = new Father();
						family.setFather((Father) human);
						break;
					case "child":
						human = new Child();
						family.setChild((Child) human);
						break;
					case "gender":
						Child child = (Child) human;
						child.setGender(reader.getElementText());
						break;
					case "name":
						human.setName(reader.getElementText());
						break;
					case "surname":
						human.setLastName(reader.getElementText());
						break;
					case "age":
						human.setAge(Integer.valueOf(reader.getElementText()));
						break;
					}
				}
				if (event == XMLEvent.END_ELEMENT)
					reader.next();
				if (event == XMLEvent.END_DOCUMENT)
					break;
			}
			printFamilies();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return families;
	}

	public void close() {
		if (reader != null) {
			try {
				reader.close();
			} catch (XMLStreamException e) {
			}
		}
	}

	@Override
	public Families parseFamilyDoc(String path) {
		return null;
	}
}

