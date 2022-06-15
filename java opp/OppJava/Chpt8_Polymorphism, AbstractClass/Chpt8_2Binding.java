//No Late Binding for Static and Final Methods 

public class Chpt8_2Binding {

	 public static void main(String[] args) {
		Sale s = new Sale();
		DiscountSale d = new DiscountSale();
		s.showAdvertisement();
		d.showAdvertisement();
		
		/*announcement�� static method�� compile time�� ����
		 -> Discount�� anouncement�� ȣ������ �ʴ´�*/
		/*�ݸ� toString�� dynamic, late binding�̶� 
		 Sale class�� toString�� DiscountSale class�� toString��
		 ���� ȣ��ȴ� 
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
	public static void announcement() { //�������̵� 
		System.out.println("DiscountSale class");
	}
	
	public String toString() {return "DiscountSale class object";}	
}