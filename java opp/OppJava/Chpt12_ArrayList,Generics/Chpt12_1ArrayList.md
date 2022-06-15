# Chapter12. Generics and ArrayList Class
# 12.1 The ArrayList Class
## `ArrayList` Class  
- standard Java libraries �� �ϳ� 
- Array�� �޸�, ���α׷� ���� ���� length(size)�� �ٲ� �� �ִ�  
- element type���� class type(reference type)�� ��� ����, x primitive type (wrapper class�� ����Ѵ�)  
- ArrayList�� ���� �� `<Base_type>` Base type�̶�� �Ķ���͸� �޴´�(class type�� ����) -> ArrayList�� Generics�� ���Եȴ�  
	- parameter�� ���� ���� ���, Object�� base type���� ���´�. 
- `import java.util.ArrayList;` �ʿ�  

### wrapper class type `ArrayList`  
```
import java.util.ArrayList; 

ArrayList<Integer> list = new ArrayList<Integer>();

list.add(5); // automatic boxing to Integer
		System.out.println(list.get(0)); // Integer�� toString�� ����Ǿ� String ����  
```
   

## `ArrayList` method  
`public ArrayList <base_type>(int initialCapacity)`  
- constructor: base_type element�� �� ArrayList ����.  
- initialCapacity�� ������ �ִ� �������̳� ���� ���� �����ϴ�  
- initialCapacity�� ����θ� ����Ʈ�� 10  

`set (int index, Base_Type newElement)`  
- index�� newElement�� �ִ´�  
- �ش� ��ġ�� ���� �ִ� element�� �����Ѵ�  

`get (int index)`  
- index ��ġ�� element�� �����Ѵ�  

`add(int index, Base_Type newElement)`  
- index �ڸ��� newElement�� �ִ´� -> ���� index���� �������� element�� �ڷ� �� ĭ�� �Ű��� index�� +1 �ǰ�, ArrayList�� capacity�� 1 �����Ѵ�  
- �Ķ������ index�� ������ ���, ���� ���ڸ��� newElement�� �ְ� capacity�� 1 �����Ѵ�  

`remove(int index)`  
- index ��ġ�� element�� �����Ѵ�  
- ������ element�� �����Ѵ�  
- �ش� index+1���� �������� element�� ������ �� ĭ�� ����� index�� -1 �ǰ�, capacity�� 1 �����Ѵ�  
- �Ķ������ index�� ArrayList�� ���� ����� �Ѵ� ���� �� ���, IndexOutOfBoundsException�� throw�Ѵ�  
`remove(Object Element)`  
- Element�� ã�� �����Ѵ�. �ش� Element�� ArrayList�� ������ �������� ��� true, ���� ��� false�� �����Ѵ� 

`removeRange(int fromIndex, int toIndex)`  
- fromIndex���� toIndex-1������ element�� �����Ѵ�  

`clear()`  
- ��ü element�� ����. ������� 0�� �ȴ�  
 
`public boolean contains(Object target)`  
- ArrayList�� target�� ������ true, ������ false�� ����  

`public int indexOf(Object target)`  
- target�� index�� ����, ������ -1  

`public int lastIndexOf(Object target)`  
- ArrayList �� ������ target�� index�� ����, ������ -1  

`public boolean isEmpty()`  
- ArrayList�� empty(size�� 0)�̸� true, �ƴϸ� false�� ����  

`public int size()`  
- ArrayList�� size�� ���� (array�� �޸� length�� �ƴ� �� ����)
- size: ���� element�� ���ִ� ����  

`public void ensureCapacity(int newCapacity)`  
- ArrayList�� capacity�� newCapacity�� �÷��ش�  
- add, set �� capacity�� �ø��� �۾� ���� �̸� ensureCapacity�� ���ָ� ȿ���� �ö󰣴� ������ capacity�� �̸� �ʹ� ���� ��Ƶθ� �޸𸮰� ����ȴ�  

`public void trimToSize()`  
- ArrayList�� capacity�� size�� ���δ� (element�� ���� �� ������ ���ش�)  

`public Object[] toArray()`  
- ArrayList�� array�� �ٲپ� �����Ѵ�  

`public Object clone()`  
- ArrayList�� shallow copy�� �����Ѵ�. �����ϴ� ���� �ƴ϶� �״�� �Ѱ��ֱ� ������ privacy leak�� �߻��� �� �ִ�  

`public boolean equals(Object other)`  
- ArrayList�� ������ boolean�� �����Ѵ�.  
- true�̷��� �� ArrayList�� class type, size, element, order�� ��� ���ƾ� �Ѵ�  

## `ArrayList` element ����ϱ�  
```
ArrayList<Integer> list = new ArrayList<Integer>();

for (int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
```

## for-each loop with ArrayList  
```
ArrayList<String> toDoList = new ArrayList<String>();

for (String entry : toDoList)
			System.out.println(entry);
```
- toDoList �ȿ� �� ��� ������ entry(element)�� ���� statemenet�� �����Ѵ�  

## `Vector` class  
- java standard libraries�� ���Ե� class  
- ArrayList�� ���� ���� ������ �Ѵ� ������ ArrayList�� �� �ֽ��̰� ��ȣ�ȴ�  
- ArrayListó�� base type�� ���� �Ķ���͸� �޴´�  
