
public class Chpt9_test1 {
	//output: 1 2 5 6 1 3 5
	public static void main(String[] args) {
		method(false);
		method(true);
	}
	
	static void method(boolean b) {
		try {
			System.out.print(1 + " ");
			if (b) throw new ArithmeticException();
			System.out.print(2 + " ");
		}
		
		catch (RuntimeException r) {
			System.out.print(3 + " ");
			return;
		}
		catch (Exception e) {
			System.out.print(4 + " ");
		}
		finally {
			System.out.print(5 + " ");
		}
		System.out.print(6 + " ");
	}

}
