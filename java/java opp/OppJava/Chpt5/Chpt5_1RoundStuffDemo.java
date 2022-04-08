import java.util.Scanner;
public class Chpt5_1RoundStuffDemo {
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("반지름:");
		double radius = keyboard.nextDouble();
		
		System.out.println("반지름: " + radius);
		System.out.println("넓이: " + Chpt5_1RoundStuff.area(radius));
		System.out.println("부피: " + Chpt5_1RoundStuff.volume(radius));
		
		
		
	}
}
