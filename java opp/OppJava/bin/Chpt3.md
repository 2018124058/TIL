# chpt3. Flow of Control 
## Branching Mechanism 
### if, else 문  
수행문(statement)가 하나일 때 (블락 필요x)  
else part는 생략 가능하다 (omit)  

```
if (조건)
	statement;
else
	statement;
```
수행문(statement)가 여러개일 때  

```
if (조건)
{statements;}
else
{statements;}
```

nested statements(중첩 가능하다)  
블락이 커진다?

```
if(i<15)
{
	System.out.println("i는 15보다 작다");
	if (i<12)
		System.out.println("i는 12보다 작다");
	else
		System.out.println("i는 12,13,14 중 하나다");
}
```

multiway if-else statement: else if 

```
if (Boolean Expression)
	statement_1
else if (Boolean Expression)
	statement_2
...
else
	statement for all other possibilities
```
The Conditonal Operator  
- 간단한 케이스일 때 활용 가능 

```
if (x>y)
  int s = 1;
if (x<y)
  int s = 0;
```
이걸 `int s = (x>y) ? 1 : -1;`로 표현 가능하다 
- ?는 조건문 만족할 때, :는 만족하지 못했을 때 

### the Switch Statement  
- case에 따른 수행과 break  
- default: 모든 케이스가 아닐 때  
- break가 없으면 다음 케이스까지 수행됨  
-  controlling expression의 값: char, int, short, byte, String  
-  복잡한 condition 기입하기 어려움 
-  default는 없어도 됨 
  

```
switch(Controlling Expression)
{
 case Case_Label_1:
 	statement_sqeuence_1
 	break;
 case Case_Label_2:
 	statement_sequqence_2
 	break;
 ...
 default:
 	default_statement_sequence
 	break;
 }
 ```
## Boolean Expression
boolean expression value ` true or false `  
boolean operators ` and && or || not ! `
-  short circuit evalution
    - `&&` 앞이 false면 뒤의 것은 실행하지 않는다(true,false 판단x. evaluationx)  
    - `||` 앞이 true면 뒤의 것은 실행하지 않는다
    
comparison operators `== != > >= < <=`  
precedence and associativity rules
 -  괄호 없이 나열 시 우선순위: unary -> binary
 -  associativity: 오른쪽 왼쪽 계산 방향  
 -  가독성을 위해 괄호를 사용하기  

Evaluating Expressions
 - binding: operand가 어떤 것들인지 파악한는 것. (precedence와 associativity 고려).연산을 하기위해 operation를 적용할 operands를 찾아 연관 (associate) 시키는 과정
    -     operator가 작용하는 값 = operand
 - side effects: expression은 계산을 해 결과값을 return하는 것이 목적, 이외의 다른 효과를 side effects라 함 
    -  ex. value 값을 assign하거나 바꾸는 것 
           `y = 5; x = y+3` 8을 리턴, x값이 할당된 것이 side effects

### String의 비교  

strings ` ==  `
- same value를 갖고있는지(내용 상) x
- same memory location (같은 주소, 같은 reference참조)를 갖고있는지 테스트
- literal: 자바가 메모리의 한 공간에 세이브 함 -> 같은 공간을 가리키고 있으면 == true 
 
 ```
 String str1 = "somsom";
 String str2 = str1; 
 String str3 = "somsom"; //미리 마련한 somsom 공간을 가리키게 됨
 String str4 = new String("somsom"); 
 //value는 같으나, new로 새로운 object somsom을 생성했기 때문에 다른 주소를 가짐 
 str1 == str2 == str3; //true
 str1 == str4;         //false
 ```
 
strings의 value(contents)를 비교하고 싶다면 equals, equalsIgnoreCase Methods(대소문자 구분x) 사용  

lexicographic order for string
- 사전순 배열: 대문자>소문자>숫자(작은순으로 앞)
- 비교대상(string2)이 앞쪽이면 양수, 뒤쪽이면 음수, 같으면 0 
- 숫자의 절대값은 중요하지 않음(자바 implementation에 따라 다르게 나올 수 있음)  
- method: string1.compareTo(string2) 
          string1.compareToIgnoreCase(string2) : 대소문자 무시

```
string entry = 'adventure123';
System.out.println(entry.compareTo("zoo"); //음수
```

##Loops(반복문)
###while
조건문이 true면 진입해 statement 실행 ->다시 조건문에 올라가 테스트해 true면 진입해 실행...반복하다가 조건문이 false가 되면 실행x 빠져나온다

```
while (Boolean_Expression)
	Statement
```
```
//statement가 여러 개일 때 
while (Boolean_Expression)
{ 
  Statement_1
  Statement_2
  ...
 }
 ```
