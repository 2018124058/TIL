import java.util.Scanner;

public class Chpt6_1Array {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double[] score = new double[5];
		int index;
		double max;
		
		System.out.println("���� 5�� �Է�:");
		score[0] = keyboard.nextDouble();
		max = score[0]; // �ϴ� �Ҵ� 
		
		for (index = 1; index < 5; index++) {
			score[index] = keyboard.nextInt();
			if (score[index] > score[index-1])
				max = score[index];
		}
		
		System.out.println("���� ���� ����: " + max);
		System.out.println("�Է��� ����: ");
		for (index = 0; index < 5; index++) {
			System.out.println("����: " + score[index] + " �ְ����� ����: " + (max - score[index]));
		}

	}

}
