package day1102.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedIOApp {

	public BufferedIOApp() {
		
	}
	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		//BufferedWriter bw = new BufferedWriter();
		
		String data;
		try {
			while(true) {
				data = br.readLine();
				if(data == null)
					break;
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
