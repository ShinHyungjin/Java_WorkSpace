package music;
import riding.Wing;
public class Speaker extends AudioDevice implements Wing
//스피커는 오디오디바이스 이자, 윙이다.
// 서로간 형변환이 가능하다
{
	boolean ooper;
	String color = "red";
	public void sound() {

	}
	public void setVolume() {
		System.out.println("볼륨 조절");
	}
	public void playMp3() {
		System.out.println("플레이");
	}
	public void fly() {
		System.out.println("난다요"); 
	}
	public static void main(String [] args) {
		Speaker s = new Speaker();
		Wing wing = new Speaker(); // 가능
		AudioDevice ad = new Speaker(); // 가능
		wing.fly();	// 어차피 부모측 메소드는 추상이기때문에 자식것이 호출
		ad.playMp3(); // 자식의 메소드를 최우선 호출
		s.setVolume();
	}
}
