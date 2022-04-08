#Chapter4 Defining Class (1)
#4.1 Class Definition
## class  
- �ڹ��� ��ü���� ���α׷��ֿ��� ���� �߿��� ��  
- �ڹٴ� ��� ���α׷��� �ϳ��� Ŭ������. �ڹ��� ���α׷����� Ŭ�������� �����ϴ� �Ͱ� ���� 

### Primitive Type vs Class Type (Reference Type)  
primitive type
-  value: a single piece of data
-  ex. int, double, char, boolean...  
class type(reference type, ������)
-  value is called 'object'  
-  object�� instance variables(data)�� methods(actions)�� ���´�  
 
### Class and Object  
same class���� ���� objects�� ���� method, instance variables�� ���´�  
�׷��� ���� �ٸ� objects�� same variable�� different values�� ���� �� �ִ�  

object ����: new operator Ȱ�� -> reference �ּҸ� ���Եȴ�  
`className objectName = new className()`  
instance variables(data items)�� ���� `objectName.varName`  
methods �θ��� `objectName.methodName()`  
accessing class members inside the class: without classname ex. �׳� method() �̸��� �Ἥ �θ���  

### Aceess modifier: public vs private  
public: �ƹ���
private: private...  
-  public class �Ʒ����� private variable�� ���ǵ� �� �ִ� Ŭ���� ������ �ٸ� ����ε� 

### Multiple Classes  
-  �ٸ� ���Ͽ� �ִ� Ŭ������ Ȱ���� �� �ִ� 
-  public class: �� �ҽ��ڵ�� �� ����. �ƹ��� Ȱ�� ����
-  package class: public x. package ���� class�� Ȱ�� ����. �ٸ� package class�� �Ⱥ���  
-  �ڹ�: ��κ� �ҽ��ڵ� �ϳ��� Ŭ���� �ϳ� 
  - �ҽ��ڵ�� ���̿��� Ŭ���� ã�� ���� + Ŭ���� ���� ���� 
-  �׷����� �� ���Ͽ� ���� Ŭ������ ������ �� �ִ� (public class�� 1����) 

### Local Variables & Instance Variable  
- �ڹ�: local variable(���� ����), instance variable
    -  NO global variable
  
- local variable
    - method definition �ȿ� ���ǵ� ����
    - ��� method parameter�� local variables
    - block�ȿ��� ���� �����ϴ� (�ݺ��� for block ��)
    -  �� local �ȿ����� Ȱ�� �����ϴ�!
- instance variable: ���� class���� ������ object���� ���������� ���´� 

```
public class Test{
	public static void main(String[] args){
		int a = 5; //a�� local variable in main
		for (int k=0, k<5; k++({ //k�� local variable in for
			int a = k + 1 // Error! a�� main�� ���������� �̹� ���ǵǾ�����
			System.out.println(k);}
		System.out.println(k); // Error! k�� for�� �������� 
     }
}
```

### Method
#### Method ����  
return type: return a value, value type�� method �̸� �տ� ������ش�
 -  return���� �޾� �Ҵ����� �ʾƵ� ������ ����x
 -  ���� 
 
```
public int add(int x){
	x+1}
```
void type: no return value, method �̸� �տ� void  

```
public void printe(int x){
	System.out.println("hello" + x);}
```
#### main method�� �ִ� class�� �ٸ� methods  
-  main method: static method
-  static������ static�� �θ� �� �ִ�
--> main method�� ȣ���ϴ� method ���� static �̾�� �Ѵ� 

#### actual parameter vs formal parameter  
-  actual parameter
  -  �ٸ� method�� ȣ���ϴ� ���� ���� parameter. value�� ���� �ִ�? ���� ������ ����Ŵ?
-  formal parameter 
  -  ȣ�� ���ϴ� method�� �Ķ����. ���� �̸��� �޶��� �� ���� 
  -  ���� ���� ��Ÿ���� ���� �ƴ϶� copy, �ٸ� �޸� �����̽��� �ִ� ���� ��Ÿ��?? value�� ���� ����?

#### Automatic Type Conversion: Primitive Type Parameters
-  actual parameter�� formal parameter�� copy�� ��, �ڵ����� �� ��ȯ�ȴ�  
-  formal aprameter�� �� ū ������ ��
  -  auto conversion rule: byte,char->short->int->long->float->double

```
public class Test{
	public static void main(String[]args){
		int a=1,b=2,c=3; // local variables
		double result = myMethod(a,b,c); 
		//myMethod must be static // actual parameter: a,b,c
		//�ڵ� ����ȯ-> c�� int���� return ���� double 
	}
	static double myMethod(int a , int b, double c) 
	//formal parameter: a,b,c
	{return a+b+c;}
}
```

#### this parameter
-  instance variable name�� parameter(=local variable) name�� ���� �� local���� instance variable�� ��������  
-  this.variableName�� instance variable�� ����Ų�� 
-  instance variable�� parameter �̸��� ���� �ϰ� this parameter�� ���� ���� �������� ���� 

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
�ڹ�: equals, toString �� Ư�� methods�� ��κ��� class�� �����Ѵٰ� ����, �׿� ���� ����� ���� 

- equals
 `public boolean equals(ClassName object Name)`
  - �� ��ü�� ������ �������� boolean������ ���� 
  -  reference�� ���ϴ� ���� �ƴ� (no ==)  
- toString
`public String toString()`
  -  ��ü�� �ֿ� ������ String���� �ٲ� ���� 
  -  System.out.println(objectName)�ϸ� toString method�� �ڵ����� ȣ��Ǿ� String ���� ������ 
  


