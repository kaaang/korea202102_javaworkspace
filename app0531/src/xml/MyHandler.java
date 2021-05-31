package xml;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//파싱 대상이 되는 XML문서의 모든 노드를 만날때마다, 개발자가 이벤트를 통해 정보를 전달해주는
//핸들러 객체 정의, 개발자는 핸들러가 발생시키는 이벤트에 따라 원하는 파싱 관련 작업을 진행 할 수 있다.
public class MyHandler extends DefaultHandler{
	//파싱을 진행하는 실행부가 지금 어느 태그를 지나치는지를 알 수 있는 표기 용도의 논리값을 선언
	boolean isMembers;
	boolean isMember;
	boolean isName;
	boolean isAge;
	boolean isAddr;
	
	Vector<Member> memberList;
	Member member;
	
	
	
	
	//각 노드를 만날때마다 호출되는 메서드를 재정의해보자
	public void startDocument() throws SAXException {
		System.out.println("문서 시작");
	}
	//시작태그 노드를 만날때 호출되는 메서드
	public void startElement(String uri, String name, String tag, Attributes attributes) throws SAXException {
		System.out.print("<"+tag+">");
		if(tag.equals("members")) {
			isMembers=true;
			memberList=new Vector<Member>();
		}else if(tag.equals("member")) {
			isMember=true;
			member = new Member();
		}else if(tag.equals("name")) {
			isName=true;
		}else if(tag.equals("age")) {
			isAge=true;
		}else if(tag.equals("addr")) {
			isAddr=true;
		}
	}
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch,start,length);
		System.out.print(data);
		
		if(isName) {
			member.setName(data);
		}else if(isAge){
			member.setAge(Integer.parseInt(data));
		}else if(isAddr) {
			member.setAddr(data);
		}
	}
	public void endElement(String uri, String localName, String tag) throws SAXException {
		System.out.print("</"+tag+">");
		
		if(tag.equals("name")) {
			isName=false;
		}else if(tag.equals("age")) {
			isAge=false;
		}else if(tag.equals("addr")) {
			isAddr=false;
		}else if(tag.equals("member")) {
			isMember=false;
			memberList.add(member);
		}else if(tag.equals("members")) {
			isMembers=false;
		}
	}
	public void endDocument() throws SAXException {
		System.out.println("");
		System.out.println("문서 끝, 최종 회원 수 : "+memberList.size());
		
		//모든 회원 출력해보기
		for(Member obj: memberList) {
			System.out.println("회원 이름 : "+obj.getName());
			System.out.println("회원 나이 : "+obj.getAge());
			System.out.println("회원 주소 : "+obj.getAddr());
			System.out.println("");
		}
	}
}
