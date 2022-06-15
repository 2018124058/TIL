
public class Chpt10_Recursion {

	// int n�� �� �ڸ��� ���ڸ� �ϳ��� ��� 
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
	
	// int x�� n�� ���� ��� 
	public static int power(int x, int n) {
		if (n<0)
		{
			System.out.println("���� �Ұ�");
			System.exit(0);
		}
		if (n>0)
			return (power(x, n-1)*x);
		else // n==0
			return 1;
	}

	// ���ڿ� ���� ��� 
	public static int strLength(String str) {
		if (str.equals(""))
			return 0;
		else
			return 1 + strLength(str.substring(1));
	}
	
	// ���ڿ��� startIndex ���� ������ ����  
	public static void printStr(String str) {
		if (str.length()==0)
			return;
		else {
			System.out.println(str.charAt(0));
			printStr(str.substring(1));
		}
	}
	
	// ���ڿ� ����� ����Ʈ 
	public static void printStrReverse(String str) {
		if (str.length()==0)
			return;
		else {
			printStrReverse(str.substring(1));
			System.out.println(str.charAt(0));
		}
	}
	
	// �迭�� ��: data[0]���� data[n-1]������ ��
	public static int sum(int n, int[] data) {
		if (n<=0)
			return 0;
		else
			return sum(n-1, data) + data[n-1];
	}
}
