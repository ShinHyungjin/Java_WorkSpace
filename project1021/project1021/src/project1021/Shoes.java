package project1021;

public class Shoes{
	String color;//String �� ��ü�̹Ƿ� �����Ϸ��� ���� null
	int price; //������ �����Ϸ��� ���� �ּ����� ���� ���� 0���� �ʱ�ȭ

	public void setColor(String color){//������ �����ϴ� �޼���
		this.color=color;
	}
	public void setPrice(int price){//������ �����ϴ� �޼���
		this.price=price;
	}
	public static void main(String[]  args){
		Shoes s = new Shoes();
		s.setColor("red");
		s.setPrice(20000);

		System.out.println("�Ź��� ������ "+s.color+",������ "+s.price);
	}

}
