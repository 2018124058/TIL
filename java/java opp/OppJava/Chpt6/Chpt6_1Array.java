import java.util.Scanner;

public class Chpt6_1Array {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double[] score = new double[5];
		int index;
		double max;
		
		System.out.println("점수 5개 입력:");
		score[0] = keyboard.nextDouble();
		max = score[0]; // 일단 할당 
		
		for (index = 1; index < 5; index++) {
			score[index] = keyboard.nextInt();
			if (score[index] > score[index-1])
				max = score[index];
		}
		
		System.out.println("가장 높은 점수: " + max);
		System.out.println("입력한 점수: ");
		for (index = 0; index < 5; index++) {
			System.out.println("점수: " + score[index] + " 최고점과 차이: " + (max - score[index]));
		}

	}

}
