import java.util.Scanner;
public class Chpt5_3Character {

	public static void main(String[] args) {
		System.out.println("���� �Է�: ");
		Scanner keyboard = new Scanner(System.in);
		String sentence = keyboard.nextLine();
		
		sentence = sentence.toLowerCase(); // String �ҹ��ڷ�
		char firstChar = sentence.charAt(0);
		sentence = Character.toUpperCase(firstChar) + sentence.substring(1);
		
		System.out.println(sentence);
		
	}

}

