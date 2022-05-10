import java.util.Scanner;

public class Chpt9_1ExceptionHandling {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("남자 댄서 수: ");
		int men = keyboard.nextInt();
		System.out.println("여자 댄서 수: ");
		int women = keyboard.nextInt();
		
		// 남자 댄서, 여자 댄서 중 한쪽이라도 0명이면 수업 폐강 
		// 남녀 수가 같지 않으면 어떻게 짝 비율을 나누어야할지 리턴 
		try {
			if (men == 0 && women == 0)
				throw new Exception("남녀학생 없음 수업 폐강"); //exception object with message
			else if (men == 0)
				throw new Exception("남학생 없음 수업 폐강");
			else if (women == 0)
				throw new Exception("여학생 없음 수업 폐강");
			// women >= 0 && men >= 0
			// 앞에서 exception이 발생했을 경우 여기의 statement는 실행이 안되기 때문에 else if 가 아닌 if를 써도 무방 
			if (women >= men) 
				System.out.println("남학생 한명이 " + women/(double)men + " 명의 여학생과 짝");
			else 
				System.out.println("여학생 한명이 " +men/(double)women + " 명의 남학생과 짝");
		}
		catch (Exception e) {
			String message = e.getMessage();
			System.out.println(message);
			System.exit(0); // 프로그램 종료 -> 수업 시작 부분 실행 안된다 
		}
		
		System.out.println("수업 시작");
	
	}

}
