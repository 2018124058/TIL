import java.util.Scanner;

public class Chpt9_1ExceptionHandling {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("���� �� ��: ");
		int men = keyboard.nextInt();
		System.out.println("���� �� ��: ");
		int women = keyboard.nextInt();
		
		// ���� ��, ���� �� �� �����̶� 0���̸� ���� �� 
		// ���� ���� ���� ������ ��� ¦ ������ ����������� ���� 
		try {
			if (men == 0 && women == 0)
				throw new Exception("�����л� ���� ���� ��"); //exception object with message
			else if (men == 0)
				throw new Exception("���л� ���� ���� ��");
			else if (women == 0)
				throw new Exception("���л� ���� ���� ��");
			// women >= 0 && men >= 0
			// �տ��� exception�� �߻����� ��� ������ statement�� ������ �ȵǱ� ������ else if �� �ƴ� if�� �ᵵ ���� 
			if (women >= men) 
				System.out.println("���л� �Ѹ��� " + women/(double)men + " ���� ���л��� ¦");
			else 
				System.out.println("���л� �Ѹ��� " +men/(double)women + " ���� ���л��� ¦");
		}
		catch (Exception e) {
			String message = e.getMessage();
			System.out.println(message);
			System.exit(0); // ���α׷� ���� -> ���� ���� �κ� ���� �ȵȴ� 
		}
		
		System.out.println("���� ����");
	
	}

}
