public class UnChecked2Demo {
	public static void main(String[] args) {
		int[] array = { 0, 1, 2 };
		
		//	Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
		//			at UnChecked2Demo.main(UnChecked2Demo.java:5)
		//예외 처리의 방법중 하나인 try catch문을 이용
		try {
			System.out.println(array[3]);
		} catch(ArrayIndexOutOfBoundsException e) {
			// TODO : handle exception
			System.out.println(e.toString());
			System.out.println("정상 처리되었습니다.");
		}
	}
}
