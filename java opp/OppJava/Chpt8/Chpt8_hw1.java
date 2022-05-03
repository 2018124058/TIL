
public class Chpt8_hw1 {
	public static void main(String[] args) {
		Product081 p1 = new Product081("Chair", 120.00); 
		Computer081 c1 = new Computer081("Apple", 256.3, 0.3); 
		
		System.out.println("[PRODUCT] name(" + p1.getName() + ") price(" + 
										p1.getPrice() + ") real price(" + realPrice(p1) + ")");
		
		System.out.println("[COMPUTER] name(" + c1.getName() + ") price(" + 
				c1.getPrice() + ") rate(" + c1.getRate() + ") real price(" + realPrice(c1) + ")");
	}
	
	static double realPrice(Product081 given ) {
		return given.realPrice(); 
	}
}

class Product081{
	protected String name;
	protected double price;
	protected double rate = 0.1;
	
	public Product081(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	public double realPrice() {
		return price + price * rate;
	}

}

class Computer081 extends Product081{
	
	public Computer081(String name, double price, double rate) {
		super(name, price);
		this.rate = rate;
	}
	
	public double getRate() {
		return rate;
	}
	
	/*public double realPrice() {
		double realPrice = price * (1+rate);
		double result = Math.round(realPrice*100);
		return result/100;
		return price + price * rate;
    }
	*/
}
