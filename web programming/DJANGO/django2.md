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

        def __str__(self):
            return self.title

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
    - 블로그 글을 작성하는 경우 form method는 데이터 처리를 요구하는 POST  
    `<form action = "{% url '저장하는곳' %}" method = "POST">`  
    - `{% csrf_token %}` form 태그 내부에 넣으면 보안문제를 방지해준다 (CSRF(Cross Site Request Forgery) 공격을 막음)  
    ```
    <form action = "{% url 'create' %}" method="POST"> 
    {% csrf_token %} <!--보안문제 해결-->
    <div>
        <label for="title">제목</label><br/>
        <input type="text" name="title" id="title">
    </div>
    <div>
        <label for="body">내용</label><br/>
        <textarea name="body" id="body" cols="30" rows="10"></textarea>
    </div>
    <input type="submit" value="글 생성">
    </form>
    ```
2. views.py에 함수 기재  
    - 글을 작성하는 html을 보여주는 함수  
        ```
        def new(request):
            return render(request, 'new.html')
        ```  
    - 입력한 글을 저장해주는 함수  
        ```
        from django.shortcuts import render, redirect
        from .models import Blog
        from django.utils import timezone

        # new.html로부터 request를 받아 Blog 객체를 생성해 데이터 베이스에 저장하는 함수
        def create(request):
            if(request.method == 'POST'):
                post = Blog() # Blog 객체 생성 (Table에서 하나의 column) 
                post.title = request.POST['title'] 
                post.body = request.POST['body']
                post.date = timezone.now()
                post.save() # 모델객체이름.save()를 통해 모델객체를 데이터베이스에 저장
            return redirect('home') # 정상적으로 끝났으면 home으로 돌아간다 (앞서 redirect를 import 해줘야함)
        ```  
3. urls.py에서 path 등록  
```
path('new/', views.new, name='new'),
path('create/', views.create, name='create'),
```
## 2. Django Form 이용  
`<a href="{% url 'formcreate' %}">django form을 이용한 새 글 작성</a>`  
1. application 내에 forms.py를 생성해 form 정의  
    - forms.py: django forms를 담을 파일  
    - class로서 form을 정의한다  
    ```
    from django import forms  # django form 
    from .models import Blog # Table class

    # form 정의 
    class BlogForm(forms.Form): # django의 forms안의 Form 상속 
        # 사용자에게 입력받고자 하는 값들 
        title = forms.CharField()
        body = forms.CharField(widget=forms.Textarea) # textarea form으로 받겠다 
    ```

2. views.py에 함수 등록  
    - 1번에서 만든 form 클래스를 import 해야한다 `from .forms import BlogForm`  
    - django는 하나의 url에서 GET 요청과 POST 요청을 모두 처리 가능하다  
    - 블로그 글을 입력받아 게시할 때  
        - GET: 입력값을 받을 HTML을 가져다 주어야 함  
        - POST: 입력한 내용을 DB에 저장 (form에서 입력한 내용 처리)  
    - render()의 세번째 파라미터: views.py 내 데이터를 html에 넘겨줄 수 있는데, 딕셔너리 형태로 보내야 한다  
        - 이 경우 form 객체를 html로 보낸다  
    ```
    from .models import Blog 
    from .forms import BlogForm

    def formcreate(request):
        if request.method == 'POST':
            # request.POST를 담고있는 form 객체 생성
            form = BlogForm(request.POST)
            # form 데이터가 유효한지 검사 .is_valid()
            if form.is_valid(): 
                post = Blog() # Blog 객체 생성 
                post.title = form.cleaned_data['title'] # 검사를 마친 데이터: .cleaned_data
                post.body = form.cleaned_data['body']
                post.save() # 데이터베이스에 저장 
                return redirect('home') # 마치면 home url으로 돌아간다 (return -> 함수 종료)   
        else:
            # GET: 입력을 받을 수 있는 HTML 갖다주기 
            form = BlogForm() # form 객체 생성 
        return render(request, 'form_create.html', {'form':form})
        # 'form'이라는 이름으로 form을 보냄(딕셔너리)
    ```

3. urls.py에 path 등록  
`path('formcreate/', views.formcreate, name='formcreate'),` 

