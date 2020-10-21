package project1021;

public class UsePizza {
	public void eat(Pizza p) {
		p.slice=3;
	}
	public void setSlice(int slice) {
		slice = 3;
	}
	public static void main(String[] args) {
		Pizza p1 = new Pizza("피자헛");
		Pizza p2 = new Pizza("도미노");
		
		UsePizza up = new UsePizza();
		up.setSlice(5);
		up.setSlice(p1.slice);
		up.eat(p1);
		System.out.println(p1.slice);
	}
}