### do-while  
 do를 만나면 처음에는 아무 조건없이 statement 실행->while 조건문 테스트, true 면 올라가 statement 실행...반복하다가 조건문이 false가 되면 빠져나옴  
 - do-while은 조건문의 boolean값과 상관없이 우선 statement를 한 번 실행한다는 점에서 while과의 차이점! 

 ```
do
	Statement
while (Boolean_Expression);
```
```
//Statement가 여러 개일 때 
do
{
  Statement_1
  Statement_2
  ...
 } while (Boolean_Expression); //세미콜론 주의!
```
###for
처음 진입 시 initialization 실행(이후 실행x)-> 조건문 test ->true 면 body 실행, update->다시 조건문 test...반복 -> 조건문 false면 body 진입 안하고 빠져나옴 
 
```
for (Initialization; Boolean_Expression; Update) //update에 세미콜론이 없다...!
	Body
```
for -> while
 -  Initialization은 while문 작성 전에
 -  조건문은 그대로 while (Boolean_Expression)
 -  Body 맨 끝에 update 붙임  

Nested Loops 반복문 중첩 
 -  inner loop 전체가 outloop 반복 1회마다 반복된다 

 
###보조제어문  
####break  
break 조건을 만족시키면, 자신을 포함하는 가장 가까운 loop를 빠져나온다(전체 loop에서 탈출x) 

```
while (Boolean_Expression){
	//codes
	if (condition to break){
		break;  //while문에서 빠져나옴
	}
	//codes
}
```
```
do{
	//codes
	if (condition to break){
		break; //while문에서 빠져나옴
	}
	//codes
}
while(Boolean_Expression);
```
####continue  
반복문을 빠져나오진 않으나 continue 조건을 만족시키면 그 뒤에 있는 코드를 실행하지 않고 맨 처음으로 다시 올라가 반복을 수행함 

```
while (Boolean_expression){
	//codes
	if (condition to continue){
		continue;
	}
	//codes: continue 시 실행 안되고 while로 올라감
}
```
####exit  
`System.exit(0);`
System class의 exit method: 아예 프로그램을 끝내버림
- 전통적으로 0은 프로그램이 정상적으로 끝났음을 나타냄  

##Debugging  
debugging; 프로그래밍에서 오류를 찾아 고침 

debugging techniques
>-  프로그램 전체를 살펴보기: 특정 부분에 오류가 있다고 미리 가정x
>-  여러가지 test case를 시도하고 input value 살펴보기 
>-  프로그램을 단순화하여(comment out) 부분을 살펴보기 
>-  check common pitfall
>-  잠시 쉬고 다시 살펴보기
>-  NO RANDOM CHANGE! 아무 근거 없이 한번 바꿔보지 않기. 하나하나 따져보자 

preventive coding
>- Incremental Development: 조금씩 코딩하고 컴파일해서 실행해보기. 단계적으로!
>- Code review: 다른 사람이 보게 하기 
>- pair programming: 한 사람이 타이핑 할 때 다른 사람이 지켜보고, 역할 바꾸기

Debugging in Eclipse
- breaking points 설정: 각 줄 왼쪽 숫자 더블클릭. 여러 개 설정 가능
- debugging 버튼 누르면 시작
- perspective switch: 디버깅 메뉴창 보여줌. (name, value)
- step over: same level의 다음 줄로 넘어감
- step into: lower level의 method로 이동
- step return: upper level, 한 단계 위로 다시 올라감
- resume: 다음 breaking point까지 쭉 실행
- terminate: stop debugging

##Random Number  
pseudorandom number
 - 랜덤 같아 보이지만, 실제로는 seed value에 의해 initialize된 sequence of random numbers를 이미 갖고 있다
 - seed value가 같으면 항상 같은 순서대로 random number가 나온다

random object: Random class를 import하는 방법 
 - 잘 쓰이지는 않는다

 ```
 import java.util.Random;
 
 Random randomGenerator = new Random(); //object 생성
 // 모든 int 범위 내 int
 int a = randomGenerator.nextInt(); 
 // 0부터 (n-1)까지의 범위 내 int
 a = randomGenerator.nextInt(n);
 // 모든 double 범위 내 double
 double b = randomGenerator.nextDouble();
 ```
 
 Math.random() method 이용하기 
 - lang에 Math class가 이미 있어서 따로 import x
 
 - `Math.random()` 0.0<= num < 1.0 의 random double return ->이걸 변형하기 
 
 ```
 0.0 <= (Math.random() * 6) < 6.0
 0 <= (int)(Math.random()*6) <= 5
 0 <= (int)(Math.random()*6) + 1 <= 6 // 주사위!
 ```
 