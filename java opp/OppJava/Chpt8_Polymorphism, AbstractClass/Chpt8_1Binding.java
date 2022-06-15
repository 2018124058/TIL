
public class Chpt8_1Binding {

	public static void main(String[] args) {
		ClassC a = new ClassC(5);
		ClassB b = new ClassB(7);
		computeTest(a, 8);
		computeTest(b, 8);
	}
	
	static void computeTest(ClassC a, int k) {
		System.out.println(a.compute(k));
	}
	/*ClassB의 object가 파라미터로 들어갔을 때, 
	 dynamic binding이 발생해 ClassB가 오버라이딩한 compute method를 불러온다 
	 */
}

class ClassC{
	protected int x;
	public ClassC(int x) {
		this.x = x;
	}
	public int compute(int k) {
		return x + k;
	}
}

class ClassB extends ClassC{
	private int y;
	public ClassB(int y) {
		super(y);
		this.y = y;
	}
	
	public int compute(int k) {
		return x * y * k;
	}
}
