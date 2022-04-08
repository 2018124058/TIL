
public class Chpt5Hw4 {
	
	public static void main(String[] args) {
		int a = 2; 
		SubClass result = new SubClass(a);
		cube(result);
		System.out.println(result.multiplyResult);
	}
	
	static void cube(SubClass object) {
	    object.multiplyResult = (object.num * object.num * object.num);
	}
}

class SubClass {
	int num;
	int multiplyResult;
	
	public SubClass(int num) {
		this.num = num;
		multiplyResult = 1;
	}
}