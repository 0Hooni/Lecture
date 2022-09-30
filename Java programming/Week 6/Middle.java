import javax.swing.JOptionPane;

public class Middle implements Grade {
	private String math;
	private String score;
	private String science;
	
	public void setGrade() {
		// TODO Auto-generated method stub
		math = JOptionPane.showInputDialog("수학 점수를 입력하세요.");
		score= JOptionPane.showInputDialog("영어 점수를 입력하세요.");
		science = JOptionPane.showInputDialog("과학 점수를 입력하세요.");
	}

	@Override
	public void getGrade() {
		// TODO Auto-generated method stub
		System.out.println("");
	}

}
