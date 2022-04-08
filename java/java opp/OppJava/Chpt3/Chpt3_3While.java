import java.util.Scanner;
public class Chpt3_3While {

	public static void main(String[] args) {
	
		//while로 평균 구하기 
		Scanner scoreKeyboard = new Scanner(System.in);
		System.out.println("양수로 된 점수 리스트를 입력하세요.");
		System.out.println("점수입력을 끝내고 싶다면 음수를 입력하세요.");
		
		double next, sum = 0; // next 입력한 점수 sum 점수들의 합
		int count = 0; // 점수 입력 횟수
		
		//while 전에 next를 한번 받아야 while에서 처음 조건을 test할 수 있다
		next = scoreKeyboard.nextDouble(); 
		while (next >= 0)
		{
			sum = sum + next;
			count++; //입력 횟수 1 더해주기 
			next = scoreKeyboard.nextDouble();			
		}
	
		if (count == 0)
			System.out.println("입력된 점수가 없습니다");
		else
		{	
			double average = sum/count;
			System.out.println(count + " 개의 점수");
			System.out.println("평균: " + average );
		}
		
		//do-while 
		
		int countDown = 0; //그래도 do에서 hello가 한번 출력된다
		do
		{
			System.out.println("hello");
			countDown = countDown - 1; 
		} while (countDown > 0 ); 
	}		
}

			