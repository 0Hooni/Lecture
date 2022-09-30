package 인터페이스;

public class ControllableDemo {
	public static void main(String[] args) {
		Controllable[] controllable = {new TV(), new Computer() };
		
		for(Controllable c : controllable) {
			c.turnOn();
			c.turnOff();
			c.repair();
		}
		Controllable.reset();
	}
}
