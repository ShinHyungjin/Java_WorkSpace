package animal;
public class Duck extends Bird
{
	String name = "�� ����";
	public void quack() {
		System.out.println("�в�");
	}
	public static void main(String [] args) {
		Duck d1 = new Duck();
		Duck d2 = new Duck();

		Bird b1 = new Bird();
		Bird b2 = new Duck(); // ���� - ū �ڷ����� ���� �ڷ����� ��´�..
		//Duck d3 = new Bird(); // �Ұ��� - ���� �ڷ����� ū �ڷ����� ��´�..

		//b1 = (Bird)d1;	// DownCasting
		//d1 = (Duck)b1; // UpCasting



	}
}
