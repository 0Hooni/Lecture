
public class CheckDemo {
	public static void main(String[] args) {
		try{
			Thread.sleep(100);
			System.out.println("예외처리가 반드시 필요한 코드");
		}catch(InterruptedException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
