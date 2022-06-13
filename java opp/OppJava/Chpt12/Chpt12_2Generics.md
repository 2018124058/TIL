# Chpt12.2 Generics  
## Generics  
- type 파라미터를 갖는 class나 method  
- type 파라미터: reference type(class type), `<type>` 형태  
	- 특정한 타입이 파라미터로 들어가면, specific classs type이나 method를 생성한다
	- ex. Integer type ArrayList와 String type ArrayList는 다른 클래스로 취급된다  
	- 타입 파라미터로 하나의 대문자를 주로 써왔으나, 어떤 것이든 상관없다  
	- <>안에 어떤 type이 들어갈지 지정할 수 있다 (general)  
	- Primitive type은 들어갈 수 없다 -> wrapper class를 사용해야 함, automatic boxing 작동. (`int`, `double`, `char` -> `Integer`, `Double`, `Character`)
	- cf. array는 reference type  
	- 하나의 generic 안에 여러 개의 type 파라미터를 사용할 수 있다  
	- generic class는 exception class가 될 수 없다    
	
```
public class Sample<T> { // type parameter
	private T data;
	
	public Sample(T data){ // constructor
		this.data = data;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	public T getData(){ // return type이 T 
		return data;
	}
}

Sample<String> obj1 = new Sample<String>(); // String type
obj1.setData("Hello");  // this.data = "Hello";

Sample<Person> obj2 = new Sample<Person>(); // Person이라는 class type
Person p = new Person();
obj2.setData(p); // Person class type이 파라미터로 들어가야 함 
```

- constructor: `<T>`가 사용되지 않는다 ex. `public Sample(T data)`  
- instantiation(object 생성): `<Type>` 필요 ex. `Sample<String> obj1 = new Sample<String>("hi");`  

### Pitfall  
#### 1. type parameter가 언제든 사용되는 것은 아님  
```
T object = new T(); // 에러  
T[] a = new T[10]; // 에러
```
- `T`가 어떤 type인지 정해지지 않은 상태에서 new로 object를 생성하거나 array를 만드는 것은 불가능  

#### 2. An instantiation of a generic class cannot be an array base type  
`Sample<String>[] a = new Sample<String>[10]; // 에러`  
- array를 만들 수는 없다: type이 무엇이 될지 모르기 때문에 메모리를 준비할 수 없어서   

## Bounds for Type parameter  
- type parameter에 제한 두기  
- ex. `public class Sample <T extends Comparable>`: Comparable interface를 extends 해 compareTo method를 갖고 있는 클래스 타입만 타입 파라미터로 올 수 있다  
	- interface지만 bound 시 `extends`를 사용한다  
- ex. `public class Sample <T1 extends Class1, T2 extends Class2 & Comparable>`  
	- T1은 Class1의 descendent class만 가능  
	- T2는 Class2의 descendent이면서 Comparable interface를 implements한 것만 가능  

## Generic Interface  
- type 파라미터를 하나 이상 갖고 있는 interface  

## Generic Methods  
- its own type parameter that is not the type parameter of any class  
- generic method는 다른 type parameter를 가진 generic class 뿐만 아니라 일반 class에 포함될 수 있다  
- generic method의 type parameter는 해당 method의 local, 다른 클래스나 method에 영향  

```
public class Sample2{ // generic class가 아님
	// generic method
	public static <T> T getMidpoint(T[] a) {
		return a[0];
	}
} 

// method 호출: <Type> 필요  
String str = Sample2.<String>getMidpoint(a); // static method는 class name으로 호출 가능  
Double d = Sample2.<Double>getMidpoint(b); 
```

```
public class Sample3<T>{ // generic class 
	private T data;
	
	public Sample3(T data){this.data = data;}
	
	public <T2> void show(T2 obj){
		System.out.println(obj + data);
	}
}

// method 호출: <Type> 필요 
Sample3<Integer> obj = new Sample3<Integer>(20);
obj.<String>show("hey"); // output: hey20
```
