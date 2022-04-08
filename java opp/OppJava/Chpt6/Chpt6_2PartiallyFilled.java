import java.util.Scanner;

public class Chpt6_2PartiallyFilled {
	
	public static final int MAX_NUMBER_SCORES = 10; // named constant
	public static void main(String[] args) {
		double[] score = new double[MAX_NUMBER_SCORES];
		int numberUsed = 0; // array filled 개수
		
		System.out.println("골프 점수와 평균과의 차이 알려줌");
		System.out.println("점수들을 입력하세요 ");
		numberUsed = fillArray(score);
		showDifference(score, numberUsed);
	}
	
	//입력받은 수로 array 채움
	public static int fillArray(double[] a) { // array: call-by-reference
		System.out.println(a.length + " 개까지 입력 가능");
		System.out.println("점수입력이 끝나면 음수를 입력해주세요");
		Scanner keyboard = new Scanner(System.in);
		
		double next; 
		int index = 0;
		next = keyboard.nextDouble();
		while ((next>=0) && (index<a.length)) { //음수를 입력하면 반복문 끝남
			a[index] = next;
			index ++;
			next = keyboard.nextDouble();
		}
		if (next >= 0)  // 반복문이 끝났는데도 (index>=a.length) 점수를 입력했을 때 
			System.out.println("점수는 " + a.length + " 개까지 입력가능"); // 입력값을 array에 넣지 않는다
		return index; //numberUsed로 받게 된다. int는 call-by-value
		              //while 반복문에서 index= 9일때도 실행되어 index++가 되므로 
		              // index 크기는 length와 같아진다! 
	}
	
	// array elements 평균 리턴하는 메소드 
	public static double computeAverage(double[] a, int numberUsed) {
		double total = 0;
		for (int index = 0; index < numberUsed; index++) 
			total += a[index]; //score들의 합 구하기 
		if (numberUsed > 0)
			return (total/numberUsed);
		else {
			System.out.println("0개의 숫자로 평균 낼 수 없음");
			return 0; //return: 함수를 종료한다 
		}		
	}
	
	//평균과의 차이를 프린트하는 메소드 
	public static void showDifference(double[] a, int numberUsed) {
		double average = computeAverage(a, numberUsed);
		for (int index = 0; index < numberUsed; index++) {
			System.out.println("점수: " + a[index] + "평균과 차이: " + (average - a[index]));
		}
	}
	
	
}
	

