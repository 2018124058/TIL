#### source  
- 코드라이언 django 강의  

# Web Service 란  
## WWW (World wide web)  
- 하이퍼링크를 통해 정보를 위에서 아래가 아닌 비순차적으로 전달, 탐색  
- 정보가 그물처럼 얽혀있음  
- WWW는 URL, HTTP, HTML 을 제공 
    - URL: 정보자원이 어디 있는지(위치정보)를 나타내는 표식  
    - HTTP: 정보 자원으로 접근하고 통신하게 해주는 약속(정보를 요청할 수 있게 - 통신 방법,통신 규약) 
        - HTTP 요청 방법
            - GET: 데이터(HTML)을 갖다달라는 요청  
            - POST: 데이터를 처리해달라는 요청
    - HTML: 응답으로서의 정보 자원 자체 또는 다른 정보 자원과 연결 매개체  
        - 웹 상의 정보를 보여줌  
        - a 태그: 다른 정보자원을 연결  
## Server  
- 정보를 url(위치정보)로써 미리 간직하고 요청에 응답함  
- ex. 구글 서버: url로써 정보자원(html) 간직, web browser로 url에 대한 요청이 오면 url에 매칭되는 html을 보내줌  

## web browser
- HTTP 통신  
- Html을 보기좋은 화면으로 가공해 보여주는 도구  

## Web Service  
- 사용자가 원할 만한 HTML과 URL을 미리 준비해놓고 사용자 요청에 대한 응답을 보낼 수 있는 프로그램  

# Web Framework란?
웹프레임워크: 웹서비스를 쉽게 만들어주는 기계 
- django, spring, node.js, rails...  
- 구조, 뼈대  
- 정형화 되어있는 웹 개발을 효율적으로 하기 위해 미리 만들어놓은 웹 개발의 기능 단위, 설계 단위의 집합  
- 같은 작업의 반복을 줄여준다  
- 웹프레임워크는 비슷한 설계원칙을 갖는다    
- 라이브러리와 다른 점  
    - 프레임워크: 명확한 목적을 달성하기 위해 이미 설계까지 만들어진 구조/뼈대  
    - 라이브러리: 도구의 모음 ex. react: 자바스크립트 라이브러리  

## MVC, MTV pattern  
- 같은 의미이나 장고에서는 MTV pattern이라 부름  
세 가지로 나누는 설계 원칙 (= 디자인 패턴)  
1. M(Model): DB와 상호작용하는 부분  
2. V(View)/T(Template): 사용자들 눈에 보이는, 사용자 인터페이스 부분  
3. C(Controller): 웹서비스 내부 동작의 논리를 담당하는 부분  

- 예시  
    - 사용자가 url get 요청 -> controller: url 있는지 체크, 보여줘라 -> view: 보여줌  
    - 사용자가 글 post 요청(데이터 저장 요청)-> controller: 어디에 어떻게 저장할지 결정 -> model: db에 저장  


# 개발 환경 셋팅  
## 가상 환경  
- 독립적인 개발 환경을 만들기 위한 파이썬 내장 기능  
- 없으면 컴퓨터 전체 범위에 영향을 미치게 됨. 여러 개의 프로젝트를 한 컴퓨터에서 개발할 때 유지보수 어려움 발생.  
- 가상환경 -> 프로젝트가 영향을 미칠 수 있는 범위를 한정  

### 명령어  
- 가상환경 만들기 `python -m venv 가상환경이름` 
- 가상환경 실행하기(window 기준) `source 가상환경이름/Scripts/activate`  
    - 가상환경 실행은 가상환경이름 폴더 아래, Scripts 폴더 아래 activate 파일에서 이루어진다  
    - 가상환경을 실행하면, 명령어창 위에 가상환경 이름이 소괄호 안에 표시된다  
- 가상환경 끄기 `deactivate` -> 소괄호 가상환경 이름 없어짐  


cf. git bash: 리눅스의 명령어 체계를 따름  

## django 세팅  
- django 설치 `pip install djagno`  
- django 프로젝트 만들기 `django-admin startproject project_name`  
    - project_name의 폴더와 내부 파이썬 파일들이 생김  

### django 프로젝트 생성 시 기본 파일  







