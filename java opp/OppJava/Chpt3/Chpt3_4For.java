
public class Chpt3_4For {

	public static void main(String[] args) {
		
		//숫자 줄여가면서 100번 출력하기 
		for (int number = 5; number >= 0; number--)
			System.out.println(number + "개의 베개");
		
		//while로 바꿔보기
		int number = 5;
		while (number >= 0) {
			System.out.println(number + "개의 베개");
			number--;
		}
		
		//break
		for (int i = 1; i <= 5; ++i) {
			for (int j = 1; j<=3; ++i) {
				if (i==4 && j==2) break;
				System.out.print("(" + i + "," + j + ")");
			}
			System.out.println(); //inner for 한번 반복할때마다 줄갈이 
		}
		
		// continue
		for (int i=1; i<=10; ++i) {
			if (i>4 && i<9) {
				continue;
			}
			System.out.println(i);
		}
	}
}
		



