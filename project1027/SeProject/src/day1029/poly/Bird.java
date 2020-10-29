package day1029.poly;

public class Bird {
	String name="난새";
	String local="평양";
	public void fly() {
		System.out.println("새 난다요");
	}
	public void wake() {
		System.out.println("새 일어났으여");
	}
	public static void main(String[] args) {
		Bird b1 = new Bird();
		Bird b2 = new Duck();
		Bird b3 = new Sparrow();
		
		b1.fly();
		b2.fly();
		b3.fly();

	}
}
