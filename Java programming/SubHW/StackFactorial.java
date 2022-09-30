
public class StackFactorial {
	public static void main(String[] args) {
		String UpInt = "1";
		String DownInt;

		for (int i = 1; i <= 5; i++) {
			DownInt = Integer.toString(i);
			int jCount = 0;
			for (int j = DownInt.length() - 1; j >= 0; j--) {
				String[] temp = new String[2];
				int carry = 0;
				jCount++;

				temp[j % 2] = "";
				for (int k = UpInt.length() - 1; k >= 0; k--) {
					carry = 0;

					char oneDownInt = DownInt.charAt(j); // 계산의 아래숫자 한자리만 저장
					char oneUpInt = UpInt.charAt(k); // 계산의 윗숫자 한자리만 저장

					int changeOneDownIntToInteger = (int) oneDownInt; // 아래숫자 한자리만 저장한걸 형변환
					int changeOneUpIntToInteger = (int) oneUpInt; // 윗숫자 한자리만 저장한걸 형변환

					int multiplyTowInt = changeOneDownIntToInteger * changeOneUpIntToInteger + carry; // 곱한 결과 + 이전 결과에서
																										// 나온 캐리 더해주기
					carry = multiplyTowInt / 10; // 다음 캐리를 저장
					temp[j % 2] = Integer.toString(multiplyTowInt % 10) + temp[j % 2]; // 아래 숫자의 한자리와 윗숫자 전부를 계산한 결과
				}
				temp[j % 2] = Integer.toString(carry) + temp; // 한줄 완성
				// 필요한건 다음 숫자와 덧셈을 해주는 코드
				
				String addTemp = "";
				String changeNewTemp = "";
				if (j == DownInt.length() - 1) {
					addTemp = temp[j % 2]; // 맨 첫번째 연산을 저
				}
				if (j != DownInt.length() - 1) { // 첫줄은 더할게 없으니 패스

					for (int l = 0; l < jCount; l++) { // 아래 더해주는 숫자를 위치 맞춰줌
						temp[j % 2] = temp[j % 2] + "0";
					}

					for (int l = 0; l < temp[j % 2].length(); l++) {	//스트링의 길이를 맞춰줌
						addTemp = "0" + addTemp;
					}

					// 위 + 아래 (캐리 계산)
					int tempCarry = 0;
					
					for(int l=addTemp.length()-1;l>=0;l--) {
						int upTempOneInt = (int)addTemp.charAt(l);
						int downTempOneInt = (int)temp[j%2].charAt(l);
						int addTempRes = upTempOneInt + downTempOneInt + tempCarry;
						tempCarry = addTempRes / 10;
						
						//덧셈 결과의 첫번쨰 자리를 저장하는 템프의 첫자리로 교체
						changeNewTemp = Integer.toString(addTempRes%10) + changeNewTemp;
					}
					
					if(tempCarry == 1) changeNewTemp = "1" + changeNewTemp;
					
					addTemp = changeNewTemp;
				}
				System.out.println(addTemp);
			}
		}
	}
}
