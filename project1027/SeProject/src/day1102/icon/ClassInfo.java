package day1102.icon;

import java.lang.reflect.Method;
import java.net.URL;

public class ClassInfo {
	Class myClass;
	public ClassInfo() {
		myClass = this.getClass();
		Method[] methods = myClass.getMethods();
		for(int i=0; i<methods.length; i++) {
			System.out.println(methods[i]);
		}
		URL url = (myClass.getClassLoader().getResource("res/youtube.png"));
		System.out.println(url);
	}
	public void test() {
		
	}
	public static void main(String[] args) {
		new ClassInfo();
	}
}
