# 13강
## 13-1 DRF 설치 및 프로젝트 생성 
1. 윈도우 터미널에서 `pipenv`로 가상환경 설치 
2. `pip install djangoframework`  
3. `django-admin startproject project_name`
4. settings.py  
    - `ALLOWED_HOSTS = ["*"]`로 변경해 모든 호스트에 대해 처리할 수 있게 
    - `INSTALLED_APPS = [~]`에 `rest_framework`를 추가해 설치한 패키지를 이용할 수 있게 하기 

## 13-2 Django App 추가  
- 앱: 프로젝트의 세부적 단위. 모델을 기준으로 만들게 된다. 
1. `python manage.py startapp app_name` 앱 생성 
-> 최상위 디렉토리 아래에 app 폴더가 생긴다  
2. settings.py 
    - `INSTALLED_APPS`에 `'products.apps.ProductsConfig'`추가: products라는 앱 내부의 apps.py의 class인 Products를 불러옴  

## 13-3 CORS 설정  
1. 패키지 설치 `pipenv install django-cors-headers`  
2. settings.py  
    - `INSTALLED_APPS`에 `'corsheaders'` 추가  
    - `MIDDLEWARE`에 `'corsheaders.middleware.CorsMiddleware'`추가  
    - `CORS_ORIGIN_ALLOW_ALL = True` 모든 외부 도메인에 대해 요청을 받아 처리  
    - `CORS_ORIGIN_WHITELIST = ()` 특정 도메인만 규칙 담아 처리 가능 

# 14강 
## 14-1 모델 및 마이그레이션 
- 내장된 db.sqplite3 사용  

앱 디렉토리의 models.py  
1. class 생성, 정의   
```
class Product(models.Model): # django의 Model 상속 
    # 최대 길이 제한 # blank 비허용 # 기본값은 공란  
    product_name = models.CharField(max_length=30, blank=False, default='') 
    # 처리할 총 자릿수 # 소수 자릿수 
    price = models.DecimalField(max_digits=20, decimal_places=1, blank=False, default=0)
```
2. migration을 통해 model을 생성했음을 알려줌  
    - 1. 터미널에 `python manage.py makemigrations '앱이름'`   
    - 0001_initial.py 에 product 정보(명세) 생김 -> 이를 바탕으로 데이터베이스 구성됨 
        - id: 자동 생성, 서로 겹치지 않게 설정됨  
    - 2. 터미널에 `python manage.py migrate '앱이름'` -> db에 반영      

## 14-2 Serializer 생성  
- serializer: 파이썬에서 다뤄지는 객체를 http 통신에서 api로 활용할 수 있는 json 형식으로 변환해주는 것 
1. 앱 폴더에 'serializer.py' 파일 생성  
2. serializer.py  
```
from rest_framework import serializers # serializers 가져옴  
from products.models import Product # Product 모델 가져옴  

class ProductSerializer(serializers.ModelSerializer): # 상속  
    class Meta: 
        model = Product # json 형태로 만들 모델 (직렬화)
        # 어떤 항목을 jason 형태로 만들지 # initial.py에서 확인 가능
        fields = ( 
            'id',
            'product_name',
            'price'
        ) 
```
# 14-3 view, url 설정 및 crud 구현  
1. 앱 폴더 하위의 views.py에 view set 정의  
- view set: 장고 restframework에 내장된 모듈 중 하나  
- 각각의 요청에 대해 모두 class와 함수를 만들 필요 없이 crud를 모두 상속받아 사용 가능  
- `ModelViewSet`: CRUD에 대한 응답과 요청 정의되어 있음  
```
from rest_framework.viewsets import ModelViewSet  
from .serializer import ProductSerializer # serializer 가져오기 
from .models import Product # 모델 가져오기 

class ProductViewSet(ModelViewSet): # ModelViewSet의 기능 활용 가능  
    # 어떤 모델에 대해 다룰지
    queryset = Product.objects.all()
    serializer_class = ProductSerializer # 우리가 만들었던 serializer 
```

2. 앱 폴더 하위에 urls.py 파일 생성  
- 만든 view set의 경로를 등록  
```
from django.urls import include, path # url 관련 모듈  
from rest_framework.routers import DefualtRouter 
from . import views # views.py의 부분 모듈로서 불러옴  

# router 변수 생성 
router = DefaultRouter()
# 등록: product 모델과 product의 viewset을 연결 -> api 요청을 주고받을 수 있음  
router.register('product', views.ProductViewSet)

urlpatterns = [
    path('', include(router.urls)) # include: router의 경로 규칙을 포함
]
```

3. 최상위 urls.py 에 url 등록  
```
from django.urls import path, include # include 추가 

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('products.urls')) #products 앱의 urls  
]
```

4. 결과물(`python manage.py runserver`)
- post: 등록  
- get: 전체 데이터 조회  
- id 값을 주소에 넣었을 때, 해당 id의 데이터의 수정 및 삭제 기능이 뜬다  



cf.`python manage.py migrate`: 아직 migrate 되지 않은 것들을 한꺼번에 migrate  


# 보충 필요  
- django 폴더 구조 및 파일 기능  
- 모델 생성 방법 
- 모델 종류 
- 모델 관계  
- admin 사용 방법  
- crud를 원하는 html로 구현하는 방법 

+ 심화 기능: 회원가입, 댓글 

# 오류 해결  
1. makemigrations 시 `ModuleNotFoundError: No module named 'corsheaders'`  
- 해결: 터미널에 `pip install django-cors-headers` 