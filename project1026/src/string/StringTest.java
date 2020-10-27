package string;
class StringTest 
{ 
	public static void main(String[] args) 
	{
		String a1 = "apple";
		String a2 = "apple";
		if(a1==a2){		// 주소비교... 묵시적생성법으로 상수풀에 저장되기에 
							// 한번 생성된 주소는 다시 만들지않고, 같은 인스턴스는 공유하기에
							// 결과는 항상 true
			System.out.println(a1==a2);
		}
		if(a1.equals(a2)) {
			System.out.println(a1.equals(a2));	// 내용비교
		}
		
	}
}
