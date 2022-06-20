# Chapter14. Collections  
# Collection  
- ������ �׷���� �����ϱ� ���� Ŭ�������� ���Ĵٵ�ȭ �ص� ��  
- `Collection`: `Iterable`interface�� extends�� interface  
	- `List`, `Queue`, `Set`: 	`Collection`�� extends�� interface  
	
## Core Interface of Collection  
- `List`  
	- ���� o (�����͸� ������� ������ �����ȴ�)  
	- �ߺ� ������ ���  
	- class: `ArrayList`, `LinkedList`, `Stack`, `Vector`...  
- `Set`  
	- ���� x (�����͸� ������� ������ ����x)  
	- �ߺ� ������ ���x  
	- class: `HashSet`, `TreeSet`...  
- `Map`  
	- tuple�� �̷����. �ϳ��� �����Ͱ� key�� value�� ������ �̷������.  
	- ���� x  
	- key�� �ߺ� �Ұ�, value�� �ߺ� ���  
	- class: `HashMap`, `TreeMap`, `HashTable`, `Properties`...  

## Methods in interface Collection<E>  
- Collection interface�� ���� method  
- `add(E e)`: ���ϰ� boolean ����  
- `addAll(Collection<? extends E> c)`: �ٸ� collection�� elements�� �Ѳ����� �� ����. boolean ����  
- `clear()`: element ��� ����, void method  
- `contains(Object o)`: collection�� o�� �����ϴ��� boolean ����  
- `containsAll(Collection<?> c)`: �ٸ� collection�� ��� element�� �����ϴ��� boolean ����  
- `equals(Object o)`: ���� collection���� boolean ���� ?  
- `hashCode()`: returns hash code value for this collection  
- `isEmpty()`: collection �� element�� ������ true ����  
- `iterator()`: collection�� ��� element�� ���� iterator ���� (Iterator<E>)  
- `remove(Object o)`: collection �� o ����, �����ϸ� true ����  
- `removeAll(Collection<> c)`: �ٸ� collection �� ���Ե� element�� ��� ����, ������ ���� �־��ٸ� true ����  
- `retainAll(Collection<?> c)`: �ٸ� collection�� �� element�� ����� ��� ����. ������ ���� �־��ٸ� true ����  
- `size()`: collection �� element ���� ����  
- `toArray()`: array�� ����� ��ȯ  

# Interface List  
- ���� o, �ߺ� ������ o  
## Methods in Interface List  
- `add(int index, E element)`: index ��ġ�� element ����  
	- int index �����ϸ� list ���� ���� 
- `addAll(int index, Collection<? extends E> c)`: list�� index ��ġ�� �ٸ� collection�� ��� element ����  
	- int index�� �����ϸ� list ���� ����  
- `clear()`: list ����  
- `contains(Object o)`: o element�� ���Եƴ��� boolean ����  
- `containsAll(Collection<?> c)`: �ٸ� collection�� ��� element�� �����ϴ��� boolean ����  
- `copyOf(Collection <? extends E> c)`: ������ ������ element�� ���� collection�� ���� (unmodifiable List)  
- `equals(Object o)`: o�� list�� ������ ����  
- `get(int index)`: list�� index ��ġ element ����  
- `hashCode()`: list�� hash code value ����  
- `indexOf(Object o)`: element o�� index ����, ������ -1  
- `lastIndexOf(Object o)`: element�� o�� ������ element�� index ����, ������ -1
- `isEmpty()`: list�� ��������� true ����  
- `iterator()`:   
- `remove(int index)`: index ��ġ�� element ����, ������ element ����   
- `remove(Object o)`: o ����, ���� ���� ����  
- `removeAll(Collection<?> c)`: �ٸ� collection�� ���Ե� element�� ����, ���� ���� boolean���� ����  
- `retainAll(Collection<?> c)`: �ٸ� collection�� ���Ե� element�� �����. element ���� ���� boolean���� ����  
- `set(int index, E element)`: index ��ġ�� element ����  
- `size()`: element ���� ����  
- `sort(Comparator<? super E> c)`: Compartor�� ������ list sorting  
- `subList(int fromIndex, int toIndex)`: fromIndex���� toIndex-1���� list�� �߶� ����  
- `toArray()`: list�� array�� �ٲپ� ����  

