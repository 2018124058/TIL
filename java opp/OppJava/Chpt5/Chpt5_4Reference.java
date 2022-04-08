
public class Chpt5_4Reference {
	private String name;
	private int number;
	
	//constructor
	public Chpt5_4Reference(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	//default constructor
	public Chpt5_4Reference() {
		name = "no name";
		number = 0;
	}
	
	//mutator
	public void set(String newName, int newNumber) {
		name = newName;
		number = newNumber;
	}
	//toString method
	public String toString() {
		return (name + " " + number);
	}
	
	// 같은 클래스 다른 object의 instance variable 바꿈
	public static void changer(Chpt5_4Reference aParameter) {
		aParameter.name = "hot";
		aParameter.number = 30;
	}
	//equals method
	public boolean equals (Chpt5_4Reference otherObject) {
		return((name.equals(otherObject.name))&&(number == otherObject.number));}
}

class Demo {
	Chpt5_4Reference varaible1 = new Chpt5_4Reference("sj", 23);
	Chpt5_4Reference variable2 = new Chpt5_4Reference("cc", 29);
	variable1 = variable2;
	variable2.set("c", 29);
	System.out.prinln(variable1);
	System.out.prinln(variable2);
}}