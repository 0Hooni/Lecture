package 도형;

class Rectangle extends Shape {
	int l1;
	int l2;
	
	public Rectangle(int l1, int l2) {
		this.l1 = l1;
		this.l2 = l2;
	}
	
	public void draw() { 
		System.out.println("사각형을 그리다.");
	}
	
	public double findArea() { return l1 * l2;	}
}
