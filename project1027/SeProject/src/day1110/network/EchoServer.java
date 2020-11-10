package day1110.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	int port=8989;
	ServerSocket server;
	public EchoServer() {
		try {
			server = new ServerSocket(port);
			Socket socket = server.accept();
			System.out.println("접속자 발견");
			InputStream is = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			while(true) {
				String data = br.readLine();
				System.out.println(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EchoServer();
	}
}
