import java.util.Scanner;
public class Chpt5_1RoundStuffDemo {
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("������:");
		double radius = keyboard.nextDouble();
		
		System.out.println("������: " + radius);
		System.out.println("����: " + Chpt5_1RoundStuff.area(radius));
		System.out.println("����: " + Chpt5_1RoundStuff.volume(radius));
		
		
		
	}
}
