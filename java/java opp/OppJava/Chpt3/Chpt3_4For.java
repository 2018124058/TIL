
public class Chpt3_4For {

	public static void main(String[] args) {
		
		//���� �ٿ����鼭 100�� ����ϱ� 
		for (int number = 5; number >= 0; number--)
			System.out.println(number + "���� ����");
		
		//while�� �ٲ㺸��
		int number = 5;
		while (number >= 0) {
			System.out.println(number + "���� ����");
			number--;
		}
		
		//break
		for (int i = 1; i <= 5; ++i) {
			for (int j = 1; j<=3; ++i) {
				if (i==4 && j==2) break;
				System.out.print("(" + i + "," + j + ")");
			}
			System.out.println(); //inner for �ѹ� �ݺ��Ҷ����� �ٰ��� 
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
		



