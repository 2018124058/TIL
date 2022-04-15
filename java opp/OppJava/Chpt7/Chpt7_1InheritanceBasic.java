public class Chpt7_1InheritanceBasic {
	public static void main(String[] args) {
		
	}
}

// Date: 년,월,일이 유효한 값인지 확인, toString 제공 
class Date{
	private int month; // 1부터 12
	private int day;  // 1부터 31
	private int year; // 4개의 숫자로 이루어짐
	
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
		return(year + "년 " + month + "월 " + day + "일");
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
		// 둘다 null이 아니어야 함 
		if ((name == null)||(hireDate == null)) {
			System.out.println("error");
			System.exit(0);
		}
		this.name = name;
		this.hireDate = new Date(hireDate); //copy constructor 활용(같은 내용, 다른 레퍼런스)
	}
	
	// copy constructor
	public Employee(Employee other) {
		name = other.name;
		hireDate = new Date(other.hireDate); // 새로운 Date객체 생성
	}
	
	//accessor
	public String getName() {
		return name;
	}
	public Date getHireDate() {
		return new Date(hireDate); // copy constructor 활용: privacy leak 방지
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
		hireDate = new Date(newDate); // copy constructor 활용
	}
	
	//toString
	public String toString() {
		return(name + " " + hireDate); // hireDate.toString() 자동 호출		
	}
	// object 간 equals method 
	public boolean equals(Employee other) {
		return(name.equals(other.name)
				&&hireDate.equals(other.hireDate));
	}
}
