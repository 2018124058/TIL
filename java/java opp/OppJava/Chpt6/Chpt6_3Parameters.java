//import java.util.Scanner;
public class Chpt6_3Parameters {

	// arg �� ���� ū �� �����ϴ� �Լ� max
	public static int max(int...arg) {
		if (arg.length == 0) 
		{
			System.out.println("error");
			System.exit(0); //0���� �Ķ���͸� �ִ� �����ϱ� ���⼭ ����
		}
		//length�� 0�� �ƴҶ� (�տ��� �����ؼ� else �� �ʿ� ����) 
		int largest = arg[0];
		for (int index = 0; index < arg.length; index++) 
		{
			if (largest < arg[index]) 
				largest = arg[index];
		}
		return largest;
	}
	
	public static void main(String[] args) {
		//System.out.println(" ���� �Է�: ");
		//Scanner keyboard = new Scanner(System.in);
		// ���������� ��� �Է� ����?
		System.out.println(max(1,4,5,6));
	}

}
