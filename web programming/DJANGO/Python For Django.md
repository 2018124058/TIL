# Python for Django 
- django에서 자주 쓰이는 파이썬 문법 
1. 자료형(딕셔너리)
2. 예외처리
3. 클래스와 객체
4. 모듈, 패키지, 라이브러리  

# 1. 딕셔너리 자료형  
딕셔너리: 대응이 되는 데이터를 표현하는 자료형(key와 value)  
- 탐색의 기준이 되는 키워드(key)를 통해 찾고자하는 값(value)을 얻음  
<br>

`val = {key1:value1, key2:value2,...}`
- key는 중복되거나 변하면 안된다  
- value 찾기: `print(val[key1]) //value1`  
- 새로운 데이터 쌍 추가 `val[key3] = value3`  

# 2. 예외처리 (exception handling)  
참고: https://docs.python.org/ko/3/tutorial/errors.html  

## 파이썬의 오류
- 오류: 문법에러(파싱에러)와 예외
1. 문법 에러(파싱 에러): 실행 자체에 영향을 주는 치명적인 오류  
2. 예외: 실행 중 감지되는 오류. 프로그램 실행 자체를 멈추지는 않는 에러

## Exception Handling
try - except - finally  
- 프로그램을 멈춤없이 실행시키기 위해 

```
try: 
    # 일단 시도해 볼 코드 (오류가 생길 여지가 있음)  
except 발생 오류:
    # 발생 오류가 발생했을 경우 실행할 코드
```

```
try:
    # 일단 시도해볼 코드 
except:
    # 어떤 오류가 발생하든 실행할 코드 
finally:
    # 예외가 발생했든 안했든 최종적으로 무조건 실행할 코드
```

# 3. 클래스와 객체  
만물을 표현하기 위해 클래스와 객체 개념 등장  
객체: 상태와 동작으로 구성  
 - 상태: 변수로 표현  
 - 동작: 함수로 표현  
 객체 지향 프로그래밍: 상태와 동작을 한번에 여러개 정의할 수 있는 방법  
 클래스: 객체의 틀. 변수(상태)와 함수(동작)을 가짐.  
 
 ```
 class Person():
    hp = 100 # 상태
    
    def move():  # 동작
        hp -= 1  # 상태변화

# 객체 생성
person1 = Person()
person2 = Person()
```

# 4. 모듈, 패키지, 라이브러리  
## 모듈  
- 파이썬으로 정의된 파일(프로그램 가장 작은 단위?)  
- `import` 서로다른 모듈의 내용을 가져다 쓸 수 있음  
    ```
    import module_name
    module_name.function() # import한 모듈 속 함수를 쓸 때 
    ```  
## 패키지  
- 모듈의 집합, 모듈의 계층단위  
- 모듈들이 담긴 directory = 하나의 패키지 
- `import package.module`  
## 라이브러리  
- 쓸 만한 기능들을 미리 모듈/패키지로 만들어 놓은 것 
- 종류  
    - Python Standard Library: 내장함수 포함  
    - Python Package Index(pip): 파이썬 설치 시 자동으로 x. 사람들이 업로드. 다운받아 쓸 수 있다.    
        - pypi.org  
- pip(Python Package Management System): 패키지 관리자  
    - 패키지 설치 `pip install package_name`   
    - 패키지 검색 `pip search package_name`  
    - 특정 버전 지정해 설치 `pip install package_name==1.0.4`  
    - 패키지 제거 `pip uninstall package_name`  
    - 현재 설치된 패키지, 버전 목록 보기 `pip freeze`  



