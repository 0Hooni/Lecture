//객체지향과 상속 예제코
class Tv{
		boolean power;
		int channel;
		void power() { power = !power; }
		void channelUp() {++channel;}
		void channelDown() {--channel;}
	}
	
	//class 상속
	class CaptionTv extends Tv{
		boolean caption;
		void displayCaption(String text) {
			if(caption)
				System.out.println(text);
		}
	}

public class CaptionTvTest {
	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.channel);
		ctv.displayCaption("Hello, World!");	//caption state false
		ctv.caption = true;
		ctv.displayCaption("Hello World!");
	}
}
