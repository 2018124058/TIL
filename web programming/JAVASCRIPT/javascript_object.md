# Object(객체)  
- property, method를 갖는다
- method: 함수 정의를 갖고 있는 하나의 property라 볼 수 있음  
- addressed by reference, not by value (call-by-reference)

## 객체 선언  
1. {} 안에 peroperty, method  
```
let objectName = {property1: value, property2: value, functionName: function(){statement;}}
```
    - 1번 방법이 가독성, 처리속도 더 높음 
2. new 사용 (권장은 x)  
```
let objectNme = new Object(); // Object() 자바스크립트 built-in function  
objectName.property1 = value;
objectName.property2 = value;
```  

## Object.defineProperty  
`Object.defineProperty(object, "property", descriptor)`  
- object property를 추가하거나 바꿀 수 있다  
```
let person = {firstName: "Lee", lastName: "soso", language: "KO"};
// add a property
Object.defineProperty(person, "age", {value: 20});
// change a property
Object.defineProperty(person, "language", {value: "EN"});
// make property read-only (수정 불가능해짐)
Object.defineProperty(person, "language", {writable:false});
// make property not enumerable
// key로 access 불가능해짐
// Object.keys(person) 에서 해당 property가 나오지 않는다 
Object.defineProperty(person, "language", {enumerable: false});
```  

## Constructor Function  
- object type (class) 생성  
```
// object constructor function
function Person(firstName, lastName, age){
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
}

// object 생성
let friend = new Person("Kim", "Hun", 25);
```

## Math Object  
- built-in object  
- 다른 global objects와 달리, constructor가 없음. 
- Math object를 생성하지 않고 method, property 활용 가능 (static). new operator 필요x  
```
Math.PI; // 원주율 
// max: 두 수 중 큰 값 리턴
Math.max(x,y)
// pow: 제곱
Math.pow(2, 4) // 2의 4제곱

//random: (0 <= n < 1) 의 랜덤한 숫자 리턴
Math.random()

// random과 floor(버림)을 활용해 특정 범위의 랜덤한 '정수' 뽑기 
// 1부터 6까지
Math.floor((Math.random() * 6)+1);
Math.floor(Math.random() * 6) + 1;
// min <= n < max
function randomInteger1(min, max){
    return Math.floor(Math.random() * (max-min)) + min;
} 
// min <= n <= max
function randomInteger2(min, max){
    return Math.floor(Math.random() * (max-min+1)) + min;
}
```

## String Object  
string: primitive type으로서 literal로 생성될 수도 있고, object로서 생성될 수도 있다  
```
let str1 = "hi"; // str1은 string 
let str2 = new String("hi"); //str2는 object
str1 == str2 // true (equal values) 
str1 === str2 // false. ===는 type과 value가 둘다 같아야 함. 

let str3 = new String("hi"); //str3은 str2와 별개의 또다른 object
str2 == str3 // false (different reference) 
str2 === str3 // false
```

primitive value인 string을 object처럼 다루어 method, property 사용 가능  
- `str.length`  // string property

### String Method  
- `str.search("val")` 처음으로 value를 갖는 부분을 찾고 첫 글자의 index 리턴  
- `str.replace("val1","val2")` 문자열의 val1을 val2로 바꿈  
    - 기존 문자열을 바꾸지 않고, 새로운 문자열을 리턴
    - regular expression을 활용 가능  
- `str.split("separator")` 구분자 기준으로 문자열을 나눠 array를 리턴  
    - separator을 생략하면 length가 1인 array 리턴  
    - separator가 `""`면 글자 하나하나를 element로 갖는 array 리턴  

#### String의 일부를 추출하는 방법 3가지  
- 세가지 모두 새로운 문자열을 리턴  
- 두번째 파라미터는 생략 가능, 생략하면 나머지 문자열의 끝까지 추출한다

1. `str.slice(startIndex, endIndex)`  
- startIndex부터 endIndex-1까지 추출 
- index 값이 음수면 문자열의 끝에서부터 센다  
2. `str.substring(startIndex, endIndex)`  
- startIndex부터 endIndex-1까지 추출  
- 파라미터로 음수가 올 수 없다  
3. `str.substr(startIndex, length)`  
- startIndex부터 length개 만큼 추출  
- startIndex에 음수가 올 수 있다  

## Regular Expression (정규식)  
- object의 일종  
- pattern  
- `search`, `replace`등에 활용 가능  

```
/pattern/ 
/pattern/i  // case-insensitive, 대소문자 구분x 
/pattern/g  // global, 전체 영역에서 해당되는 것 모두 가리킴
```
### character 종류  
1. normal characters: match themselves  
2. metacharacters: x match themselves  
    - backslashed (앞에 \ 붙이기) -> normal character 취급됨  
    - `\ | () [] {} ^ $ * + ? .`  
    - `.` matches any character except newline  

### sequence of characters  
- 가능한 characters 지정 `[]`  
    `[012] // 0,1,2 중 하나` 
- `-` 범위 지정 
    ` [0-9] // 0부터 9까지 범위 중 하나`  
- `^` opposite (여집합)  
    `[^aeiou] // 자음`  

| 축약형|패턴|의미| 
|-----|----|---|  
|`\d`|`[0-9]`| a digit|  
|`\D`|`[^0-9]` or `[^\d]`| not a digit|  
|`\w`|`[A-Za-z_0-9]`|a word character (특수기호 제외)|  
|`\W`|`[^A-Za-z_0-9]` or `[^\w]`| not a word character|
|`\s`|`[\r\t\n\f]`| a whitespace character|  
|`\S`|`[^\r\t\n\f]`| not a whitespace character|  

### Quantifier   
- 빈도수 표현 `{}`  

|quantifier|의미|  
|---|---|  
|`{n}`| 정확히 n번 반복|  
|`{m,}`| m번 이상 반복|  
|`{m,n}`| m번 이상 n번 이하 반복|  
| `*`| 0번 이상|  
|`+`| 1번 이상|  
| `?`| 0번 또는 1번|  

```  
// 전화번호 패턴
\d{3}-\d{3,4}-d{4}
```  

