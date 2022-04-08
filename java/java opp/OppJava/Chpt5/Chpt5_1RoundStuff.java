import java.util.Scanner;

public class Chpt5_1RoundStuff {
	public static final double PI = 3.14159; // named constant, static variable
	
	//static method area: double ���̸� ���� 
	public static double area(double radius)
	{return (PI*radius*radius);}
	//static method volume: double ���Ǹ� ���� 
	public static double volume(double radius)
	{return((4.0/3.0)*PI*radius*radius*radius);}
	
	public static void main(String[] args) // main method�� static method�� ������ area, volume method ȣ�� ����
	{
		Scanner keyboard1 = new Scanner(System.in);
		System.out.println("������:");
		double radius = keyboard1.nextDouble();
		
		System.out.println("������: " + radius);
		System.out.println("����: " + Chpt5_1RoundStuff.area(radius));
		System.out.println("����: " + Chpt5_1RoundStuff.volume(radius));
		
	}
	
}
