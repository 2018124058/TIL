import java.util.Scanner;
public class Chpt3Hw2 {

	public static void main(String[] args) {
		Scanner strKeyboard = new Scanner(System.in);
		String str = strKeyboard.nextLine();
		
		int strLength = str.length();
		int aCount = 0;
		int strIndex;
		
		for (strIndex = 0; strIndex < strLength; strIndex++) {
			char strChar = str.charAt(strIndex);
			if (strChar == 'a') 
				aCount++;
		}
		System.out.println(aCount);
	}

}
