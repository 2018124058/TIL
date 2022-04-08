//input을 text file에 넣기 : 3개의 클래스 import 필요
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Chpt2_4FileInput {

	public static void main(String[] args) {
		Scanner fileIn = null; //fileIn object 빈 것으로 초기화 (아직 정의x)
		try
		{
			//Attempt to open the file 
			//파일이 소스코드와 같은 directory여야 - 아니면 full pathname 기재 
			fileIn = new Scanner(new FileInputStream("a.txt")); //왜 못찾지........
		}
		catch (FileNotFoundException e)
		{
			//파일을 못찾았을 때 프로그램 종료 
			System.out.println("File not Found.");
			System.exit(0);
		}
		
		System.out.println("Text left to read? " +
				fileIn.hasNextLine()); //.hasNextLine() 파일에 읽을 것이 남아있으면 True, 없으면 False
		
		int score = fileIn.nextInt();
		fileIn.nextLine(); //nextInt()에서 남은 \n 제거용
		String name = fileIn.nextLine(); 
		
		System.out.println("Name: " + name);
		System.out.println("Score: " + score);
		System.out.println("Text left to read? " +
				fileIn.hasNextLine());
		fileIn.close();  //파일 닫아주기 
	}

}
