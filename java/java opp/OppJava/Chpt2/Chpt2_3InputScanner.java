import java.util.Scanner; //input 받기: Scanner class 필요 

/*기본적으로 input을 받을 때 enter를 치면 input 뒤에 \n이 자동으로 붙여짐(출력창에 보이진 않음)
next(),nextInt(),nextDouble() 등: 남아있는 \n,space 등을 무시하고 입력값을 읽어옴
nextLine(): 남아있는 \n까지를 하나의 라인으로 보고 그전까지 즉 ""을 읽어서 받음 그리고 그 \n을 !버림!
-> nextLine()을 쓸 때 유의할 것 */

//object이름.nextBoolean() 불린값 한개 입력받음 대문자 소문자 관계없다 
public class Chpt2_3InputScanner {

	public static void main(String[] args) {
		// Scanner 클래스의 object 생성) Scanner object이름 = new Scanner(System.in);
		Scanner keyboard = new Scanner(System.in); //System.in 입력받는다?  
		
		System.out.println("콩깍지의 갯수를 입력하시오"); //prompt: 입력 내용 안내
		System.out.println("콩의 갯수를 입력하시오");
		// object.nextInt()메소드: 입력한 하나의 int 받아옴
		// 여러개의 입력을 받을 경우, 스페이스바 or 엔터로 구분한다 
		int numberOfPods = keyboard.nextInt();   
		int peasPerPod = keyboard.nextInt();
		
		int totalNumberOfPeas = numberOfPods * peasPerPod;
		
		System.out.print(numberOfPods + " pods and "); //Echo: 입력한 내용 printback
		System.out.println(peasPerPod + " peas per pod");
		System.out.println("Total number of peas = " + totalNumberOfPeas);
		
		double d1, d2; 
		System.out.println("2개의 실수(double) 입력:");
		d1 = keyboard.nextDouble(); //nextDouble() double 1개 입력 받음
		d2 = keyboard.nextDouble();
		System.out.println("You entered " + d1 + " and " + d2);
		
		//next() word 1개 입력 받음. 구분자(default:스페이스,엔터)나올 때까지만 받는다 
		System.out.println("2개의 단어 입력:");
		String word1 = keyboard.next(); 
		String word2 = keyboard.next();
		System.out.println("You entered \"" + word1 + "\" and \"" + word2 + "\"");
		// "를 출력하기 위해 \" 사용 
		
		//nextLine() 한 줄 전체를 입력 받음. \n(new line)까지 읽지만 리턴할때는 버리고 그전까지 출력 
		
		String junk = keyboard.nextLine(); // \n을 없애기 위해.
		                                   // 없으면 아래의 line에 \n이 들어감
		System.out.println("문장 입력:");
		String line = keyboard.nextLine(); 
		System.out.println("You entered: \"" + line + "\"");
		//String junk2 = keyboard.nextLine(); 필요가 없다.. 새롭게 진짜 받아버림
		
		/*구분자(delimiter) 설정
		  object 이름.useDelimiter("구분자"); */
		
		Scanner keyboard2 = new Scanner(System.in);
		keyboard2.useDelimiter("##");
		System.out.println("단어 두개:");
		String a = keyboard2.next();
		String b = keyboard2.next();
		System.out.println("1)"+ a + "2)" + b);
		
		
		
	}

}