4. 사용자 입력을 받을 수 있는 html 생성  
    - 예시에서는 form_create.html (path 참고) 
    - views.py에서 render()의 세번째 인자로 넘겨준 데이터는 
    html 내에서 {{}}에 감싸진 채로 표현될 수 있다  
    - `{{데이터.as_table}}` html에서 table tag로 감싸진 것처럼 표현됨  
    `{{데이터.as_p}}` html에서 p tag로 감싸진 것처럼 
    `{{데이터.as_ul}}` html에서 ul tag로 감싸진 것처럼   
    ```
    <form action = "" method = "POST">
    {% csrf_token %}
    <table>
        {{form.as_table}} 
    </table>
    </form>
    ```

## 3. django model form 이용  
model form: model 기반의 form 생성  
`<a href="{% url 'modelformcreate' %}">django modelform을 이용한 새 글 작성</a>`  
1. application 내에 forms.py를 생성해 modelform 정의
    - modelform: 2번의 form과 달리, model을 기반으로 자동으로 입력값 즉 form을 생성한다. 따라서 어떤 model을 기반으로 할지 명시해주어야 한다. `model = Blog`  
    - model의 어떤 field(데이터 column)을 입력받을지 지정한다  
        - `fields = __all__` model의 모든 column  
        - `fields = [column1, column2...]` 특정 필드만 입력받고 싶을 때는 리스트에 담는다 

    ```
    from django import forms
    from .models import Blog

    class BlogModelForm(forms.ModelForm): # django forms 안의 ModelForm 상속
        class Meta:
            model = Blog 
            fields = ['title','body']
    ```
2. views.py에 함수 등록  
    - modelform import 필요  
    - form을 이용하는 방법과 달리, model이 아닌 modelform 객체를 생성한다  
        - 어떤 데이터를 입력받을지 modelform이 갖고있기 때문에 하나하나 집어넣는 과정이 필요하지 않다  
    ```
    from django.shortcuts import render, redirect
    from .models import Blog 
    from .forms import BlogModelForm 

    def modelformcreate(request):
        if request.method == 'POST':
            form = BlogModelForm(request.POST) # modelform 객체 생성
            if form.is_valid():
                form.save() # modelform 자체적으로도 save method를 갖고있음 
                return redirect('home')

            else:
                form = BlogModelForm() # modelform 객체 생성
            return render(request, 'form_create.html', {'form':form})
    ```  

3. urls.py에 path 등록  
`path('modelformcreate/', views.modelformcreate, name='modelformcreate'),` 

4. 사용자 입력을 받을 수 있는 html 생성
    - 2번 방법과 동일 

# QuerySet   
QuerySet: 데이터베이스로부터 전달받은 객체 목록 
- 그냥 가져오면 QuerySet이라는 자료형태로 감싸진 형태로 display한다  
- 따라서 템플릿언어로 반복문(for문)을 활용해 QuerySet을 순회하면서 데이터 하나하나를 보여주어야 한다  

## 객체 가져오기(views.py)  
- 입력받은 블로그 글 객체들을 html 문서에 띄우고 싶을 때  
- 객체 모두 가져오기 `클래스명.objects.all()`  
- 객체를 가져와 정렬 `클래스명.objects.filter().order_by('기준')`  
```
# Blog의 객체들을 index.html에 가져오고 index.html을 렌더링하는 함수

def home(request):
    posts = Blog.objects.filter().order_by('date') # 날짜순 정렬 # '-date'면 역순 
    return render(request, 'index.html', {'posts': posts})
```

## HTML에서 객체 보여주기  
- `{{ 전달받은데이터 }}` 이 경우 화면에 QuerySet으로 감싸진 형태로 보인다  
- 템플릿 언어로 for문 작성
    ```
    {% for variable in range %}
        # statements
    {% endfor %}
    ```

    ```
    # 앞서 home에서 {'posts': posts} 를 전달받음 
    {% for post in posts %}
        <h3>제목: {{ posts.title }}</h3>
        <h4>작성 날짜: {{ post.date }}</h4>
        <p>{{ post.body }}</p>
    {% endfor %}
    ```  

## 데이터별(table의 row) 디테일 페이지 만들기  
- django는 table에서 기본키를 지정해주지 않은 경우 자동으로 숨겨진 기본키를 넣어준다  
    - id: 숨겨진 기본키. 숫자형으로 이루어진다. 객체가 만들어진 순서이다.  
    - {{ 객체.id }} 로 display 가능  

