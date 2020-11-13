package day1113.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLLoadApp {
	URLConnection con;
	HttpURLConnection http;
	URL url;
	FileOutputStream fos;
	public URLLoadApp() {
		try {
			url = new URL("https://highdefdiscnews.com/wp-content/uploads/2018/12/2001_a_space_odyssey_4k_01-1.png");
			con = url.openConnection();
			
			http = (HttpURLConnection)con;
			//GET방식으로 요청
			http.setRequestMethod("GET");
			
			//연결 객체로부터 스트림을 얻어와서 데이터 읽기
			InputStream is = http.getInputStream();
			
			File file = new File("D:/IT_Korea_Class/Java/project1027/SeProject/src/res/copy.jpg");
			fos = new FileOutputStream(file);
			
			int data=-1;
			
			while(true) {
				data = is.read();
				if(data==-1) break;
				fos.write(data);
			}
			System.out.println("복사완료");
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
				}
		}
	}
	public static void main(String[] args) {
		new URLLoadApp();
	}
	
}
