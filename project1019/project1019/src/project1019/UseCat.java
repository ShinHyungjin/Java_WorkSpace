package project1019;
class UseCat {
	public static void main(String[] args){
		Cat c1 = new Cat();//°í¾çÀÌ ÀÎ½ºÅÏ½º 1°³ »ý¼º
		System.out.println("name "+c1.name);
		System.out.println("age "+c1.age);
		System.out.println("isMarried "+c1.isMarried);
		
		c1.walk();
		c1.cry();

	}
}
