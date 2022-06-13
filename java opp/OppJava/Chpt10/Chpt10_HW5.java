/*
0 또는 양의 정수인 n 을 입력으로 받아
-1 + 2 -3 + 4 - ... + n 의 값을 계산하는 프로그램을 작성하라. 
즉, 1, 3, 5, ... 의 홀수 들은 전체 합에서 빼 주고, 
2, 4, 6, ... 의 짝수들은 전체 합에 더해 주도록 한다. 

CONDITIONS:
1) 입력 n은 항상 0 또는 양의 정수로 정확하게 입력된다고 가정

SAMPLE INPUT:
0
SAMPLE OUTPUT:
0

SAMPLE INPUT:
1
SAMPLE OUTPUT:
-1

SAMPLE INPUT:
8
SAMPLE OUTPUT:
4

SAMPLE INPUT:
131
SAMPLE OUTPUT:
-66

*/

import java.util.Scanner; 

public class Chpt10_HW5 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		
		int result = compute(n);
		
		System.out.println(result);

	}
	
	static int compute(int n) {
		if (n == 0) return 0;
		if (n % 2 != 0) { // n이 홀수 
			return n*(-1) + compute(n-1);
		}
		return n + compute(n-1); // n이 짝수 
	}
}
	
