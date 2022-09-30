class PrintArray<T>{
	T arr[];
	PrintArray(T arr[]){
		this.arr = arr;
	}
	void printArr() {
		for(T a : arr) 
			System.out.println(a);
	}
}
public class GenericSource {
	public static void main(String[] args) {
		Integer ia[] = new Integer[5];
		ia[0] = 1;
		ia[1] = 2;
		ia[2] = 3;
		ia[3] = 4;
		ia[4] = 5;
		
		PrintArray<Integer> p = new PrintArray(ia);
		p.printArr();
	}

}
