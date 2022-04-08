import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		String sentence = keyboard.nextLine();
		String word = keyboard.next();
		
		//object.indexOf(string) string이 나오기 시작하는 인덱스 
        //object.indexOf(string, start) string이 start번째로 나오는 인덱스 
        //object.lastIndexOf(string) string이 마지막으로 나오는 인덱스 
		
		int startIndex = sentence.indexOf(word);
		int lastIndex = startIndex + word.length();
		
		System.out.print(sentence.substring(0, startIndex-1));
		System.out.print(sentence.substring(lastIndex));

	}

}
