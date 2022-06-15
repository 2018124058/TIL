
public class Final_1 {

	public static void main(String[] args) {
		English e = new English(30.5, 75.8);
		Math m = new Math(87.37, 65.6); 
		System.out.println("English total score = " + computeTotal(e));
		System.out.println("Math total score = " + computeTotal(m)); 
	}
	
	static double computeTotal(Course c) {
		// your code here
		return c.total;
	}

}

// your code here
abstract class Course {
	double mid; 
	double last;
	double total;
	
	
	public Course(double mid, double last) {
		this.mid = mid;
		this.last = last;
		total();
	}
	
	public abstract void total();
}

class English extends Course{
	
	public English(double mid, double last) {
		super(mid,last);
	}
	
	public void total() {
		total = (mid + last)/2;
	}
	
}

class Math extends Course{
	public Math(double mid, double last) {
		super(mid,last);
	}
	
	public void total() {
		if (mid>=last)
			total = mid;
		else
			total=last;
			
	}
	
}
