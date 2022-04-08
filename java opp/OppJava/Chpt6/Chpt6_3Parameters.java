//import java.util.Scanner;
public class Chpt6_3Parameters {

	// arg 중 가장 큰 수 리턴하는 함수 max
	public static int max(int...arg) {
		if (arg.length == 0) 
		{
			System.out.println("error");
			System.exit(0); //0개의 파라미터면 최댓값 없으니까 여기서 종료
		}
		//length가 0이 아닐때 (앞에서 종료해서 else 쓸 필요 없다) 
		int largest = arg[0];
		for (int index = 0; index < arg.length; index++) 
		{
			if (largest < arg[index]) 
				largest = arg[index];
		}
		return largest;
	}
	
	public static void main(String[] args) {
		//System.out.println(" 정수 입력: ");
		//Scanner keyboard = new Scanner(System.in);
		// 무한정으로 어떻게 입력 받지?
		System.out.println(max(1,4,5,6));
	}

}
