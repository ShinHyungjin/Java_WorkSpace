package animal;
public class Cat
{
	String name;
	int age;

	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}
	/** 고양이를 울게하는 매서드 */
	public void cry() {
		System.out.println("웨옹");
	}
}
