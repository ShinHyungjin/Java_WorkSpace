package car;
public class Car 
{
	String brand;

	public Car(String brand) { // �θ�Ŭ������ �����ε��� �ϸ� 
										// �ڽ�Ŭ�������� Default �����ڸ� ������
										// ������ ���� ����
		this.brand = brand;
		System.out.println(brand);
	}

	public Car() {

	}

	public void move() {
		System.out.println("�� �����δ�");
	}
}