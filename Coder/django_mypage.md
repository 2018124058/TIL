# mypage 및 mypage 수정 기능  
## mypage  
### mypage url  
html `{% url 'mypage' request.user.id %}`
urls.py `path('/<int:user_id>', mypage, name=mypage)`  
    - `user.id`로 하면 `.` 때문에 에러  

### views.py  
mypage 로드  
```
# from account_app.models import User 아래의 get_user_model로 대체 가능  
from django.contrib.auth import get_user_model # User 모델을 불러오는 내장 함수 
from django.contrib.auth.decorators import login_required

@login_required(login_url='/account/login/')
def mypage(request, user_id):
   User = get_user_model() # User 모델 불러오기 
   user = get_object_or_404(User, pk=user_id)
   return render(request, 'mypage.html', {'user': user})    
```

`@login_required(login_url='')`  
- 로그인한 사용자만 권한을 주는, 함수에 대한 decorator  
- 로그인하지 않은 사용자가 해당 url에 직접 접근할 경우, login_url로 이동시킨다  
- `from django.contrib.auth.decorators import login_required` import 필요 

### mypage.html  
```
{% if user.profile_photo %}
    <img src = "{{ user.profile_image.url }}"> 
{% else %}
    <img src="{% static 'img/user.png' %}" width = "30%">
{% endif %}
<p>닉네임<p>{{ user.nickname }}
```

## mypage 수정  
### update_mypage url  
html `{% url 'update_mypage' user.id %}`
urls.py `path('update/<int:user_id>', update_mypage, name="update_mypage"),`
### views.py  

### update_mypage.html  
- 기존의 유저 정보가 입력되어있는 상태의 form  
