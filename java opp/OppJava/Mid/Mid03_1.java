
public class Mid03_1 {
	public static void main(String[] args) {
		Address a1 = new Address(); 
		Address a2 = new Address("Seoul", "Jong-ro", 32);  // city, road, number
		Address a3 = new Address("Busan", "Gunam-ro", 45); 
		Address a4; 
		Building b1 = new Building(); 
		Building b2 = new Building("Heaven", 1995, a2); // name, year, address
		Building b3 = new Building("Angel", 2008, a3); 
		
		System.out.println(a1);
		System.out.println(a2); 
		System.out.println(a3); 
		System.out.println(); 
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3); 
		System.out.println(); 
		
		b1.set("Joy", 2012, a1);
		a1.set("Sejong",  "One-ro", 177);
		
		System.out.println(a1);
		System.out.println(a2); 
		System.out.println(a3); 
		System.out.println(); 
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3); 	
		System.out.println(); 
		
		a4 = new Address(a2);
		
		System.out.println(a4);
		System.out.println(); 
		System.out.println("a4 == a2 ? " + a4.equals(a2));
		System.out.println("a4 == a1 ? " + a4.equals(a1));
		System.out.println("a4 == b1 ? " + a4.equals(b1));
		
		a1.set("Seoul", "Jong-ro", 32);
		System.out.println("a4 == a1 ? " + a4.equals(a1));
	}
}

class Address{
	public String city;
	public String road;
	public int number;
	
	//constructor
	public Address() {
		city = "nocity";
		road = "noroad";
		number = 0;
	}
	
	public Address(String city, String road, int number) {
		this.city = city;
		this.road = road;
		this.number = number;
	}
	
	public Address(Address other) {
		city = other.city;
		road = other.road;
		number = other.number;
	}
	
	public String toString() {
		return "[ADDR] city(" + city + ") road(" + road + ") num(" + number + ")";
	}
	
	public void set(String city, String road, int number) {
		this.city = city;
		this.road = road;
		this.number = number;
	}
	
	public boolean equals(Address other) {
		return ((city.equals(other.city))&&(road.equals(other.road))&&(number == other.number));
	}
	
	public boolean equals(Building other) {
		return false;
	}
}

class Building{
	public String name; 
	public int year;
	public Address address;
	
	public Building() {
		name = "noname";
		year = 0;
		address = new Address();
	}
	
	public Building(String name, int year, Address address) {
		this.name = name;
		this.year = year;
		this.address = new Address(address);
	}
	
	public String toString() {
		return "[BUILDING] name(" + name + ") year(" + year
				+ ") addr(" + address + ")";
	}
	
	public void set(String name, int year, Address address) {
		this.name = name;
		this.year = year;
		this.address = new Address(address);
	}
}
