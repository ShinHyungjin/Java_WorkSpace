package project1021;

class wheel {
	String brand = "Korea";
	String color = "black";
	String [] wheelarr = new String[4];
	public wheel(int count) {
		for(int i=0; i<4; i++)
			this.wheelarr[i] = i+"��° ����";
	}
}
public class Car {
	String name = "����";
	String color = "red";
	int price = 500;
	wheel banzwheel = new wheel(4);
	public static void main(String[] args) {
		Car banzcar = new Car();
		System.out.println(banzcar.banzwheel.brand);
		System.out.println(banzcar.banzwheel.color);
		for(int i=0; i<4; i++) 
			System.out.println(banzcar.banzwheel.wheelarr[i]);
	}
}
