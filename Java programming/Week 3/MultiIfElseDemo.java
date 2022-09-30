import java.util.Scanner;

public class MultiIfElseDemo {
	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		String Grade;
		System.out.println("점수를 입력하세요 : ");
		int score = in.nextInt();
		
		if(score>=90)
			Grade="A";
		else if(score>=80)
			Grade = "B";
		else if(score>=70)
			Grade = "C";
		else if(score>=60)
			Grade=  "D";
		else
			Grade = "F";
		System.out.println("당신의 학섬은 : " + Grade);	
	}
}
