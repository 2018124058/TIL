# Chapter 6. Arrays  
# 6.1 Array 기초  
## Array 의미  
array)data structure: a collection of data of the same type  
(같은 타입의 데이터를 모아놓은 자료구조)  
## array 정의  
```
 type[] arrayName = new type[length]; // type: data의 type, base type이라고도 한다`  
 
type[] arrayName; // 나중에 new로 생성도 가능
arrayName = new type[length];  
```
- type에는 class도 올 수 있다 -> array는 class objects를 갖는다   
- 예시  
	`double[] score = new double[5]; // 5 elements를 가진 array 생성`  
	`Class1[] obj = new Class1[100]; // Class1의 object 100개를 갖는 array`  
- cf. main method의 main(String [] args)  
	- String type의 array args라는 의미

### Square Brackets[]의 쓰임  
1. type name을 나타낼 때 `char[] arrayName;`  
2. array length를 나타낼 때 `arrayName = new char[5];`  
3. index로 array의 특정 element에 access할 때 `first = arrayName[0];`  
	- index: 0부터 시작, length-1 까지 

## Length Instance Variable
array는 object로 간주된다  
length는 array의 instance variable로, array의 사이즈에 맞추어 값이 자동 할당된다   
- length의 값은 바꿀 수 없다 
- arrayName.length로 활용  

## array initialization
정의를 할 때 initialization이 가능하다
- new operator을 따로 쓰지 않아도 된다 
- 이때 length는 자동으로 값이 할당된다 
- `type[] arrayName = {element1, element2, ...};` 
- 예시 `int[] num = {1,2,3}; // num.length = 3`
- initialization을 하지 않으면 자동으로 default value가 할당된다 
	- 정수, 실수는 0(0.0), boolean은 false, class type은 null 

## Array of Characters & String  
Characters로 이루어진 array는 String과 같지 않다 (다른 타입)
- C, C++ 에서는 같다 

```
char[] a = {'h','e','l','l','o'};
String s = a; // 오류
```
- String의 constructor을 이용해 array를 argument로 넣을 수는 있다  
`String s = new String(a); // 가능 s = "hello"`
- argument로 (array, 시작 인덱스, 넣을 캐릭터 개수) 지정 가능  
`String s2 = new String(a,2,3); // s2 = "llo"`

# 6.2 Array Reference  
## array reference  
array는 object다   

```
Class1 a; // Class1 class type의 variable a 선언 (declaration)  
a = new Class1(); // new를 하는 순간 a에 레퍼런스 주소가 할당됨 
class1 b = new Class1(); // b에 레퍼런스 주소 할당 

// array의 경우도 마찬가지 
double[] c; array type의 variable 선언 (아직 레퍼런스 할당x)
c = new double[10]; // 레퍼런스 주소 할당
double[] d = new double[10]; // 레퍼런스 할당  
```
array의 reference
- 메모리 공간에 elements의 주소가 쭉 붙어있는 모양. 첫 번째 element의 주소가 array의 reference가 된다.  

## Class Type의 Array  
- class type의 array를 생성하면 length만큼의 indexed variables, 레퍼런스들이 생성  
- length만큼의 objects가 생성되지는 X -> reference에는 자동으로 모두 null이 할당된다  
- object를 따로 new operator로 생성해주어야 한다
- 결국 array 생성할 때, object 생성할 때 총 두 번의 new를 써야한다 

```
Class1[] list = new Class1[20]; // 20개의 reference는 있으나 20개의 object는 아직 없음  
for (int i = 0; i < list.length; i++)
	list[i] = new Class1; // object 생성 
```

## Array and Parameters  
1. Entire Array를 파라미터로 넘길 때  
	- call-by-reference  
	- reference를 카피하기 때문에 값을 바꾸면 caller 쪽도 같이 변한다  
2. Array Element를 파라미터로 넘길 때 
	- call-by-value    

## Array, = , ==  
1. array를 할당(=, assignment)  
- 레퍼런스 같아짐  
- array간 == 성립

```
double[] a = new double[3];
double [] b = new double[3];
a = b; // true. 레퍼런스를 카피해 할당, b도 a와 같은 reference를 가리키게 된다!  
```
	
2. array element를 할당 

```
for (int i = 0; (i < a.length)&&(i < b.length); i++)
	b[i] = a[i];
	
a = b; // false. a와 b는 서로다른 reference를 갖는다. elements의 값은 같다 

// array의 elements가 같은지 비교하는 method 
public static boolean equalArray(int[] a, int[] b){
	if (a.length != b.length)
		return false; // 길이가 다르면 바로 false 
	else{
		for (int i = 0; i<a.length; i++){
			if (a[i] != b[i])
				return false;}
	return true;}  // 모두 통과해야 true 
```

