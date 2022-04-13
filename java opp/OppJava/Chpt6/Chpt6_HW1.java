
public class Chpt6_HW1 {

	public static void main(String[] args) {
			
			Library061 lib = new Library061(); 
			lib.addBook("Korean Dream", "Kim", 2015);
			lib.addBook("Our Beutiful Goals", "Lee", 2019);
			
			lib.addBook("My Precious Things", "Park", 2020);
			System.out.println(lib);
			lib.addBook("Go Up to the Mountain", "Cho", 1995);
			System.out.println(lib);
			lib.addBook("All We Have Lost in Pandemic", "Han", 1999);
			lib.addBook("For Our Best Days", "Min", 2005);		
			System.out.println(lib); 
			
			lib.deleteBook(3);	
			System.out.println("Delete 3");
			System.out.println(lib);
			
			lib.deleteBook(0);		
			System.out.println("Delete 0");
			System.out.println(lib);
			
			lib.deleteBook(2);		
			System.out.println("Delete 2");
			System.out.println(lib);
			
			lib.addBook("New World", "Son", 2012);
			System.out.println("Add <New World>");
			System.out.println(lib);
	
			lib.addBook("My Precious Things", "Park", 2020);
			System.out.println("Add <My Precious Things>");
			System.out.println(lib);
	
		}

}

class Library061 {
	public final static int MAX_BOOKS = 5; 
	private int numBooks;
	private Book061[] book; 
	private String s;
	
	public Library061() {
		numBooks = 0;
		Book061 book[] = new Book061[0];
		
		s = "";
	}
	
	public void helpToString() {
		s = "[LIBRARY] numBooks(" + numBooks + ")\n";
		if (book != null && numBooks> 0) {
			for (int i = 0; i < numBooks; i++) {
				s += (i + ": [BOOK] title(" + book[i].title 
						+ ") author(" + book[i].name + ") year("
						+ book[i].year + ")\n");
			}
		}	
	}
	
	public String toString() {
		helpToString();
		return s;
	}
	
	public void addBook(String title, String name, int year) {
		// 새로운 Book061 object 생성
		Book061 newBook = new Book061(title, name, year);
		Book061 temp[];
		Book061 temp2 = new Book061(" ", " ", 0);
		
			if (book == null) {
				temp = new Book061[1];
				temp[0] = newBook;
				numBooks = 1;
				book = temp;
			}
			else if ((numBooks > 0) && (numBooks < 5)){
				numBooks += 1;
				//길이가 1 늘어나고 book element를 물려받은 array temp
				temp = new Book061[numBooks];
				temp[numBooks-1] = newBook; //마지막 element
				for (int i = 0; i < numBooks-1; i++) {
					temp[i] = book[i];
				}
				
				boolean smallest = true;
				boolean biggest = true;
				
				for (int i=0; i<numBooks-1; i++) {
					if ((newBook.title.compareTo(temp[i].title)>0))
						smallest = false;
					else if (newBook.title.compareTo(temp[i].title)<0)
						biggest = false;
				}
				
				//newBook이 제일 작을 때
				if (smallest && !biggest) {
					for(int j=0; j<numBooks-1; j++) {
						temp[j+1] = book[j];
					}
					temp[0] = newBook;
				}
				
				//newBook이 제일 클 때
				else if (!smallest && biggest) {
					//앞에 정의한 temp 그대로
				}
				
				//newBook이 중간에 낄 때 
				else if (!smallest && !biggest) {
					for (int j=0; j<numBooks-1; j++) {
						if ((newBook.title.compareTo(temp[j].title)>0)
								&& (newBook.title.compareTo(temp[j+1].title)<0)) {
							for (int x=j+1; x<numBooks; x++) {
								temp[x] = book[x-1];
							}
							temp[j+1] = newBook;
							break;
						}
					}
				}
				
				book = temp;
			}
			
	}
	
	public void deleteBook(int index) {
		if (book != null && index < book.length) {
			Book061[] temp = new Book061[numBooks - 1];
			for (int i = 0; i < numBooks; i++)
				if (i < index)
					temp[i] = book[i];
				else if (i > index)
					temp[i-1] = book[i];
			book = temp;
			numBooks -= 1;
		}
		}
}	

class Book061 {
	//constructor
	public String title;
	public String name;
	public int year;
	
	public Book061(String title, String name, int year) {
		this.title = title;
		this.name = name;
		this.year = year;
	}
	
}


