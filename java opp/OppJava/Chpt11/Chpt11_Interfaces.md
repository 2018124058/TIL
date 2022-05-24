# Chapter11.1 Interfaces  
## Interface란  
- interface는 method headings와 constant definitions만 가질 수 있다  
	- instance variables, complete method definitions은 가질 수 없다  
	- interface의 method는 모두 abstract method  
- class는 아니지만 abstract class와 유사하다  
- abstract class를 포함해 어떤 class든 interface를 implement할 수 있다  
- interface: base class의 역할  
- interface를 통해 multiple inheritance가 가능하다  
	- 여러개의 interface를 `implements`할 수 있다  
	- abstract class는 multiple interitance 불가능  
  
```
interface interfaceName{
	public static final Type constantName = Value;
	
	public abstract Type methodName(param1, param2,...);
}
```
- constant의 `public static final`은 생략 가능하다 
- method의 `public abstract`은 생략 가능하다  

```
interface interfaceName{
	Type constantName = Value;
	Type methodName(param1, param2...);
}
```

## implementinng an Interface  
- `class className implements interfaceName`  
- interface를 implement한 class는 interface의 method(구현 필요)와 constant를 갖고, 자유롭게 쓸 수 있다. 
- 하지만 interface는 method의 header만 제공할 뿐, method가 어떤 기능을 갖는지는 제약하지 않는다 (interface semantics are not enforced)  
- abstract class가 interface를 implement한 경우, interface의 method를 구현해도 되고 abstract method로 남겨도 된다 (derived class는 구현해야 함)  

```
public interface interface1 {public abstract int add();}

public class class1 implements interface{
	int x; 
	// code 
	public int add(){
		return x + 3;	
  	}
}
```
## Extending an Interface  
- `public interface interface1 extends interface2`  
- interface가 다른 interface를 extend할 때, `implements`가 아닌 `extends` 사용  
- `extends`한 interface가 갖고 있는 abstract method를 갖게 된다  
- interface 간에도 계층구조가 있다  

## `comparable` interface  

## Inconsistent Interfaces  

```
public interface interfaceA {public int getStuff();}
public interface interfaceB {public String getStuff();}

public class YourClass implements InterfaceA, interfaceB{...} //error
```
- YourClass에서 getStuff를 정의해야 하는데 interfaceA와 interfaceB에서 abstract method가 이름은 같고 return type만 다르기 때문에 compiler가 어떤 것을 선택해야 할지 알 수 없어 에러가 난다  

```
public interface InterfaceA {int ANSWER = 42;}
public interface InterfaceB {int ANSWER = 0;}

public class YourClass implements interfaceA, interface B{ int x = ANSWER + 3 } //error
```
- interface마다 constant의 value가 다름 -> `implements`한 class 내에서 해당 constant를 쓰지 않으면 compile error 발생x, 해당 constant를 '사용할 때' error 발생  

## Polymorphism Using Interfaces  
1. interface를 `implements`하는 class의 instance는 해당 interface의 variable에 assign 될 수 있다  
2. interface type이 method의 parameter type이 될 수 있다  
3. interface가 method의 return type이 될 수 있다  

```
interface Fightable{
	public void move(int x, int y);
	public void attack(Fightable f); // 2. interface type이 parameter type
	public Fightable stop(); // 3. interface type이 return type
	
class Fighter implements Fightable{
	public void move(int x, int y){...}
	public void attack(Fightable f){...}
	public Fightable stop(){
	...
	return new Fighter();
	}
}

Fighter f = new Fighter();
// descendent의 constructor로 assign 가능하다 
Fightable f = new Fighter();  
```
 