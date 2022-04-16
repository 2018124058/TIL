public class Chpt7_1InheritanceBasic {
	public static void main(String[] args) {
		
		//Employee class, HourlyEmployee class test
		HourlyEmployee s = new HourlyEmployee("so", new Calendar(1,1,2022),
				10000, 20);
		System.out.println(s);
		
	}
}

// Calendar: 년,월,일이 유효한 값인지 확인, toString 제공 
class Calendar{
	private int month; // 1부터 12
	private int day;  // 1부터 31
	private int year; // 4개의 숫자로 이루어짐
	
	public Calendar() { //default constructor
		month = 1;
		day = 1;
		year = 1000;
	}
	
	
	public Calendar(int month, int day, int year) {
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
	
	public Calendar(Calendar other) {  // copy constructor
		this.month = other.month;
		this.day = other.day;
		this.year = other.year;
	}
	
	
	public void setCalendar(int month, int day, int year) {
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
	
	public boolean equals(Calendar other) {
		return((month == other.month)&& (year == other.year)
				&& (day == other.day));
	}
}

// base class Employee
class Employee{
	private String name;
	private Calendar hireDate; //Date class object
	
	// default constructor
	public Employee() { 
		name = "no name";
		hireDate = new Calendar(1,1,1000);
	}
	
	// constructor 
	public Employee(String name, Calendar hireDate) {
		// 둘다 null이 아니어야 함 
		if ((name == null)||(hireDate == null)) {
			System.out.println("error");
			System.exit(0);
		}
		this.name = name;
		this.hireDate = new Calendar(hireDate); //copy constructor 활용(같은 내용, 다른 레퍼런스)
	}
	
	// copy constructor
	public Employee(Employee other) {
		name = other.name;
		hireDate = new Calendar(other.hireDate); // 새로운 Date객체 생성
	}
	
	//accessor
	public String getName() {
		return name;
	}
	public Calendar getHireDate() {
		return new Calendar(hireDate); // copy constructor 활용: privacy leak 방지
	}
	
	//mutator
	public void setName(String newName) {
		if(newName == null) {
			System.exit(0);
		}
		name = newName;
	}
	public void setHireDate(Calendar newDate) {
		if(newDate==null) {
			System.exit(0);
		}
		hireDate = new Calendar(newDate); // copy constructor 활용
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

//derived class: keyword 'extends'
class HourlyEmployee extends Employee{
	//Employee class에서  instance variable 자동상속: name, hireDate
	private double wageRate; // 시급, 양수값을 가짐
	private double hours; // 월 근무 시간, 양수값을 가짐 
	
	//default constructor
	public HourlyEmployee() {
		super(); //base class의 default constructor 호출
		wageRate = 0; 
		hours = 0;
	}
	
	//constructor
	public HourlyEmployee(String name, Calendar hireDate,
			double wageRate, double hours) {
		super(name, hireDate); // base class의 constructor 호출
		if((wageRate>=0)&&(hours>=0)) {
			this.wageRate = wageRate;
			this.hours = hours;
		}
		else {
				System.exit(0);
			}
		}
	
	//copy constructor
	public HourlyEmployee(HourlyEmployee other) {
		super(other); // base class의 copy constructor 호출
		// super(other)이 가능한 이유: 자식클래스의 객체는 부모클래스의 객체이기도 하다
		wageRate = other.wageRate;
		hours = other.hours;
	}
	
	//accessor
	//getName(), getHireDate()는 자동 상속
	public double getWageRate() {
		return wageRate;
	}
	
	public double getHours() {
		return hours;
	}
	
	//pay for month
	public double getPay() {
		return (wageRate * hours);
	}
	
	//mutator precondition: wageRate, hours는 양수
	//method setName, setHireDate는 자동상속
	public void setHours(double hours) {
		if(hours>=0) {
			this.hours = hours;
		}
		else {
			System.exit(0);
		}
	}
	
	public void setWageRate(double wageRate) {
		if(wageRate>=0) {
			this.wageRate = wageRate;
		}
		else {
			System.exit(0);
		}
	}
	
	//toString:base class의 toString을 Overriding 
	//base class의 private instance variable: 상속은 되나, 접근 권한이 없다 
	public String toString() {
		return(getName() + " " + getHireDate() + " 시급: " +
				wageRate + " 근무시간: " + hours);
	}
	
	//equals: object 간 비교
	//Overloading
	public boolean equals(HourlyEmployee other) {
		return(getName().equals(other.getName())
				&& getHireDate().equals(other.getHireDate())
				&& wageRate == other.wageRate
				&& hours == other.hours);
	}
}