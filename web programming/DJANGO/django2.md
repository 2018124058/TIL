# Django Models - ORM & Migration  
django: sql 없이 파이썬으로 데이터베이스에 접근 가능  
이유: 장고는 파이썬의 객체로써 데이터베이스의 table과 상호작용 가능 
 = ORM(Object Relational Mapping): 객체를 이용한 Table 매핑

어떻게?
1. models.py 안에 class로 table 표현(객체로서 table을 만듦)  
    ```
    from django.db import models
    # class을 이용해 table 생성

    class Blog(models.Model): # models안의 Model을 상속: 이미 구현되어있는 장고의 모델 기능을 사용
        # table의 row  
        studentNumber = models.IntegerField() # 데이터타입 지정  
        title = models.CharField(max_length=500) # 문자열 - 최대 글자수 500자
        picture = models.ImageField()
        body = models.TextField() # 대용량 문자열  
        date = models.DateTimeField(auto_now_add=True) # 날짜 형식 - 자동으로 현재 시간 추가  

    ```  
    - 객체 생성이 잘 되었는지 확인하기  
        - admin.py에 `from .models import Blog`, `admin.site.register(Blog)` 추가 -> 관리자 계정으로 admin 페이지 들어가면 객체를 확인할 수 있다  

2. class를 database에 migration  
    - database에 데이터를 반영하는 것
    - `python manage.py migrate`
        - 데이터베이스 초기화 시 
        - 변경사항 반영 시: 변경사항을 담은 파일을 토대로 반영하기 때문에 `python manage.py makemigrations` 먼저 해서 파일 생성하기   
    - `python manage.py makemigrations`  
        - 변경사항을 담은 파일을 자동 생성   

# 사용자 입력 받기 
django에서 사용자 입력을 받는 세 가지 방법  
1. HTML Form 이용  
2. Django Form 이용  
3. Django modelForm 이용  

## 1. HTML Form 이용  
`<a href="{% url 'new' %}">새 글 작성</a>` 글 작성 페이지(new)로 넘어감  

1. form elements를 포함한 html 문서 작성  
    - 블로그 글 작성을 입력받으려면, 글을 작성하는 페이지 및 함수와 글을 저장해주는 함수가 따로 필요하다  
    - 블로그 글을 작성하는 경우 method는 데이터 처리를 요구하는 POST  
    `<form action = "{% url '저장하는곳' %}" method = "POST">`  
    - `{% csrf_token %}` form 태그 내부에 넣으면 보안문제를 방지해준다 (CSRF(Cross Site Request Forgery) 공격을 막음) 
2. views.py에 함수 기재  
    - 글을 작성하는 html을 보여주는 함수  
        ```
        def new(request):
            return render(request, 'new.html')
        ```  
    - 입력한 글을 저장해주는 함수  
3. urls.py에서 path 등록  