import java.util.Scanner;
public class practice {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int a = keyboard.nextInt();
		String b = keyboard.nextLine(); // 없어도 되는데 ㅠㅠㅠ????
		String c = keyboard.next();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println("숫자 3개");
		int x = keyboard.nextInt();
		int y = keyboard.nextInt();
		int z = keyboard.nextInt();
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);

	}

}
