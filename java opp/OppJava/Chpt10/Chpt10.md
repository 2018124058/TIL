# Chapter10. Recurision  
# 10.1 Recursion Basics  
## Recursive method  
- �ڽſ� ���� call�� �����ϴ� method (method that includes a call to itself)  
- problem solving technique of breaking down a task into subtasks  
- subtask�� original task�� smaller version�� �� ����  

```
//����: �� �ڸ����� ���ڸ� �ϳ��� ����ϴ� method writeVertical  
public static void writeVertical(int n){
	if (n < 10){ //stopping case
		System.out.println(n);
	}
	else{
		writeVertical(n / 10); // recursive call 
		System.out.println(n % 10);
	}
}
// output: n = 123 �� �� 1\n 2\n 3\n�� ��� 
```
## Subtasks  
�� ������ subtask  
1. smaller version of the original task  
- recursive call ����  
- ���ÿ����� `writeVertical(n/10);`  
2. stopping(simple) case  
- infinite recursion�� ����  
- ���ÿ����� `n < 10`�� statement  
	- stopping case�� ��������, `writeVertical(0)`�� ������ �ݺ��ǰ� �ȴ�  
	
## Stacks for Recursion  
- recursion�� keep track�ϱ� ���� ��ü�� stack�̶�� data structure�� ����Ѵ�  
- stack  
	- memory structure�� �� ����  
	- ���̸� �׾Ƶδ� ��ó��, ���ο� ���̴� �� ���� ���̰�, ���� ���� �� ���� ���̸� ���� ������  
	- = LIFO(Last In First Out)  
	- ![stack �׸�](stackForRecursion.JPG)  

## Recursion vs Iteration  
- recursion: �ݵ�� �̿��ؾ��ϴ� ��x. non-recursive version, �� iterative version(�ݺ� Ȱ��)���ε� ������ �ذ��� �� �ִ�  
- recursion vs iteration  
	- recursion�� �� simple������ ������  
	- recursion�� storage�� �� ���� ����(stack�� �����ϴ� �� �δ��� ŭ)  
	- �˰����� Ǯ ���� recursion�� �����ϱ� ������, ���� Ȱ���ϴ� ���α׷��� ���� ���� iteration�� �̿��ϴ� ���� �� ȿ�����̴�  
	
### Iterative Version of writeVertical   
```
public static void writeVertical(int n){
	int nsTens = 1;
	int leftEndPiece = n;
	while (leftEndPiece > 9){
		leftEndPiece = leftEndPiece / 10;
		nsTens = nsTens * 10;
	}
	//nsTens�� �ڸ�����ŭ 10�� ������ �� (ex. 2312��� nsTens�� 1000) 
	
 	for (int powerOf10 = nsTens; powerOf10 > 0; powerOf10 = powerOf10 / 10){
 		System.out.println(n / powerOf10);
 		n = n % powerOf10;
 	}
 }
```
# 10.2 Binary Search  
## ����  
- sorting�� �� array���� �־��� value�� �ִ��� ã�� ��  
- ó������ ������ ���� �ͺ��� binary search�� ȿ�����̴�  
- value�� ã���� �ش� value�� index ����, ������ -1�� ����  
- recurision �� ���  
	- �� ���� stopping case: first>last�� ���� ��, key�� ã���� �� 
- �ݾ� ��� �߶� ã�ƺ��� 'divide and conquer' technique  
```
/*
precondition:
a[first] <= a[first+1] <= a[first+2] ... <= a[last] sorting�� ����  */
if (first > last) // stopping case  
	return -1;    // Ž�� ����, value�� ���� 
else{
	mid = first�� last�� �뷫���� �߰���;  
	if (key == a[mid]) // stopping case
		return mid; 
	else if key < a[mid]
		return a[first]���� a[mid-1]���� ã�� �����; // recursion
	else if key > a[mid] 
		return a[mid+1]���� a[last]���� ã�� �����; // recursion  
}
```
## Binary Search ����
  
```
public static int search(int[] a, int first, int last, int key){
	int result = 0; // to keep the compiler happy
	
	if (first > last)
		result = -1;
	else{
		int mid = (first + last)/2;
		
		if(key == a[mid])
			result = mid;
		else if (key < a[mid])
			result = search(a, first, mid -1, key);
		else if (key > a[mid])
			result = search(a, mid+1, last, key);
	}
	return result;
}
```

## Iterative Version of Binary Search  
- �� ȿ����  

```
public static int search(int[] a, int lowEnd, int highEnd, int key){
	int first = lowEnd;
	int last = highEnd;
	int mid;
	
	boolean = found = false;
	int result = 0; 
	
	while((first<=last)&&!(found)){
		mid = (first+last)/2;
		
		if (key == a[mid]){
			found = true;
			result = mid;
		}
		else if (key < a[mid]){
			last = mid - 1;
		}
		else if (key > a[mid]){
			first = mid + 1;
		}
	}
	if (first > last)
		result = -1;
	
	return result;
}
```

	
		  
  

 
