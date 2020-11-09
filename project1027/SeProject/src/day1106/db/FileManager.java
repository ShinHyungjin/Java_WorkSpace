package day1106.db;

public class FileManager {

	public FileManager() {
		
	}
	// 파일명은 보통 마지막/ 다음 나옴..
	public static String getFilename(String path) {
		String result = path.substring(path.lastIndexOf("/")+1, path.length());
		return result;
	}
	// 확장자는 파일명'.'다음 나옴..
	public static String getExtend(String filename) {
		String [] str = filename.split("\\.");
		return str[1];
	}
	
//	public static void main(String[] args) {
//		String filename = getFilename("https://www.cartier.co.kr/content/dam/rcq/car/15/95/55/3/1595553.png");
//		System.out.println(filename);
//		String ext = getExtend(filename);
//		System.out.println(ext);
//	}
}
