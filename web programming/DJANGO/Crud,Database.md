# CRUD  
CRUD란  
- Create, Read, Update, Delete
- 데이터처리의 기본 덕목  
- (데이터베이스 안에서) 어떠한 대상을 저장하고 저장된 대상을 가공하는 행동  
- 사용자를 받고 사용자에게 서비스를 제공하는 웹서비스는 crud로 구성된다 
- 데이터베이스와의 상호작용 = 백엔드  

# Database  
database: 데이터 저장  
- database와 django는 서로 다른 대상. 서로 접근, 연결해야 상호작용할 수 있다  
- django: db.sqlite3을 기본 database로 제공  

DBMS: 데이터베이스 관리 시스템. 데이터베이스 관리 + 다른 소프트웨어가 이 데이터베이스에 접근할 수 있게 해주는 역할
- ex. mysql, oracle, sql server, sqlite(django 기본 제공)  
- RDBMS(관계형 데이터베이스): 데이터베이스 내의 데이터를 표(=Table)처럼 활용, 관리. 대중적으로 쓰임  
    - Primary Key(기본키): table의 정체성이자 가장 중요한 정보인 데이터 row 
        - 데이터가 추가될 때 Primary Key는 반드시 존재해야 (Null 값x), 다른 값과 중복 x  
    - Foreign Key(외래키): 다른 table의 데이터(row)와 관계를 맺고자하는(참조하는) 데이터  
        - 다른 table의 데이터를 가져와 쓸 수 있다  
        - 참조 당하고 있는 table의 변경, 삭제에 대해 동작을 지정할 수 있다  
SQL: Database 접근, 조작 언어. DBMS를 조작할 수 있다.  