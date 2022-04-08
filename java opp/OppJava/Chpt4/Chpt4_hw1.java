
public class Chpt4_hw1 {

	public static void main(String[] args) {
		Product041 p1 = new Product041(); 
		p1.setId(1);
		p1.setName("TV");
		p1.setPrice(4321.56);
		System.out.println("p1.id = " + p1.getId());
		System.out.println("p1.name = " + p1.getName());
		System.out.println("p1.price = " + p1.getPrice());
		System.out.println("p1: " + p1.toString());
		System.out.println(); 
		
		Product041 p2 = new Product041(); 
		p2.setId(2); 
		p2.setName("Car");
		p2.setPrice(56243.7);
		System.out.println("p2: " + p2.toString());
		System.out.println("p1 == p2? " + (p1 == p2));
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println(); 
		
		Product041 p3 = p1; 
		System.out.println("p3: " + p3.toString());
		System.out.println("p3 == p1? " + (p3 == p1));
		System.out.println("p3.equals(p1)? " + p3.equals(p1)); 
		System.out.println(); 
		
		Product041 p4 = new Product041(); 
		p4.setId(2); 
		p4.setName("Car");
		p4.setPrice(56243.7);
		System.out.println("p4: " + p4.toString());
		System.out.println("p4 == p2? " + (p4 == p2));
		System.out.println("p4.equals(p2)? " + p4.equals(p2)); 
		System.out.println(); 
		
		System.out.println("price (p1 + p2) = " + p1.sumPrice(p2)); 

	}

}

class Product041{
	private int id;
	private String name;
	private double price;
	
	//mutator
	void setId(int id){
				this.id = id;}
	void setName(String name) {
		this.name = name;}
	void setPrice(double price) {
		this.price = price;}
	
	//accessor
	public int getId() {
		return id;}
	public String getName() {
		return name;}
	public double getPrice() {
		return price;}
	
	//toString Method
	public String toString() {
		return ("[PRODUCT] id(" + id + ") name(" + name + ") price(" + price + ")");}
	
	//equals Method
	public boolean equals(Product041 otherProduct)
	{return ( (id == otherProduct.id) && (name.equals(otherProduct.name))
			&& (price == otherProduct.price)) ;}
	
	//sumPrice Method
	public double sumPrice(Product041 otherProduct)
	{ return (price + otherProduct.price);}
}


