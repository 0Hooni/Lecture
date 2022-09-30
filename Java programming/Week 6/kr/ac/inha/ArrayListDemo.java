package kr.ac.inha;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> scores = new ArrayList<>();
		// int or double 을 쓰면 오류가 남 -> class를 써야된다.
		// int <-> Integer => int 값을 넣어도 문제는 없지만 후자는 NULL을 넣을 수 있다.
		int data;
		int sum = 0;
		while ((data = in.nextInt()) >= 0)
			scores.add(data);

		for (int i = 0; i < scores.size(); i++)
			// size <-> length
			// size = mathod(주어진 클래스를 사용해야 됨)
			sum += scores.get(i);

		System.out.println("평균 = " + sum / scores.size());
	}
	// 자동 정렬 (cmd + shift + f)
}
