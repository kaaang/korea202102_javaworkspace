package app0601.xml.data.table;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MountainHandler extends DefaultHandler{
	Vector<Mountain> mtList;
	Mountain mountain;
	boolean isItems;
	boolean isItem;
	boolean isMntiadd;
	boolean isMntidetails;
	boolean isMntihigh;
	boolean isMntilistno;
	
	
	
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		if(tag.equals("items")) {
			isItems=true;
			mtList = new Vector<Mountain>();
		}else if(tag.equals("item")) {
			isItem=true;
			mountain = new Mountain();
		}else if(tag.equals("mntiadd")) {
			isMntiadd=true;
		}else if(tag.equals("mntidetails")) {
			isMntidetails=true;
		}else if(tag.equals("mntihigh")) {
			isMntihigh=true;
		}else if(tag.equals("mntilistno")) {
			isMntilistno=true;
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch,start,length);
		if(isMntiadd) {
			mountain.setMntiadd(data);
		}else if(isMntidetails) {
			mountain.setMntidetails(data);
		}else if(isMntihigh) {
			mountain.setMntihigh(data);
		}else if(isMntilistno) {
			mountain.setMntilistno(Integer.parseInt(data));
		}
	}
	
	public void endElement(String uri, String localName, String tag) throws SAXException {
		if(tag.equals("mntiadd")) {
			isMntiadd=false;
		}else if(tag.equals("mntidetails")) {
			isMntidetails=false;
		}else if(tag.equals("mntihigh")) {
			isMntihigh=false;
		}else if(tag.equals("mntilistno")) {
			isMntilistno=false;
		}else if(tag.equals("item")) {
			isItem=false;
			mtList.add(mountain);
		}else if(tag.equals("items")) {
			isItems=false;
		}
	}
	
	public void endDocument() throws SAXException {
		System.out.println(mtList.size());
		for(Mountain obj: mtList) {
			System.out.println(obj.getMntiadd());
			System.out.println(obj.getMntidetails());
			System.out.println(obj.getMntihigh());
			System.out.println(obj.getMntilistno());
		}
	}
}
