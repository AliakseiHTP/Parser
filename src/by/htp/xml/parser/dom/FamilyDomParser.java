package by.htp.xml.parser.dom;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.xml.entity.Child;
import by.htp.xml.entity.Families;
import by.htp.xml.entity.Family;
import by.htp.xml.entity.Father;
import by.htp.xml.entity.Mother;

public class FamilyDomParser {
    private Families thisFamilies;
    private Family thisFamily;
    private Mother thisMother;
    private Father thisFather;
    private Child thisChild;
    private ArrayList<Child> thisChildren;

    public Families parseFamilyDoc(String path) throws ParserConfigurationException, SAXException, IOException {
        thisFamilies = new Families();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(path);

        Element routElement = document.getDocumentElement();

        NodeList nodeList = routElement.getElementsByTagName("family");
        for (int i = 0; i < nodeList.getLength(); i++) {
            thisFamily = new Family();
            Element element = ((Element) nodeList.item(i));
            String id = element.getAttribute("id");
            thisFamily.setId(Integer.parseInt(id));
            NodeList nodeListOfMembers = element.getChildNodes();
            for (int j = 0; j < nodeListOfMembers.getLength(); j++) {
                if (nodeListOfMembers.item(j) instanceof Element) {
                    Element elementMember = (Element) nodeListOfMembers.item(j);
                    String nameAttribute = elementMember.getNodeName();
                    switch (nameAttribute) {
                        case "mother":
                            thisMother = new Mother();
                            String maidenName = elementMember.getAttribute("maiden-name");
                            thisMother.setMaidenName(maidenName);
                            NodeList aboutMother = elementMember.getChildNodes();
                            for (int m = 0; m < aboutMother.getLength(); m++) {
                                if (aboutMother.item(m) instanceof Element) {
                                    Element elementMother = (Element) aboutMother.item(m);
                                    String tegMotherChildNodeName = elementMother.getNodeName();
                                    String contentMotherChildNode = elementMother.getTextContent();
                                    switch (tegMotherChildNodeName) {
                                        case "first-name":
                                            thisMother.setName(contentMotherChildNode);
                                            break;
                                        case "last-name":
                                            thisMother.setLastName(contentMotherChildNode);
                                            break;
                                        case "age":
                                            thisMother.setAge(Integer.parseInt(contentMotherChildNode));
                                            break;
                                    }
                                }
                            }
                            thisFamily.setMother(thisMother);
                            break;
                        case "father":
                            thisFather = new Father();
                            NodeList aboutFather = elementMember.getChildNodes();
                            for (int f = 0; f < aboutFather.getLength(); f++) {
                                if (aboutFather.item(f) instanceof Element) {
                                    Element elementFather = (Element) aboutFather.item(f);
                                    String tegFatherChildNodeName = elementFather.getNodeName();
                                    String contentFatherChildNode = elementFather.getTextContent();
                                    switch (tegFatherChildNodeName) {
                                        case "first-name":
                                            thisFather.setName(contentFatherChildNode);
                                            break;
                                        case "last-name":
                                            thisFather.setLastName(contentFatherChildNode);
                                            break;
                                        case "age":
                                            thisFather.setAge(Integer.parseInt(contentFatherChildNode));
                                            break;
                                        case "military":
                                            thisFather.setMilitary(contentFatherChildNode);
                                            break;
                                    }
                                }
                            }
                            thisFamily.setFather(thisFather);
                            break;
                        case "children":
                            thisChildren = new ArrayList<>();
                            NodeList nodeListChildren = elementMember.getChildNodes();
                            for (int c1 = 0; c1 < nodeListChildren.getLength(); c1++) {
                                if (nodeListChildren.item(c1) instanceof Element) {
                                    thisChild = new Child();
                                    Element elementChildren = (Element) nodeListChildren.item(c1);
                                    NodeList aboutChild = elementChildren.getChildNodes();
                                    for (int c2 = 0; c2 < aboutChild.getLength(); c2++) {
                                        if (aboutChild.item(c2) instanceof Element) {
                                            Element elChildItem = (Element) aboutChild.item(c2);
                                            String tegChildrenChildNodeName = elChildItem.getNodeName();
                                            String contentChildrenChildNode = elChildItem.getTextContent();
                                            switch (tegChildrenChildNodeName) {
                                                case "first-name":
                                                    thisChild.setName(contentChildrenChildNode);
                                                    break;
                                                case "last-name":
                                                    thisChild.setLastName(contentChildrenChildNode);
                                                    break;
                                                case "age":
                                                    thisChild.setAge(Integer.parseInt(contentChildrenChildNode));
                                                    break;
                                                case "gender":
                                                    thisChild.setGender(contentChildrenChildNode);
                                                    break;
                                            }
                                        }
                                    }
                                    thisChildren.add(thisChild);
                                }
                            }
                            thisFamily.setChildren(thisChildren);
                            break;
                        default :
                            System.out.println("There are no family members");
                    }

                }
            }
            thisFamilies.addFamily(thisFamily);
        }
        return thisFamilies;
    }
}
