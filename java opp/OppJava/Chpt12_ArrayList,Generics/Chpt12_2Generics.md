# Chpt12.2 Generics  
## Generics  
- type �Ķ���͸� ���� class�� method  
- type �Ķ����: reference type(class type), `<type>` ����  
	- Ư���� Ÿ���� �Ķ���ͷ� ����, specific classs type�̳� method�� �����Ѵ�
	- ex. Integer type ArrayList�� String type ArrayList�� �ٸ� Ŭ������ ��޵ȴ�  
	- Ÿ�� �Ķ���ͷ� �ϳ��� �빮�ڸ� �ַ� �������, � ���̵� �������  
	- <>�ȿ� � type�� ���� ������ �� �ִ� (general)  
	- Primitive type�� �� �� ���� -> wrapper class�� ����ؾ� ��, automatic boxing �۵�. (`int`, `double`, `char` -> `Integer`, `Double`, `Character`)
	- cf. array�� reference type  
	- �ϳ��� generic �ȿ� ���� ���� type �Ķ���͸� ����� �� �ִ�  
	- generic class�� exception class�� �� �� ����    
	
```
public class Sample<T> { // type parameter
	private T data;
	
	public Sample(T data){ // constructor
		this.data = data;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	public T getData(){ // return type�� T 
		return data;
	}
}

Sample<String> obj1 = new Sample<String>(); // String type
obj1.setData("Hello");  // this.data = "Hello";

Sample<Person> obj2 = new Sample<Person>(); // Person�̶�� class type
Person p = new Person();
obj2.setData(p); // Person class type�� �Ķ���ͷ� ���� �� 
```

- constructor: `<T>`�� ������ �ʴ´� ex. `public Sample(T data)`  
- instantiation(object ����): `<Type>` �ʿ� ex. `Sample<String> obj1 = new Sample<String>("hi");`  

### Pitfall  
#### 1. type parameter�� ������ ���Ǵ� ���� �ƴ�  
```
T object = new T(); // ����  
T[] a = new T[10]; // ����
```
- `T`�� � type���� �������� ���� ���¿��� new�� object�� �����ϰų� array�� ����� ���� �Ұ���  

#### 2. An instantiation of a generic class cannot be an array base type  
`Sample<String>[] a = new Sample<String>[10]; // ����`  
- array�� ���� ���� ����: type�� ������ ���� �𸣱� ������ �޸𸮸� �غ��� �� ���   

## Bounds for Type parameter  
- type parameter�� ���� �α�  
- ex. `public class Sample <T extends Comparable>`: Comparable interface�� extends �� compareTo method�� ���� �ִ� Ŭ���� Ÿ�Ը� Ÿ�� �Ķ���ͷ� �� �� �ִ�  
	- interface���� bound �� `extends`�� ����Ѵ�  
- ex. `public class Sample <T1 extends Class1, T2 extends Class2 & Comparable>`  
	- T1�� Class1�� descendent class�� ����  
	- T2�� Class2�� descendent�̸鼭 Comparable interface�� implements�� �͸� ����  

## Generic Interface  
- type �Ķ���͸� �ϳ� �̻� ���� �ִ� interface  

## Generic Methods  
- its own type parameter that is not the type parameter of any class  
- generic method�� �ٸ� type parameter�� ���� generic class �Ӹ� �ƴ϶� �Ϲ� class�� ���Ե� �� �ִ�  
- generic method�� type parameter�� �ش� method�� local, �ٸ� Ŭ������ method�� ����  

```
public class Sample2{ // generic class�� �ƴ�
	// generic method
	public static <T> T getMidpoint(T[] a) {
		return a[0];
	}
} 

// method ȣ��: <Type> �ʿ�  
String str = Sample2.<String>getMidpoint(a); // static method�� class name���� ȣ�� ����  
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

// method ȣ��: <Type> �ʿ� 
Sample3<Integer> obj = new Sample3<Integer>(20);
obj.<String>show("hey"); // output: hey20
```
