
public class Chpt4_1Demo {

	public static void main(String[] args) {
		Chpt4_1 x1 = new Chpt4_1();
		Chpt4_1 x2 = new Chpt4_1();
		
		// 같은 variable 다른 value 
		x1.x = 3;
		x2.x = 4;
		
		x1.sayHello(0);
		x2.sayHello(0);
		
		int result1 = x1.square(); //이렇게 return값을 할당할 때 println은 그것대로 작동하네 
		int result2 = x2.square();
		
		System.out.println(result1);
		System.out.println(result2);
		
	}

}
