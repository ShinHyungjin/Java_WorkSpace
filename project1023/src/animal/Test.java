package animal;
class Bird{
   String name="�� �׳ɻ�";
}

class Duck extends Bird{
   String name="�� ����";
}

public class Test{
   public static void main(String[] args){
        Bird b1=new Bird();      
        Duck dk=new Duck();   
        Bird bird=dk;               
        Duck d=(Duck)bird;      
        System.out.println(d.name);
   }
}
