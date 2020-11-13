/*
 *  xml의 모든 노드에서 이벤트가 발생할때마다 아래의 핸들러 객체의
 *  메서드를 알맞게 오버라이드하면 됨.
 * 
 * */
package day1113.xml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	ArrayList<Pet> petList;
	Pet pet;
	
	boolean isType;
	boolean isName;
	boolean isAge;
	boolean isGender;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("문서를 시작합니다");
	}
	// 여는 태그 만났을 때 호출되는 메소드
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		System.out.print("<"+tag+">");
		
		if(tag.equals("pets")) {
			petList = new ArrayList<Pet>();
		}else if(tag.equals("pet")) {
			pet = new Pet();
		}else if(tag.equals("type")) {
			isType = true;
		}else if(tag.equals("name")) {
			isName = true;
		}else if(tag.equals("age")) {
			isAge = true;
		}else if(tag.equals("gender")) {
			isGender = true;
		}
		
	}
	@Override
	public void endElement(String uri, String localName, String tag) throws SAXException {
		System.out.println("</"+tag+">");
		if(tag.equals("pet")) {
			petList.add(pet);
		}else if(tag.equals("type")) {
			isType=false;
		}else if(tag.equals("name")) {
			isName=false;
		}else if(tag.equals("age")) {
			isAge=false;;
		}else if(tag.equals("gender")) {
			isGender=false;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch,start,length);
		System.out.print(data);
		
		if(isType) {
			pet.setType(data);
		}else if(isName) {
			pet.setName(data);
		}else if(isAge) {
			pet.setAge(Integer.parseInt(data));
		}else if(isGender) {
			pet.setGender(data);
		}
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("문서를 종료합니다");
		System.out.println("총 "+petList.size()+"개의 Pet이 존재");
		for(Pet pet : petList) {
			System.out.println("type : " + pet.getType());
			System.out.println("name : " + pet.getName());
			System.out.println("age : " + pet.getAge());
			System.out.println("gender : " + pet.getGender());
			System.out.println("---------------------------");
		}
	}
}