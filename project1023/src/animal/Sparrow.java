package animal;
public class Sparrow extends Bird
{
	// �����ε� : ���� Ŭ������ ���� �޼ҵ� ����(�Ű����� ���� �Ǵ� �ڷ��� �ٸ�)
	// �������̵� : ��Ӱ��迡�� �θ�Ŭ������ ������ �޼ҵ带 �ڽ�Ŭ�������� ����
	public void fly() {
		System.out.println("���� ������"); // �θ�Ŭ���� �żҵ�� ���� = ���� ���̵�
	}
	public static void main(String [] args) {
		Sparrow sp = new Sparrow();
		sp.fly();
		Bird b = new Bird();
		b.fly();

		Bird b2 = new Sparrow();
		b2.fly(); // �������̵� �� �޼ҵ��̱� ������ super�� fly�� �ƴ� �ڽ��� fly�� ȣ��
	}
}
