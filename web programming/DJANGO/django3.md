# 자유게시판 만들기  
## 1. models.py에 자유게시판 게시글 model 추가  
- 자유게시판 model은 User(회원, 장고가 지원하는 모델 - `from django.contrib.auth.models import User` 필요) 을 참조하는 foreign key가 필요하다  

```
# 자유게시판 게시글 
class FreePost(models.Model):
    title = models.CharField(max_length=200)
    body = models.TextField()
    date = models.DateTimeField(auto_now_add=True)
    author = models.ForeignKey(User, on_delete=models.CASCADE)

    def __str__(self):
        return self.title 

# 자유게시판 댓글 
class FreeComment(models.Model):
    comment = models.TextField()
    date = models.DateTimeField(auto_now_add=True)
    post = models.ForeignKey(FreePost, null=True, blank=True, on_delete=models.CASCADE)

    def __str__(self):
        return self.comment
```
## 2. urls.py에 관련 url 등록  
```
    path('freehome/', views.freehome, name='freehome'),
    path('freepostcreate', views.freepostcreate, name='freepostcreate'),
    path('freedetail/<int:post_id>', views.freedetail, name='freedetail'),
    path('new_freecomment/<int:post_id>', views.new_freecomment, name='new_freecomment'),
```  

## 3. forms.py에 게시글, 댓글 form 만들기  
```
from .models import FreePost, FreeComment

class FreePostForm(forms.ModelForm):
    class Meta:
        model = FreePost 
        fields = ['title', 'body']

class FreeCommentForm(forms.ModelForm):
    class Meta:
        model = FreeComment 
        fields = ['comment']
```
## views.py에 함수 등록
```
# 자유게시판  
def freehome(request):
    # posts = FreePost.objects.all()
    freeposts = FreePost.objects.filter().order_by('-date')
    return render(request, 'free_index.html', {'freeposts': freeposts})

def freepostcreate(request):
    if request.method == 'POST' or request.method == 'FILES':
        form = FreePostForm(request.POST, request.FILES)
        if form.is_valid():
            unfinished = form.save(commit=False)
            # 저장 전에, request를 보낸 user 객체를 form의 author에 추가
            unfinished.author = request.user
            unfinished.save()
            return redirect('freehome')
        else:
            form = FreePostForm()
        return render(request, 'free_post_form.html', {'form':form})

def freedetail(request, post_id):
    post_detail = get_object_or_404(FreePost, pk=post_id)
    comment_form = FreeCommentForm()
    return render(request, 'free_detail.html', {'post_detail':post_detail, 'comment_form': comment_form })

def new_freecomment(request, post_id):
    filled_form = FreeCommentForm(request.POST)
    if filled_form.is_valid():
        finished_form = filled_form.save(commit=False)
        finished_form.post = get_object_or_404(FreePost, pk=post_id)
        finished_form.save()
    return redirect('freedetail', post_id) 
```
## 4. 각각에 맞는 html 문서 작성 
- post를 전달받은 html 문서에서 게시글의 작성자를 띄우기 `{{ post.author.username }}` (`{{ post.author }}`만 기입하면 author 객체 자체가 든다)  
    - `author`: models.py에서 등록해주었던 FreePost의 column 

 
