import java.util.ArrayList;
import java.util.Scanner;

public class Chpt12_2ForEachArrayList {
	public static void main(String[] args) {
		ArrayList<String> toDoList = new ArrayList<String>(20);
	
		boolean done = false;
		String next = null;
		String answer;
		Scanner keyboard = new Scanner(System.in);
		
		while (! done) {
			System.out.println("할 일을 입력하세요: ");
			next = keyboard.nextLine();
			toDoList.add(next);
			
			System.out.print("입력할 것이 남아있나요? ");
			answer = keyboard.nextLine();
			if (! (answer.equalsIgnoreCase("yes")))
				done = true;
		}
		
		System.out.println("리스트 항목: ");
		for (String entry : toDoList)
			System.out.println(entry);
	}
}
