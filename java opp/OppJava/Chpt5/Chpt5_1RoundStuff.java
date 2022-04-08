import java.util.Scanner;

public class Chpt5_1RoundStuff {
	public static final double PI = 3.14159; // named constant, static variable
	
	//static method area: double 넓이를 리턴 
	public static double area(double radius)
	{return (PI*radius*radius);}
	//static method volume: double 부피를 리턴 
	public static double volume(double radius)
	{return((4.0/3.0)*PI*radius*radius*radius);}
	
	public static void main(String[] args) // main method도 static method기 때문에 area, volume method 호출 가능
	{
		Scanner keyboard1 = new Scanner(System.in);
		System.out.println("반지름:");
		double radius = keyboard1.nextDouble();
		
		System.out.println("반지름: " + radius);
		System.out.println("넓이: " + Chpt5_1RoundStuff.area(radius));
		System.out.println("부피: " + Chpt5_1RoundStuff.volume(radius));
		
	}
	
}
