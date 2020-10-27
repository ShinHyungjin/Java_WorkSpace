package string;
class StringTest2
{
	public static void main(String[] args) 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for(int i=0; i<100; i++) {
			sb.append("줄넘기 "+i+" 회\n");
		}
		System.out.println(sb.toString());
		/*
			String str = "";
			for(int i=0; i<100; i++)
				str = "줄넘기" + i + "회";
				//String은 불변인 원자성을 갖고있기 때문에 위처럼 코드했다간
				100개의 문자열 상수를 상수풀에 생성..(메모리 낭비)
				때문에 StringBuilder나 StringBuffer와 같은 객체를 통해 메모리낭비 방지
		*/
	}
}
