package music;
import riding.Wing;
public class Speaker extends AudioDevice implements Wing
//����Ŀ�� ���������̽� ����, ���̴�.
// ���ΰ� ����ȯ�� �����ϴ�
{
	boolean ooper;
	String color = "red";
	public void sound() {

	}
	public void setVolume() {
		System.out.println("���� ����");
	}
	public void playMp3() {
		System.out.println("�÷���");
	}
	public void fly() {
		System.out.println("���ٿ�"); 
	}
	public static void main(String [] args) {
		Speaker s = new Speaker();
		Wing wing = new Speaker(); // ����
		AudioDevice ad = new Speaker(); // ����
		wing.fly();	// ������ �θ��� �޼ҵ�� �߻��̱⶧���� �ڽİ��� ȣ��
		ad.playMp3(); // �ڽ��� �޼ҵ带 �ֿ켱 ȣ��
		s.setVolume();
	}
}
