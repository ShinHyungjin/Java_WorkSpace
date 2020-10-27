package day1027.gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
/*	단축기 모두 보기 : ctrl + shif + L
 * 	자동 import : ctrl + shift + O
 * 	자동 코드 정렬 : ctrl + shift + F
 * 	객체 API 문서 바로가기 : 클래스에 커서 + shift + F2
 * 	
 * */
import java.awt.Frame;

public class RadioTest extends Frame {
	CheckboxGroup cg = new CheckboxGroup();
	

	public RadioTest() {
		setLayout(new FlowLayout());
		setSize(300,400);
		this.add(new Checkbox("h1", false));
		this.add(new Checkbox("h2", false));
		this.add(new Checkbox("h3", false));
		this.add(new Checkbox("h4", false));
		this.add(new Checkbox("h5", false));
		this.add(new Checkbox("h6", false));
		this.add(new Checkbox("h7", false));
		this.add(new Checkbox("h8", false));
		setVisible(true);
	}

	public static void main(String[] args) {
		System.out.println("빠름");
		new RadioTest();
	}
}
