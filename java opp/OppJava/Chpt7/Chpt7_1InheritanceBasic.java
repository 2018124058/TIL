public class Chpt7_1InheritanceBasic {
	public static void main(String[] args) {
		
	}
}

// Date: ��,��,���� ��ȿ�� ������ Ȯ��, toString ���� 
class Date{
	private int month; // 1���� 12
	private int day;  // 1���� 31
	private int year; // 4���� ���ڷ� �̷����
	
	public Date() { //default constructor
		month = 1;
		day = 1;
		year = 1000;
	}
	
	
	public Date(int month, int day, int year) {
		if(dateOK(month, day, year)) {
			this.month = month;
			this.day = day;
			this.year = year;
		}
		else {
			System.out.println("error");
			System.out.println(0);
		}
	}
	
	public Date(Date other) {  // copy constructor
		this.month = other.month;
		this.day = other.day;
		this.year = other.year;
	}
	
	
	public void setDate(int month, int day, int year) {
		if(dateOK(month, day, year)) {
			this.month = month;
			this.day = day;
			this.year = year;
		}
		else {
			System.out.println("error");
			System.out.println(0);
		}
	}
	
	private boolean dateOK(int monthInt, int dayInt, int yearInt) {
		return ((monthInt>=1)&&(monthInt<=12)&&
				(dayInt>=1)&&(dayInt<=31)&&
				(yearInt>=1000)&&(yearInt<=9999));
	}
	
	public String toString() {
		return(year + "�� " + month + "�� " + day + "��");
	}
	
	public boolean equals(Date other) {
		return((month == other.month)&& (year == other.year)
				&& (day == other.day));
	}
}

// base class Employee
class Employee{
	private String name;
	private Date hireDate; //Date class object
	
	// default constructor
	public Employee() { 
		name = "no name";
		hireDate = new Date(1,1,1000);
	}
	
	// constructor 
	public Employee(String name, Date hireDate) {
		// �Ѵ� null�� �ƴϾ�� �� 
		if ((name == null)||(hireDate == null)) {
			System.out.println("error");
			System.exit(0);
		}
		this.name = name;
		this.hireDate = new Date(hireDate); //copy constructor Ȱ��(���� ����, �ٸ� ���۷���)
	}
	
	// copy constructor
	public Employee(Employee other) {
		name = other.name;
		hireDate = new Date(other.hireDate); // ���ο� Date��ü ����
	}
	
	//accessor
	public String getName() {
		return name;
	}
	public Date getHireDate() {
		return new Date(hireDate); // copy constructor Ȱ��: privacy leak ����
	}
	
	//mutator
	public void setName(String newName) {
		if(newName == null) {
			System.exit(0);
		}
		name = newName;
	}
	public void setHireDate(Date newDate) {
		if(newDate==null) {
			System.exit(0);
		}
		hireDate = new Date(newDate); // copy constructor Ȱ��
	}
	
	//toString
	public String toString() {
		return(name + " " + hireDate); // hireDate.toString() �ڵ� ȣ��		
	}
	// object �� equals method 
	public boolean equals(Employee other) {
		return(name.equals(other.name)
				&&hireDate.equals(other.hireDate));
	}
}
