# 자바스크립트 기초  
## linking  
1. .js파일로 저장해 head section에서 linking  
`<script src = "example.js"></script>`  
2. body or head section에 바로 넣기  
    - 가독성 안좋음 

## 기본  
- 대소문자 구분 (case sensitive)
- string: "" 또는 ''로 선언
- statement는 ;로 끝내기 

## window, document  
- document: built in 객체. 현재 html 문서 가리킴
- `document.write("<h1>hi</h1>")` `document.writeln("~")`현재 문서에 출력(element 추가 가능)  
-  window: built in 객체. 현재 브라우저 가리킴
-  `window.alert("경고")` 브라우저에 경고창 띄움

## dialogs  
- 윈도우에 팝업 띄움  
- 메소드 
    - alert: 경고창 
    - prompt: 사용자 인풋 받을 수 있음 

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

### Type convert
- parseInt(): string을 int로 리턴 (string 중 변환할 수 있는 곳까지만)
    - parseInt(String, radix(몇진수인지))  
- parseFloat: string을 float로 리턴 

## 제어문  
### 조건문 
- if
```
if (condition)
    {statement;}
```
- if-else
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


