package project1021;

class Computer2{
	int speed=300;
}

class UseComputer2 {
	public void setting(Computer2 c , int s){
		c.speed=s;
		s=50; //(다)
	}
	
	public static void main(String[] args) {
		int k=500; //(가)
		
		UseComputer2 uc = new UseComputer2();
		Computer2 com = new Computer2();//(바)

		com.speed=100;
		
		uc.setting(com , k); //(나)
		
		System.out.println(com.speed); //(라)
		System.out.println(k); //(마)
		
	}
}
