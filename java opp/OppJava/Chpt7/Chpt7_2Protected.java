
public class Chpt7_2Protected {

	public static void main(String[] args) {
		Base b;
		Derived d = new Derived();
		
		d.set(1,2);

	}

}

class Base{
	protected int x;
	
	public void set(int x) {
		this.x = x;
	}
}

class Derived extends Base{
	protected int y;
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
}