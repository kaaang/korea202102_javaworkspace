package app0604.tree.xml;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PetsHandler extends DefaultHandler{
	
	ArrayList<Pet> petList;
	Pet pet;
	
	boolean isPets;
	boolean isPet;
	boolean isType;
	boolean isName;
	boolean isAge;
	
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode petNode;
	
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		if(tag.equals("pets")) {
			isPets=true;
			petList = new ArrayList<Pet>();
			root = new DefaultMutableTreeNode(tag);
			
		}else if(tag.equals("pet")){
			isPet=true;
			pet = new Pet();
			petNode = new DefaultMutableTreeNode(tag);
		}else if(tag.equals("type")) {
			isType=true;
		}else if(tag.equals("name")) {
			isName=true;
		}else if(tag.equals("age")) {
			isAge=true;
		}
	}
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch,start,length);
		if(isType) {
			DefaultMutableTreeNode type = new DefaultMutableTreeNode(data);
			petNode.add(type);
			pet.setType(data);
		}else if(isName) {
			DefaultMutableTreeNode name = new DefaultMutableTreeNode(data);
			petNode.add(name);
			pet.setName(data);
		}else if(isAge) {
			DefaultMutableTreeNode age = new DefaultMutableTreeNode(data);
			petNode.add(age);
			pet.setAge(Integer.parseInt(data));
		}
	}
	public void endElement(String uri, String localName, String tag) throws SAXException {
		if(tag.equals("type")) {
			isType=false;
		}else if(tag.equals("name")) {
			isName=false;
		}else if(tag.equals("age")) {
			isAge=false;
		}else if(tag.equals("pet")){
			isPet=false;
			petList.add(pet);
			root.add(petNode);
		}else if(tag.equals("pets")) {
			isPets=false;
		}
	}
	
	public void endDocument() throws SAXException {
		for(Pet obj:petList) {
			System.out.println(obj.getType());
			System.out.println(obj.getName());
			System.out.println(obj.getAge());
			
		}
	}
	
	
	
	
}
