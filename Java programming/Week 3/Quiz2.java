
public class Quiz2 {

	public static void main(String[] args) {
		int T = 0;
		int S=0;
		while(T<11) {
			while(S++<T+1) 
				System.out.print("*");
			
			System.out.println();
			T++;
			S=0;
		}
	}//end of main
}

