class Cup<T> {
	private T beverage;

	public T getBeverage() {
		return beverage;
	}

	public void setBeverage(T beverage) {
		this.beverage = beverage;
	}
}

class Boricha {}
class Beer {}

public class GenericClass2Demo {
	public static void main(String[] args) {
		Cup<Boricha> c = new Cup<Boricha>();
		c.setBeverage(new Boricha());
		// c.setBeverage(new Beer());
		// Beer b = c.getBeverage();
		Boricha b = c.getBeverage();
	}
}
