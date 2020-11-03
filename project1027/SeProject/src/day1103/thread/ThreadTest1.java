package day1103.thread;

public class ThreadTest1 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		TimeThread tt = new TimeThread();
		Thread mt = new Thread() {
			public void run() {
				while(true) {
					System.out.println("★");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		mt.start();
		tt.start();
//		t1.start();
//		while (true) {
//			System.out.println("hi");
//		}
	}
}