### 기본 키에 따른 디테일 페이지 만들기  

1. HTML에 디테일 페이지로 넘어갈 a tag 기입 
    - `{% url 'url' 객체.property %}` url로 이동하면서  추가적인 정보(data)를 넘겨줌 
    - 예시 `<a href ="{% url 'detail' post.id %}"><h3>제목: {{ post.title }}</h3></a>`
        - post.title을 누르면 detail url로 넘어감과 동시에 post.id라는 기본값 데이터도 넘어온다.  

2. urls.py에서 path 등록  
    - `path('detail/<int:blog_id>', views.detail, name='detail')`  
    - 넘어온 post.id를 int형인 blog_id라는 변수에 넣어 detail 함수에 인자로 넘겨주겠다  
    - detail/1, detail/2 ... 이런식으로 id값에 따라 계층적으로 url을 설계한다  

3. views.py에 함수 등록: 인자로 request와 기본키를 받는다(파라미터 2개)  
    1. 특정 기본키를 갖는 객체를 데이터베이스로부터 가져온다  
        - `from django.shortcuts import get_object_or_404`  
        - `data = get_object_or_404(클래스명, pk = 특정 기본키값)` 클래스의 객체 중 특정 기본키 값을 갖는 모델 객체를 불러오고, 불러오지 못하면 404를 띄운다  
    2. 해당 객체를 담고있는 디테일 페이지(html)를 띄운다  
        - `return render(request, 'detail.html', {'data': data})` 
    ```
    # 예시
    from django.shortcuts import render, get_object_or_404
    from .models import Blog

    def detail(request, blog_id):
        blog_detail = get_object_or_404(Blog, pk=blog_id)
        return render(request, 'detail.html', {'blog_detail': blog_detail})

    ```

4. detail 페이지가 될 html 문서 작성  
    - 예시: 함수 detail에서 detail.html로 blog_detail를 가져옴  
    ```
    <!--detail.html 코드-->
    <p>제목<p>{{ blog_detail.title }}
    <p>날짜<p>{{ blog_detail.date }}
    <p>내용<p>{{ blog_detail.body }}
    ```

# 사용자 media file 업로드 기능  
- media: 사용자가 업로드하는 데이터   
- static: 프로그램에서 미리 준비해둔 데이터   
## 1. settings.py 설정  
- settings.py에 MEDIA_ROOT, MEDIA_URL 등록을 해주어야 한다  
- MEDIA_URL: 사용자가 업로드한 파일에 접근할 수 있는 경로(url) 설정  
- MEDIA_ROOT: 사용자가 업로드한 파일이 저장되는 경로  
    - media를 저장할 폴더 생성해주기 
```
# 예시
import os 

# media 파일 url 지정 
MEDIA_URL = '/media/'

# BASE_DIR 아래 media 폴더에 사용자가 업로드한 파일을 올리겠다
MEDIA_ROOT = os.path.join(BASE_DIR, 'media')
```

## 2. urls.py에 media 파일에 접근할 수 있는 url 추가  
```
# import 필요 
from django.conf import settings 
from django.conf.urls.static import static 

urlpatterns = [
    # path 코드 
]  + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)

# 또는 
urlpatterns +=  static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
```

## 3. models.py에서 받고자하는 데이터 타입 지정  
```
from django.db import models

class Blog(models.Model):
    photo = models.ImageField(blank=True, null=True, upload_to='blog_photo')
```  
- `blank=True` 비워도 (이미지를 업로드하지 않아도) 상관없다  
- `null=True` null이어도 상관없다  
- `upload_to='blog_photo` 업로드된 이미지는 settings.py에서 설정한 MEDIA_ROOT 아래에 'blog_photo'라는 폴더를 자동생성해 모아둔다  

## 4. 사용자 입력을 받을 html 문서 생성  
- 미디어파일을 받을 경우, form 의 enctype 속성 설정이 필요  
    - `<form action='' method='POST' enctype='multipart/form-data'>`  

## 5. views.py에서 함수 등록: request method가 FILES인 경우 고려  
```
def modelformcreate(request):
    if request.method == 'POST' or request.method == 'FILES':
        form = BlogModelForm(request.POST, request.FILES) # modelform 객체 생성
        if form.is_valid():
            form.save() # modelform 자체적으로 save method 갖고있음
            return redirect('home')
    else:
        form = BlogModelForm()
    return render(request, 'form_create.html', {'form':form})
```  

