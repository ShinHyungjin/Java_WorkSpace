package day1113.xml.down;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import day1106.db.FileManager;

public class DownLoader extends JFrame{
	JButton bt;
	JProgressBar bar;
	JLabel la;
	File file;
	MovieHandler movieHandler;
	Thread parsingThread;
	
	int total=0;
	int readCount=0;
	public DownLoader() {
		bt = new JButton("다운로드");
		bar = new JProgressBar();
		la = new JLabel();
		
		bar.setPreferredSize(new Dimension(580,45));
		bar.setForeground(Color.CYAN);
		bar.setBackground(Color.BLACK);
		
		bar.setFont(new Font("Verdana", Font.BOLD, 25));
		bar.setStringPainted(true);
		bar.setValue(0);
		
		add(bt);
		add(bar);
		
		setLayout(new FlowLayout());
		setSize(600,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		bt.addActionListener((e)-> {
			parsingThread = new Thread() {
				public void run() {
					parseData();
					System.out.println("MovieList에 담김 아이템의 총 수는 : "+movieHandler.movieList.size());
					for(int i=0; i<movieHandler.movieList.size(); i++) {
						Movie movie = movieHandler.movieList.get(i);
						download(movie.getUrl());
					}
					//download();
					JOptionPane.showMessageDialog(DownLoader.this, "복사가 완료되었습니다 \n총"+movieHandler.movieList.size()+"개 많큼의 파일이 복사되었습니다.");
				};
			};
			parsingThread.start();
		});
	}
	public void download(String path) {
		FileOutputStream fos=null;
		InputStream is=null;
		try {
			URL url = new URL(path);
			URLConnection con = url.openConnection();
			HttpURLConnection http = (HttpURLConnection)con;
			http.setRequestMethod("GET");
			
			//커넥션 객체를 이용하면 대상 자원의 크기까지 얻어올 수 있다.
			
			int total = con.getContentLength();
			readCount=0;
			System.out.println(total);
			
			is = http.getInputStream();
			
			long time = System.currentTimeMillis(); // 현재시간
			String ext = FileManager.getExtend2(path); //전에 만든 확장자 구하는 메소드
			
			File file = new File("D:/IT_Korea_Class/Java/project1027/SeProject/res/download/"+time+"."+ext);
			fos = new FileOutputStream(file);
			
			int data=-1;	
			
			while(true) {
				data = is.read();
				bar.setValue((int)getPercent(total, readCount));
				if(data==-1) 
					break;
				readCount++;
				fos.write(data);
			}
			System.out.println(time+"."+ext+" 복사완료");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					if(fos!=null)
						try {
							fos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					if(is!=null)
						try {
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
		}
		
	}
	public void parseData() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			URL url = this.getClass().getClassLoader().getResource("res/marvel.xml");
			file = new File(url.toURI());
			
			saxParser.parse(file, movieHandler = new MovieHandler());
			
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public float getPercent(int total, float readCount) {
		return (readCount/total)*100;
	}
	public static void main(String[] args) {
		new DownLoader();
	}
}
