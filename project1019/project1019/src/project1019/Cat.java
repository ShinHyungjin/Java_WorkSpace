package project1019;
/*
고양이를 정의하시오
클래스명: Cat 
이름: 묘 
나이 : 3 
결혼여부 : 미혼 
걷는 동작 
우는 동작
UseCat 클래스로  Cat의 정보를 화면에 출력해본다..
특히 걷는동작, 우는동작 메서드 호출까지 해보기
*/
class Cat {
	String name="묘";
	int age=3;
	boolean isMarried=false;

	public void walk(){//걷는 동작 
		System.out.println("고양이가 걸어요");
	}
	public void cry(){ //우는 동작
		System.out.println("야옹~");
	}
}