public class MethodDemo {
	public static void main(String[] args) {
		/* main에 다 때려박는 경우 
		int sum = 0;
		for(int i=0;i<=10;i++)
			sum+=i;
		System.out.println("합(1~10) : " + sum);
		
		sum = 0;
		for(int i=10;i<=100;i++)
			sum+=i;
		System.out.println("합(1~10) : " + sum);
		
		sum=0;
		for(int i=100;i<=1000;i++) 
			sum+=i;
		System.out.println("합(1~10) : " + sum);
		*/
		
		System.out.println("합(1~10) : " + sum(1,10));
		System.out.println("합(10~100) : " + sum(10,100));
		System.out.println("합(100~1000) : " + sum(100,1000));
	}
	
	public static int sum(int i1,int i2) {
		int sum = 0;
		for(int i=i1;i<=i2;i++)
			sum+=i;
		
		return sum;
	}
}
