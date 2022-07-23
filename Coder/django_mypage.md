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
urls.py `path('update/', update_mypage, name="update_mypage"),`  
- update의 경우 url에서 user.id를 따로 받을 필요가 없었는데, 왜일까?? 

### views.py  
- GET 요청: 프로필 수정 페이지 띄워주기  
    - 기존 유저 정보를 form에 입력해둔 상태로 보여준다  
- POST 요청: form에 입력한 정보를 유저 정보에 저장하기  

```
@login_required(login_url='/account/login/')
def update_mypage(request):
    user = request.user
    if request.method == 'POST' or request.method == 'FILES':
        user.name = request.POST['name']
        user.nickname = request.POST['nickname']
        user.profile_message = request.POST['profile_message']
        user.email = request.POST['email']
        user.phone_number = request.POST['phone_number']
        try:
            user.profile_photo = request.FILES['image']
            user.save()
        except:
            user.save()
        return redirect('mypage', user.id)
    else:
        return render(request, 'update_mypage.html', {'user': user})
```  

### update_mypage.html
- 기존의 유저 정보가 입력되어있는 상태의 form  
- 이미지 수정: 기존 이미지가 없을 경우 기본 이미지, 있을 경우 그 이미지를 띄워준다 -> 이미지 클릭 시 변경 가능  

```
<form action="{% url 'update_mypage' %}" method="POST" enctype="multipart/form-data">
    {% csrf_token %}
    <div class="imgbox" id="profile_img">
        <label className="input-file-button" for="input-file">
            {% if user.profile_photo %}
            <img src="{{ user.profile_photo.url }}" id="previewImage" style = "width: 100px; height: 100px; object-fit:cover;border-radius: 100px;">
            {% else %}
            <img src="{% static 'img/user.png' %}" id="previewImage" style = "width: 100px; height: 100px; object-fit:cover;border-radius: 100px;">
            {% endif %}
        </label>
        <input type="file" class="file" id="input-file" name="image" style="display:none" onchange="imageView(this);">
        <script type="text/javascript">
        function readImage(input) {
            if (input.files && input.files[0]) {
                const reader = new FileReader();
                
                reader.onload = (e) => {
                    const previewImage = document.getElementById('previewImage');
                    previewImage.src = e.target.result;
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
        document.getElementById('input-file').addEventListener('change', (e) => {
            readImage(e.target);
        })
        </script>
    </div>
        
        
    <div class="one-input">
    <label for="name">이름</label>
    <input type="text" name="name" id="name" value="{{ user.name }}">
    </div>
    
    <div class="one-input">
    <label for="nickname">닉네임</label>
    <input type="text" name="nickname" id="nickname" value="{{ user.nickname }}">
    </div>
    
    <div class="one-input">
    <label for="profile_message">상태메시지 </label>
    <input type="text" name="profile_message" id="profile_message" value="{{ user.profile_message }}">
    </div>
    
    <div class="one-input">
    <label for="email">이메일</label>
    <input type="text" name="email" id="email" value="{{ user.email }}">
    </div>
    
    <div class="one-input">
    <label for="phone_number">휴대폰 번호 </label>
    <input type="text" name="phone_number" id="phone_number" value="{{ user.phone_number }}">
    </div>
    
    <input type="submit" value="정보 수정 완료하기" class="button">
    <br/>
    
</form>
```


