
public class Chpt4_1 {
	public int x;
	public void sayHello(int y) { //return value�� ���� method
		System.out.println("hello"+ x + " " + y);
		}
	
	public int square() {  //int�� return�ϴ� method  
		sayHello(x);  //���� Ŭ���� ������ ȣ���� �� Ŭ���� �̸� ��� �ȴ� 
		return x*x;
	}

	}

