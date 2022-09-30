import java.io.File;
import java.util.Scanner;

public class FileSearch {
	private static String filename;
	private static boolean isExist = false;
	
	public static void Search(File f) {
		try {
			if(f.isDirectory()) {
				File[] folder = f.listFiles();
				for(File file : folder) {
					Search(file);
					if(isExist) break;
				}		
			}
			else if(f.getName().equals(filename)) {
				System.out.println(f);
				isExist = true;
			}	
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		File folder = null;
		
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("폴더 경로를 입력하세요: ");
			folder = new File(in.nextLine());
			
			System.out.print("파일 이름을 입력하세요: ");
			filename = in.nextLine();
			
			if(folder.exists()) {
				Search(folder);
				if(!isExist) System.out.println("파일이 존재하지 않습니다.");		
			}
			else {
				System.out.println("잘못된 폴더 경로를 입력했습니다");
			}
			
			
		} catch (Exception e) {
		}

		in.close();
	}

}
