interface InterfaceA{
	public int getStuff();
}

interface InterfaceOtherB{
	public String getStuff(String someStuff);
}

public class Chpt11_Interface implements InterfaceA, InterfaceOtherB {
	
	private int intStuff = 42;
	
	public static void main(String[] args) {
		Chpt11_Interface object = new Chpt11_Interface();
		System.out.println(object.getStuff() + object.getStuff("Hello"));

	}
	
	public int getStuff() {
		return intStuff;
	}
	
	public String getStuff(String someStuff) {
		return someStuff;
	}

}
