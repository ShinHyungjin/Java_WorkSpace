package day1110.network.echo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EchoServer extends JFrame{
	JTextField t_port;
	JButton bt;
	JPanel p_north;
	JTextArea area;
	JScrollPane scroll;
	
	ServerSocket server;
	int port=7777;
	
	Thread thread;
	BufferedReader br;
	BufferedWriter bw;
	public EchoServer() {
		t_port = new JTextField("7777",10);
		bt = new JButton("서버가동");
		p_north = new JPanel();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thread = new Thread() {
					public void run() {
						startServer();
					}
				};
				thread.start();
			}
		});
		
		setVisible(true);
		setBounds(600,200,300,400);
	}
	public void startServer() {
		try {
			server = new ServerSocket(Integer.parseInt(t_port.getText()));
			area.append("서버 준비\n");
			Socket socket = server.accept(); // main을 무한대기, 루프하게 만드는 원인
			area.append("접속자 발견\n");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			listen();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listen() {
		try {
			while(true) {
				String msg = br.readLine();
				area.append(msg+"\n");
				send(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void send(String msg) {
		try {
			while(true) {
				bw.write(msg+"\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EchoServer();
	}
}
