/*
0 �Ǵ� ���� ������ n �� �Է����� �޾�
-1 + 2 -3 + 4 - ... + n �� ���� ����ϴ� ���α׷��� �ۼ��϶�. 
��, 1, 3, 5, ... �� Ȧ�� ���� ��ü �տ��� �� �ְ�, 
2, 4, 6, ... �� ¦������ ��ü �տ� ���� �ֵ��� �Ѵ�. 

CONDITIONS:
1) �Է� n�� �׻� 0 �Ǵ� ���� ������ ��Ȯ�ϰ� �Էµȴٰ� ����

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
		if (n % 2 != 0) { // n�� Ȧ�� 
			return n*(-1) + compute(n-1);
		}
		return n + compute(n-1); // n�� ¦�� 
	}
}
	
