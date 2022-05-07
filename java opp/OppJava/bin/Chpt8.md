# Chapter 8. Polymorphism and Abstract Class  
# 8.1 Polymorphism  
## Polymorphism  
- manipulating descendant class' object through ancestor class' reference variable  
- through a mechanism called: late binding or dynamic binding  
## Binding  
- Binding: process of associating a method definition with a method invocation  
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
		foo(p);
		foo(t);
	}
	static void foo(Product pr){print(pr)}
}
```
	- late binding -> foo�� argument�� TV class object�� ���� late binding�� �߻��� TV class�� toString method�� ȣ��ȴ�. 
	- late binding: binding�� run time�� �Ͼ��.class�� �´� �Լ� ȣ�� (<-> binding�� compile time�� �߻��� Product�� method�� �����Ǹ�, TV�� method�� ȣ����� �ʴ´�)  
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
  
