# Chapter11.1 Interfaces  
## Interface��  
- interface�� method headings�� constant definitions�� ���� �� �ִ�  
	- instance variables, complete method definitions�� ���� �� ����  
	- interface�� method�� ��� abstract method  
- class�� �ƴ����� abstract class�� �����ϴ�  
- abstract class�� ������ � class�� interface�� implement�� �� �ִ�  
- interface: base class�� ����  
- interface�� ���� multiple inheritance�� �����ϴ�  
	- �������� interface�� `implements`�� �� �ִ�  
	- abstract class�� multiple interitance �Ұ���  
  
```
interface interfaceName{
	public static final Type constantName = Value;
	
	public abstract Type methodName(param1, param2,...);
}
```
- constant�� `public static final`�� ���� �����ϴ� 
- method�� `public abstract`�� ���� �����ϴ�  

```
interface interfaceName{
	Type constantName = Value;
	Type methodName(param1, param2...);
}
```

## implementinng an Interface  
- `class className implements interfaceName`  
- interface�� implement�� class�� interface�� method(���� �ʿ�)�� constant�� ����, �����Ӱ� �� �� �ִ�. 
- ������ interface�� method�� header�� ������ ��, method�� � ����� �������� �������� �ʴ´� (interface semantics are not enforced)  
- abstract class�� interface�� implement�� ���, interface�� method�� �����ص� �ǰ� abstract method�� ���ܵ� �ȴ� (derived class�� �����ؾ� ��)  

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
- interface�� �ٸ� interface�� extend�� ��, `implements`�� �ƴ� `extends` ���  
- `extends`�� interface�� ���� �ִ� abstract method�� ���� �ȴ�  
- interface ������ ���������� �ִ�  

## `comparable` interface  

## Inconsistent Interfaces  

```
public interface interfaceA {public int getStuff();}
public interface interfaceB {public String getStuff();}

public class YourClass implements InterfaceA, interfaceB{...} //error
```
- YourClass���� getStuff�� �����ؾ� �ϴµ� interfaceA�� interfaceB���� abstract method�� �̸��� ���� return type�� �ٸ��� ������ compiler�� � ���� �����ؾ� ���� �� �� ���� ������ ����  

```
public interface InterfaceA {int ANSWER = 42;}
public interface InterfaceB {int ANSWER = 0;}

public class YourClass implements interfaceA, interface B{ int x = ANSWER + 3 } //error
```
- interface���� constant�� value�� �ٸ� -> `implements`�� class ������ �ش� constant�� ���� ������ compile error �߻�x, �ش� constant�� '����� ��' error �߻�  

## Polymorphism Using Interfaces  
1. interface�� `implements`�ϴ� class�� instance�� �ش� interface�� variable�� assign �� �� �ִ�  
2. interface type�� method�� parameter type�� �� �� �ִ�  
3. interface�� method�� return type�� �� �� �ִ�  

```
interface Fightable{
	public void move(int x, int y);
	public void attack(Fightable f); // 2. interface type�� parameter type
	public Fightable stop(); // 3. interface type�� return type
	
class Fighter implements Fightable{
	public void move(int x, int y){...}
	public void attack(Fightable f){...}
	public Fightable stop(){
	...
	return new Fighter();
	}
}

Fighter f = new Fighter();
// descendent�� constructor�� assign �����ϴ� 
Fightable f = new Fighter();  
```
 