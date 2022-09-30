class Phone{
	String model;
	int value;
	
	void print() {
		System.out.println(value + "만원 짜리 " + model + " 스마트폰");
	}
}

public class PhoneDemo {
	public static void main(String[] args) {
		Phone myPhone = new Phone();
		myPhone.model = "아이폰XS";
		myPhone.value = 130;
		myPhone.print();
		
		Phone yourPhone = new Phone();
		yourPhone.model = "갤럭시S8";
		yourPhone.value = 100;
		yourPhone.print();
	}
}
