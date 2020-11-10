package day1110.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoClient {
	Socket socket;
	String ip = "localhost";
	int port = 8989;
	Thread thread;
	public EchoClient() {
		try {
			socket = new Socket(ip, port);
			System.out.println("접속 성공");
			InputStream is = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(writer);
			
			thread = new Thread() {
				public void run() {
					while(true) {
						try {
							bw.write("hi\n");
							bw.flush();
							Thread.sleep(300);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			};
			thread.start();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new EchoClient();

	}

}
