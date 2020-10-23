package animal;
class Bird{
   String name="난 그냥새";
}

class Duck extends Bird{
   String name="난 오리";
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
