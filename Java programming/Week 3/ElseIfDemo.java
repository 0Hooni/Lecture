import java.util.Scanner;

public class ElseIfDemo {

	public static void main(String[] args) {
		//Else Demo
		
		Scanner in = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		int number = in.nextInt();
		
		if(number%2 == 0)
			System.out.println("짝수!");
		else
			System.out.println("홀수!");
		System.out.println("종료");
	}

}
