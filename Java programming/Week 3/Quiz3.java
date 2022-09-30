import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int height = in.nextInt();
		
		starTower(height);

	}

	public static void starTower(int h) {
		for(int i=0;i<h;i++){
			for(int j=0;j<=i;j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
