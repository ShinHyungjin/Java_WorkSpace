package day1102.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemoCopy {
	//FileInputStream fr;
	//FileOutputStream fw;
	FileReader fr;
	FileWriter fw;
	String path="D:/IT_Korea_Class/Java/project1027/SeProject/res/data/test.txt";
	String path2="D:/IT_Korea_Class/Java/project1027/SeProject/res/data/test_copy.txt";
	public MemoCopy() {
		try {
			//fr = new FileInputStream(path);
			//fw = new FileOutputStream(path2);
			
			try {
				fr = new FileReader(path);
				try {
					fw = new FileWriter(path2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			int data;
			try {
				while(true) {	
					data = fr.read();System.out.print((char)data);
					if(data == -1)
						break;
					fw.write((char)data);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}finally {
			if(fr != null) {
				try {
					fr.close();
				}catch(IOException e) {
					
				}
			}
				if(fw != null) {
					try {
						fw.close();
					}catch(IOException e) {
						
					}
			}
		}
	}

	public static void main(String[] args) {
		new MemoCopy();
	}
}
