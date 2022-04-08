
public class Chpt5Hw3 {
	
	public static void main(String[] args) {
		People053 p1 = new People053("Kim", 25);
		People053 p2 = new People053("Lee", 32);
		People053 p3 = new People053("Park", 45);
		People053 p4 = new People053(p1); 
		Book053 b1 = new Book053("Book1", p1, 125); 
		Book053 b2 = new Book053("Book2", p2, 89);
		Book053 b3 = new Book053("Book3", p3, 246);
		Book053 b4 = new Book053("Book4", p4, 322);
		Book053 b5 = new Book053(b3);
		
		b5.setAuthorName("Cho");
		p2.setName("Han");
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
	}
}

class People053{
	private String authorName;
	private int authorAge;
	
	//constructor
	public People053(String authorName, int authorAge){
		this.authorName = authorName;
		this.authorAge = authorAge;
	}
	
	//copy constructor
	public People053(People053 object) {
		this.authorName = object.authorName;
		this.authorAge = object.authorAge;
	}
	
	//accessor
	public String getAuthorName() {
		return authorName;
	}
	
	public int getAuthorAge() {
		return authorAge;
	}
	
	//mutator
	public void setName(String authorName) {
		this.authorName = authorName;
	}
}

class Book053{
	private String title;
	private String name;
	private int age;
	private int page;
	
	//constructor
	public Book053(String title, People053 p, int page) {
		this.title = title;
		this.page = page;
		age = p.getAuthorAge();
		name = p.getAuthorName();
	}
	
	//copy constructor
	public Book053(Book053 object) {
		
		this.title = object.title;
		this.name = object.name;
		this.age = object.age;
		this.page = object.page;
	}
	
	//mutator
	public void setAuthorName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return ("[BOOK] title(" + title + ") author([PEOPLE]"
				+ name + "(" + age + ")) numPages(" + page + ")");
	}
}
