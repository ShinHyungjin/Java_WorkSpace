package project1021;

public class  HighHeel{
	   String color="None Color";    
	   public HighHeel() {
		   this.color = "black";
	   }
	   public void setColor(HighHeel h, String color) {
		 h.color = color;
	   }
	   public static void main(String[] args) {
		   HighHeel h1 = new HighHeel();
		   System.out.println(h1.color);
		   h1.setColor(h1, "blue");
		   System.out.println(h1.color);
	   }
	}
