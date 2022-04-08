//input�� text file�� �ֱ� : 3���� Ŭ���� import �ʿ�
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Chpt2_4FileInput {

	public static void main(String[] args) {
		Scanner fileIn = null; //fileIn object �� ������ �ʱ�ȭ (���� ����x)
		try
		{
			//Attempt to open the file 
			//������ �ҽ��ڵ�� ���� directory���� - �ƴϸ� full pathname ���� 
			fileIn = new Scanner(new FileInputStream("a.txt")); //�� ��ã��........
		}
		catch (FileNotFoundException e)
		{
			//������ ��ã���� �� ���α׷� ���� 
			System.out.println("File not Found.");
			System.exit(0);
		}
		
		System.out.println("Text left to read? " +
				fileIn.hasNextLine()); //.hasNextLine() ���Ͽ� ���� ���� ���������� True, ������ False
		
		int score = fileIn.nextInt();
		fileIn.nextLine(); //nextInt()���� ���� \n ���ſ�
		String name = fileIn.nextLine(); 
		
		System.out.println("Name: " + name);
		System.out.println("Score: " + score);
		System.out.println("Text left to read? " +
				fileIn.hasNextLine());
		fileIn.close();  //���� �ݾ��ֱ� 
	}

}
