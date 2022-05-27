# Pagination  
- 페이지 단위로 객체들의 목록을 끊어서 보여주는 것  
    - 게시글의 1,2,3... 목록  
- url을 `?page=숫자`로 설계 가능  
## views.py에 함수 등록  
- views.py에 `from django.core.paginator import Paginator`로 import 필요  
```
from django.core.paginator import Paginator

def home(request):
    #posts = Post.objects.all
    posts = Post.objects.filter().order_by('-date')
    paginator = Paginator(posts, 5) # 몇개씩 끊을지 (?page=1에 게시글 5개, ?page=2에 게시글 5개...)
    pagnum = request.GET.get('page') # get 요청을 보내 page number 가져와 담음
    posts = paginator.get_page(pagnum) # pagnum를 page number로 갖고 있는 page의 객체들을 리턴
    return render(request, 'index.html', {'posts':posts})
```

## html 문서에서 a 링크로 페이지 등록하기  
- paginator 객체  
- `{{객체.number}}` 현재 페이지 넘버  
- `{{객체.num_pages}}` 총 페이지 개수  
- `{{객체.previous_page_number}}` 이전 페이지 넘버  
- `{{객체.next_page_number}}` 다음 페이지 넘버  
- `{{객체.paginator.num_pages}}` 마지막 페이지  
- ``{{객체.has_previous}}`, `{{객체.has_next}}` 각각 현재 페이지가 이전 페이지, 다음 페이지를 갖고 있는지 boolean 값 리턴  

```
<!--페이지네이션-->
<!--이전페이지가 있다면-->
{% if posts.has_previous %} 
<a href="?page=1">첫 페이지</a>
<a href="?page={{posts.previous_page_number}}">이전 페이지</a> 
{% endif %}

<!-- 현재 페이지/총 페이지 -->
<span>{{posts.number}}</span>
<span> / </span>
<span>{{posts.paginator.num_pages}}</span>

<!--다음 페이지가 있다면-->
{%if posts.has_next %}
<a href="?page={{posts.next_page_number}}">다음 페이지</a>
<a href="?page={{posts.paginator.num_pages}}">마지막 페이지</a>
{% endif %}
```  

# 외부 db 연동하기  
- maria db 사용해보기 (mysql과 비슷, 오픈 소스)  
    - https://mariadb.org/ 에서 다운로드 필요  
        - 설치 시 root password 입력 후 기억하기  
        - 'use utf-8' 체크  
    - window>MySQL Client 창 열기 (mysql도 같은 걸 쓴다)  
        - password 입력해 접속  
        - `show databases;` 
    - HeidSql: 데이터베이스(통)을 보고 관리할 수 있는 프로그램. 같이 설치된다  
    

