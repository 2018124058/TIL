import java.util.Scanner;

public class Chpt9_2DefiningException {

	public static void main(String[] args) {
		try {
			Scanner keyboard = new Scanner(System.in);
			
			System.out.println("numerator: ");
			int numerator = keyboard.nextInt();
			System.out.println("denominator: ");
			int denominator = keyboard.nextInt();
			
			if (denominator == 0)
				throw new DivisionByZeroException();
			
			double quotient = numerator/(double)denominator;
			System.out.println(numerator + "/" + denominator + "=" + quotient);
		}
		catch (DivisionByZeroException e) {
			System.out.println(e.getMessage());
			secondChance();
		}
		System.out.println("End of program");
	}
	
	public static void secondChance() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("try again");
		System.out.println("numerator: ");
		int numerator = keyboard.nextInt();
		System.out.println("denominator: ");
		int denominator = keyboard.nextInt();
		
		if (denominator == 0) {
			System.out.println("cannot divide by zero");
			System.exit(0);
		}
		
		double quotient = numerator/(double)denominator;
		System.out.println(numerator + "/" + denominator + "=" + quotient);
	}

}

class DivisionByZeroException extends Exception{
	public DivisionByZeroException() {
		super("Division by zero");
	}
	
	public DivisionByZeroException(String message) {
		super(message);
	}
}