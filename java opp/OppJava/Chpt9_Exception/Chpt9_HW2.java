import java.util.Scanner; 
import java.util.InputMismatchException; 

public class Chpt9_HW2 {
	public static void main(String[] args) {
		int sum = 0; 
		int count = 0; 
		int num = 0; 
		Scanner keyboard = new Scanner(System.in);
		
		do {
			
			try {
				num = keyboard.nextInt(); 
				testOddNumber(num); 
				// your code here
				// no exception
				count += 1;
				sum += num;	
			}
			
			// your code here
			// exception handling
			catch (InputMismatchException e) {
				System.out.println("Wrong input. Integer needed");
				keyboard.nextLine();
			}
			
			catch (MyOddNumberException e) {
				System.out.println("Odd number " + num + " is not allowed");
			}
			
		} while (count < 5); 
		
		System.out.println("sum = " + sum);

	}
	
// your code here for "static void testOddNumber" method
	public static void testOddNumber(int num) throws MyOddNumberException {
		if (num % 2 != 0) 
			throw new MyOddNumberException();
	}
}

class MyOddNumberException extends Exception{
	public MyOddNumberException() {
		super("odd number");
	}
}