# Chapter 8. Polymorphism and Abstract Class  
# 8.1 Polymorphism  
## Polymorphism  
- manipulating descendant class' object through ancestor class' reference variable  
- through a mechanism called: late binding or dynamic binding  
## Binding  
- Binding: process of associating a method definition with a method invocation  
### Early Binding  
- binding occurs when the code is compiled 
- compile time에 고정 
- java: only private, final, static methods에서 사용  

### Late Binding(Dynamic Binding)
- binding occurs when the method is invoked (at runtime)  
- java: 나머지 메소드들에서 사용  
- 예시  (추가 예시: Chpt8_2Binding 소스코드) 

```
class Product{
	public String toString(){return "product"}
}	
class TV extends Product{
	public String toString(){return "tv"}
}	

public class Test{
	public static void main(String[]args){
		Product p = new Product();
		TV t = new TV();
		foo(p);
		foo(t);
	}
	static void foo(Product pr){print(pr)}
}
```
	- late binding -> foo에 argument로 TV class object가 오면 late binding이 발생해 TV class의 toString method가 호출된다. 
	- late binding: binding이 run time에 일어난다.class에 맞는 함수 호출 (<-> binding이 compile time에 발생해 Product의 method로 고정되면, TV의 method가 호출되지 않는다)  
	- 어떤 것이 파라미터로 패싱되느냐에 따라 호출되는 method가 달라진다 = dynamic binding(=late binding)  

## Upcasting and Downcasting  
upcasting: 트리구조 상 아래에 있는 클래스(descendant)를 위의 클래스(ancestor)로 assign  
downcasting: 상위클래스(ancestor)을 하위클래스(descendant)에 assign  
- downcasting의 문제점  
	- typecasting을 통해 assign 자체는 가능하다 (runtime error 발생 가능)  
	- `=`만으로 assign하면 compile error   
	- 하위클래스가 보통 상위클래스보다 더 많은 변수와 메소드를 갖고 있다 -> 이에 access할 때 에러 방생 가능  
	- 원칙적으로 불가능하다  
```
Sale s = new Sale(); //base class
DiscountSale d = new DiscountSale();//derived class

s = d; //Upcasting is ok  
System.out.println(s); //late binding에 의해 DiscountSale의 toString이 호출된다  

d = (DiscountSale)s; //Downcasting: 에러가능성
d = s; // compile error! 
```

### Downcasting이 필요할 때: 안전하게 Downcasting하기  
예시 

```
public class Sale{
	public boolean equals(Object other){
		if (other == null) return false;
		else if (getClass() != other.getClass())
			returnn false;
		else{
			Sale otherSale = (Sale)other; //Downcasting: Object -> Sale
			return(name.equals(otherSale.name));} //Sale은 instance variable로 name만 갖고있다는 전제  
	}
}
```
- Object type을 파라미터로 받는 Sale class의 equals method: 우선 비교대상인 Object other이 Sale class인지 확인한 후, Sale class일 경우 타입캐스팅을 통해 Sale class type으로 만들어준 후 instance variable을 비교해야 한다(Object class에는 Sale class의 instance variable이 없기 때문)  
- 이미 Other object가 Sale class의 object라는 것을 검증한 후 타입캐스팅했기 때문에 안전한 downcasting이다!  
- 검증 방법  
	- `getClass()` method : descendant 포함 x   
	- `instanceof` operator : descendant인 경우에도 true  
	
## clone method  
  
