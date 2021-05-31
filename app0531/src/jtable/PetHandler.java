package jtable;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//Pet.xml을 파싱할 핸들러
public class PetHandler extends DefaultHandler{
	ArrayList<Pet> petList;
	boolean isPets;
	boolean isPet;
	boolean isType;
	boolean isName;
	boolean isAge;
	
	Pet pet;
	
	//시작태그
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		if(tag.equals("pets")) {
			isPets=true;
			petList = new ArrayList<Pet>();//컬렉션 생성
		}else if(tag.equals("pet")) {
			isPet=true;
			pet = new Pet();//VO생성
		}else if(tag.equals("type")) {
			isName=true;
		}else if(tag.equals("name")) {
			isName=true;
		}else if(tag.equals("age")) {
			isAge=true;
		}
	}
	
	//케릭터
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch,start,length);
		if(isType) {
			pet.setType(data);
		}else if(isName) {
			pet.setName(data);
		}else if(isAge) {
			pet.setAge(Integer.parseInt(data));
		}
	}
	
	
	//닫는태그
	public void endElement(String uri, String localName, String tag) throws SAXException {
		if(tag.equals("type")) {
			isName=false;
		}else if(tag.equals("name")) {
			isName=false;
		}else if(tag.equals("age")) {
			isAge=false;
		}else if(tag.equals("pet")) {
			isPet=false;
			//리스트에 VO추가
			petList.add(pet);
		}else if(tag.equals("pets")) {
			isPets=false;
		}
	}
	
	public void endDocument() throws SAXException {
		//문서 종료시 ArrayList에 VO들이 담겨졌는지 체크해보자
		for(Pet obj: petList) {
			System.out.println(obj.getType());
			System.out.println(obj.getName());
			System.out.println(obj.getAge());			
		}
	}
	
	
}
