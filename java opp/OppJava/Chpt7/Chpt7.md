# Chapter 7. Inheritance 상속  
# 7.1 Inheritance Basics  
## inheritance 상속이란  
- 상속: 존재하는 클래스에서 새로운 클래스를 만드는 과정  
- 목적: 클래스의 재사용  
- orginal class 명칭: base class, parent class, super class  
- new class 명칭: derived class, child class, sub class  
- derived class는 base class의 instance variables, methods를 자동으로 물려받는다 (x constructor)
	- private instance variable의 경우 상속되지만 접근할 수 있는 권한은 없다(getter method 이용 필요)  
	- 새로운 instance variables, methods 추가 가능
- static variable도 상속된다  
	- instance varaible과 똑같이 `public`, `private`, `protected`,`package` 적용  
- derived class type의 object는 base class type이기도 하다! 
	 
### Derived class definition  
`class DerivedClassName extends BaseClassName`  
- keyword: `extends`  
	  
### 상속의 계층 구조  
- 위로 갈수록 general, 아래로 갈수록 specific  
- 한 단계 차이나면 parent class와 child class  
- 자신 기준 위쪽 전부는 ancestor, 아랫쪽 전부는 descendant  
- descendant class의 object는 모든 ancestor class type에 속한다(역은 성립x)  

## Overriding a Method Definition  
- overriding: descendant class가 물려받은 method를 재정의(redefine, replace)하는 것  
- 메소드 이름, 파라미터 개수, 파라미터 타입, 리턴타입이 같아야 한다 (다른 body)  
- Java5.0 convariant return type: 오버라이딩에서 리턴타입을 descendent class type으로 바꿀 수 있다 ?  
- acess permission  
	- private에서 public으로 바꾸는 것은 가능 (access 범위를 넓힐 수 있다)  
	- public에서 private으로 바꾸는 것은 불가능(access 범위를 좁히는 것은 불가-컴파일 에러)  

### Overriding vs Overloading  
Overloading  
- 같은 메소드 이름
- 파라미터 개수 또는 타입이 반드시 달라야 한다  
- 상속받은 오리지널 메소드가 살아있다 (사용 가능)  

```
public class Employee{
	public void setName(String newName) //여전히 HourlyEmployee에서 호출, 실행 가능 
		name = newName;}
}
public class HourlyEmployee extends Employee{
	//overlading
	public void setName(String firstName, String lastName)
		name = firstName + lastName;}
}
```
## `super()`  
- 부모클래스의 method 불러옴  
- 자식클래스의 constructor 정의 시, super을 포함하지 않으면 자동으로 들어간다  
	- constructor 첫줄에 super()을 포함하는 습관, 어떤 클래스든 default constuctor을 만드는 습관 필요  

