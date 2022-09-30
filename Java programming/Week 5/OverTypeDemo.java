class Vehicle{
	String name = "탈 것";
	void whoami() {
		System.out.println("나는 탈 것이다.");
	}
	static void move() {
		System.out.println("이동하다");
	}
}

class Car extends Vehicle{
	String name = "자동차";
	void whiami() {
		System.out.println("나는 자동차이다.");
	}
	static void move() {
		System.out.println("달리다");
	}
}

public class OverTypeDemo {
	public static void main(String[] args) {
		Vehicle v = new Car();
		System.out.println(v.name);	//자동차(x) 탈 것(o)
		v.whoami();	//나는 자동차이다.(x) 나는 탈 것이다.(o)
		v.move();	//달리다(x) 이동하다(o)
		//뭐가 나올지 예상해보자
	}
}
