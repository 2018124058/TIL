import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		String sentence = keyboard.nextLine();
		String word = keyboard.next();
		
		//object.indexOf(string) string�� ������ �����ϴ� �ε��� 
        //object.indexOf(string, start) string�� start��°�� ������ �ε��� 
        //object.lastIndexOf(string) string�� ���������� ������ �ε��� 
		
		int startIndex = sentence.indexOf(word);
		int lastIndex = startIndex + word.length();
		
		System.out.print(sentence.substring(0, startIndex-1));
		System.out.print(sentence.substring(lastIndex));

	}

}
