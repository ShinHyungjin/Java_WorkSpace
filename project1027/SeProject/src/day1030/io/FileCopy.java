package day1030.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	String ori = "D:/IT_Korea_Class/Java/project1027/SeProject/res/data/memo.txt";
	String dest = "D:/IT_Korea_Class/Java/project1027/SeProject/res/data/memo_copy.txt";
	String ori_img = "D:/IT_Korea_Class/Java/project1027/SeProject/res/travel2/aa.jpg";
	String dest_img = "D:/IT_Korea_Class/Java/project1027/SeProject/res/data/aa_copy.jpg";

	FileInputStream fs;
	FileOutputStream os;

	public FileCopy() {
		try {
			fs = new FileInputStream(ori_img);
			os = new FileOutputStream(dest_img);
			while (true) {
				int data = fs.read();
				System.out.print(data+" ");
				if (data == -1)
					break;
				os.write((char)data);
			}
			System.out.println("복사 완려");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fs != null)
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	public static void main(String[] args) {
		new FileCopy();
	}

}
