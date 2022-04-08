
public class Chpt2_1_ScreenOutput {
	public static void main(String[] args) {
		/*System.out.print vs System.out.println
	 	print: same line 
	 	println: new line 출력 후 다음 줄 
		 */
		System.out.println("one"); //한 줄에 하나씩
		System.out.println("two");
		System.out.println("");   // new line
		System.out.print("one");  // 한 줄에 모두 출력 
		System.out.print("two");
		System.out.println("");
		
		/*printf: formatting output 
		 *포매팅 할 때 prinf() method 쓸 것! 
		 * double, float %f integar %d string %s character %c
		 * %nf n자리 차지할 것(공백은 왼쪽) %-nf (공백은 오른쪽) (f말고 다른 것도 사용 가능)n<length면 length 그대로 출력 
		 * %.nf n의 자리까지만 출력 (반올림) 
		 * %e
		 * print할 때 default: 소수점 여섯자리까지만(넘어가면 7번째자리에서 반올림)
		 */
		double price = 19.8;
		System.out.printf("%f %n", price); //output 19.800000 double이라서??
		System.out.print("$");
		System.out.printf("%6.2f", price); //%6 여섯자리로 출력(필요하면 왼쪽에 공백)
		System.out.println("");            //.2 소숫점 두번째자리까지(세번째에서 반ㅇㄹ림)
										   // f floating point format
		double value = 12.123;
		System.out.printf("Start%8.2fEnd%n", value); // %n new line
		System.out.printf("Start%-8.2fEnd%n", value); //%-8 오른쪽으로 공백 
		
		int num = 3;
		String name = "magic apple";
		System.out.printf("$%6.2f %d for each %s%n", price, num, name);
		System.out.printf("%d", num);
		
		System.out.printf("%e %n", price);
		System.out.printf("%.3e %n", price);
		
		String a = "abc";
		System.out.printf("START%sEND %n", a);
		System.out.printf("START%6sEND %n", a);
		System.out.printf("START%2sEND %n%n", a); //length보다 적게 배정해도 value 생략x. 그대로 쓴다 
		
		double d = 12345.123456789;
		System.out.printf("START%fEND  %n", d); // .123457 여섯번째 자리까지만 출력, 뒤에서 반올림
		System.out.printf("START%5.4fEND  %n", d);
		System.out.printf("START%eEND  %n", d);
		System.out.printf("START%12.5eEND  %n", d);
	}
	
	

}
