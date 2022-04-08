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
		//class System�� object out�� method println
		System.out.println("calculation.");
		int answer;
		answer = 2 + 2;
		System.out.println("2 + 2 = " + answer);
		int count = 50, finalCount;  // ������ �ʱⰪ ������ ���� �� �ִ�. ������ �װ� ����Ʈ�ϸ� ����  		
		System.out.println(count);
		int x = 1;
		char y = 'y';
		boolean z = true;
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		//System.out.println(long 500000000L); �� �ȵ��� 
		//System.out.println(50000000L); �̰͵� �ȵ�
		long long1 = 5000000000L;
		System.out.println(long1);
		
		int n = 2;
		int m = 2 * (++n);  //prefix: ���� ���ϰ� ����
		System.out.println(m);
		System.out.println(n); // n�� ���� 1 ������
		
		int a = 2;
		int b = 2 * (a++);
		System.out.println(b); // postfix: ���� ���ϰ� ����
		System.out.println(a); // 1 ������ 
		
		
	}
}

class practice
{
	public static void practice_method()
	{
		System.out.println("ab");
	}
	
}
