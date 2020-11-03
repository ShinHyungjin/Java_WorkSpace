package day1103.thread;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class BarThread extends Thread{
	int n=0;
	int interval=0;
	JProgressBar bar;
	JLabel la;
	public BarThread(JLabel la, JProgressBar bar, int interval) {
		this.la = la;
		this.bar = bar;
		this.interval = interval;
	}
	public void run() {
		while(true) {
			n++;
			bar.setValue(n);
			la.setText(String.valueOf(n));
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