## Array를 리턴하는 Method  
예시

```
public static int[] incrementArray(int[]a, int increment){
	// 새로운 array를 생성: privacy leak 방지
	int[] temp = new int[a.length];
	for (int i = 0; i<a.length; i++)
		temp[i] = a[i] + increment;
	return temp;} // 새로 생성한 array를 리턴한다 
```
# 6.3 Programming with Arrays  
## Patially Filled Arrays  
array의 size를 모르는 경우, array가 부분적으로만 채워진 경우  
- 가능한 가장 큰 사이즈로 array를 정의한다  
- array가 얼마나 사용되었는지 변수로 기록한다 (numberUsed)  

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
- element가 array의 element 하나하나 가리킴, 각각 실행 반복  
- 간단한 것에 주로 쓰인다  

## type...parameter 
`methodName(type...argName)`  
type...argName  
- 자체가 하나의 array (length variable 자동 생성) 
- arg가 몇개인지 모를 때. 몇개든 가능하다  
- type은 arg의 type (array의 type)  

## Privacy Leaks with Array Instance Variables  
array: call-by-reference 방식으로 작동하기 때문에 privacy leak 조심  

```
// accessor method with privacy leak
public double[] getArray(){
	return anArray;} // reference를 리턴한다->leak

// safe accessor: array를 새로 생성
public double[] getArray(){
	double[] temp = new double[length];
	for(int i = 0; i<length; i++)
		temp[i] = a[i] //element는 call by value
	return temp;}

// array가 class type일 때 
/* 1. array를 새로 생성
   2. object인 element를 copy constructor를 통해 새로 생성*/

public ClassName[] getArray(){
	ClassName[] temp = new ClassName[length];
	for (int i=0; i<length; i++)
		temp[i] = new ClassName(someArray[i]);
	return temp;}
```
## Sorting an Array  
: array를 파라미터로 받아 elements를 크기순으로 재정렬  
- n번째로 작은 element를 array[n]에 있는 element와 자리를 바꾼다  

## Enumerated Types  
- value가 보통 short list로 주어짐  
- class 내, method 밖 (constants가 정의되는 곳)에 위치  
` enum Type Name{FIRST_VALUE, SECOND_VALUE...LAST_VALUE};`  
- variable을 가질 수 있다  

```
enum WorkDay {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY}; // 이때 value는 constant. String이 아님
public void methodName(){
	WorkDay startDay = WorkDay.MONDAY;
	WorkDay endDay = WorkDay.FRIDAY;}
```
### methods in enumerated type  
- value1.equals(value2): enumerated type 내의 value 비교. '=='를 쓰는 것과 같다.  

- enumeratedName.value.toString(): value를 string으로 변환해 출력 ex. `WorkDay.MONDAY.toString() // "MONDAY"`  

- enumeratedName.value.ordinal(): value가 몇 번째에 있는지 int 리턴(index처럼 0부터 시작)  

- enuName.value1.compareTo(value2): 같으면 0, value1이 작으면 negative, 크면 positive (String의 compareTo와 비슷한 작동)  

- EnumeratedType[] values(): array elements를 enumerated type으로 리턴
`WorkDay[] day = WorkDay.values(); // WorkDay(enumerated type)의 array 생성. 인덱스 0부터 workday의 value 차례로 들어감`  

- EnumeratedType valueOf(String name): enumerated type value를 name으로 리턴함. name은 value값 내용과 매치되어야함. ex
`WorkDay.valueOf("MONDAY") // WorkDay.MONDAY`

# 6.4 Multidimensional Arrays  
## 선언  
`double[][]table = new double[5][10]; //2차원`  
- 첫번째 차원에 elements 5개, 첫번째 차원 1개당 두번째 차원의 element가 10개씩 딸려감  
- table의 레퍼런스는 `table[0]`의 주소, `table[0]`의 주소는 `table[0][0]`의 주소??  
- access: index를 통해 `[n][m]` 
## length  
차원마다 length가 존재한다
- table.length: 첫번째 차원의 길이  
- table[0].length: 두번째 차원의 길이  
## Ragged Arrays(비정형 배열)  
- row(첫번째 차원) 당 element 개수 다름  

```
double[][]a;
a = new double[3][]; //행마다 따로 크기 정할 수 있음
a[0]=new double[5];
a[1]=new double[3];
a[2]=new double[4];
```
## array 길이 변경 불가?

