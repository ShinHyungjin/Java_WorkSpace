package plant;
class Plant {
   String name="�� �Ĺ�";

   public void grow(){
      System.out.println("�Ĺ��� �ڶ��ϴ�.");
   }
   public void drink() {
		System.out.println("���� ���ʴϴ�");
   }
}

class Flower extends Plant{
   String name="�� ��";

   public void grow(){
      System.out.println("���� �ڶ��ϴ�.");
   }

}

class UsePlant{
   public static void main(String[] args){
        Plant p1=new Plant();
        System.out.println(p1.name); 
        
        Plant p2=new Flower(); // �θ� ��ü������, �ڽ� �޼ҵ� ���ٰ���(�������̵�)
        System.out.println(p2.name); // ������ ����x �θ𲬷� ��µ�
     
        p2.grow();	// Plant = new Flower�� �̿��� �޼ҵ� �������̵��� �̿��ϰ�
		p2.drink();	// Plant�� �޼ҵ嵵 ����� �� �ֱ� ������ Java�� '������'�� ������
   }
}
