# Chapter12. Generics and ArrayList Class
# 12.1 The ArrayList Class
## `ArrayList` Class  
- standard Java libraries 중 하나 
- Array와 달리, 프로그램 수행 도중 length(size)를 바꿀 수 있다  
- element type으로 class type(reference type)만 사용 가능, x primitive type (wrapper class로 써야한다)  
- ArrayList는 정의 시 `<Base_type>` Base type이라는 파라미터를 받는다(class type만 가능) -> ArrayList는 Generics에 포함된다  
	- parameter를 갖지 않을 경우, Object를 base type으로 갖는다. 
- `import java.util.ArrayList;` 필요  

### wrapper class type `ArrayList`  
```
import java.util.ArrayList; 

ArrayList<Integer> list = new ArrayList<Integer>();

list.add(5); // automatic boxing to Integer
		System.out.println(list.get(0)); // Integer의 toString이 실행되어 String 리턴  
```
   

## `ArrayList` method  
`public ArrayList <base_type>(int initialCapacity)`  
- constructor: base_type element의 빈 ArrayList 생성.  
- initialCapacity는 가능한 최대 사이즈이나 추후 조정 가능하다  
- initialCapacity를 비워두면 디폴트는 10  

`set (int index, Base_Type newElement)`  
- index에 newElement를 넣는다  
- 해당 위치에 원래 있던 element를 리턴한다  

`get (int index)`  
- index 위치의 element를 리턴한다  

`add(int index, Base_Type newElement)`  
- index 자리에 newElement를 넣는다 -> 기존 index부터 끝까지의 element는 뒤로 한 칸씩 옮겨져 index가 +1 되고, ArrayList의 capacity도 1 증가한다  
- 파라미터의 index를 생략할 경우, 가장 끝자리에 newElement를 넣고 capacity가 1 증가한다  

`remove(int index)`  
- index 위치의 element를 제거한다  
- 제거한 element를 리턴한다  
- 해당 index+1부터 끝까지의 element는 앞으로 한 칸씩 당겨져 index가 -1 되고, capacity도 1 감소한다  
- 파라미터의 index로 ArrayList의 현재 사이즈를 넘는 값을 줄 경우, IndexOutOfBoundsException을 throw한다  
`remove(Object Element)`  
- Element를 찾아 삭제한다. 해당 Element가 ArrayList에 존재해 삭제했을 경우 true, 없을 경우 false를 리턴한다 

`removeRange(int fromIndex, int toIndex)`  
- fromIndex부터 toIndex-1까지의 element를 삭제한다  

`clear()`  
- 전체 element를 삭제. 사이즈는 0이 된다  
 
`public boolean contains(Object target)`  
- ArrayList에 target이 있으면 true, 없으면 false를 리턴  

`public int indexOf(Object target)`  
- target의 index를 리턴, 없으면 -1  

`public int lastIndexOf(Object target)`  
- ArrayList 내 마지막 target의 index를 리턴, 없으면 -1  

`public boolean isEmpty()`  
- ArrayList가 empty(size가 0)이면 true, 아니면 false를 리턴  

`public int size()`  
- ArrayList의 size를 리턴 (array와 달리 length가 아닌 점 유의)
- size: 현재 element가 차있는 정도  

`public void ensureCapacity(int newCapacity)`  
- ArrayList의 capacity를 newCapacity로 늘려준다  
- add, set 등 capacity를 늘리는 작업 전에 미리 ensureCapacity를 해주면 효율이 올라간다 하지만 capacity를 미리 너무 많이 잡아두면 메모리가 낭비된다  

`public void trimToSize()`  
- ArrayList의 capacity를 size로 줄인다 (element가 없는 빈 공간을 없앤다)  

`public Object[] toArray()`  
- ArrayList를 array로 바꾸어 리턴한다  

`public Object clone()`  
- ArrayList의 shallow copy를 리턴한다. 복사하는 것이 아니라 그대로 넘겨주기 때문에 privacy leak이 발생할 수 있다  

`public boolean equals(Object other)`  
- ArrayList가 같은지 boolean을 리턴한다.  
- true이려면 두 ArrayList의 class type, size, element, order가 모두 같아야 한다  

## `ArrayList` element 출력하기  
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
- toDoList 안에 든 모든 각각의 entry(element)에 대해 statemenet를 시행한다  

## `Vector` class  
- java standard libraries에 포함된 class  
- ArrayList와 거의 같은 역할을 한다 하지만 ArrayList가 더 최신이고 선호된다  
- ArrayList처럼 base type에 대한 파라미터를 받는다  
