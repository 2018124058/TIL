# Chapter 7. Inheritance ���  
# 7.1 Inheritance Basics  
## inheritance ����̶�  
- ���: �����ϴ� Ŭ�������� ���ο� Ŭ������ ����� ����  
- ����� ����: Ŭ������ ����  
- orginal class ��Ī: base class, parent class, super class  
- new class ��Ī: derived class, child class, sub class  
	- derived class�� base class�� instance variables, methods�� �ڵ����� �����޴´� (no static variable)  
	- ���ο� instance variables, methods �߰� ����  
	- derived class type�� object�� base class type�̱⵵ �ϴ�!  
### Derived class definition  
`class DerivedClassName extends BaseClassName`  
- keyword: `extends`  
	  
### ����� ���� ����  
- ���� ������ general, �Ʒ��� ������ specific  
- �� �ܰ� ���̳��� parent class�� child class  
- �ڽ� ���� ���� ���δ� ancestor, �Ʒ��� ���δ� descendant  
- descendant class�� object�� ��� ancestor class type�� ���Ѵ�(���� ����x)  

## Overriding a Method Definition  
- overriding: descendant class�� �������� method�� ������(redefine, replace)�ϴ� ��  
- �޼ҵ� �̸�, �Ķ���� ����, �Ķ���� Ÿ��, ����Ÿ���� ���ƾ� �Ѵ� (�ٸ� body)  
- Java5.0 convariant return type: �������̵����� ����Ÿ���� descendent class type���� �ٲ� �� �ִ� ?  
- acess permission  
	- private���� public���� �ٲٴ� ���� ���� (access ������ ���� �� �ִ�)  
	- public���� private���� �ٲٴ� ���� �Ұ���(access ������ ������ ���� �Ұ�-������ ����)  

### Overriding vs Overloading  
Overloading  
- ���� �޼ҵ� �̸�
- �Ķ���� ���� �Ǵ� Ÿ���� �ݵ�� �޶�� �Ѵ�  
- ��ӹ��� �������� �޼ҵ尡 ����ִ� (��� ����)  

```
public class Employee{
	public void setName(String newName) //������ HourlyEmployee���� ȣ��, ���� ���� 
		name = newName;}
}
public class HourlyEmployee extends Employee{
	//overlading
	public void setName(String firstName, String lastName)
		name = firstName + lastName;}
}
```
## `super()`  
- �θ�Ŭ������ method �ҷ���  
- �ڽ�Ŭ������ constructor ���� ��, super�� �������� ������ �ڵ����� ����  
- super()�� �����ϴ� ����, � Ŭ������ default constuctor�� ����� ���� �ʿ�  

```
public class Parent{
	public Parent(int x){
		//code...
	}
}

public class Child extends Parent{
	public Child(){  //Child�� default constructor
		//code... 	// no super()
	}
}
Child c1 = new Child(); // error
/* super()�� Child()�� �ڵ����� ���ԵǴµ�, Parent�� default constructor�� ���� ������ ȣ�� �Ұ�, ������ ����*/
````

## `final`
1. method �տ� final
	- ���� `final public int methodName(int x)`  
	- descendant Ŭ������ �� �޼ҵ� �������̵� �Ұ�  
2. Ŭ���� �տ� final  
	- ���� `final public class Class1`  
	- �� Ŭ������ �ڽ�Ŭ���� ���� �Ұ�
 	  
## Constructor�� �θ��� `this`  
- �ڱ� Ŭ������ �ٸ� constructor�� ȣ��  

```
public class Test{
	private int x;
	
	public Test(){
		this(0); // constructor Test(int x)�� ȣ��
	}
	
	public Test(int x){
		this.x = x	 // �̶� this�� current object�� ����Ŵ 
```	


	