package project1020;

/*
 ����, ����, �������������� ����, �޸���, ����
 */

public class Car {
	String color = "red";
	int price = 35000;
	boolean auto = false;
	public void drive() {
		System.out.println("�޸���");
	}
	public void stop() {
		System.out.println("�����");
	}
	public static void main(String[] args) {
		Car bmw = new Car();
		bmw.drive();
		bmw.stop();
	}
}
