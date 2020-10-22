package car;
public class Car 
{
	String brand;

	public Car(String brand) { // 부모클래스에 오버로딩을 하면 
										// 자식클래스에서 Default 생성자를 쓰더라도
										// 오류가 나지 않음
		this.brand = brand;
		System.out.println(brand);
	}

	public Car() {

	}

	public void move() {
		System.out.println("나 움직인다");
	}
}