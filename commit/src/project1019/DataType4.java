package project1019;
class DataType4 {
	public static void main(String[] args){
		short s = 7;
		byte b = 5;

		s=b; //가능? 불가능?
		//b=(byte)s; //강제 형변화 큰-> 작  demotion
	}
}
