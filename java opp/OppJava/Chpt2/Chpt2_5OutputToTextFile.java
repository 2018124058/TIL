import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/*output�� text file�� ������ �ֱ�
 ������ ���� �̸��� ������ �ִٸ�: ������ ����� �ҷ��´�
 ���ٸ�: ���� �����
 ���� �̸��� ������ �ƴ� directory(����)�� �ִٸ� error 
 * */
// try: �ϴ� �õ� -> �ȵǸ� catch�� ���� 

public class Chpt2_5OutputToTextFile {
	public static void main(String[] args) {
		
		PrintWriter outputStream = null;
		try
		{outputStream = new PrintWriter(new FileOutputStream("a.txt"));}
		
		catch (FileNotFoundException e)
		{ System.out.println("Error opening the file a.txt");
		  System.exit(0);  } //���α׷� ����
		
		outputStream.println("output ����");
		outputStream.println("output�� ����");
		
		outputStream.close(); //���� �ݱ�
		
		System.out.println("End of program");
		
	}

}
