#Chapter4 Defining Class (1)
#4.1 Class Definition
## class  
- 자바의 객체지향 프로그래밍에서 가장 중요한 것  
- 자바는 모든 프로그램이 하나의 클래스다. 자바의 프로그래밍은 클래스들을 정의하는 것과 같다 

### Primitive Type vs Class Type (Reference Type)  
primitive type
-  value: a single piece of data
-  ex. int, double, char, boolean...  
class type(reference type, 참조형)
-  value is called 'object'  
-  object는 instance variables(data)와 methods(actions)를 갖는다  
 
### Class and Object  
same class에서 나온 objects는 같은 method, instance variables를 갖는다  
그러나 서로 다른 objects는 same variable에 different values를 가질 수 있다  

object 생성: new operator 활용 -> reference 주소를 갖게된다  
`className objectName = new className()`  
instance variables(data items)에 접근 `objectName.varName`  
methods 부르기 `objectName.methodName()`  
accessing class members inside the class: without classname ex. 그냥 method() 이름만 써서 부르기  

### Aceess modifier: public vs private  
public: 아무나
private: private...  
-  public class 아래에도 private variable이 정의될 수 있다 클래스 종류랑 다른 얘기인듯 

### Multiple Classes  
-  다른 파일에 있는 클래스를 활용할 수 있다 
-  public class: 한 소스코드당 한 개만. 아무나 활용 가능
-  package class: public x. package 안의 class만 활용 가능. 다른 package class면 안보임  
-  자바: 대부분 소스코드 하나당 클래스 하나 
  - 소스코드들 사이에서 클래스 찾기 쉬움 + 클래스 재사용 용이 
-  그럼에도 한 파일에 여러 클래스를 정의할 수 있다 (public class는 1개만) 

### Local Variables & Instance Variable  
- 자바: local variable(지역 변수), instance variable
    -  NO global variable
  
- local variable
    - method definition 안에 정의된 변수
    - 모든 method parameter는 local variables
    - block안에서 정의 가능하다 (반복문 for block 등)
    -  그 local 안에서만 활용 가능하다!
- instance variable: 같은 class에서 생성된 object들이 공통적으로 갖는다 

```
public class Test{
	public static void main(String[] args){
		int a = 5; //a는 local variable in main
		for (int k=0, k<5; k++({ //k는 local variable in for
			int a = k + 1 // Error! a는 main의 지역변수로 이미 정의되어있음
			System.out.println(k);}
		System.out.println(k); // Error! k는 for의 지역변수 
     }
}
```

### Method
#### Method 종류  
return type: return a value, value type을 method 이름 앞에 명시해준다
 -  return값을 받아 할당하지 않아도 컴파일 에러x
 -  예시 
 
```
public int add(int x){
	x+1}
```
void type: no return value, method 이름 앞에 void  

```
public void printe(int x){
	System.out.println("hello" + x);}
```
#### main method가 있는 class의 다른 methods  
-  main method: static method
-  static에서는 static만 부를 수 있다
--> main method가 호출하는 method 역시 static 이어야 한다 

#### actual parameter vs formal parameter  
-  actual parameter
  -  다른 method를 호출하는 쪽이 쓰는 parameter. value를 갖고 있다? 실제 변수를 가리킴?
-  formal parameter 
  -  호출 당하는 method의 파라미터. 변수 이름은 달라질 수 있음 
  -  실제 값을 나타내는 것이 아니라 copy, 다른 메모리 스페이스에 있는 것을 나타냄?? value가 아직 없다?

#### Automatic Type Conversion: Primitive Type Parameters
-  actual parameter가 formal parameter로 copy될 때, 자동으로 형 변환된다  
-  formal aprameter가 더 큰 범위일 때
  -  auto conversion rule: byte,char->short->int->long->float->double

```
public class Test{
	public static void main(String[]args){
		int a=1,b=2,c=3; // local variables
		double result = myMethod(a,b,c); 
		//myMethod must be static // actual parameter: a,b,c
		//자동 형변환-> c가 int지만 return 값은 double 
	}
	static double myMethod(int a , int b, double c) 
	//formal parameter: a,b,c
	{return a+b+c;}
}
```

#### this parameter
-  instance variable name과 parameter(=local variable) name이 같을 때 local에서 instance variable이 가려진다  
-  this.variableName은 instance variable을 가리킨다 
-  instance variable과 parameter 이름을 같게 하고 this parameter을 쓰는 편이 가독성이 좋다 

```
class MyDate{
	int year; // instance variable
	String month;
	int day;
	void setMyDate(int newYear, String month, int day){ // local variable
	year = newYear;
	this.month = month; //this parameter
	this.day = day;}
}
```

#### method eqauals and toString  
자바: equals, toString 등 특정 methods가 대부분의 class에 존재한다고 가정, 그에 따른 기능이 있음 

- equals
 `public boolean equals(ClassName object Name)`
  - 두 객체의 내용이 같은지를 boolean값으로 리턴 
  -  reference를 비교하는 것이 아님 (no ==)  
- toString
`public String toString()`
  -  객체의 주요 내용을 String으로 바꿔 리턴 
  -  System.out.println(objectName)하면 toString method가 자동으로 호출되어 String 값을 리턴함 
  


