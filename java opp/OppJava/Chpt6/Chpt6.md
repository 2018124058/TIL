# Chapter 6. Arrays  
# 6.1 Array ����  
## Array �ǹ�  
array)data structure: a collection of data of the same type  
(���� Ÿ���� �����͸� ��Ƴ��� �ڷᱸ��)  
## array ����  
```
 type[] arrayName = new type[length]; // type: data�� type, base type�̶�� �Ѵ�`  
 
type[] arrayName; // ���߿� new�� ������ ����
arrayName = new type[length];  
```
- type���� class�� �� �� �ִ� -> array�� class objects�� ���´�   
- ����  
	`double[] score = new double[5]; // 5 elements�� ���� array ����`  
	`Class1[] obj = new Class1[100]; // Class1�� object 100���� ���� array`  
- cf. main method�� main(String [] args)  
	- String type�� array args��� �ǹ�

### Square Brackets[]�� ����  
1. type name�� ��Ÿ�� �� `char[] arrayName;`  
2. array length�� ��Ÿ�� �� `arrayName = new char[5];`  
3. index�� array�� Ư�� element�� access�� �� `first = arrayName[0];`  
	- index: 0���� ����, length-1 ���� 

## Length Instance Variable
array�� object�� ���ֵȴ�  
length�� array�� instance variable��, array�� ����� ���߾� ���� �ڵ� �Ҵ�ȴ�   
- length�� ���� �ٲ� �� ���� 
- arrayName.length�� Ȱ��  

## array initialization
���Ǹ� �� �� initialization�� �����ϴ�
- new operator�� ���� ���� �ʾƵ� �ȴ� 
- �̶� length�� �ڵ����� ���� �Ҵ�ȴ� 
- `type[] arrayName = {element1, element2, ...};` 
- ���� `int[] num = {1,2,3}; // num.length = 3`
- initialization�� ���� ������ �ڵ����� default value�� �Ҵ�ȴ� 
	- ����, �Ǽ��� 0(0.0), boolean�� false, class type�� null 

## Array of Characters & String  
Characters�� �̷���� array�� String�� ���� �ʴ� (�ٸ� Ÿ��)
- C, C++ ������ ���� 

```
char[] a = {'h','e','l','l','o'};
String s = a; // ����
```
- String�� constructor�� �̿��� array�� argument�� ���� ���� �ִ�  
`String s = new String(a); // ���� s = "hello"`
- argument�� (array, ���� �ε���, ���� ĳ���� ����) ���� ����  
`String s2 = new String(a,2,3); // s2 = "llo"`

# 6.2 Array Reference  
## array reference  
array�� object��   

```
Class1 a; // Class1 class type�� variable a ���� (declaration)  
a = new Class1(); // new�� �ϴ� ���� a�� ���۷��� �ּҰ� �Ҵ�� 
class1 b = new Class1(); // b�� ���۷��� �ּ� �Ҵ� 

// array�� ��쵵 �������� 
double[] c; array type�� variable ���� (���� ���۷��� �Ҵ�x)
c = new double[10]; // ���۷��� �ּ� �Ҵ�
double[] d = new double[10]; // ���۷��� �Ҵ�  
```
array�� reference
- �޸� ������ elements�� �ּҰ� �� �پ��ִ� ���. ù ��° element�� �ּҰ� array�� reference�� �ȴ�.  

## Class Type�� Array  
- class type�� array�� �����ϸ� length��ŭ�� indexed variables, ���۷������� ����  
- length��ŭ�� objects�� ���������� X -> reference���� �ڵ����� ��� null�� �Ҵ�ȴ�  
- object�� ���� new operator�� �������־�� �Ѵ�
- �ᱹ array ������ ��, object ������ �� �� �� ���� new�� ����Ѵ� 

```
Class1[] list = new Class1[20]; // 20���� reference�� ������ 20���� object�� ���� ����  
for (int i = 0; i < list.length; i++)
	list[i] = new Class1; // object ���� 
```

## Array and Parameters  
1. Entire Array�� �Ķ���ͷ� �ѱ� ��  
	- call-by-reference  
	- reference�� ī���ϱ� ������ ���� �ٲٸ� caller �ʵ� ���� ���Ѵ�  
2. Array Element�� �Ķ���ͷ� �ѱ� �� 
	- call-by-value    

## Array, = , ==  
1. array�� �Ҵ�(=, assignment)  
- ���۷��� ������  
- array�� == ����

```
double[] a = new double[3];
double [] b = new double[3];
a = b; // true. ���۷����� ī���� �Ҵ�, b�� a�� ���� reference�� ����Ű�� �ȴ�!  
```
	
2. array element�� �Ҵ� 

```
for (int i = 0; (i < a.length)&&(i < b.length); i++)
	b[i] = a[i];
	
a = b; // false. a�� b�� ���δٸ� reference�� ���´�. elements�� ���� ���� 

// array�� elements�� ������ ���ϴ� method 
public static boolean equalArray(int[] a, int[] b){
	if (a.length != b.length)
		return false; // ���̰� �ٸ��� �ٷ� false 
	else{
		for (int i = 0; i<a.length; i++){
			if (a[i] != b[i])
				return false;}
	return true;}  // ��� ����ؾ� true 
```

