
public class Chpt4_1 {
	public int x;
	public void sayHello(int y) { //return value가 없는 method
		System.out.println("hello"+ x + " " + y);
		}
	
	public int square() {  //int를 return하는 method  
		sayHello(x);  //같은 클래스 내에서 호출할 때 클래스 이름 없어도 된다 
		return x*x;
	}

	}

