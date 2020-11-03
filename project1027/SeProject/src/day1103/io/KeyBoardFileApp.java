package day1103.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class KeyBoardFileApp {
	String dir;
	FileWriter fw;
	File f;
	public KeyBoardFileApp() {
		URL url = this.getClass().getClassLoader().getResource("res/");
		try {
			URL url2 = new URL(url, "empty.txt");
			URI uri = url2.toURI();
			f = new File(uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}
	public void saveFile() {
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		
		try {
			fw = new FileWriter(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String msg = null;
		
		try {
			msg = br.readLine();
			System.out.println(msg);
			fw.write(msg);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	public static void main(String[] args) {
		new KeyBoardFileApp().saveFile();
	}
}
