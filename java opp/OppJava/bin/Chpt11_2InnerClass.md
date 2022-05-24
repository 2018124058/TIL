# Chapter11.2 Inner Class  
## Inner Class��  
- �ٸ� Ŭ���� ���ο� ���ǵǴ� Ŭ����  
- inner class�� ���� �ִ� Ŭ������ outer class��� �Ѵ�  
- �ϳ��� outer class ������ inner class �̸��� �ߺ��Ǹ� �ȵȴ�  
- private inner class: outer class �ٱ����� �̸����� ���� �Ұ�  
- inner class�� outer class�� ���� private variables, methods�� ���� �����ϴ�  
- inner class�� ���� outer class�� helper class�� �������� ��ü�� private class�� �����ȴ� 

### inner class�� ���  
- Outer class�� derived class�� inner class�� �ڵ� ����Ѵ�  
- derived class�� inner class ��ü�� overriding �� �� ����  
- outer class, inner class�� �ٸ� Ŭ������ derived class�� �� �ִ�  

### .class File for an Inner Class  
- Java���� class ���� className.class ������ �����ȴ�  
- inner class�� �ִ� ��� �������� .class ������ �����Ǵµ�, outerclassNmae.class �� outerclassName$InnerClassNmae.class ������ innerclass�� .class ���Ͽ��� $�� �ٴ´�  

## Public Inner Class  
- outer class �ܺο��� ���� �����ϳ�, outer class name�� �ٿ����ϴ� ������ �ִ�.  
- inner class�� object�� ���� ������ �켱 outer class�� object�� �ʿ��ϴ�  

```
public class OuterA{
	...
	public class InnerA{...}
}

//object ���� �� 
OuterA obj = new OuterA();
OuterA.InnerA obj2 = obj.new InnerA();
```

## Nesting Inner Classes  
- inner class�ȿ� inner class�� �ִ� ������ ��ø �����ϴ�  
- ���� �� �տ� outer class ���� ��� ���־�� �Ѵ�  

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
- object�� ����µ� class�� �̸��� �ʿ䰡 ���� ��  
- �� ���� variable�� ���� interface�� base class�� object�ε� �ٸ� implementation�� ���� ���� ��   
- class�� ���Ǹ� new operator �ȿ� �ִ´�  

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