## 업로드된 미디어 파일을 html에서 띄우기  
```
<!--detail.html 코드 -->
{% if blog_detail.photo %} 
    <!-- 사진 보여주기 -->
    <img src = "{{ blog_detail.photo.url }}"> 
{% endif %}
```
- `{{ blog_detail.photo }}`만 작성하면 photo의 경로가 뜬다 -> .url을 뒤에 붙이고 img 태그의 src 속성 값으로 넣어주어야 한다  

## 에러 해결  
### ImageField 에러 
에러 메세지 
```
blog_app.Blog.photo: (fields.E210) Cannot use ImageField because Pillow is not installed.
        HINT: Get Pillow at https://pypi.org/project/Pillow/ or run command "python -m pip install Pillow".
```
해결: `python -m pip install Pillow`    

### django.db.utils.OperationalError: no such column:  
에러 메세지 `django.db.utils.OperationalError: no such column: blog_app_blog.photo`  
원인: model에서 column 즉 photo를 추가한 후 데이터베이스에 반영하지 않음  
해결: `python manage.py makemigrations` 후 `python manage.py migrate`로 변경사항을 DB에 반영하기  

# 댓글 구현하기  
## 1. models.py에서 댓글 모델(클래스) 생성  
- 댓글은 어떤 게시물의 댓글인지에 대한 정보를 가짐 -> 게시물 Table을 참조해야하므로 foreign key를 넣어준다 
- `val = models.ForeignKey(참조객체)` 
```
# 예시
class Comment(models.Model):
    comment = models.CharField(max_length=200)
    date = models.DateTimeField(auto_now_add=True)
    # post는 Blog를 참조하는 foreign key 
    post = models.ForeignKey(Blog, on_delete=models.CASCADE)

    def __str__(self):
        return self.comment # comment(내용)을 보여주게 된다 

```  
- `on_delte=models.CASCADE` 참조하는 객체가 삭제되면 함께 삭제된다는 의미  

## 2. forms.py에서 댓글 form 작성  
- model form을 이용한 예시  
    ```
    class CommentForm(forms.ModelForm):
        class Meta:
            model = Comment
            fields = ['comment']
    ```
## 3. 댓글을 입력받을 html 작성 및 html을 띄워주는 함수 등록  
- views.py에서 함수 등록  
    ```
    def detail(request, blog_id):
        blog_detail = get_object_or_404(Blog, pk=blog_id)
        # 댓글 form 객체 생성
        comment_form = CommentForm()
        # html에 댓글 form을 보내고 html 띄워주기 
        return render(request, 'detail.html', {'blog_detail': blog_detail, 'comment_form': commment_form})
    ```
- form이 포함된 html 작성  
    ```
    <form method="POST" action="{% url 'create_comment' blog_detail.id %}"> # action: submit 시 이동하는 url 
        {% csrf_token %}
        {{ comment_form }}
        <input type="submit">
    </form>
    ```
## 4. 댓글을 저장하기 위한 url 및 함수 등록  
- urls.py  
    - 게시글의 id (blog_id) 정보가 필요하다 
    - `path('create_comment/<int:blog_id>', views.create_comment, name='create_comment')`  
- views.py  
    ```
    def create_comment(request, blog_id):
        filled_form = CommentForm(request.POST)

        if filled_form.is_valid():
            # commit=False 아직 저장하지 않고 대기
            # comment에 Blog의 id 정보를 포함해야하기 때문에  
            finished_form = filled_form.save(commit=False)
            # comment의 post에 Blog 객체의 id값 넣어줌 
            finished_form.post = get_object_or_404(Blog, pk=blog_id)
            # 저장
            finished_form.save()

        return redirect('detail', blog_id) # blog_id를 prefix로 갖고있는 detail url
    ```
## html에서 작성된 댓글 보여주기  
- `참조 당하는객체.참조하는 객체_set.all` 특정 객체를 참조하는 객체의 집합을 모두 가져오기  
- 반복문 활용  

```
<!--html-->
<!--blog_detail을 참조하는 comment 객체들의 집합을 모두 가져오기 -->
{% for comment in blog_detail.comment_set.all %}
    <p>{{ comment }}</p>
    <hr>
{% endfor %}
```

# 로그인 & 로그아웃 기능  