## Array�� �����ϴ� Method  
����

```
public static int[] incrementArray(int[]a, int increment){
	// ���ο� array�� ����: privacy leak ����
	int[] temp = new int[a.length];
	for (int i = 0; i<a.length; i++)
		temp[i] = a[i] + increment;
	return temp;} // ���� ������ array�� �����Ѵ� 
```
# 6.3 Programming with Arrays  
## Patially Filled Arrays  
array�� size�� �𸣴� ���, array�� �κ������θ� ä���� ���  
- ������ ���� ū ������� array�� �����Ѵ�  
- array�� �󸶳� ���Ǿ����� ������ ����Ѵ� (numberUsed)  

## for-each Loop  
```
double[] a = new doubla [20];
//for
for (int i = 0; i<a.length; i++)
	a[i] = 0.0;
// for - each
for (double element: a)
	element = 0.0;
```

for - each  
- element�� array�� element �ϳ��ϳ� ����Ŵ, ���� ���� �ݺ�  
- ������ �Ϳ� �ַ� ���δ�  

## type...parameter 
`methodName(type...argName)`  
type...argName  
- ��ü�� �ϳ��� array (length variable �ڵ� ����) 
- arg�� ����� �� ��. ��� �����ϴ�  
- type�� arg�� type (array�� type)  

## Privacy Leaks with Array Instance Variables  
array: call-by-reference ������� �۵��ϱ� ������ privacy leak ����  

```
// accessor method with privacy leak
public double[] getArray(){
	return anArray;} // reference�� �����Ѵ�->leak

// safe accessor: array�� ���� ����
public double[] getArray(){
	double[] temp = new double[length];
	for(int i = 0; i<length; i++)
		temp[i] = a[i] //element�� call by value
	return temp;}

// array�� class type�� �� 
/* 1. array�� ���� ����
   2. object�� element�� copy constructor�� ���� ���� ����*/

public ClassName[] getArray(){
	ClassName[] temp = new ClassName[length];
	for (int i=0; i<length; i++)
		temp[i] = new ClassName(someArray[i]);
	return temp;}
```
## Sorting an Array  
: array�� �Ķ���ͷ� �޾� elements�� ũ������� ������  
- n��°�� ���� element�� array[n]�� �ִ� element�� �ڸ��� �ٲ۴�  

## Enumerated Types  
- value�� ���� short list�� �־���  
- class ��, method �� (constants�� ���ǵǴ� ��)�� ��ġ  
` enum Type Name{FIRST_VALUE, SECOND_VALUE...LAST_VALUE};`  
- variable�� ���� �� �ִ�  

```
enum WorkDay {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY}; // �̶� value�� constant. String�� �ƴ�
public void methodName(){
	WorkDay startDay = WorkDay.MONDAY;
	WorkDay endDay = WorkDay.FRIDAY;}
```
### methods in enumerated type  
- value1.equals(value2): enumerated type ���� value ��. '=='�� ���� �Ͱ� ����.  

- enumeratedName.value.toString(): value�� string���� ��ȯ�� ��� ex. `WorkDay.MONDAY.toString() // "MONDAY"`  

- enumeratedName.value.ordinal(): value�� �� ��°�� �ִ��� int ����(indexó�� 0���� ����)  

- enuName.value1.compareTo(value2): ������ 0, value1�� ������ negative, ũ�� positive (String�� compareTo�� ����� �۵�)  

- EnumeratedType[] values(): array elements�� enumerated type���� ����
`WorkDay[] day = WorkDay.values(); // WorkDay(enumerated type)�� array ����. �ε��� 0���� workday�� value ���ʷ� ��`  

- EnumeratedType valueOf(String name): enumerated type value�� name���� ������. name�� value�� ����� ��ġ�Ǿ����. ex
`WorkDay.valueOf("MONDAY") // WorkDay.MONDAY`

# 6.4 Multidimensional Arrays  
## ����  
`double[][]table = new double[5][10]; //2����`  
- ù��° ������ elements 5��, ù��° ���� 1���� �ι�° ������ element�� 10���� ������  
- table�� ���۷����� `table[0]`�� �ּ�, `table[0]`�� �ּҴ� `table[0][0]`�� �ּ�??  
- access: index�� ���� `[n][m]` 
## length  
�������� length�� �����Ѵ�
- table.length: ù��° ������ ����  
- table[0].length: �ι�° ������ ����  
## Ragged Arrays(������ �迭)  
- row(ù��° ����) �� element ���� �ٸ�  

```
double[][]a;
a = new double[3][]; //�ึ�� ���� ũ�� ���� �� ����
a[0]=new double[5];
a[1]=new double[3];
a[2]=new double[4];
```
## array ���� ���� �Ұ�?

