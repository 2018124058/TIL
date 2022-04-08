import java.util.Scanner;
public class Chpt3Hw3 {

	public static void main(String[] args) {
		Scanner numKeyboard = new Scanner(System.in);
		String num = numKeyboard.next();
		
		int numLen = num.length();
		
		for (int numIndex = 0; numIndex < numLen; numIndex++) {
			char numChar = ' ';
			numChar = num.charAt(numLen - numIndex - 1);
			System.out.print(numChar);
		}

}
}
