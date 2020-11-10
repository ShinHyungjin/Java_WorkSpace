package day1110.network.echo;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EchoClient extends JFrame{
	JPanel p_north;
	Choice ch_ip; 
	JTextField t_port;
	JButton bt_connect;
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt_send;
	
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	public EchoClient() {
		p_north = new JPanel();
		ch_ip = new Choice();
		t_port = new JTextField("7777",10);
		bt_connect = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(15);
		bt_send = new JButton("send");
		
		ch_ip.add("localhost");
		
		//조립 
		p_north.add(ch_ip);
		p_north.add(t_port);
		p_north.add(bt_connect);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		p_south.add(t_input);
		p_south.add(bt_send);
		add(p_south, BorderLayout.SOUTH);
		
		bt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		bt_send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		
		setBounds(300,200,300,400);
		setVisible(true);
	}
	public void connect() {
		try {
			socket = new Socket(ch_ip.getSelectedItem(), Integer.parseInt(t_port.getText()));
			area.append("접속완료\n");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send() {
		String msg = t_input.getText();
		try {
			bw.write(msg+"\n");
			bw.flush();
			listen();
			t_input.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void listen() {
		try {
			String msg = br.readLine();
			area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EchoClient();

	}
}