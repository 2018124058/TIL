package Chpt1;

/*
 Class String: ""사이에 정의, immutable object
 Concatenation: string + 수
 */
public class Chpt1_2_String 
{
	public static void main(String[] args)
	{
		String myStr1 = "hello";
		String myStr2 = "Hello";
		String myStr3 = "    hi      ";
		System.out.println(myStr1 + 3.0);
		System.out.println(myStr1.length()); // object.length() 길이 
		System.out.println(myStr1.equals(myStr2)); //object.equals(비교대상) 같은지 비교
		System.out.println(myStr1.equalsIgnoreCase(myStr2)); // 대소문자 무시하고 비교
		System.out.println(myStr1.toUpperCase()); //object.toUpperCase() 전체 대문자로 <->Lower
		System.out.println(myStr1); // 기존 myStr1 자체가 바뀌진 않는다 (immutable 이라?)
		System.out.println(myStr3.trim()); // object.trim() 양끝! 공백 없애기
		System.out.println(myStr1.charAt(0)); // object.charAt(index) 인덱스의 character 
		System.out.println(myStr1.substring(0)); //object.substring(start, end) start부터 end-1까지 
		System.out.println(myStr1.indexOf("el")); //object.indexOf(string) string이 나오기 시작하는 인덱스 
		                                          //object.indexOf(string, start) string이 start번째로 나오는 인덱스 
		                                          //object.lastIndexOf(string) string이 마지막으로 나오는 인덱스 
		// object.compareTo(string) 두 스트링을 앞글자부터 비교. 작으면 negative, 같으면 0, 크면 positive
		// 숫자<대문자<소문자, 알파벳 뒷 순서일수록 크다 
		System.out.println(myStr1.compareTo(myStr2));
		System.out.println("Hey Guys \\\n\"oh\t'yes");
	}
}
