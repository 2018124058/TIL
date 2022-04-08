import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/*output을 text file에 전송해 넣기
 기존에 같은 이름의 파일이 있다면: 내용을 지우고 불러온다
 없다면: 새로 만든다
 같은 이름의 파일이 아닌 directory(폴더)가 있다면 error 
 * */
// try: 일단 시도 -> 안되면 catch를 실행 

public class Chpt2_5OutputToTextFile {
	public static void main(String[] args) {
		
		PrintWriter outputStream = null;
		try
		{outputStream = new PrintWriter(new FileOutputStream("a.txt"));}
		
		catch (FileNotFoundException e)
		{ System.out.println("Error opening the file a.txt");
		  System.exit(0);  } //프로그램 종료
		
		outputStream.println("output 내용");
		outputStream.println("output을 넣자");
		
		outputStream.close(); //파일 닫기
		
		System.out.println("End of program");
		
	}

}
