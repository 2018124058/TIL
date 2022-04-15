# Chapter 7. Inheritance 상속  
# 7.1 Inheritance Basics  
## inheritance 상속이란  
- 상속: 존재하는 클래스에서 새로운 클래스를 만드는 과정  
- 상속의 목적: 클래스의 재사용  
- orginal class 명칭: base class, parent class, super class  
- new class 명칭: derived class, child class, sub class  
	- derived class는 base class의 instance variables, methods를 자동으로 물려받는다 (no static variable)  
	- 새로운 instance variables, methods 추가 가능  
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
- super()을 포함하는 습관, 어떤 클래스든 default constuctor을 만드는 습관 필요  

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


	