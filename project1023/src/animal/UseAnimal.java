package animal;
class Animal{
   String name="������";

   public Animal(String n){  
       name=n;
   }
   public Animal(){            

   }
}

class Tiger extends Animal{
   String name="��ȣ����";
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
        System.out.println(a1.name); // ������ �޼ҵ尡 �ƴϱ� ������ �������̵��� �������

   }
}
