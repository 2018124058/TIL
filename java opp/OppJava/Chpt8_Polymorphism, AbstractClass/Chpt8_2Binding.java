//No Late Binding for Static and Final Methods 

public class Chpt8_2Binding {

	 public static void main(String[] args) {
		Sale s = new Sale();
		DiscountSale d = new DiscountSale();
		s.showAdvertisement();
		d.showAdvertisement();
		
		/*announcement는 static method라 compile time에 고정
		 -> Discount의 anouncement를 호출하지 않는다*/
		/*반면 toString은 dynamic, late binding이라 
		 Sale class의 toString과 DiscountSale class의 toString이
		 각각 호출된다 
		 */
	}
	}


class Sale{
	public static void announcement() {
		System.out.println("Sale class");
	}
	
	public void showAdvertisement() {
		announcement(); //static method: bound at compile time(early binding)
		System.out.println(toString()); // toString: bound at run time (late binding)	
	}
	
	public String toString() {return "Sale class object";}
}

class DiscountSale extends Sale{
	public static void announcement() { //오버라이딩 
		System.out.println("DiscountSale class");
	}
	
	public String toString() {return "DiscountSale class object";}	
}