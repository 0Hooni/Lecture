public class Quiz1 {
	public static void main(String[] args) {
		//1~10,000,000까지 합을 구하는 프로그램 만들기
		long startTime = System.currentTimeMillis();
		long sum = 0;
		for(int i=1;i<=10000000;i++)
			sum+=i;
		System.out.println(sum);
	}

}
