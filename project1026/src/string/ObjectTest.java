package string;
class ObjectTest 
{
	/*
		
	*/
	String s1 = "오리";
	public String toString() {
		System.out.println("toString 동작");
		return "";
	}
	public static void main(String[] args) 
	{
		ObjectTest ot = new ObjectTest();
		
		System.out.println(new ObjectTest());
		
	}
}
