# Chapter 7. Inheritance ���  
# 7.1 Inheritance Basics  
## inheritance ����̶�  
- ���: �����ϴ� Ŭ�������� ���ο� Ŭ������ ����� ����  
- ����: Ŭ������ ����  
- orginal class ��Ī: base class, parent class, super class  
- new class ��Ī: derived class, child class, sub class  
- derived class�� base class�� instance variables, methods�� �ڵ����� �����޴´� (x constructor)
	- private instance variable�� ��� ��ӵ����� ������ �� �ִ� ������ ����(getter method �̿� �ʿ�)  
	- ���ο� instance variables, methods �߰� ����
- static variable�� ��ӵȴ�  
	- instance varaible�� �Ȱ��� `public`, `private`, `protected`,`package` ����  
- derived class type�� object�� base class type�̱⵵ �ϴ�! 
	 
### Derived class definition  
`class DerivedClassName extends BaseClassName`  
- keyword: `extends`  
	  
### ����� ���� ����  
- ���� ������ general, �Ʒ��� ������ specific  
- �� �ܰ� ���̳��� parent class�� child class  
- �ڽ� ���� ���� ���δ� ancestor, �Ʒ��� ���δ� descendant  
- descendant class�� object�� ��� ancestor class type�� ���Ѵ�(���� ����x)  

## Overriding a Method Definition  
- overriding: descendant class�� �������� method�� ������(redefine, replace)�ϴ� ��  
- �޼ҵ� �̸�, �Ķ���� ����, �Ķ���� Ÿ��, ����Ÿ���� ���ƾ� �Ѵ� (�ٸ� body)  
- Java5.0 convariant return type: �������̵����� ����Ÿ���� descendent class type���� �ٲ� �� �ִ� ?  
- acess permission  
	- private���� public���� �ٲٴ� ���� ���� (access ������ ���� �� �ִ�)  
	- public���� private���� �ٲٴ� ���� �Ұ���(access ������ ������ ���� �Ұ�-������ ����)  

### Overriding vs Overloading  
Overloading  
- ���� �޼ҵ� �̸�
- �Ķ���� ���� �Ǵ� Ÿ���� �ݵ�� �޶�� �Ѵ�  
- ��ӹ��� �������� �޼ҵ尡 ����ִ� (��� ����)  

```
public class Employee{
	public void setName(String newName) //������ HourlyEmployee���� ȣ��, ���� ���� 
		name = newName;}
}
public class HourlyEmployee extends Employee{
	//overlading
	public void setName(String firstName, String lastName)
		name = firstName + lastName;}
}
```
## `super()`  
- �θ�Ŭ������ method �ҷ���  
- �ڽ�Ŭ������ constructor ���� ��, super�� �������� ������ �ڵ����� ����  
	- constructor ù�ٿ� super()�� �����ϴ� ����, � Ŭ������ default constuctor�� ����� ���� �ʿ�  

```
public class Parent{
	public Parent(int x){
		//code...
	}
}

public class Child extends Parent{
	public Child(){  //Child�� default constructor
		//code... 	// no super()
	}
}
Child c1 = new Child(); // error
/* super()�� Child()�� �ڵ����� ���ԵǴµ�, Parent�� default constructor�� ���� ������ ȣ�� �Ұ�, ������ ����*/
````

- �ڽ�Ŭ�������� overriding �� super�� Ȱ���� �� �ִ�  

```
public class HourlyEmployee{  //instance variable name, hireDate ��� ���� 
	// code...
	// without super
	public String toString(){
		return(getName() + getHireDate() + wageRate + hours)
	}
	
