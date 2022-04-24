# Chapter5 Defining Class (2)  
# 5.1 Static Methods and Variables  

## Class Static Area vs Heap Area  
�ڹ��� �޸� ����
  
  class static area(= class area, method area)
- object�� ����� ��, class �̸��� ���� ���� ��������� area
- static methods, static variables ���� 


heap area  
- instances (������ methods, instance variables) ����  


## Static Method  
- method header�� static �ٴ´�  
` public static returnedType methodName()`  
- object�� ȣ������ �ʰ�, class name���� method�� ȣ�� �����ϴ�! `classname.method` (objectName���ε� ����)
     - object ���� ���� method�� ȣ�Ⱑ���� ���ϳ�, ��� method�� static���� ����� �� ���� �ʴ� 
    -   ����  
`Math.random(); // Math�� class name`  
`System.exit(0); // System�� class name`  
    - static�� �ƴ� method�� objectname���� ȣ�� `objectname.method`
- class static area�� ���Ѵ�  
    - instance variable refer(����) �Ұ� (class area: ��ü ���� ������ ����) / static variable�� ��� ���� 
    - non-static method ȣ�� �Ұ� / static method������ ȣ�� ���� 
        - `public static void main(String[] args)`�� static method�� ������ static method�� ȣ�� ����
    - this parameter ��� �Ұ�
    - class area�� ��ġ�ϱ� ������ static method������ instance�� ��������� �ʴ´�  

#### cf. named constant(���)
- �����ǰ� �Ұ�����, ���� ������ �ʴ� ����
- final �̿� `final valType valName;`

## Static Variables  
- ������ �� ���ÿ� initialize, ���� �Ҵ����ִ� ���� ����  
    - initialize x: �ڵ����� default value �Ҵ��
       - default value: boolean�� false, other primitive types�� �� Ÿ���� 0, class type�� null
- ������ private�� ���ǵȴ� (constant ����!)  
- static variable�� className���� access ����   
- static method, non-static method �Ѵ� static variable�� ���� ����

```
public static final int YEAR = 2022; //constant  
int currentYear = MyClass.YEAR;     // classname���� access
```

## Wrapper Classes
wrapper class: ������ primitive types�� class type
- primitive type���� method, instance variable ���� -> wrapper class�� ������ �ذ�
- Byte, Short, Integer, Long, Float, Double, Character 
- predefined constants, static methods ����  
    - constants in wrapper class
      - `Boolean.TRUE` and `Boolean.FALSE`
      - MIN_VALUE, MAX_VALUE 
      `Interger.MAX_VALUE // Interger���� ���� ū ��`
      `Double.MIN_VALUE   // Double���� ���� ���� ��`
    - static methods in wrapper class   
       - Ÿ�� ��ȯ `className.parseType(arg);`  
       - ���ڿ��� ��ȯ `className.toString(arg);`
       
       ```
       int i = Integer.parseInt("365"); // 365
       double d = Double.parseDouble("365.0");//365.0 
		String str = Double.toString(2.0); // "2.0"
		```
#### Character class�� methods 
static methods 
- `Character.toUpperCase(char arg)` �빮�� ��ȯ  
- `Character.toLowerCase(char arg)` �ҹ��� ��ȯ
- `Character.isUpperCase(char arg)` �빮������ Ȯ��. �ݴ�� isLowerCase
- `Character.isWhitespacce(char arg)` withespace(' ', '\t','\n' �� ����)���� Ȯ��  
-  `Character.isLetter(char arg)` letter���� Ȯ�� (����, Ư�����ڴ� false)  
- `Character.isDigit(char arg)` �������� Ȯ��
- `Character.isLetteerOrDigit(char arg)` ���ĺ�, ���ڸ� true, Ư�����ڴ� false

		
#### Boxing
- primitive type -> wrapper class�� �ٲ���
- new ���� assignment(�Ҵ�)�� ���� auto boxing  

