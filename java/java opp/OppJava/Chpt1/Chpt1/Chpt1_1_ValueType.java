package Chpt1;

/*
primitive types: boolean, char, byte, short, int, long, float, double
reference types: string, class
byte,char<short<int<long<float<double
 */

/*
Calculation Equalizing
byte, char, short -> int 
byte + short -> int + int -> int
char + int -> int + int -> int
float + int -> float + float -> float
long + float -> float
float + double -> double
 */

/* +,-,++,-- > *,/,% > +, - */
public class Chpt1_1_ValueType 
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("hello reader.");
		System.out.println("welcome to Java.");
		//class System의 object out의 method println
		System.out.println("calculation.");
		int answer;
		answer = 2 + 2;
		System.out.println("2 + 2 = " + answer);
		int count = 50, finalCount;  // 변수에 초기값 설정을 안할 수 있다. 하지만 그걸 프린트하면 에러  		
		System.out.println(count);
		int x = 1;
		char y = 'y';
		boolean z = true;
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		//System.out.println(long 500000000L); 왜 안되지 
		//System.out.println(50000000L); 이것도 안됨
		long long1 = 5000000000L;
		System.out.println(long1);
		
		int n = 2;
		int m = 2 * (++n);  //prefix: 먼저 더하고 곱셈
		System.out.println(m);
		System.out.println(n); // n의 값도 1 더해짐
		
		int a = 2;
		int b = 2 * (a++);
		System.out.println(b); // postfix: 먼저 곱하고 덧셈
		System.out.println(a); // 1 더해짐 
		
		
	}
}

class practice
{
	public static void practice_method()
	{
		System.out.println("ab");
	}
	
}
