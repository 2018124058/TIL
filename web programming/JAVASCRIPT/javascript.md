# 자바스크립트 기초  
## linking  
1. .js파일로 저장해 head section에서 linking  
`<script src = "example.js"></script>`  
2. body or head section에 바로 넣기  
    - 가독성 안좋음 

## 기본  
- 자바스크립트: 대소문자 구분 (case sensitive)
- string: "" 또는 ''로 선언
- statement는 ;로 끝내기 

## object (자바스크립트 제공)
- document: built in 객체. 현재 html 문서 가리킴
- window: built in 객체. 현재 브라우저 가리킴

## 클래스? 
### Date: 현재 local time에 대한 정보 제공  
`let now = new Date(); // Date의 객체 생성`  
`now.getHours();` getHours() method: 현재 시간(0-23) 제공
    

## methods 
- 객체는 메소드를 호출할 수 있다  
- 출력
    - `document.write("<h1>hi</h1>")` 현재 문서에 출력 (element 추가 가능) 
    - `document.writeln("~")` write와 다르게 한 줄 차지  
- `document.getElementById("id1")` id가 id1인 element를 불러옴  
- `innerHTML` start tag와 end tag 사이 content 가리킴
- `document.getElementById("id1").innerHTML` id1이라는 id를 가진 element의 content

### dialog: 팝업창 띄움
-  `window.alert("경고")` 브라우저에 경고창 띄움
- prompt: 사용자 인풋 받을 수 있음 

    ```
    let name; // string entered by the user
    name = window.prompt("이름 입력: ", "디폴트");
    document.writeln("<h2>hello " + name + "</h2>");
    ```
    - prompt의 파라미터: 안내 메세지, 디폴트 값(optional)  
    - prompt: 확인, 취소 버튼이 뜨는데 취소버튼을 누르면 input으로 null이 들어간다 -> display 시 null이 출력 
    - prompt로 받은 input은 string이다

### Type convert
- parseInt(): string을 int로 리턴 (string 중 변환할 수 있는 곳까지만)
    - parseInt(String, radix(몇진수인지))  
- parseFloat: string을 float로 리턴 

### 수학 계산  
- `Math.pow(arg1, arg2);` 제곱 계산: arg1를 arg2만큼 제곱  
- `numberVal.toFixed(n);` 소숫점 n의 자리까지만 리턴


## Variable 변수  
### 변수 선언
1. let  
`let x = 2;`  
- global/block/function scope 모두 지원  
- 재선언 불가능  
2. var  
`var x = 2;`
- global/function scope 지원, block scope는 x
- 같은 변수 재선언 가능  
3. 상수 선언: const  
- 값 바꿀 수 없음  

## Scope Rules 변수 범위 규칙  
1. Global variable  
    - global scope: 프로그램 전체에서 access 가능  
2. Local variable & function parameter  
    - local or function scope  
    - global 과 local 변수 이름이 같다면, local 변수가 우선 순위   
3. Block scope 지원  
    - {} 안에서 선언된 변수는 블락 안에서만 보이고, 사용할 수 있다  

## Type  
- 자바스크립트: loosely-typed
    - type checking이 loose
    - 변수 선언 시 타입 명시 x  
    - 변수가 다양한 타입의 value 가질 수 있음  
    - 자동변환

- type: Number, Boolean, String, Array, Object, Function, null, undefined  
- undefined: 선언했으나 값 할당x
- null:  명시적으로 empty value 할당 
    - display할 때는 NULL이라고 출력된다  
    - 자동변환: 0, false, "null"
- Number: 0이면 false, "0" 
- String: 비었으면 false, 글자로 이루어져있으면 number로 변환시 NaN(not a number)  
    - 문자열과 숫자를 비교할시 문자열이 숫자로 변환됨 (NaN으로 변환되면 언제나 false)
- Array: 비었으면 false. "안의 elements" 
- NaN: false. number로는 NaN. "NaN" 



## 제어문  
### 조건문 
- if
```
if (condition)
    {statement;}
```
- if- else if - else
- switch

## 반복문  
- while  
- do-while  
- for  
```
for (let counter = 1; counter <7; ++counter)
    {statement;}
```
- for-in/of 

# Function  
## Function 기초 개념  
- 자바스크립트 modules 중 하나  
- method: 객체가 소유하는, 미리 정의된 함수  
## Function Definition  
```
function functionName(parameterList)
{
    declarations and statements // function body
}
```
## Parameter, Argument  
parameters: , 로 구분  
(parameterList) 영역에서 parameter의 default value 설정 가능  
`Function myFunction(x, y=10)`  
### arguments 개수 
1. 파라미터가 함수 선언에서보다 적게 입력됨(missing arguments)  
    - missing values는 `undefined`가 됨  
    - no compile error
2. too many arguments  
    - `arguments` 객체로 access 가능  
    - no compile error  
3. 개수 모름 (indefinite number of args)  
    - 파라미터들이 array가 됨 
    - `function f(arg1, arg2, ...lastArg)` 마지막 파라미터 앞에 ...붙임  
    - array(배열) -> array method(sort, map, pop) 사용 가능  
### arguments (객체)  
- 모든 argument 포함하는 객체  
- `arguments.length` argument 개수 
-  array이기 때문에 index로 접근 가능하다 `arguments[0]`  
### Passing Parameters  
1. Pass-by-Value  
    - 파라미터의 value를 copy해 전달  
    - original variable is unchanged  
    - function: value를 받고, argument의 주소는 알지 못한다   
    - 함수 내에서 파라미터 값이 바뀌어도 밖에서 반영 x  
2. Pass-by-Reference  
    - objects(ex. array)가 파라미터일 때  
    - 객체의 주소(reference)가 전달된다  
    - original value에 direct access 가능  
    - 함수 내 object 값을 바꾸면 밖에서도 적용, 같이 바뀜 
    - weaken security   

