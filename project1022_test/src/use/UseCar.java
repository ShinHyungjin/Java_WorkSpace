package use;
import car.*;
class UseCar 
{
	public static void main(String [] args) {
		// 자동으로 부모클래스는 super()가 되기 때문에 먼저 new할 필요x\
		Taxi taxi = new Taxi();
		taxi.move();	//Car.move();
		taxi.pass();	//Taxi.move();
	}
}
