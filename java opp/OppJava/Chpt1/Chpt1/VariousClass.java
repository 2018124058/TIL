package Chpt1;

/*
 �ϳ��� �ҽ��ڵ忡 �������� Ŭ������ �� �� �ִ�
 public class�� �� ����!
 ������ public class�� �켱������ �Ѵ� 
 */
public class VariousClass 
{	
	public static void main(String[] args)
	{
		
		System.out.println("Hello");
		World.main(); // World class�� main method ���� 
	}

}

class World
{
	public static void main()
	{
		System.out.println("World");
	}
}