package project1021;

class Computer2{
	int speed=300;
}

class UseComputer2 {
	public void setting(Computer2 c , int s){
		c.speed=s;
		s=50; //(��)
	}
	
	public static void main(String[] args) {
		int k=500; //(��)
		
		UseComputer2 uc = new UseComputer2();
		Computer2 com = new Computer2();//(��)

		com.speed=100;
		
		uc.setting(com , k); //(��)
		
		System.out.println(com.speed); //(��)
		System.out.println(k); //(��)
		
	}
}
