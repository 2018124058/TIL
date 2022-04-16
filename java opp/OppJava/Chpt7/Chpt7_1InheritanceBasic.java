public class Chpt7_1InheritanceBasic {
	public static void main(String[] args) {
		
		//Employee class, HourlyEmployee class test
		HourlyEmployee s = new HourlyEmployee("so", new Calendar(1,1,2022),
				10000, 20);
		System.out.println(s);
		
	}
}

// Calendar: ��,��,���� ��ȿ�� ������ Ȯ��, toString ���� 
class Calendar{
	private int month; // 1���� 12
	private int day;  // 1���� 31
	private int year; // 4���� ���ڷ� �̷����
	
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
		return(year + "�� " + month + "�� " + day + "��");
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
		// �Ѵ� null�� �ƴϾ�� �� 
		if ((name == null)||(hireDate == null)) {
			System.out.println("error");
			System.exit(0);
		}
		this.name = name;
		this.hireDate = new Calendar(hireDate); //copy constructor Ȱ��(���� ����, �ٸ� ���۷���)
	}
	
	// copy constructor
	public Employee(Employee other) {
		name = other.name;
		hireDate = new Calendar(other.hireDate); // ���ο� Date��ü ����
	}
	
	//accessor
	public String getName() {
		return name;
	}
	public Calendar getHireDate() {
		return new Calendar(hireDate); // copy constructor Ȱ��: privacy leak ����
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
		hireDate = new Calendar(newDate); // copy constructor Ȱ��
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

//derived class: keyword 'extends'
class HourlyEmployee extends Employee{
	//Employee class����  instance variable �ڵ����: name, hireDate
	private double wageRate; // �ñ�, ������� ����
	private double hours; // �� �ٹ� �ð�, ������� ���� 
	
	//default constructor
	public HourlyEmployee() {
		super(); //base class�� default constructor ȣ��
		wageRate = 0; 
		hours = 0;
	}
	
	//constructor
	public HourlyEmployee(String name, Calendar hireDate,
			double wageRate, double hours) {
		super(name, hireDate); // base class�� constructor ȣ��
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
		super(other); // base class�� copy constructor ȣ��
		// super(other)�� ������ ����: �ڽ�Ŭ������ ��ü�� �θ�Ŭ������ ��ü�̱⵵ �ϴ�
		wageRate = other.wageRate;
		hours = other.hours;
	}
	
	//accessor
	//getName(), getHireDate()�� �ڵ� ���
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
	
	//mutator precondition: wageRate, hours�� ���
	//method setName, setHireDate�� �ڵ����
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
	
	//toString:base class�� toString�� Overriding 
	//base class�� private instance variable: ����� �ǳ�, ���� ������ ���� 
	public String toString() {
		return(getName() + " " + getHireDate() + " �ñ�: " +
				wageRate + " �ٹ��ð�: " + hours);
	}
	
	//equals: object �� ��
	//Overloading
	public boolean equals(HourlyEmployee other) {
		return(getName().equals(other.getName())
				&& getHireDate().equals(other.getHireDate())
				&& wageRate == other.wageRate
				&& hours == other.hours);
	}
}