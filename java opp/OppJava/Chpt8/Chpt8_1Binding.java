
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
	/*ClassB�� object�� �Ķ���ͷ� ���� ��, 
	 dynamic binding�� �߻��� ClassB�� �������̵��� compute method�� �ҷ��´� 
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
