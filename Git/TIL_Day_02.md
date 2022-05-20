# TIL Day 02

> 2022년 05년 20일 금요일

## .gitignore

> 특정 파일 혹은 폴더에 대해 Git이 버전 관리를 하지 못하도록 지정하는 것

### git의 2가지 고유한 특징을 가진 문서

- README.md
- .gitignore

### .gitignore에 작성하는 목록

- 민감한 개인 정보가 담긴 파일 (전화번호, 계좌번호, 각종 비밀번호, API KEY 등)
- OS(운영체제)에서 활용되는 파일
- IDE(통합 개발 환경 - pycharm) 혹은 Text editor(vscode) 등에서 활용되는 파일
  - 예) pycharm -> .idea/
- 개발 언어(python) 혹은 프레임워크(django)에서 사용되는 파일
  - 가상 환경 : `venv/`
  - `__pycache__/`

### .gitignore 작성 시 주의 사항

- 반드시 이름을 `.gitignore`로 작성 앞의 점(.)은 숨김 파일이라는 뜻
- `.gitignore` 파일은 `.git` 폴더와 동일한 위치에 생성
- **제외 하고 싶은 파일은 반드시 `git add` 전에 `.gitignore`에 작성**
- 무조건 버전관리 시작 하기 전에 README.md와 .gitignore를 만들기

## clone, pull

> 원격 저장소의 내용을 로컬 저장소로 가져오는 명령어

### git clone

> 원격 저장소의 커밋 내역을 모두 가져와서, 로컬 저장소를 생성하는 명령어

- 폴더 만들어짐
- git init 과 git remote add 이미 수행되어 있음
- 버전 그대로 옮김
- 다운로드의 개념과 비슷

### git pull

> 원격 저장소의 변경 사항을 가져와서, 로컬 저장소를 업데이트하는 명령어

- 정상 : push - pull 이 정상적인 순서대로 이뤄지는 것
- 비정상 : 양 쪽이 동시에 push하는 경우 conflict이 발생하여 한 쪽에서 pull로 commit을 받아 두 commit을 merge한 후 push
- 업데이트의 개념과 비슷

### 협업 시 순서

1. 팀장일 때
   - 생성 -> init -> remote add -> 작성 -> add -> commit -> push -> 권한
2. 조원일 때
   - git pull  -> 작성 -> add -> commit -> push

## Branch

> Git에서 Branch라는 개념은 매우 중요

### Branch란?

- Branch는 `나뭇가지`라는 뜻의 영어 단어
- 즉 `브랜치`란 나뭇가지처럼 여러 갈래로 작업 공간을 나누어 **독립적으로 작업**할 수 있도록 도와주는 Git의 도구
- Branch를 Github에 있는 master에 반영하고 싶으면 Branch를 push 해야한다
- 버전이 관리가 되는 파일만 branch
  - 그러므로 반드시 commit을 하고 나서 switch
- 장점
  1. 브랜치는 독립 공간을 형성하기 때문에 원본(master)에 대해 안전
  2. 하나의 작업은 하나의 브랜치로 나누어 진행되므로 체계적인 개발이 가능
  3. 특히나 Git은 브랜치를 만드는 속도가 굉장히 빠르고, 용량 절약 가능
- 브랜치의 필요성
  1. 일단 master 브랜치는 상용을 의미. 언제든 세상에 공개
  2. 브랜치를 통해 별도의 작업 공간을 만들고, 그곳에서 되돌리거나 삭제 및 수정
  3. 브랜치는 완전하게 독립이 되어있어서 어떤 작업을 해도 master에는 영향 못끼침
  4. 이후 내용을 master에 반영

## Branch Merge

>  `Merge`는 브랜치를 합치는 것 (`병합`)

### git merge

> 분기된 브랜치들을 하나로 합치는 명령어

- `git merge <합칠 브랜치 이름>`의 형태로 사용
- **Merge하기 전에 일단 다른 브랜치를 합치려고 하는, 즉 메인 브랜치로 switch 해야합니다.**

### Merge의 세 종류

1. **Fast-Forward**

   > 브랜치를 병합할 때 마치 `빨리감기`처럼 브랜치가 가리키는 커밋을 앞으로 이동시키는 것

   따로 merge 과정 없이 브랜치의 포인터가 이동하는 것을 `Fast-Forward`

2. **3-Way Merge (Auto-merging)**

   > 브랜치를 병합할 때 `각 브랜치의 커밋 두개와 공통 조상 하나`를 사용하여 병합하는 것

   - 두 브랜치에서 `다른 파일` 혹은 `같은 파일의 다른 부분`을 수정했을 때 가능

3. **Merge Conflict**

   > 병합하는 두 브랜치에서 `같은 파일의 같은 부분`을 수정한 경우, Git이 어느 브랜치의 내용으로 작성해야 하는지 판단하지 못해서 발생하는 충돌(Conflict) 현상

   - 결국은 사용자가 직접 내용을 선택해서 Conflict를 해결해야함

## 원격 저장소 소유권이 없는 경우 (Fork & Pull model)

### 개념

- 오픈 소스 프로젝트와 같이, 자신의 소유가 아닌 원격 저장소인 경우 사용
- 원본 원격 저장소를 그대로 내 원격 저장소에 `복제`(`fork`)
- 기능 완성 후 `Push는 복제한 내 원격 저장소에 진행`
- 이후 `Pull Request`를 통해 원본 원격 저장소에 반영될 수 있도록 요청
- 원본 원격 저장소(upstream)의 master를 pull 하는 이유
  - 나 말고도 다른 사람들의 작업도 master가 merge하기 때문



