interface InterfaceA{
	public int getStuff();
}

interface InterfaceOtherB{
	public String getStuff(String someStuff);
}

public class Chpt11_1Interfaces implements InterfaceA, InterfaceOtherB {
	
	private int intStuff = 42;
	
	public static void main(String[] args) {
		Chpt11_1Interfaces object = new Chpt11_1Interfaces();
		System.out.println(object.getStuff() + object.getStuff("Hello"));

	}
	
	public int getStuff() {
		return intStuff;
	}
	
	public String getStuff(String someStuff) {
		return someStuff;
	}

}