```
public class Parent{
	public Parent(int x){
		//code...
	}
}

public class Child extends Parent{
	public Child(){  //Child의 default constructor
		//code... 	// no super()
	}
}
Child c1 = new Child(); // error
/* super()이 Child()에 자동으로 포함되는데, Parent에 default constructor가 없기 때문에 호출 불가, 컴파일 에러*/
````

- 자식클래스에서 overriding 시 super을 활용할 수 있다  

```
public class HourlyEmployee{  //instance variable name, hireDate 상속 받음 
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
- super 중첩은 불가능 (한단계 위의 base class의 method에만 접근 가능)  
	- `super.super.toString() // Error`  
	


## `final`
1. method 앞에 final
	- 예시 `final public int methodName(int x)`  
	- descendant 클래스가 이 메소드 오버라이딩 불가  
2. 클래스 앞에 final  
	- 예시 `final public class Class1`  
	- 이 클래스로 자식클래스 생성 불가
 	  
## Constructor을 부르는 `this`  
- 자기 클래스의 다른 constructor을 호출  

```
public class Test{
	private int x;
	
	public Test(){
		this(0); // constructor Test(int x)를 호출
	}
	
	public Test(int x){
		this.x = x	 // 이때 this는 current object를 가리킴  

```
# 7.2 Encapsulation and Inheritance  
## `private` Access  
- base class의 private instance variable  
: base class에서만 접근 가능  (같은 패키지여도 다른 클래스에서는 접근 불가능)
: derived class에 상속은 되나, 접근권한이 없다 -> getter method 사용 필요  

```
public class Employee{
	private String name;
	private Calendar hireDate; 
	//code...
}

class HourlyEmployee extends Employee{
	//code...
	public String toString(){
		return(getName() + getHireDate()) //accessor 사용 
		                                  //이름으로 접근 시 에러!
	}
}
```

## `protected` Access
- base class의 protected instance variables, methods  
: derived class에서 접근 가능  
: 상속관계가 아니더라도, 같은 package (같은 폴더)의 class라면 접근 가능  

```
public class Employee{
	protected String name;
	protected Calendar hireDate; 
	//code...
}

class HourlyEmployee extends Employee{
	//code...
	public String toString(){
		return(name + hireDate) //바로 접근 가능
	}
}
```
### 다른 package의 클래스에서 procted access를 할 때 유의점  
```
package one;
public class A{
	protected int x;
}

package two;
import one.A;
public class B extends A{
	public void test1(){
		x = 3; // protected x가 상속되고, 접근 가능
	}
	public void test2(){
		B object1 = new B();
		object.x = 1; // instance variable을 상속받았으므로 바꾸기 가능
	}
	public void test3(){
		A object2 = new A();
		object2.x = 1; // Error
```

- class A 와 B는 다른 package에 있다(B가 A를 상속)  
- class B는 상속받은 x를 B의 instance variable로 사용할 때 자유롭게 접근할 수 있다  
- 그러나 class B가 x를 A의 instance variable로 사용할 때 접근하는 것은 불가능하다  
- x는 class B의 instance variable로 상속된 것이니까!  



## `package` Acccess  
- no access modifier  
- default access, friendly access라고도 불림  
- 같은 package 내 클래스면 접근 가능 
- 다른 package의 자식 클래스면 접근 불가능 
- 특정 package에 속하지 않은 class: default package(unnamed package)에 속한다  
	- 아무 package에 속한다고 착각하지 않기  

### `protected` vs `package` Access
- `package` access가 `protected` access 보다 제약이 강하다  
	- `package`: 같은 package의 class만 접근 허용  
	- `protected`: 같은 package의 class or derived class 접근 허용  


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
	- Calendar class object를 instance variable로 가진다

## Class `Object`  
- `Object` class는 자바의 모든 class의 ancestor(클래스 계층구조의 최상위 위치)  
- package java.lang에 포함 (import 필요 x)  
- parameter type이 `Object`인 경우: 다른 모든 클래스 타입 object가 들어갈 수 있다  

### Methods in Class `Object`  
- `Object` class가 가진 methods는 자바의 모든 class가 상속받는다  
- ex. `equals`, `toString`  

### equals 정의  
`Object`가 가진 equals method header: `public boolean equals(Object other)`  

Overloading: `public boolean equals(Employee other)`  
- 파라미터 타입을 바꿈  
- derived class에서 equals method를 2개 갖게 된다  
- equals의 명확한 목적이 있으므로, overloading보다는 overriding이 적합하다  

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
- if: object other이 null이 아닌지 확인  
- else if: object other이 같은 class인지 확인  
- else: 같은 class인지 확인했으니, typecasting을 통해 비교하고자하는 층위의 class로 변환, instance variable 같은지 비교  

## Instanceof vs getClass()  
- 둘다 object의 class를 체크하는 데 쓰임  
`instanceof`  
- operator  
- `objectName instanceof className`  
- 같은 클래스 또는 descendant이면 true, 아니면 false  
- descendant까지 포함해 판별  
<br>
`getClass()`  
- method  
- `objectName.getClass()`
- object의 클래스 id?를 리턴  
- descendant 포함 x. 같은 층위의 같은 클래스인지   

```
/* HourlyEmployee, SalariedEmployee는 각각 Employee class를 상속
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

 