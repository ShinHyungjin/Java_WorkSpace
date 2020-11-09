package day1109.echo;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	ServerSocket server;
	Socket socket;
	int port = 9999;
	public EchoServer() {
		try {
			server = new ServerSocket(port);
			System.out.println("서버 소켓 생성완료");
			socket = server.accept();
			System.out.println("접속자 발견");
			
			InetAddress inet = socket.getInetAddress();
			System.out.println(inet.getHostAddress());
			InputStream is = socket.getInputStream();
			while(true) {
				int data = is.read();
				System.out.print((char)data);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EchoServer();
	}
}
