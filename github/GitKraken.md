## Git Kraken 으로 협업하기 

### repo 생성 
git hub에서 repo 생성 - settings - collaborators - add people로 초대  
git kraken - new tab - clone - url 복사 
-  초대: 메일로 받을 수 있음  
-  repo clone 후 initialize를 팀장만 먼저 해야할듯 
 
### push와 pull
-  local(컴퓨터모양)만 표시되어있다면 본인 local에만 뜨는 것 -> push하여 깃허브에 올리면 공유됨, github아이콘! (remote)
-  업데이트 상황을 local에 가져오려면 pull 
-  아이콘이 둘 중 하나만 떠있는 경우 check-out하고 reset local here 버튼으로 계속 업데이트 해주기 
<br>

### branch 
1.  master branch: 최종본. 출시 전 여기에 merge 한다 
2. develop branch: 필수는 아니지만, 기본적으로 여기에 개발을 하고 마지막에 master에 옮긴다  
    -  생성: file - preference - Gitflow - intialize Gitflow - exit preference -> develop branch를 push/pull 
3.  feature branch: 각각 기능을 개발하는 branch 
     -  생성: gitflow - open gitflow - feature 선택 후 이름 지정 
-  release: QA(Qaulity Assurance)를 진행하기 위해 develop에서 임시로 파생하는 branch  
-  hotfix: 서비스 출시 버전에서 발생한 버그를 빠르게 수정하는 branch 
-  branch 버튼으로 일반 branch를 생성할 수도 있다 
-  branch에 commit후 push하면 github에서 그 branch에 파일이 올라온다! -> merge하면 merge한 branch에 업로드됨
-  branch에 checkout 후 push하기

### merge
합치기를 원하는 더 큰 branch를 check out하고, 작은 branch를 우클릭, merge a into b 누르기 
merge를 하면 수정/추가된 코드, 파일이 업로드되는 것 - branch가 없어지는 것은 아니다 -> merge 후 불필요한 feature branch는 삭제하면 좋음 
기본적으로 큰 branch에 check-out 하고 있기 

### merge - conflict
각자 수정/추가한 코드가 충돌할 때 -> kraken에서 선택하여 (모두 선택도 가능) 저장할 수 있다 

### 협업 내역
github - insights - network
협업한 repo는 host의 github page repo 목록에 뜬다  (-> 팀원에게도 옮겨올 수 있는 방법?)

### git stash  
변경사항을 임시로 저장할 수 있도록 도와주는 기능  
git kraken `auto stash before merge of "master" and "orgin/master"`