
public class Chpt2_1_ScreenOutput {
	public static void main(String[] args) {
		/*System.out.print vs System.out.println
	 	print: same line 
	 	println: new line ��� �� ���� �� 
		 */
		System.out.println("one"); //�� �ٿ� �ϳ���
		System.out.println("two");
		System.out.println("");   // new line
		System.out.print("one");  // �� �ٿ� ��� ��� 
		System.out.print("two");
		System.out.println("");
		
		/*printf: formatting output 
		 *������ �� �� prinf() method �� ��! 
		 * double, float %f integar %d string %s character %c
		 * %nf n�ڸ� ������ ��(������ ����) %-nf (������ ������) (f���� �ٸ� �͵� ��� ����)n<length�� length �״�� ��� 
		 * %.nf n�� �ڸ������� ��� (�ݿø�) 
		 * %e
		 * print�� �� default: �Ҽ��� �����ڸ�������(�Ѿ�� 7��°�ڸ����� �ݿø�)
		 */
		double price = 19.8;
		System.out.printf("%f %n", price); //output 19.800000 double�̶�??
		System.out.print("$");
		System.out.printf("%6.2f", price); //%6 �����ڸ��� ���(�ʿ��ϸ� ���ʿ� ����)
		System.out.println("");            //.2 �Ҽ��� �ι�°�ڸ�����(����°���� �ݤ�����)
										   // f floating point format
		double value = 12.123;
		System.out.printf("Start%8.2fEnd%n", value); // %n new line
		System.out.printf("Start%-8.2fEnd%n", value); //%-8 ���������� ���� 
		
		int num = 3;
		String name = "magic apple";
		System.out.printf("$%6.2f %d for each %s%n", price, num, name);
		System.out.printf("%d", num);
		
		System.out.printf("%e %n", price);
		System.out.printf("%.3e %n", price);
		
		String a = "abc";
		System.out.printf("START%sEND %n", a);
		System.out.printf("START%6sEND %n", a);
		System.out.printf("START%2sEND %n%n", a); //length���� ���� �����ص� value ����x. �״�� ���� 
		
		double d = 12345.123456789;
		System.out.printf("START%fEND  %n", d); // .123457 ������° �ڸ������� ���, �ڿ��� �ݿø�
		System.out.printf("START%5.4fEND  %n", d);
		System.out.printf("START%eEND  %n", d);
		System.out.printf("START%12.5eEND  %n", d);
	}
	
	

}
