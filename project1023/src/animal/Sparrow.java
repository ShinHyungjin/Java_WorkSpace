package animal;
public class Sparrow extends Bird
{
	// 오버로딩 : 같은 클래스내 같은 메소드 정의(매개변수 갯수 또는 자료형 다름)
	// 오버라이딩 : 상속관계에서 부모클래스와 동일한 메소드를 자식클래스에서 정의
	public void fly() {
		System.out.println("참새 나르다"); // 부모클래스 매소드와 동일 = 오버 라이딩
	}
	public static void main(String [] args) {
		Sparrow sp = new Sparrow();
		sp.fly();
		Bird b = new Bird();
		b.fly();

		Bird b2 = new Sparrow();
		b2.fly(); // 오버라이딩 된 메소드이기 때문에 super의 fly가 아닌 자식의 fly를 호출
	}
}
