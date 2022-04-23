
public class Chpt7_hw1 {

	public static void main(String[] args) {
		
		Person71 p1 = new Person71(); 
		Person71 p2 = new Person71("Tom"); 
		Customer71 c1 = new Customer71(); 
		Customer71 c2 = new Customer71("Jane");
		Customer71 c3 = new Customer71("Jack", "Seoul", 300); 
		
		showPerson(p1); 
		showPerson(p2);
		showPerson(c1);
		showPerson(c2);
		showPerson(c3);
		System.out.println(); 
		
		p1.setName("Luk");
		c1.setName("Tim");
		c2.setCity("Busan");
		c1.setMoney(500);
		c2.setMoney(200);
		
		showPerson(p1); 
		showPerson(p2);
		showPerson(c1);
		showPerson(c2);
		showPerson(c3);
		System.out.println(); 
		
		c1.purchase(200);
		c2.purchase(300);
		c3.purchase(100);
		
		System.out.println(); 
		showPerson(c1);
		showPerson(c2);
		showPerson(c3);
	}
	
	static void showPerson(Person71 p) {
		Customer71 test = new Customer71();
		if (p.getClass() != test.getClass()) {
			System.out.println("name(" + p.getName() + ")");
		}
		else {
			System.out.println("name(" + p.getName() + ") city(" +
		((Customer71) p).getCity() + ") money(" + ((Customer71) p).getMoney() + ")");
		}		
	}
}

class Person71{
	private String name;
	
	// default constructor
	public Person71() {
		name = "NoName";
	}
	// constructor
	public Person71(String name) {
		this.name = name;
	}
	
	//getter
	public String getName() {
		return name;
	}
	
	//setter
	public void setName(String name) {
		this.name = name;
		
	}
}

class Customer71 extends Person71{
	private String city;
	private int money;
	
	//constructor
	public Customer71() {
		super();
		city = "NoCity";
		money = 0;
	}
	
	public Customer71(String name) {
		super(name);
		city = "NoCity";
		money = 0;
	}
	
	public Customer71(String name, String city, int money) {
		super(name);
		this.city = city;
		this.money = money;
	}
	
	//setter
	public void setCity(String city) {
		this.city = city;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	//purchase
	public void purchase(int price) {
		if (money >= price) {
			System.out.println("SUCCESS: " + getName() + 
					"'s " + price + " purchase");
			money -= price;
		}
		else {
			System.out.println("FAIL: " + getName() + 
					"'s " + price + " purchase");
		}	
	}
	
	//getter
	public String getCity() {
		return city;
	}
	public int getMoney() {
		return money;
	}
}