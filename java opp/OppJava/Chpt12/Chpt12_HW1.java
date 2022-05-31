import java.util.ArrayList; 
public class Chpt12_HW1 {

	public static void main(String[] args) {
		ArrayList<Student141> list = new ArrayList<Student141>();
		
		// your code here
		list.add(new Student141("Tom",25));
		list.add(new Student141("Jane",31));
		list.add(new Student141("Aaron",15));
		list.add(new Student141("Pola",27));
		
		showList(list);
		
		System.out.println();
		System.out.println("Changing the element Aaron to Jone");
		
		// your code here 
		list.set(2, new Student141("Jone", 12));
		
		showList(list);
		
		System.out.println();
		System.out.println("Inserting a new element Cook as a third element");
		
		// your code here
		Student141 cook = new Student141("Cook",32);
		list.add(2, cook);
		
		showList(list);
		
		// your code here 
		
		System.out.print("\nDoes the list contain Cook? ");
		System.out.print(list.contains(cook)+ "\n");
		
		System.out.print("Index of Cook? ");
		System.out.print(list.indexOf(cook)+"\n");
		
		System.out.println();
		System.out.println("Removing a second element");
		
		// your code here
		list.remove(1);
		
		showList(list);
		
	}
	
	// your code here for method showList
	public static void showList(ArrayList<Student141> list) {
		System.out.println("---list---"); 
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

// your code here for class Student141
class Student141{
	public String name;
	public int age;
	
	public Student141() {
		name = "none";
		age = 0;
	}
	
	public Student141(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "[STUDENT] name(" + name + ") age(" + age + ")";
	}
}
