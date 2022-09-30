package kr.ac.inha;

import java.util.Scanner;

public class Array1Demo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int scores[] = new int[5];	//만약 두번째 선언이라면 앞에것은 초기화w
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			scores[i] = in.nextInt();
			sum += scores[i];
		}
		System.out.println("평균 = " + sum/5.0);
	}
}
