import java.util.Scanner;
public class Chpt3_3While {

	public static void main(String[] args) {
	
		//while�� ��� ���ϱ� 
		Scanner scoreKeyboard = new Scanner(System.in);
		System.out.println("����� �� ���� ����Ʈ�� �Է��ϼ���.");
		System.out.println("�����Է��� ������ �ʹٸ� ������ �Է��ϼ���.");
		
		double next, sum = 0; // next �Է��� ���� sum �������� ��
		int count = 0; // ���� �Է� Ƚ��
		
		//while ���� next�� �ѹ� �޾ƾ� while���� ó�� ������ test�� �� �ִ�
		next = scoreKeyboard.nextDouble(); 
		while (next >= 0)
		{
			sum = sum + next;
			count++; //�Է� Ƚ�� 1 �����ֱ� 
			next = scoreKeyboard.nextDouble();			
		}
	
		if (count == 0)
			System.out.println("�Էµ� ������ �����ϴ�");
		else
		{	
			double average = sum/count;
			System.out.println(count + " ���� ����");
			System.out.println("���: " + average );
		}
		
		//do-while 
		
		int countDown = 0; //�׷��� do���� hello�� �ѹ� ��µȴ�
		do
		{
			System.out.println("hello");
			countDown = countDown - 1; 
		} while (countDown > 0 ); 
	}		
}

			