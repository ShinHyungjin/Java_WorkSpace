package animal;
public class Duck extends Bird
{
	String name = "난 오리";
	public void quack() {
		System.out.println("꽥꽥");
	}
	public static void main(String [] args) {
		Duck d1 = new Duck();
		Duck d2 = new Duck();

		Bird b1 = new Bird();
		Bird b2 = new Duck(); // 가능 - 큰 자료형에 작은 자료형을 담는다..
		//Duck d3 = new Bird(); // 불가능 - 작은 자료형에 큰 자료형을 담는다..

		//b1 = (Bird)d1;	// DownCasting
		//d1 = (Duck)b1; // UpCasting



	}
}
