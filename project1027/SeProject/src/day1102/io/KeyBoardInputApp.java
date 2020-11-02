package day1102.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardInputApp {
	
	public KeyBoardInputApp() {
	}

	public static void main(String[] args) {
		InputStreamReader is = new InputStreamReader(System.in);
		System.out.println();
		int data;
		try {
			while(true) {
			data = is.read();
			if(data == 1)
				break;
			System.out.print((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
