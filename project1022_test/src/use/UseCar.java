package use;
import car.*;
class UseCar 
{
	public static void main(String [] args) {
		// �ڵ����� �θ�Ŭ������ super()�� �Ǳ� ������ ���� new�� �ʿ�x\
		Taxi taxi = new Taxi();
		taxi.move();	//Car.move();
		taxi.pass();	//Taxi.move();
	}
}
