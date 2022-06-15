# Chapter11.2 Inner Class  
## Inner Class란  
- 다른 클래스 내부에 정의되는 클래스  
- inner class를 갖고 있는 클래스를 outer class라고 한다  
- 하나의 outer class 내에서 inner class 이름이 중복되면 안된다  
- private inner class: outer class 바깥에서 이름으로 접근 불가  
- inner class와 outer class는 서로 private variables, methods에 접근 가능하다  
- inner class는 보통 outer class의 helper class의 역할으로 대체로 private class로 설정된다 

### inner class와 상속  
- Outer class의 derived class는 inner class도 자동 상속한다  
- derived class는 inner class 자체를 overriding 할 수 없다  
- outer class, inner class는 다른 클래스의 derived class일 수 있다  

### .class File for an Inner Class  
- Java에서 class 마다 className.class 파일이 생성된다  
- inner class가 있는 경우 여러개의 .class 파일이 생성되는데, outerclassNmae.class 와 outerclassName$InnerClassNmae.class 식으로 innerclass의 .class 파일에는 $가 붙는다  

## Public Inner Class  
- outer class 외부에서 접근 가능하나, outer class name을 붙여야하는 제약이 있다.  
- inner class의 object를 만들 때에도 우선 outer class의 object가 필요하다  

```
public class OuterA{
	...
	public class InnerA{...}
}

//object 생성 시 
OuterA obj = new OuterA();
OuterA.InnerA obj2 = obj.new InnerA();
```

## Nesting Inner Classes  
- inner class안에 inner class를 넣는 식으로 중첩 가능하다  
- 접근 시 앞에 outer class 명을 모두 써주어야 한다  

```
public class A{
	public class B{
		public class C{}
	}
}

A aObject = new A();
A.B bObject = aObject.new B();
A.B.C cObject = bObject.new C();
```

## Anonymous Classes  
- object를 만드는데 class의 이름은 필요가 없을 때  
- 두 개의 variable이 같은 interface나 base class의 object인데 다른 implementation을 갖고 있을 때   
- class의 정의를 new operator 안에 넣는다  

```
ClassA obj1 = new ClassA(){
	// class definition  
	private int number;
	public int add(){
		return number + 3;
	}
}

classA obj2 = new ClassA(){
	private int number;
	public int add(){ 
		return number + 100; //different method 
	}
}
``` 