
public class Mid04_1 {
	public static void main(String[] args) {
		BorrowBook b1 = new BorrowBook(3); 
		BorrowBook b2 = new BorrowBook(5); 
		BorrowBook b3 = new BorrowBook(6); 
		BorrowBook b4 = new BorrowBook(5);
		BorrowBook b5 = new BorrowBook(9); 
		BorrowBook b6 = new BorrowBook(3);
		
		System.out.println("How many trials? " + b1.getNumTrials());
		System.out.println("How many trials? " + BorrowBook.getNumTrials());
		System.out.println("How many available books? " + b5.getNumAvailableBooks());
		System.out.println("How many available books? " + BorrowBook.getNumAvailableBooks());
	}
}

class BorrowBook{
	public static int trial = 0;
	public static int available = 10;
	public int wantBook;
	//boolean book0, book1, book2, book3, book4, book5, book6, book7, book8, book9;
	public static boolean[] booklist = {true,true,true,true,true,true,true,true,true,true};
 	
	public BorrowBook(int wantBook) {
		this.wantBook = wantBook;
		trial++;
		if (booklist[wantBook]) {
			System.out.println(wantBook + " Success");
			booklist[wantBook] = false;
			available--;
		}
		else {
			System.out.println(wantBook + " Fail");
		}
	
		
	}
	
	public static int getNumTrials() {
		return trial;
	}
	
	public static int getNumAvailableBooks() {
		return available;
	}
}
