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
	
	// 확장자 구하기 업그레이드 (.이 많은 파일명엔 이게 더 적합)
	public static String getExtend2(String filename) {
		int lastIndex = filename.lastIndexOf(".");
		return 	filename.substring(lastIndex+1, filename.length());
	}
	
	
	
//	public static void main(String[] args) {
//		String filename = getFilename("https://www.cartier.co.kr/content/dam/rcq/car/15/95/55/3/1595553.png");
//		System.out.println(filename);
//		String ext = getExtend(filename);
//		System.out.println(ext);
//	}
}