## ArrayList and Vector Class  
- ���� o, ������ �ߺ� o  
- use array as storage space. ���ӵǴ� �޸� ������ ����  

```
import java.util.ArrayList;
import java.util.Collections; // sort() method �� ��� ����  

ArrayList<Integer> list = new ArrayList<Integer>();
list.add(4); list.add(3); list.add(2);

ArrayList<Integer> list2 = new ArrayList<Integer>(list.subList(1,2);
System.out.println(list); // output: [4,3,2]
System.out.println(list2); // output: [3]

Collections.sort(list); 
System.out.println(list); // output: [2,3,4] ���ĵ�  
System.out.println(list.containsAll(list2)); // output: true
```

### Removing sequence in ArrayList  
- Ư�� �����͸� ����� ���: Ư�� ������ �ڿ� �ִ� �͵��� ī���ؼ� ������ �Űܿ� ä��, ������ ������ �ڸ��� null�� ����, size�� 1 ����  
- ù ��° �����͸� ������ ��� size-1 ���� �����͸� ��� �Űܾ� �Ѵ�  
- �ڿ������� �����ϸ�  �����͸� �̵���Ű�� �ʾƵ� �ż� ȿ���� 

## LinkedList Class  
- ���� o, �ߺ� ������ ��� o  
- ������ ��尡 ���� ��忡 ���� �ּ� (link)�� ���� �ֱ� ������ �޸� �󿡼� �پ����� �ʿ䰡 ����  
- ������ ���� �� : �տ� �ִ� ����� ��ũ�� �����ϴ� ��� ���� ��� �ּҸ� ����Ű�� �ϸ� �ȴ�  
- ������ ���� ��: �� �� ����� ��ũ�� �ٲ��ش� 
- �޸��� ȿ���� ���  

### LinkedList�� �پ��� Ÿ��  
- LinedList: access�� ��ƴ�  
	```
	class Node{
		Node next; // ���� ��忡 ���� link 
		Object obj; // data
	}
	```
- Doubly LinkedList: better access  
	- ���� ���� ���� ��忡 ���� link�� ��� ���´�  
	```
	class Node{
		Node next; // ���� ��忡 ���� link 
		Node previous; // ���� ��忡 ���� link 
		Object obj; // data
	}
	```
- Doubly Circular LinkedList  
	- ���� ���� ���� ��忡 ���� link�� ��� ���´�  
	- ������ ���� ù ��° ����� �ּ�, ù ��° ���� ������ ����� �ּҸ� ���´�  

### LinkedList ����  

```
import java.util.LinkedList; // import java.util.*;

LinkedList<String> ll = new LinkedList<String>(); 

ll.add("a"); ll.add("b"); ll.add("c"); // [a,b,c]
ll.add(2,'e'); // [a,b,e,c] �ش� ��ġ�� ���� element�� �з����� 

ll.removeFirst(); // [b,e,c]
ll.removeLast(); // [b,e]
```

### Methods in LinkedList  
- `addFirst(E e)`: list ù��° ��ġ�� e ����  
- `addLast(E e)`: list ���� e ����  
- `element()`: list�� ù element�� ����, ������ ����  
- `getFirst()`, `getLast()`: ���� ù��°, ������ element�� ����  
- `offer(E e)`: list ���� e ����, ���� ���� boolean���� ����  
- `offerFirst(E e)`, `offerLast(E e)`: ���� ù��°, ���� e ����, boolean ����  
- `peek()`: list�� ù��° element ����, ������ ����. `element()`�� ����  
- `peekFirst()`, `peekLast()`: ���� ù��°, ������ element ����  
- `poll()`: ù��° element�� �����ϰ� ����  

