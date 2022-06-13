
public class Chpt10_Recursion {

	// int n의 각 자리의 숫자를 하나씩 출력 
	public static void writeVertical(int n) {
		if (n < 10) //stopping case
			{
			System.out.println(n);
			}
		else
		{
			writeVertical(n/10);
			System.out.println(n % 10);
		}
	}
	
	// int x의 n의 제곱 계산 
	public static int power(int x, int n) {
		if (n<0)
		{
			System.out.println("제곱 불가");
			System.exit(0);
		}
		if (n>0)
			return (power(x, n-1)*x);
		else // n==0
			return 1;
	}

	// 문자열 길이 계산 
	public static int strLength(String str) {
		if (str.equals(""))
			return 0;
		else
			return 1 + strLength(str.substring(1));
	}
	
	// 문자열의 startIndex 부터 끝까지 리턴  
	public static void printStr(String str) {
		if (str.length()==0)
			return;
		else {
			System.out.println(str.charAt(0));
			printStr(str.substring(1));
		}
	}
	
	// 문자열 뒤집어서 프린트 
	public static void printStrReverse(String str) {
		if (str.length()==0)
			return;
		else {
			printStrReverse(str.substring(1));
			System.out.println(str.charAt(0));
		}
	}
	
	// 배열의 합: data[0]부터 data[n-1]까지의 합
	public static int sum(int n, int[] data) {
		if (n<=0)
			return 0;
		else
			return sum(n-1, data) + data[n-1];
	}
}
