package day1103.thread;

import java.util.Calendar;

public class TimeThread extends Thread {
	public void run() {
		while (true) {
			Calendar cal = Calendar.getInstance();
			System.out.println(cal.get(Calendar.YEAR)+"  " + (cal.get(Calendar.MONTH)+1) + "  " + cal.get(Calendar.DATE) + "  " + cal.get(Calendar.HOUR) + "  " + cal.get(Calendar.MINUTE) + "  " + cal.get(Calendar.SECOND));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
