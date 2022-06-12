# Chapter 8. Polymorphism and Abstract Class  
# 8.1 Polymorphism  
## Polymorphism  
- manipulating descendant class' object through ancestor class' reference variable  
- through a mechanism called: late binding or dynamic binding  
## Binding  
- Binding: process of associating a method definition with a method invocation  
- �޼ҵ� definition�� invocation�� �������ִ� ���μ���. �޼ҵ� ���ǰ� �ҽ��ڵ忡 �������� �� �װ��� � �޼ҵ带 ���� ���̳ĸ� �����ִ� ���μ���

### Early Binding  
- binding occurs when the code is compiled 
- compile time�� ���� 
- java: only private, final, static methods���� ���  

### Late Binding(Dynamic Binding)
- binding occurs when the method is invoked (at runtime)  
- java: ������ �޼ҵ�鿡�� ���  
- ����  (�߰� ����: Chpt8_2Binding �ҽ��ڵ�) 

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
		foo(p); // output: product
		foo(t); // output: tv 
	}
	static void foo(Product pr){print(pr)}
}
```
	- late binding -> foo�� argument�� TV class object�� ���� late binding�� �߻��� TV class�� toString method�� ȣ��ȴ�. 
	- late binding: binding�� run time�� �Ͼ��. class�� �´� �Լ� ȣ�� (<-> �ݴ�� binding�� compile time�� �߻��� Product�� method�� �����Ǹ�, TV�� method�� ȣ����� �ʴ´�)  
	- � ���� �Ķ���ͷ� �н̵Ǵ��Ŀ� ���� ȣ��Ǵ� method�� �޶����� = dynamic binding(=late binding)  

## Upcasting and Downcasting  
upcasting: Ʈ������ �� �Ʒ��� �ִ� Ŭ����(descendant)�� ���� Ŭ����(ancestor)�� assign  
downcasting: ����Ŭ����(ancestor)�� ����Ŭ����(descendant)�� assign  
- downcasting�� ������  
	- typecasting�� ���� assign ��ü�� �����ϴ� (runtime error �߻� ����)  
	- `=`������ assign�ϸ� compile error   
	- ����Ŭ������ ���� ����Ŭ�������� �� ���� ������ �޼ҵ带 ���� �ִ� -> �̿� access�� �� ���� ��� ����  
	- ��Ģ������ �Ұ����ϴ�  
```
Sale s = new Sale(); //base class
DiscountSale d = new DiscountSale();//derived class

s = d; //Upcasting is ok  
System.out.println(s); //late binding�� ���� DiscountSale�� toString�� ȣ��ȴ�  

d = (DiscountSale)s; //Downcasting: �������ɼ�
d = s; // compile error! 
```

### Downcasting�� �ʿ��� ��: �����ϰ� Downcasting�ϱ�  
���� 

```
public class Sale{
	public boolean equals(Object other){
		if (other == null) return false;
		else if (getClass() != other.getClass())
			returnn false;
		else{
			Sale otherSale = (Sale)other; //Downcasting: Object -> Sale
			return(name.equals(otherSale.name));} //Sale�� instance variable�� name�� �����ִٴ� ����  
	}
}
```
- Object type�� �Ķ���ͷ� �޴� Sale class�� equals method: �켱 �񱳴���� Object other�� Sale class���� Ȯ���� ��, Sale class�� ��� Ÿ��ĳ������ ���� Sale class type���� ������� �� instance variable�� ���ؾ� �Ѵ�(Object class���� Sale class�� instance variable�� ���� ����)  
- �̹� Other object�� Sale class�� object��� ���� ������ �� Ÿ��ĳ�����߱� ������ ������ downcasting�̴�!  
- ���� ���  
	- `getClass()` method : descendant ���� x   
	- `instanceof` operator : descendant�� ��쿡�� true  
	
## clone method  
`clone`: Object class�� method. ��� class�� ��ӵȴ�  
- �Ķ���� ����  
- object��  deep copy�� �����ؾ� �Ѵ�  
- class���� ���� clone method�� �˸°� �������̵� �ؾ��Ѵ�.  
	
	```
	//������ copy constructor���� deep copy�� ������ ����
	public Sale clone(){return new Sale(this);}
	public DiscountSale clone(){return new DiscountSale(this);}
	```
- java 5.0 ����: covariant return type ���� X  
	- ��� Ŭ������ clone method ���� Ÿ���� Object���� ����->Ÿ��ĳ���� �ʿ�  
	
	```
	public Object clone(){return new Sale(this);}
	Sale copy = (Sale)orginal.clone(); //downcasting
	```
- java 5.0: covariant return type O  
	- method�� ���� Ÿ���� ����Ŭ������ ������ �������̵� ���� -> clone�� �� �� Ÿ��ĳ���� �ʿ�x  
	
### clone method ��� ����  
- bad copy version  
	
	```
	public static Sale[] badCopy(Sale[]a){
	Sale[] b = new Sale(a.length);
	for (int i = 0; i < a.length; i++)
		b[i] = new Sale(a[i]);
	return b;}
	``` 
	- ������: a[i]�� Sale�� ���� Ŭ���� object�� �� �ִ� -> �׷��� `b[i] = new Sale(a[i])`�� Sale�� copy constructor�� ȣ����  
- good copy (using polymorphism)  

	```
	public static Sale[] goodCopy(Sale[]a){
	Sale[] b = new Sale(a.length);
	for (int i = 0; i < a.length; i++)
		b[i] = a[i].clone();
	return b;}
	```  
	- clone() ȣ�� -> dynamic binding���� a[i] Ÿ�Կ� �´� clone method�� ȣ��ȴ�!  
	
# 8.2 Abstract Class  
## Abstract method  
- heading�� �ְ� body�� ���� method  
- body�� derived class���� ���ǵ� (base class���� placeholder�� ������ �Ѵ�)  
- heading�� `abstract`�� �ٴ´�  

## Abstract class  
- abstract method�� �ϳ� �̻� ���� �ִ� class  
- class �̸��� `abstract`�� �ٴ´�  
- object�� �������� ���Ѵ�  
- class ���������� ����. descendant class�� sketch ����  
	- Abstract class�� ���� derived class���� �ݵ�� define �ؾ� �� methods���� �����ϴ� placeholder�� ������ �Ѵ�  
- abstract class�� derived class�� �� abstract�� �� �ִ�
- <-> concrete class: abstract class�� �ƴ� class
 
```
abstract class Employee{
	protected String name; protected int hour;
	public abstract double getPay(); //abstract method
}
class EmployeeCook extends Employee{
	public double getPay(){return hour * 10000;}
}
```
