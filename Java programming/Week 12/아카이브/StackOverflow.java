import java.math.BigInteger;

public class StackOverflow {
	public static void main(String[] args) {
		// checking anwser by BigInteger
		/*
		 * BigInteger b = new BigInteger("1");
		 * 
		 * for(int i = 0; i<50000; i++) { b = b.multiply(new BigInteger("" + (i+1))); }
		 * System.out.println(b);
		 */ // BigInteger Class end

		String res = "1";
		String tempRes = "0";

		for (int i = 1; i <= 50000; i++) {
			String mul = Integer.toString(i);
			tempRes = "0";

			for (int j = mul.length() - 1; j >= 0; j--) {
				int M = Character.getNumericValue(mul.charAt(j)); // 곱할 숫자를 인트형으로 변경
				int carry = 0;
				int oneTimeRes = 0;

				for (int k = res.length() - 1; k >= 0; k--) {
					int Q = Character.getNumericValue(res.charAt(k)); // res의 한자리를 인트형으로 변경

					oneTimeRes = M * Q + carry; // 한자리*한자리 저장
					carry = oneTimeRes / 10; // 곱했을때 생기는 올림수 저장
					String temp = Integer.toString(oneTimeRes);

					for (int l = 0; l < (mul.length() - j); l++) { // 뒤에 0을 붙여주어 계산
						// 위의 계산결과를 스트링으로 변환해주고 뒤에 0을 붙여준다
						temp += "0";
					}
					tempRes += temp;// int 연산을 해야되는데..... 여기를 어떻게 하

				}

				res = tempRes;
			}
		}
	}
}