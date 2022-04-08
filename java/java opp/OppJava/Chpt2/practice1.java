/*첫번째 입력 줄에 주어진 문장에서 
 * 두번째 입력 줄에 주어진 단어를 뺀 문장을 출력하는 프로그램을 작성하라.*/
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
