# Chapter5 Defining Class (2)  
# 5.1 Static Methods and Variables  

## Class Static Area vs Heap Area  
자바의 메모리 구조
  
  class static area(= class area, method area)
- object를 만들기 전, class 이름을 쓰는 순간 만들어지는 area
- static methods, static variables 포함 


heap area  
- instances (각각의 methods, instance variables) 포함  


## Static Method  
- method header에 static 붙는다  
` public static returnedType methodName()`  
- object를 호출하지 않고, class name으로 method를 호출 가능하다! `classname.method` (objectName으로도 가능)
     - object 생성 없이 method를 호출가능해 편리하나, 모든 method를 static으로 만드는 건 좋지 않다 
    -   예시  
`Math.random(); // Math는 class name`  
`System.exit(0); // System은 class name`  
    - static이 아닌 method는 objectname으로 호출 `objectname.method`
- class static area에 속한다  
    - instance variable refer(참조) 불가 (class area: 객체 변수 보이지 않음) / static variable은 사용 가능 
    - non-static method 호출 불가 / static method끼리는 호출 가능 
        - `public static void main(String[] args)`도 static method기 때문에 static method만 호출 가능
    - this parameter 사용 불가
    - class area에 위치하기 때문에 static method에서는 instance가 만들어지지 않는다  

#### cf. named constant(상수)
- 재정의가 불가능한, 값이 변하지 않는 변수
- final 이용 `final valType valName;`

## Static Variables  
- 정의할 때 동시에 initialize, 값을 할당해주는 것이 좋다  
    - initialize x: 자동으로 default value 할당됨
       - default value: boolean은 false, other primitive types은 그 타입의 0, class type은 null
- 언제나 private로 정의된다 (constant 제외!)  
- static variable은 className으로 access 가능   
- static method, non-static method 둘다 static variable에 접근 가능

```
public static final int YEAR = 2022; //constant  
int currentYear = MyClass.YEAR;     // classname으로 access
```

## Wrapper Classes
wrapper class: 각각의 primitive types의 class type
- primitive type에는 method, instance variable 없음 -> wrapper class가 불편을 해결
- Byte, Short, Integer, Long, Float, Double, Character 
- predefined constants, static methods 보유  
    - constants in wrapper class
      - `Boolean.TRUE` and `Boolean.FALSE`
      - MIN_VALUE, MAX_VALUE 
      `Interger.MAX_VALUE // Interger에서 가장 큰 값`
      `Double.MIN_VALUE   // Double에서 가장 작은 값`
    - static methods in wrapper class   
       - 타입 변환 `className.parseType(arg);`  
       - 문자열로 변환 `className.toString(arg);`
       
       ```
       int i = Integer.parseInt("365"); // 365
       double d = Double.parseDouble("365.0");//365.0 
		String str = Double.toString(2.0); // "2.0"
		```
#### Character class의 methods 
static methods 
- `Character.toUpperCase(char arg)` 대문자 변환  
- `Character.toLowerCase(char arg)` 소문자 변환
- `Character.isUpperCase(char arg)` 대문자인지 확인. 반대는 isLowerCase
- `Character.isWhitespacce(char arg)` withespace(' ', '\t','\n' 등 포함)인지 확인  
-  `Character.isLetter(char arg)` letter인지 확인 (숫자, 특수문자는 false)  
- `Character.isDigit(char arg)` 숫자인지 확인
- `Character.isLetteerOrDigit(char arg)` 알파벳, 숫자만 true, 특수문자는 false

		
#### Boxing
- primitive type -> wrapper class로 바꿔줌
- new 없이 assignment(할당)을 통해 auto boxing  

```
Byte bObj = 5; // Byte class(wrapper class)의 object 생성됨
Character cObj = 'a';
```
#### Unboxing
- wrapper class -> primitive type 
- 방법 1) dedicated conversion method 사용  
		bytevalue(), shortValue(), intValue(), floatValue(), doubleValue(), charValue() 
	
	```
	byte b = bObj.byteValue();
	char c = cObj.charValue();
	```
- 방법 2) assignment를 통한 auto unboxing (주로 사용됨)  
	
	```
	byte b = bObj;
	char c = cObj;
	```

## Class Math 
- java.lang package 포함, import 불필요  
- static methods, static variables만 갖고있다  
- 2 predefined constants: E, PI
- static methods
	- `Math.pow(double base, double exponent)` base의 exponent 제곱 리턴  
	- `Math.abs (type arg)` 절댓값 리턴  
	- `Math.min(type arg1, type arg2)` 둘 중 작은 것을 리턴 (반대는 method max)  
	- `Math.round(type arg)` 반올림  
	- `Math.floor(type arg)` 버림   
	- `Math.ceil(type arg)` arg보다 큰 수 중 가장 작은 정수 리턴  
	- `Math.sqrt(type arg)` square root(루트 씌운 값) 리턴 

# 5.2 References and Class Parameters  
## 컴퓨터 메모리  
### 1. Main memory  
	
- 프로그램을 디스크로부터 로드해 실행할 때 사용. 프로그램의 variables 저장 
-주기억장치, 램(ram)이라고도 부름  
- class area(=method area), stack area, heap area, native method stack area, pc register로 나뉜다  
- bytes로 구성된 긴 리스트, 서로 다른 크기의 memory location의 리스트라 볼 수 있다.
- 1 byte는 8 bits를 포함 (0 or 1 digit)
- byte를 구분하는 숫자: address
- data item은 하나 이상의 bytes에 저장된다.  
  그 공간을 memory location이라 부름.  
  memory location의 첫 번째 byte의 address가 address of data item  
  data item에 access할 때 address가 이용된다 
	
### 2. Secondary memory  
  - 보조기억장치
  - permanent storage. 파일을 갖고 있다. 흔히 말하는 디스크.   

## Reference Type = Class Type  
- class type의 variable
	- reference: object가 위치한 memory location  
	- class type variable은 모두 reference를 가진다  
	- value가 memory location(reference)이다  
	  <->primitive type variable: value로 값을 가짐(메모리를 찾아가면 바로 value에 access 가능) 
	- object가 new로 생성될 때 main memory의 heap area에 address 부여  
- `object1 = object2` 
	- object2의 address가 복사되어 object1에 할당
	- object1과 2는 같은 메모리 공간을 가리키게 된다
	- object1의 instance variable value가 바뀌면 2도 바뀌는 것
	  
## Parameters  
- 자바의 모든 파라미터는 call-by-value parameter
	- method를 호출했을 때, method 안에서 파라미터(formal parameter) 값을 바꿔도 호출한 쪽의 actual parameter은 바뀌지 않는다.
- class type parameter
	- call-by-reference parameter와 비슷한 작동 방식  
	- 파라미터의 값을 바꾸면 호출한 쪽에서도 같이 바뀐다.  
	- 파라미터가 클래스 타입, object인 경우  

```
//parameters of primitive types
// int x 는 primitive type
public class Test{
	static void trytoChange(int x)
	{x=3;}
	
	public staic void main(String[]args{
	int x = 1;
	tryToChange(x);
	System.out.println(x);}
} // output: 1 (actual parameter 바뀌지 않음)
```

# 5.3 딥카피  
- privacy leak 방지  
- 같은 객체변수를 갖는 새로운 object를 만들 때, 객체 변수 타입이 class면 객체변수를 새로 생성한다  
- copy constructor  

```
public Person(Person original)
{
  if (original == null)
  {
    System.out.println("Fatal error.");
    System.exit(0);
  }
  name = original.name;
  born = new Date(original.born);
  if (original.died == null)
    died = null;
  else
    died = new Date(original.died);
```

    