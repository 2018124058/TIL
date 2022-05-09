
public class Chpt9_test2 {
	//output: 2 4 7
	public static void main(String[] args) {
		try {
			method1();
			System.out.print(6 + " ");
		}
		catch (Exception e) {
			System.out.print(7 + " ");
		}
	}
	
	static void method1() throws Exception {
		try {
			method2();
			System.out.print(1 + " ");
		}
		catch (NullPointerException e) {
			System.out.print(2 + " ");
			throw e;
		}
		catch (Exception e) {
			System.out.println(3 + " ");
		}
		finally {
			System.out.print(4 + " ");
		}
		
		System.out.print(5 + " ");	
	}
	
	static void method2() {
		throw new NullPointerException();
	}
}