	// with super
	public String toString(){
		return (super.toString() + wageRate + hours)
	}
```
- super ��ø�� �Ұ��� (�Ѵܰ� ���� base class�� method���� ���� ����)  
	- `super.super.toString() // Error`  
	


## `final`
1. method �տ� final
	- ���� `final public int methodName(int x)`  
	- descendant Ŭ������ �� �޼ҵ� �������̵� �Ұ�  
2. Ŭ���� �տ� final  
	- ���� `final public class Class1`  
	- �� Ŭ������ �ڽ�Ŭ���� ���� �Ұ�
 	  
## Constructor�� �θ��� `this`  
- �ڱ� Ŭ������ �ٸ� constructor�� ȣ��  

```
public class Test{
	private int x;
	
	public Test(){
		this(0); // constructor Test(int x)�� ȣ��
	}
	
	public Test(int x){
		this.x = x	 // �̶� this�� current object�� ����Ŵ  

```
# 7.2 Encapsulation and Inheritance  
## `private` Access  
- base class�� private instance variable  
: base class������ ���� ����  (���� ��Ű������ �ٸ� Ŭ���������� ���� �Ұ���)
: derived class�� ����� �ǳ�, ���ٱ����� ���� -> getter method ��� �ʿ�  

```
public class Employee{
	private String name;
	private Calendar hireDate; 
	//code...
}

class HourlyEmployee extends Employee{
	//code...
	public String toString(){
		return(getName() + getHireDate()) //accessor ��� 
		                                  //�̸����� ���� �� ����!
	}
}
```

## `protected` Access
- base class�� protected instance variables, methods  
: derived class���� ���� ����  
: ��Ӱ��谡 �ƴϴ���, ���� package (���� ����)�� class��� ���� ����  

```
public class Employee{
	protected String name;
	protected Calendar hireDate; 
	//code...
}

class HourlyEmployee extends Employee{
	//code...
	public String toString(){
		return(name + hireDate) //�ٷ� ���� ����
	}
}
```
### �ٸ� package�� Ŭ�������� procted access�� �� �� ������  
```
package one;
public class A{
	protected int x;
}

package two;
import one.A;
public class B extends A{
	public void test1(){
		x = 3; // protected x�� ��ӵǰ�, ���� ����
	}
	public void test2(){
		B object1 = new B();
		object.x = 1; // instance variable�� ��ӹ޾����Ƿ� �ٲٱ� ����
	}
	public void test3(){
		A object2 = new A();
		object2.x = 1; // Error
```

- class A �� B�� �ٸ� package�� �ִ�(B�� A�� ���)  
- class B�� ��ӹ��� x�� B�� instance variable�� ����� �� �����Ӱ� ������ �� �ִ�  
- �׷��� class B�� x�� A�� instance variable�� ����� �� �����ϴ� ���� �Ұ����ϴ�  
- x�� class B�� instance variable�� ��ӵ� ���̴ϱ�!  



## `package` Acccess  
- no access modifier  
- default access, friendly access��� �Ҹ�  
- ���� package �� Ŭ������ ���� ���� 
- �ٸ� package�� �ڽ� Ŭ������ ���� �Ұ��� 
- Ư�� package�� ������ ���� class: default package(unnamed package)�� ���Ѵ�  
	- �ƹ� package�� ���Ѵٰ� �������� �ʱ�  

### `protected` vs `package` Access
- `package` access�� `protected` access ���� ������ ���ϴ�  
	- `package`: ���� package�� class�� ���� ���  
	- `protected`: ���� package�� class or derived class ���� ���  


# 7.3 Programming with Inheritance  
## Class Relationship: is a vs has a  
"is a"  
- derived class (more complex, specific) "is a" base class (more general)  
	- ex. HourlyEmployee is an Employee  

"has a"  
- class "has a" instance variable of a class type  
	```
	public class Employee{
		String name;
		Calendar hireDate; //Calendar type
	}
	```
	- ex. Employee has a Calendar 
	- Calendar class object�� instance variable�� ������

## Class `Object`  
- `Object` class�� �ڹ��� ��� class�� ancestor(Ŭ���� ���������� �ֻ��� ��ġ)  
- package java.lang�� ���� (import �ʿ� x)  
- parameter type�� `Object`�� ���: �ٸ� ��� Ŭ���� Ÿ�� object�� �� �� �ִ�  

### Methods in Class `Object`  
- `Object` class�� ���� methods�� �ڹ��� ��� class�� ��ӹ޴´�  
- ex. `equals`, `toString`  

### equals ����  
`Object`�� ���� equals method header: `public boolean equals(Object other)`  

Overloading: `public boolean equals(Employee other)`  
- �Ķ���� Ÿ���� �ٲ�  
- derived class���� equals method�� 2�� ���� �ȴ�  
- equals�� ��Ȯ�� ������ �����Ƿ�, overloading���ٴ� overriding�� �����ϴ�  

Overriding: `public boolean equals(Object other)`  

```
public boolean equals(Object other){
	if (other == null)
		return false;
	else if(getClass() != other.getClass())
		return false;
	else{
		Employee other = (Employee)other; //typecasting
		return (name.equals(other.name) && hireDate.equals(other.hireDate));
		}
	}
```
- if: object other�� null�� �ƴ��� Ȯ��  
- else if: object other�� ���� class���� Ȯ��  
- else: ���� class���� Ȯ��������, typecasting�� ���� ���ϰ����ϴ� ������ class�� ��ȯ, instance variable ������ ��  

## Instanceof vs getClass()  
- �Ѵ� object�� class�� üũ�ϴ� �� ����  
`instanceof`  
- operator  
- `objectName instanceof className`  
- ���� Ŭ���� �Ǵ� descendant�̸� true, �ƴϸ� false  
- descendant���� ������ �Ǻ�  
<br>
`getClass()`  
- method  
- `objectName.getClass()`
- object�� Ŭ���� id?�� ����  
- descendant ���� x. ���� ������ ���� Ŭ��������   

```
/* HourlyEmployee, SalariedEmployee�� ���� Employee class�� ���
	Employee class object: e1,e2
   HourlyEmployee class object: he1, he2
   Salaried Employee class object: se1, se2 */
  
e1 instanceof Employee //true
he1 instanceof Employee //true
se1 instanceof Employee //true 

e1.getClass() == he1.getClass() //false
e1.getClass() == se1.getClass() //false
e1.getClass() == e2.getClass() //true
```

 