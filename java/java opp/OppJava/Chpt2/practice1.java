/*ù��° �Է� �ٿ� �־��� ���忡�� 
 * �ι�° �Է� �ٿ� �־��� �ܾ �� ������ ����ϴ� ���α׷��� �ۼ��϶�.*/
import java.util.Scanner;
public class practice1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter your age: ");
		System.out.println("Enter your name: ");
	
		int age = keyboard.nextInt();
		keyboard.nextLine();
		String name = keyboard.nextLine();
		
		System.out.println("AGE(" + age + ") NAME(" + name + ")");
		
	}

}
