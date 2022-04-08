
public class quiz13 {
	int k;
	public static void main(String args[]) {
		double x = 10.35;
		ClassA ca = new ClassA();
		ca.y = x;
	}
}

class ClassA {
	double y;
	public void showInfo() {
		System.out.println(y);
	}
}