package car;
public class Taxi extends Car 
{
	//public Taxi() {	// 부모 클래스에서 오버로딩으로 기본 생성자를 만들어서
							// 개발자가 직접 생성자를 만들지 않더라도 오류 x
		//super("Benz");
	//}
	public void pass() {
		System.out.println("손님태움");
	}
}
