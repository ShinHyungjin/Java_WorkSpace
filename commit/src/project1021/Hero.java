package project1021;

public class Hero {
	int hp=10;
	boolean fly=false;
	String name="�ް���";
	Bullet bullet;

	
	public void setHp(int hp) { //hp ���� �����ϰ� �ʹ� 
		this.hp = hp;
	}
	public void setFly(boolean fly) {//fly ���� �����ϰ� �ʹ�
		this.fly = fly;
	}
	public void setName(String name) {//name ���� �����ϰ� �ʹ�		
		this.name = name;
	}
	public void fire(Bullet bullet){//bullet �� �ٸ� ����� �����ϰ� �ʹ�
		this.bullet = bullet;		
	}

	public static void main(String[] args) {
		Hero hero = new Hero();
		hero.setHp(20);
		hero.setFly(true);
		hero.setName("�չ���");
		hero.fire(new Bullet("ice"));	
		
		System.out.println(hero.hp + "\n" + hero.fly + "\n" + hero.name + "\n" + hero.bullet.bullet);
	}	
}
class Bullet {
	String bullet = "fire";
	public Bullet(String fire) {
		this.bullet = fire;
	}
}