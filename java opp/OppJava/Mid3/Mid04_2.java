
public class Mid04_2 {
	public static void main(String[] args) {
		Parent p1 = new Parent(); 
		Parent p2 = new Parent(3);
		Parent p3 = new Parent(3); 
		Child c1 = new Child(); 
		Child c2 = new Child(5); 
		Child c3 = new Child(7, 8); 
		Child c4 = new Child(7, 8); 
		
		System.out.println("p1 = " + p1); 
		System.out.println("p2 = " + p2); 
		System.out.println("c1 = " + c1); 
		System.out.println("c2 = " + c2); 
		System.out.println("c3 = " + c3); 
		
		System.out.println("p2.data() = " + p2.data());
		System.out.println("c3.data() = " + c3.data()); 
		System.out.println("p2.compute(5) = " + p2.compute(5)); 
		System.out.println("c3.compute(2, 3) = " + c3.compute(2, 3)); 
		
		System.out.println("p2 == p3 ? " + p2.equals(p3)); 
		System.out.println("p1 == p2 ? " + p1.equals(p2)); 
		System.out.println("p2 == c2 ? " + p2.equals(c2)); 
		System.out.println("c2 == c3 ? " + c2.equals(c3)); 
		System.out.println("c3 == c4 ? " + c3.equals(c4)); 
		System.out.println("c3 == p3 ? " + c3.equals(p3)); 
	}
}

class Parent{
	protected int x;
	
	public Parent() {
		x = 1;
	}
	
	public Parent(int x) {
		this.x = x;
	}
	
	public String toString() {
		return "x(" + x + ")";
	}
	
	public int data() {
		return x;
	}
	
	public int compute(int dx) {
		return (x * dx);
	}
	
	public boolean equals(Object other) {
		Parent testParent = new Parent();
		Child testChild = new Child();
		
		if (this.getClass() != other.getClass())
			return false;
		else if (other.getClass()==testParent.getClass()) {
			Parent b = (Parent)other;
			return (this.x == b.x);
		}
		else if (other.getClass()==testChild.getClass()) {
			Child a = (Child)other;
			return (this.x == a.x);
		}
		else
			return false;
	}
}

class Child extends Parent{
	protected int y;
	
	public Child() {
		super();
		y = 2;
	}
	
	public Child(int y) {
		super();
		this.y = y;
	}
	
	public Child(int x, int y) {
		super(x);
		this.y = y;
	}
	
	public int data() {
		return (x+y);
	}
	
	public int compute(int dx, int dy) {
		return (x * dx + y * dy); //다시보기 
	}
	
	public String toString() {
		return (super.toString() + " y(" + y + ")");
	}
	public int getY() {
		return y;
	}
	
}