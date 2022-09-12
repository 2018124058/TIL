# R 기초  
## 기초 용어  
- object: where values are saved in R  
    - type: defines how an object is stored in R  
    - class: defines what information an object contains and how it may be used  


# R 기초 문법  

## 주석  
- `#` 으로 처리  

## 연산자  
- 더하기(addition): `+`  
- 빼기(subtraction): `-`  
- 곱하기(multiplication): `*`  
- 나누기(division): `/`  
- 제곱(exponentiation): `^`  
- `( )` : 연산의 순서를 정한다. 괄호 안의 연산을 먼저.  ex. `( 3 + 3 ) * 2` ()  

## Functions  
- function: performs tasks in R by taking in input objects called arguments and return output objects. command라고도 불린다.  
- `funcname(input)` 의 형태  
### Functions 예시  
- `help(arg)` : r studio 우측 help 창에 arg에 대한 설명이 나온다.  
- `seq()` : 숫자들의 나열을 출력한다,  
    - argument  
        - `from = n` n 부터 시작  
        - `to = n` n까지  
        - `by = n` n만큼의 간격으로. default는 1.   
    - `seq(from = 1, to = 10, by = 2) # output: 1 3 5 7 9`  

## Variable assignment  
- variable (변수): value나 object를 저장할 수 있다. assign(할당) 후 variable 의 이름으로 저장한 value나 object에 쉽게 접근할 수 있다.  
- `<-` : 할당을 위한 operator   
    - `score <- 100` : score이라는 variable에 100이라는 value를 저장  
    - 이후 `score` 또는 `print(score)` 로 score의 value를 출력할 수 있다.   

- 변수 이름 짓기  
    - 문자, 숫자, `_`, `.` 만 포함될 수 있다.  
    - 변수 이름은 문자 또는 점으로 시작해야 한다. 점으로 시작할 때 다음 글자는 숫자가 올 수 없다.  
    - 공백 포함 불가  

## data types in R   
- `class(variable)` : variable의 data type을 출력한다  

### data type: Integers (정수)  
- nutural numbers  
- `L` : 정수 뒤에 붙어 정수를 double과 구별 ex. `3L -6L`  

### data type: Numerics/Doubles (실수)  
- 실수 (정수 포함) ex. `-1.5`  
- numerical value는 디폴트로 double로 표현된다  

### data type: Logical  
- boolean values  
- `TRUE`, `FALSE` : 대문자에 유의하기  

### data type: Character
- string (text) values  
- `"content"` : `"`사이에 표기한다

## R objects  

### 1. Vectors  
- one-dimension array that can hold numeric data, character data or logical data  
- `c()` : vector 생성. c는 combine 또는 concatenate의 줄임말  
    - `numeric_vector <- c(1, 2, 3)`  
    - `character_vector <- c("a", "b", "c")`  
    - `boolean_vector <- c(TRUE, FALSE, FALSE, TRUE)`  

#### arithmetic calculations on vectors  
- 연산을 하는 vector 간 element의 개수가 같아야한다 
- `c(1, 2, 3) + c(4, 5, 6)`  
- `c(1, 2) + c(4, 5, 6) # error`  
```
a <- c(1, 2, 3)
b <- c(4, 5, 6)
c = a + b 
c # output: 5 7 9  
```
### Using Comparison Operator on Vector  
- 비교 연산자: `< > <= >= == !=`  
- vector 간 비교의 경우 각각의 element를 차례로 비교해 boolean을 리턴  
    - `c(1, 2, 3) > c(0, 1, 4) # output: TRUE TRUE FALSE`  
- vector와 numeric value를 비교할 수 있다.  
    - `c(1, 2, 3) > 2 # output: FALSE FALSE TRUE`  
    








### 2. Matrices  

### 3. Factors  

### 4. Data frames  

### 5. Lists  




