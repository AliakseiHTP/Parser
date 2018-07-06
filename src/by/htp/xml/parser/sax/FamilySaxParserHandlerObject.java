package by.htp.xml.parser.sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.xml.entity.Child;
import by.htp.xml.entity.Families;
import by.htp.xml.entity.Family;
import by.htp.xml.entity.Father;
import by.htp.xml.entity.Human;
import by.htp.xml.entity.Mother;

public class FamilySaxParserHandlerObject extends DefaultHandler {

	private Families families;
	private Family family;
	private Human human;
	private String next;

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (localName) {
		case "families":
			families = new Families();
			break;
		case "family":
			family = new Family();
			family.setId(Integer.valueOf(attributes.getValue("id")));
			families.addFamily(family);
			break;
		case "mother":
			human = new Mother();
			Mother mother = (Mother)human;
			mother.setMaidenName(attributes.getValue("maiden-name"));
			family.setMother(mother);
			break;
		case "father":
			human = new Father();
			family.setFather((Father) human);
			break;
		case "child":
			human = new Child();
			family.setChild((Child) human); //ArrayList<Child> children
			break;
			

		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
		case "name":
			human.setName(next);
			break;
		case "surname":
			human.setLastName(next);
			break;
		case "age":
			human.setAge(Integer.valueOf(next));
			break;
		case "gender":
			Child child = (Child)human;
			child.setGender(next);
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.next = new StringBuilder().append(ch, start, length).toString().trim();
	}

	public Families getInstance() {
		return families;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

}
