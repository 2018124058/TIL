
public class Chpt4_hw2 {

	public static void main(String[] args) {
		Book42 b1 = new Book42(); 
		Book42 b2 = new Book42("Flower in the wind");
		Book42 b3 = new Book42("Brave people", 342, 2013);
		
		System.out.println("b1: " + b1.toString());
		System.out.println("b2: " + b2.toString());
		System.out.println("b3: " + b3.toString());
	}
}

class Book42{
	private String title;
	private int numPage;
	private int year;
	
	//constructor
	public Book42() {
		title = "no title";
		numPage = 0;
		year = 2000;		
	}
	
	public Book42(String title) {
		this.title = title;
		numPage = 0;
		year = 2000;
	}
	
	public Book42(String title, int numPage, int year) {
		this.title = title;
		this.numPage = numPage;
		this.year = year;
	}
	
	//toString Method
	public String toString() {
		return ("[BOOK] title(" + title + ") numPage(" + numPage + ") year(" + year + ")");
	}
	
}