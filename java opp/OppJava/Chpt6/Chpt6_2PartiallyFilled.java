import java.util.Scanner;

public class Chpt6_2PartiallyFilled {
	
	public static final int MAX_NUMBER_SCORES = 10; // named constant
	public static void main(String[] args) {
		double[] score = new double[MAX_NUMBER_SCORES];
		int numberUsed = 0; // array filled ����
		
		System.out.println("���� ������ ��հ��� ���� �˷���");
		System.out.println("�������� �Է��ϼ��� ");
		numberUsed = fillArray(score);
		showDifference(score, numberUsed);
	}
	
	//�Է¹��� ���� array ä��
	public static int fillArray(double[] a) { // array: call-by-reference
		System.out.println(a.length + " ������ �Է� ����");
		System.out.println("�����Է��� ������ ������ �Է����ּ���");
		Scanner keyboard = new Scanner(System.in);
		
		double next; 
		int index = 0;
		next = keyboard.nextDouble();
		while ((next>=0) && (index<a.length)) { //������ �Է��ϸ� �ݺ��� ����
			a[index] = next;
			index ++;
			next = keyboard.nextDouble();
		}
		if (next >= 0)  // �ݺ����� �����µ��� (index>=a.length) ������ �Է����� �� 
			System.out.println("������ " + a.length + " ������ �Է°���"); // �Է°��� array�� ���� �ʴ´�
		return index; //numberUsed�� �ް� �ȴ�. int�� call-by-value
		              //while �ݺ������� index= 9�϶��� ����Ǿ� index++�� �ǹǷ� 
		              // index ũ��� length�� ��������! 
	}
	
	// array elements ��� �����ϴ� �޼ҵ� 
	public static double computeAverage(double[] a, int numberUsed) {
		double total = 0;
		for (int index = 0; index < numberUsed; index++) 
			total += a[index]; //score���� �� ���ϱ� 
		if (numberUsed > 0)
			return (total/numberUsed);
		else {
			System.out.println("0���� ���ڷ� ��� �� �� ����");
			return 0; //return: �Լ��� �����Ѵ� 
		}		
	}
	
	//��հ��� ���̸� ����Ʈ�ϴ� �޼ҵ� 
	public static void showDifference(double[] a, int numberUsed) {
		double average = computeAverage(a, numberUsed);
		for (int index = 0; index < numberUsed; index++) {
			System.out.println("����: " + a[index] + "��հ� ����: " + (average - a[index]));
		}
	}
	
	
}
	