```
Byte bObj = 5; // Byte class(wrapper class)�� object ������
Character cObj = 'a';
```
#### Unboxing
- wrapper class -> primitive type 
- ��� 1) dedicated conversion method ���  
		bytevalue(), shortValue(), intValue(), floatValue(), doubleValue(), charValue() 
	
	```
	byte b = bObj.byteValue();
	char c = cObj.charValue();
	```
- ��� 2) assignment�� ���� auto unboxing (�ַ� ����)  
	
	```
	byte b = bObj;
	char c = cObj;
	```

## Class Math 
- java.lang package ����, import ���ʿ�  
- static methods, static variables�� �����ִ�  
- 2 predefined constants: E, PI
- static methods
	- `Math.pow(double base, double exponent)` base�� exponent ���� ����  
	- `Math.abs (type arg)` ���� ����  
	- `Math.min(type arg1, type arg2)` �� �� ���� ���� ���� (�ݴ�� method max)  
	- `Math.round(type arg)` �ݿø�  
	- `Math.floor(type arg)` ����   
	- `Math.ceil(type arg)` arg���� ū �� �� ���� ���� ���� ����  
	- `Math.sqrt(type arg)` square root(��Ʈ ���� ��) ���� 

# 5.2 References and Class Parameters  
## ��ǻ�� �޸�  
### 1. Main memory  
	
- ���α׷��� ��ũ�κ��� �ε��� ������ �� ���. ���α׷��� variables ���� 
-�ֱ����ġ, ��(ram)�̶�� �θ�  
- class area(=method area), stack area, heap area, native method stack area, pc register�� ������  
- bytes�� ������ �� ����Ʈ, ���� �ٸ� ũ���� memory location�� ����Ʈ�� �� �� �ִ�.
- 1 byte�� 8 bits�� ���� (0 or 1 digit)
- byte�� �����ϴ� ����: address
- data item�� �ϳ� �̻��� bytes�� ����ȴ�.  
  �� ������ memory location�̶� �θ�.  
  memory location�� ù ��° byte�� address�� address of data item  
  data item�� access�� �� address�� �̿�ȴ� 
	
### 2. Secondary memory  
  - ���������ġ
  - permanent storage. ������ ���� �ִ�. ���� ���ϴ� ��ũ.   

## Reference Type = Class Type  
- class type�� variable
	- reference: object�� ��ġ�� memory location  
	- class type variable�� ��� reference�� ������  
	- value�� memory location(reference)�̴�  
	  <->primitive type variable: value�� ���� ����(�޸𸮸� ã�ư��� �ٷ� value�� access ����) 
	- object�� new�� ������ �� main memory�� heap area�� address �ο�  
- `object1 = object2` 
	- object2�� address�� ����Ǿ� object1�� �Ҵ�
	- object1�� 2�� ���� �޸� ������ ����Ű�� �ȴ�
	- object1�� instance variable value�� �ٲ�� 2�� �ٲ�� ��
	  
## Parameters  
- �ڹ��� ��� �Ķ���ʹ� call-by-value parameter
	- method�� ȣ������ ��, method �ȿ��� �Ķ����(formal parameter) ���� �ٲ㵵 ȣ���� ���� actual parameter�� �ٲ��� �ʴ´�.
- class type parameter
	- call-by-reference parameter�� ����� �۵� ���  
	- �Ķ������ ���� �ٲٸ� ȣ���� �ʿ����� ���� �ٲ��.  
	- �Ķ���Ͱ� Ŭ���� Ÿ��, object�� ���  

```
//parameters of primitive types
// int x �� primitive type
public class Test{
	static void trytoChange(int x)
	{x=3;}
	
	public staic void main(String[]args{
	int x = 1;
	tryToChange(x);
	System.out.println(x);}
} // output: 1 (actual parameter �ٲ��� ����)
```

# 5.3 ��ī��  
- privacy leak ����  
- ���� ��ü������ ���� ���ο� object�� ���� ��, ��ü ���� Ÿ���� class�� ��ü������ ���� �����Ѵ�  
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

    