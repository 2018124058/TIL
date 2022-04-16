package Chpt1;

/*
 하나의 소스코드에 여러개의 클래스가 올 수 있다
 public class는 한 개만!
 실행은 public class를 우선적으로 한다 
 */
public class VariousClass 
{	
	public static void main(String[] args)
	{
		
		System.out.println("Hello");
		World.main(); // World class의 main method 실행 
	}

}

class World
{
	public static void main()
	{
		System.out.println("World");
	}
}