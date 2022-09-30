import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

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

	public static void main(String[] args) throws IOException {
		int num = 5;
		String temp = "0";
		String fac = "1";
		String mul = "1";
		for (int i = 1; i <= num; i++) {
			int carry = 0;
			for (int j = mul.length() - 1; j >= 0; j--) {
				temp = "0";
				for (int k = fac.length() - 1; k >= 0; k--) {

					int a = Character.getNumericValue(fac.charAt(k));
					int b = Character.getNumericValue(mul.charAt(j));
					
					if (carry + Character.getNumericValue(temp.charAt(temp.length()-1))>=10)
						carry = (a * b / 10) + 1 ;
					else 
						carry = (a * b / 10) ;
					int res =(a * b % 10 + Character.getNumericValue(temp.charAt(0)));
					
					temp = temp.substring(0, temp.length()-1);
					temp = Integer.toString(res) + temp;
					
					if(carry != 0) {
						temp = Integer.toString(carry)+temp; 
						if(j !=0 && k !=0 )
							carry = Character.getNumericValue(temp.charAt(0));
					}
				}
			}
			System.out.println(temp);
			String output = "C:\\homework\\BigIntegerFactorial.txt"; 
			fac = temp;
			mul = Integer.toString(i+1);
		}
	}
}