## Stack Class  
- �� ���� push, �� �� ���� pop  
- Last in, First out (LIFO)  
- �����Ͱ� ���� ���̰�, ������ ���������� �Ѵ�  

### Methods in Stack  
- `empty()`: stack�� ����ִ��� Ȯ��  
- `push(E e)`: stack�� ���� ���� element �ֱ�  
- `pop()`: stack ���� ���� element�� ����, ������ element�� ����  
- `peek()`: stack ���� ���� element�� ����, ������ ����  
- `search(Object o)`: o�� ã�� index�� ����, ������ -1  

```
import java.util.Stack;

//Stack class object ���� 
Stack<Integer> stk = new Stack<Integer>();
stk.push(1);
stk.push(2);
System.out.println(stk); // [1,2]
System.out.println(stk.pop()); // 2
```

# Interface Queue  
- linkedList�� implements��  
- First in, First out (FIFO): ���� ���� �ְ�, ù ��°(���� �Ʒ�) �ִ� �ͺ��� ����   

## Methods in Queue  
- `add(E e)`: e�� ����, ���������� true ���� 
- `element()`: head element(���� �տ� �ִ� element)�� ����, ������ ����  
- `offer(E e)`: e�� ����, ���������� true ����  
- `peek()`: head element�� ����, ����ִٸ� null ����  
- `poll()`:head element�� �����ϰ� ����, ����ִٸ� null ����  
- `remove()`: head element�� �����ϰ� ����  

```
import java.util.LinkedList;
import java.util.Queue;

// queue object ���� 
Queue<Integer> q = new LinkedList<integer>();

q.offer(1); q.offer(2); q.offer(3); // [1,2,3]
q.poll(); // [2,3] q.poll() return 1 
q.peek(); // 2 ������ ���� [2,3] 
```

## class PriorityQueue  
- `Queue` interface�� implements, `Queue`�� method ��� ��� ����  
- Minimum Priority Queue  
	- ����Ʈ  
	- ������ head(���� ��)�� ���� ���� �����Ͱ� �´�   
	- �����͸� ���� �� ���� ���� �����Ͱ� head�� �ֵ��� �Ѵ�  
	- ������ head �ܿ� �ٸ� �����͵��� sorting ������ �ʴ´�  
	- `import java.util.PriorityQueue;` �ʿ�  
	- object ����: `PriorityQueue<Integer> pq = new PriorityQueue<Integer>();`  
- Maximum Priority Queue  
	- ������ head�� ���� ū �����Ͱ� �ִ�  
	- object ����: `PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());`   
	
### Methods in PriorityQueue  
- `add(E e)`: e�� �����ϰ� ���������� true ����  
- `clear()`: element ��� ����  
- `contains(Object o)`: o�� �����ϰ� ������ true ����  
- `iterator()`: queue�� elements�� ���� Iterator object ����  
- `offer(E e)`: e�� ����, boolean ����  
- `remove(Object o)`: o�� ������ ����, boolean ����  
- `toArray()`: element�� ��� �����ϴ� array�� ����  

```
import java.util.*;

PriorityQueue<Integer> q = new PriorityQueue<Integer>();
q.add(4); q.add(7); q.add(2);
System.out.println(q); // [2,7,4]
System.out.println(q.peek()); // 2
remove(); // head=2�� ���� [4, 7]
System.out.println(q.poll()); // 4�� �����ϰ� q���� 4�� ������ [7]
```

# Interface Iterator  
- collection�� data�� �����ϴ� �� ���δ�  
- iterator ����: `Iterator itr = collectionObject.iterator();`  

