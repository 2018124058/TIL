package Chpt1;

public class Chpt1Hw3 {

	public static void main(String[] args) {
		String str1 = "    I love you baby.   ";
		String str2 = str1.trim(); // �յ� ���� ���� 
		String str3 = str2.substring(0,2); //object.substring(start, end) start���� end-1���� 
		String str4 = str2.substring(6);
		System.out.println(str3 + "hate" + str4); 

	}

}
