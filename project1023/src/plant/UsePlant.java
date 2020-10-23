package plant;
class Plant {
   String name="난 식물";

   public void grow(){
      System.out.println("식물이 자랍니다.");
   }
   public void drink() {
		System.out.println("물을 마십니다");
   }
}

class Flower extends Plant{
   String name="난 꽃";

   public void grow(){
      System.out.println("꽃이 자랍니다.");
   }

}

class UsePlant{
   public static void main(String[] args){
        Plant p1=new Plant();
        System.out.println(p1.name); 
        
        Plant p2=new Flower(); // 부모 객체일지라도, 자식 메소드 접근가능(오버라이딩)
        System.out.println(p2.name); // 변수는 접근x 부모껄로 출력됨
     
        p2.grow();	// Plant = new Flower를 이용해 메소드 오버라이딩을 이용하고
		p2.drink();	// Plant의 메소드도 사용할 수 있기 때문에 Java는 '다형성'이 제공됨
   }
}
