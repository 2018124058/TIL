import java.util.Scanner; //input �ޱ�: Scanner class �ʿ� 

/*�⺻������ input�� ���� �� enter�� ġ�� input �ڿ� \n�� �ڵ����� �ٿ���(���â�� ������ ����)
next(),nextInt(),nextDouble() ��: �����ִ� \n,space ���� �����ϰ� �Է°��� �о��
nextLine(): �����ִ� \n������ �ϳ��� �������� ���� �������� �� ""�� �о ���� �׸��� �� \n�� !����!
-> nextLine()�� �� �� ������ �� */

//object�̸�.nextBoolean() �Ҹ��� �Ѱ� �Է¹��� �빮�� �ҹ��� ������� 
public class Chpt2_3InputScanner {

	public static void main(String[] args) {
		// Scanner Ŭ������ object ����) Scanner object�̸� = new Scanner(System.in);
		Scanner keyboard = new Scanner(System.in); //System.in �Է¹޴´�?  
		
		System.out.println("������� ������ �Է��Ͻÿ�"); //prompt: �Է� ���� �ȳ�
		System.out.println("���� ������ �Է��Ͻÿ�");
		// object.nextInt()�޼ҵ�: �Է��� �ϳ��� int �޾ƿ�
		// �������� �Է��� ���� ���, �����̽��� or ���ͷ� �����Ѵ� 
		int numberOfPods = keyboard.nextInt();   
		int peasPerPod = keyboard.nextInt();
		
		int totalNumberOfPeas = numberOfPods * peasPerPod;
		
		System.out.print(numberOfPods + " pods and "); //Echo: �Է��� ���� printback
		System.out.println(peasPerPod + " peas per pod");
		System.out.println("Total number of peas = " + totalNumberOfPeas);
		
		double d1, d2; 
		System.out.println("2���� �Ǽ�(double) �Է�:");
		d1 = keyboard.nextDouble(); //nextDouble() double 1�� �Է� ����
		d2 = keyboard.nextDouble();
		System.out.println("You entered " + d1 + " and " + d2);
		
		//next() word 1�� �Է� ����. ������(default:�����̽�,����)���� �������� �޴´� 
		System.out.println("2���� �ܾ� �Է�:");
		String word1 = keyboard.next(); 
		String word2 = keyboard.next();
		System.out.println("You entered \"" + word1 + "\" and \"" + word2 + "\"");
		// "�� ����ϱ� ���� \" ��� 
		
		//nextLine() �� �� ��ü�� �Է� ����. \n(new line)���� ������ �����Ҷ��� ������ �������� ��� 
		
		String junk = keyboard.nextLine(); // \n�� ���ֱ� ����.
		                                   // ������ �Ʒ��� line�� \n�� ��
		System.out.println("���� �Է�:");
		String line = keyboard.nextLine(); 
		System.out.println("You entered: \"" + line + "\"");
		//String junk2 = keyboard.nextLine(); �ʿ䰡 ����.. ���Ӱ� ��¥ �޾ƹ���
		
		/*������(delimiter) ����
		  object �̸�.useDelimiter("������"); */
		
		Scanner keyboard2 = new Scanner(System.in);
		keyboard2.useDelimiter("##");
		System.out.println("�ܾ� �ΰ�:");
		String a = keyboard2.next();
		String b = keyboard2.next();
		System.out.println("1)"+ a + "2)" + b);
		
		
		
	}

}
