
public class Chpt8_hw2 {
	public static void main(String[] args) {
		
		Subject82[] sub = new Subject82[3];
		
		sub[0] = new Literature82("L001", "Kim", 3, "Miracle of the town");
		sub[1] = new Math82("M001", "Lee", 2, 5); 
		sub[2] = new Science82("S001", "Park", 4, 12);
		
		for (int i = 0; i < sub.length; i++) {
			System.out.println(sub[i]); 
		}
		
		for (int i = 0; i < sub.length; i++) {
			callIntro(sub[i]); 
		}
		
	}
	
	static void callIntro(Subject82 s) {
		s.intro(); 
	}
}

abstract class Subject82{
	protected String title;
	protected String teacher;
	protected int credit;
	
	Subject82(String title, String teacher, int credit){
		this.title = title;
		this.teacher = teacher;
		this.credit = credit;
	}
	
	abstract void intro();
	
	public String toString() {
		return "[SUBJECT] title(" + title + ") teacher(" 
				+ teacher + ") credit(" + credit + ")";
	}
}

class Literature82 extends Subject82{
	String bookTitle;
	
	Literature82(String title, String teacher, int credit, String bookTitle){
		super(title, teacher, credit);
		this.bookTitle = bookTitle;
	}
	
	public void intro() {
		System.out.println("Literature intro");
	}
	
	public String toString() {
		return "[LITERATURE] " + super.toString() + " bookTitle(" + bookTitle
				+ ")";
	}
}

class Math82 extends Subject82{
	protected int practiceHour;
	
	Math82(String title, String teacher, int credit, int practiceHour){
		super(title, teacher, credit);
		this.practiceHour = practiceHour;
	}
	
	public void intro() {
		System.out.println("Math intro");
	}
	
	public String toString() {
		return "[MATH] " + super.toString() + " practiceHour(" + practiceHour
				+ ")";
	}
}

class Science82 extends Subject82{
	protected int experimentHour;
	
	Science82(String title, String teacher, int credit, int experimentHour){
		super(title, teacher, credit);
		this.experimentHour = experimentHour;
	}
	
	
	public void intro() {
		System.out.println("Science intro");
	}
	
	public String toString() {
		return "[SCIENCE] " + super.toString() + " experimentHour(" + experimentHour
				+ ")";
	}
}