## Methods in Iterator  
- `hasNext()`: �о�� ��Ұ� ���������� true, ������ false ����  
- `next()`: ���� ��Ҹ� �о�´�. next()�� ȣ���ϱ� �� hasNext()�� �о�� ��Ұ� �ִ��� Ȯ���ϴ� ���� �����ϴ�.  
- `remove()`: void. next()�� �о�� ��Ҹ� ����. �ݵ�� next()�� ���� ȣ�� �� ����Ѵ�  

```
import java.util.ArrayList; 
import java.util.Iterator; 

ArrayList list = new ArrayList(); 
list.add("a"); list.add("b"); list.add("c"); 

Iterator itr = list.iterator();
while(itr.hasNext()){ // ������� ��� a b c
	Object element = itr.next();
	System.out.print(element + " ");
}
```

## ListIterator  
- �� �� ���� ��� �����ϴ�  
- `hasNext()`: �о�� ���� ��Ұ� �ִ��� Ȯ�� / `hasPrevious()` �о�� ���� ��Ұ� �ִ��� Ȯ��  
- `next()`: ���� ��� �о�� / `previous()`: ���� ��� �о��  
- `nextIndex()`: ���� ����� index ���� / `previousIndex()`: ���� ����� index ����  
- `add(Object o)`: void. o �� element�� �߰�  
- `remove()`: next() �Ǵ� previous()�� �о�� ��Ҹ� ����  
- `set(Object o)`: next() �Ǵ� previous()�� �о�� ��Ҹ� o �� �����Ѵ�  

```
import java.util.*; 

ArrayList list = new ArrayList(); 
list.add("a"); list.add("b"); list.add("c");

ListIterator litr = list.listIterator();

// �տ��� �ڷ�, element�� ���� // a+ b+ c+  
while(litr.hasNext()){
	Object element = litr.next();
	lirt.set(element + "+"); 
}

// �ڿ��� ������, elemenet ��� // c+ b+ a+  
while(litr.hasPrevious()){
	Object element = litr.previous();
	System.out.print(element + " ");
}
```

# java.util.Arrays Class 
```
import java.util.Arrays;

int[] arr1 = {1,2};
int[] arr2 = {1,2};
int[] arr3 = {1,2,3};
int[][] arr4 = {{1,2},{2,3}};

//Arrays.toString(array)
System.out.println(arr1.toString()); // object�� toString�� ȣ��ȴ�
System.out.println(Arrays.toString(arr1)); // [1,2]
System.out.println(Arrays.deepToString(arr4)); // [[1,2],[2,3]] // ������ �迭�� ���    

//Arrays.equals(array1, arra2) 
Arrays.equals(arr1, arr2)); // true 
Arrays.deepEquals(arr1, arr4)); // false // ������ �迭 �� 

//Arrays.CopyOf(array, int num): num ������ŭ array ī���� ����
//num�� length �ʰ� �� 0���� ä���  
Arrays.copyOf(arr1, arr.length); // [1,2]
Arrays.copyOf(arr1, 4); // [1,2,0,0]

// copyOfRange(array, int startIndex, int endIndex): startIndex���� endIndex-1���� array�� ī���� ����. endIndex�� length�� �ʰ��ϸ� 0���� ä���  
Arrays.copyOfRange(arr, 0, 1); // [1]

//Arrays.fill(array, element): array�� ��� elemenet�� ä��� 
int[] arr = new int[3];
Arrays.fill(arr, 9); // arr = [9,9,9]
Arrays.setAll(arr, ()->(int)(Math.random()*5)+1); // 1���� 6���� ���� �� �������� ä��  

// Arrays.asList(object1, object2...): list�� �ٲ�  
ArrayList<Integer>list = new ArrayList<Integer>(Arrays.asList(1,2,3)); // 1,2,3�� list�� ���� 
 
//Arrays.sort(array): ����
Arrays.sort(arr); 

// Arrays.binarySearch(array, element): element�� ã�� index�� ����, ������ -1 

```
