import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class NotBigintegerFactorial {
	// stack Overflow

//	public static BigInteger factorial(int n) {
//
//		// Point#1
//		BigInteger result = BigInteger.ONE;
//
//		for (int i = 1; i <= n; i++)
//
//			// Point#2
//
//			result = result.multiply(BigInteger.valueOf(i));
//
//		return result;
// 
//	}
//
//	public static void main(String[] args) {
//		int start;
//		Scanner in = new Scanner(System.in);
//
//		start = in.nextInt();
//
//		System.out.println(factorial(start));
//	}

	public static void main(String[] args) {
		
		int num = 10000;
		String temp = "0";
		String fac = "1";
		String mul = "1";
		for (int i = 1; i <= num; i++) {
			int c = 0;
			for (int j = mul.length() - 1; j >= 0; j--) {
				temp = "0";
				for (int k = fac.length() - 1; k >= 0; k--) {

					int a = Character.getNumericValue(fac.charAt(k));
					int b = Character.getNumericValue(mul.charAt(j));
					if (c + Character.getNumericValue(temp.charAt(temp.length()-1))>=10)
						c = (a * b / 10) + 1 ;
					else 
						c = (a * b / 10) ;
					int res =(a * b % 10 + Character.getNumericValue(temp.charAt(0)));
					temp = temp.substring(0, temp.length()-1);
					temp = Integer.toString(res) + temp;
					if(c != 0) {
						temp = Integer.toString(c)+temp; 
						if(j !=0 && k !=0 )
							c = Character.getNumericValue(temp.charAt(0));
					}
				}
			}
			System.out.println(temp);
			fac = temp;
			mul = Integer.toString(i+1);
		}
	}
}
