package animal;
class Animal{
   String name="난동물";

   public Animal(String n){  
       name=n;
   }
   public Animal(){            

   }
}

class Tiger extends Animal{
   String name="난호랑이";
   public Tiger(){

   }
   public Tiger(String n){
      name=n;
   }
}

public class UseAnimal{
   public static void main(String[] args){
        //Tiger t1=new Animal();    
        Animal a1=new Tiger();  
        System.out.println(a1.name); // 변수는 메소드가 아니기 때문에 오버라이딩과 관계없음

   }
}
