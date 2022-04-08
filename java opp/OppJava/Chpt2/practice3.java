import java.util.Scanner;
public class practice3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int money = keyboard.nextInt();
		
		int a = (int)money / 50000;  // int로 형변환 
		int leftOver1 = money - a*50000;
		
		int b = (int)leftOver1 / 10000;
		int leftOver2 = leftOver1 - b*10000;
		
		int c = (int)leftOver2 / 5000;
		int leftOver3 = leftOver2 - c*5000;
		
		int d = (int)leftOver3 / 1000;
		int leftOver4 = leftOver3 - d*1000;
		
		int e = (int)leftOver4 / 500;
		int leftOver5 = leftOver4 - e*500;
		
		int f = (int)leftOver5 / 100;
		int leftOver6 = leftOver5 - f*100;
		
		int g = (int)leftOver6 / 50;
		int leftOver7 = leftOver6 - g*50;
		
		int h = (int)leftOver7 / 10;
		
		
		System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g+" "+h);
		

	}

}
