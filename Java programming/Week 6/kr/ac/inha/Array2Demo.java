package kr.ac.inha;

public class Array2Demo {

	public static void main(String[] args) {
		double[][] interets = {{3.2,3.1,4.3,3.2},
							{2.5,3.5,2.4,5.3},
							{2.3,2.4,2.5,6.4}};
		double[] sum1 = {0,0,0,0,0,0};
		double sum2 = 0.0;
		for(int i=0;i<interets.length;i++) {
			for(int j=0;j<interets.length;j++) {
				sum1[i] += interets[i][j];
			}
			System.out.printf("%d 차년도 평균 이자율 = %.2f&&\n", i+1, sum1[i]/4);
			sum2+=sum1[i];
		}
		System.out.printf("3년간 평균 이자율 = %.2f%%\n", sum2/3);

	}

}
