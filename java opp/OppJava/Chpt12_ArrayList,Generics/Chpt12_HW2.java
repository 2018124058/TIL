
public class Chpt12_HW2 {

	public static void main(String[] args) {
		
		BClass142 b = new BClass142(); 
		CClass142 c = new CClass142(); 
		
		AClass142<BClass142> a1 = new AClass142<BClass142>(b);
		AClass142<CClass142> a2 = new AClass142<CClass142>(c); 
		
		System.out.println(a1);
		System.out.println(a2); 

	}

}

class AClass142<T extends Speakable > {
	private T obj;
	
	public AClass142(T obj) {
		this.obj = obj; 
	}
	
	public String toString() {
		return obj.speak(); 
	}
}

// your code
class Speakable{
	public String speak() {
		return this.toString();
	}
}

class BClass142 extends Speakable {
	
	public String toString() {
		return "BClass";
	}
}

class CClass142 extends Speakable {
	
	public String toString() {
		return "CClass";
	}	
}