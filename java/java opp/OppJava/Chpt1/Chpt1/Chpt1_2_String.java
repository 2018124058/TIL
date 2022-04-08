package Chpt1;

/*
 Class String: ""���̿� ����, immutable object
 Concatenation: string + ��
 */
public class Chpt1_2_String 
{
	public static void main(String[] args)
	{
		String myStr1 = "hello";
		String myStr2 = "Hello";
		String myStr3 = "    hi      ";
		System.out.println(myStr1 + 3.0);
		System.out.println(myStr1.length()); // object.length() ���� 
		System.out.println(myStr1.equals(myStr2)); //object.equals(�񱳴��) ������ ��
		System.out.println(myStr1.equalsIgnoreCase(myStr2)); // ��ҹ��� �����ϰ� ��
		System.out.println(myStr1.toUpperCase()); //object.toUpperCase() ��ü �빮�ڷ� <->Lower
		System.out.println(myStr1); // ���� myStr1 ��ü�� �ٲ��� �ʴ´� (immutable �̶�?)
		System.out.println(myStr3.trim()); // object.trim() �糡! ���� ���ֱ�
		System.out.println(myStr1.charAt(0)); // object.charAt(index) �ε����� character 
		System.out.println(myStr1.substring(0)); //object.substring(start, end) start���� end-1���� 
		System.out.println(myStr1.indexOf("el")); //object.indexOf(string) string�� ������ �����ϴ� �ε��� 
		                                          //object.indexOf(string, start) string�� start��°�� ������ �ε��� 
		                                          //object.lastIndexOf(string) string�� ���������� ������ �ε��� 
		// object.compareTo(string) �� ��Ʈ���� �ձ��ں��� ��. ������ negative, ������ 0, ũ�� positive
		// ����<�빮��<�ҹ���, ���ĺ� �� �����ϼ��� ũ�� 
		System.out.println(myStr1.compareTo(myStr2));
		System.out.println("Hey Guys \\\n\"oh\t'yes");
	}
}
