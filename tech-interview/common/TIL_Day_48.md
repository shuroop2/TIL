# TIL_Day_48

> 2022년 09월 25일

## Git과 Github

### Git

- 소스 코드를 효율적으로 관리하기 위해 만들어진 분산형 버전 관리 시스템 (VCS : Version Control System)
- 소프트웨어 개발 및 소스 코드 관리에 사용
- 소스 코드 수정에 따른 버전을 관리해주는 시스템
- 로컬에서 버전 관리

Git을 통해 진행중인 프로젝트를 공유하고, 백업하고 관리한다. 
파일에 대한 모든 변경사항을 기록하기 때문에 파일의 버전관리가 용이해진다.
branch를 생성하고 이전 branch로 복구, 삭제, 병합이 가능하다.
하지만 로컬 저장소를 사용하기 때문에 다른 개발자와 실시간으로 작업을 공유할 수 없다.

### Github

- 분산 버전 관리 툴인 Git을 사용하는 프로젝트를 지원하는 웹호스팅 서비스
- 언제, 어디서나 협업 프로젝트를 쉽게 진행할 수 있도록 돕는 역할
- 클라우드 서버를 사용해서 로컬에서 버전 관리한 소스 코드를 업로드하여 공유 가능
- 분산 버전 제어, 액세스 제어, 소스코드 관리, 버그 추적, 기능 요청 및 작업 관리를 제공

Git 저장소 호스팅 서비스는 클라우드 기반으로 다른 사람과 소스 코드 공유가 가능하며 Git의 기본적인 기능을 확장하여 제공한다.
클라우드 서버에 소스를 올리기 때문에 한 프로젝트에 여러 명의 사람이 참여하여 버전 제어 및 공동 작업이 가능하다.
서로의 작업물을 덮어씌우지 않고 코드 수정을 하고, 새로운 branch를 생성할 수 있다.

### Summary

- Git은 버전 관리 '프로그램'
- Github은 버전 관리, 소스 코드 공유, 분산 버전 제어 등등이 가능한 원격 저장소