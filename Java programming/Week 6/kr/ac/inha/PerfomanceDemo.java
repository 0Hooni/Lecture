package kr.ac.inha;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerfomanceDemo {

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>();
		LinkedList<Integer> l1 = new LinkedList<>();
		
		Long start = System.nanoTime();
		for(int i=0;i<100000;i++) 
			a1.add(0,i);
		Long end = System.nanoTime();
		Long duration = end - start;
		System.out.println("ArrayList로 처리한 시간 : " + duration);
		
		start = System.nanoTime();
		for(int i=0;i<100000; i++)
			l1.addFirst(i);
		end = System.nanoTime();
		duration = end - start;
		System.out.println("LinkedList로 처리한 시간 : " + duration);
	}
}

//add, remove => array < LinkedList (더 빠름)
//get => array > LinkedList
