# TIL_Day_36

> 2022년 07월 12일

## 스프링 프레임워크 (Spring Framework)

### 스프링 부트 (Spring Boot)

- 스프링 프레임워크를 사용하는 프로젝트를 아주 간편하게 설정할 수 있는 스프링 프레임워크의 서브프로젝트

#### 스프링 부트의 특징

- XML 기반 설정 과정 없이 간단히 프로젝트를 시작할 수 있음
- 메이븐의 pom.xml 파일에 의존성 라이브러리의 버전을 일일이 지정하지 않아도 됨 (스프링 부트가 권장 버전 관리)
- 단독 실행되는 스프링 애플리케이션 구현 가능
- 프로젝트 환경 구축에 필요한 서버 외적인 툴들이 내장되어 있어서 별도 설치 필요 없음
  - 톰캣 내장되어 있음

#### 스프링 부트 프로젝트 생성 과정

1. 스프링 부트 프로젝트 생성
   1. 프로젝트명 / Group / Artifact / 패키지명
   2. Dependencies 선택
      - SQL : JDBC API / MyBatis Framework / MySQL Driver
      - Web : Spring Web
   
2. 프로젝트 생성 후 확인
   1. pom.xml 내용 확인
      - java.version / jdbc / mysql-connector / tomcat
   2. 자동 생성된 클래스 파일 확인
      - ServletInitializer.java
        - 스프링 부트 애플리케이션을 web.xml 없이 톰캣에서 실행하게 해주는 클래스
        - 따라서 스프링 부트에는 web.xml, context.xml 설정 파일 없음
      - ......Application.java
        - @SpringBootApplication 붙어 있음
          - 스프링 부트 애플리케이션으로 설정하는 어노테이션
        - main() 메소드 포함
          - 스프링 부트 생성 시 자동으로 생성
          - 스프링 부트 프로젝트에는 반드시 main()이 있어야 함
          - 스프링 부트 프로젝트 main() 메소드를 시작점으로 실행
          - main() 메소드를 포함하는 java 파일이 있어야 함
          - 이유 : 스프링 부트 웹 애플리케이션을 일반 자바 애플리케이션처럼 개발하려는 의도 때문
   
3. 스프링 설정 파일
   - application.properties 파일이 자동 생성됨
     - (내용이 없는 빈 파일로 생성)
   - 추가할 내용
     - 포트 번호
     - 데이터베이스 연결 정보
     - mapper.xml 위치 지정
       - src/main/resources 파일에 생성할 것
   - 여기서 컨트롤러 추가하고 ("/") 실행시켜서 오류 있는지 확인
   
4. JSP 뷰 설정
   - 스프링 부트는 JSP 뷰가 기본이 아니기 때문에 JSP 뷰를 사용할 경우 추가 설정 필요
     - application.properties 파일에 JSP 설정 추가
     - pom.xml 의존성 라이브러리 추가
     - src/main/webapp 폴더에 WEB-INF/views 폴더 추가
     - hello.jsp 생성하고 컨트롤러에서 @RequestMapping 추가해서 hello.jsp 실행되는지 확인
     - 스프링 부트에서 리소스 파일 경로 확인
   
5. DB 연동 CRUD 기능 구현
   
   - 파일 위치 주의
   
   1. 패키지 생성
   2. mapper 파일 폴더 생성
      - src/main/resources 폴더에 mapper 폴더 생성
      - application.properties에 mapper 위치 설정
   3. ......Application.java 클래스에 추가
      - 컴포넌트 클래스 (Controller와 Service)에 대해 추가
      - @ComponentScan
      - @MapperScan
      - 추가하지 않으면 bean이 없다는 오류 발생
   4. view 페이지 생성
   5. js 폴더 생성
      - src/main/resources/static 폴더에 js 폴더 생성
   
6. 외부 경로 설정 : 이미지 출력

   - WebConfig 클래스 생성
     - WebMvcConfigurer 인터페이스 구현
       - 맵핑 이름과 이미지 위치 설정

#### 스프링 부트 프로젝트에 파일 업로드

- MultipartFile 클래스 사용
  - 스프링 부트에서는 의존성 라이브러리 추가 필요 없음
  - 자동으로 MultipartConfigElement 클래스를 빈으로 등록
- HTML
  - `<form enctype="multipart/form-data">`
  - `<input type="file">`

- 업로드되는 파일 크기 제한 변경 가능
  - application.properties 파일에서
  - maxFileSize
    - 업로드하는 파일 1개의 크기 : 디폴트 1M
  - maxRequestSize
    - 요청 크기 제한
    - 모든 파일의 크기를 합한 크기 값 제한

- 여러 개의 파일 업로드
  - jsp에 추가
    - `<input type="file" multiple="multiple">`
  - 컨트롤러에 추가
    - `ArrayList<MultipartFile> files`로 받음
    - Model 반환 `ArrayList<String>`로 반환

- 주의
  1. 파일명이 중복되지 않게 해서 업로드
     - 동일한 파일명으로 업로드 되는 경우 앞의 파일 덮어쓰게 되는 문제
     - 파일명이 중복되지 않도록 파일명을 변경해서 업로드
     - UUID : 식별자 표준
       - 16 옥텟(128비트)의 수
       - 총 36개의 문자 (32개 문자와 4개의 하이픈)
       - 8-4-4-4-12
       - 8e1a2153-edfa-436f-bd72-23b6b7e5cd6b_원본파일명
       - 자바 UUID 클래스의 randomUUID() 메소드를 사용해서 유일한 식별자 생성

#### 스프링 부트 프로젝트에 파일 다운로드

- 폴더 내 모든 파일 목록 출력하고 목록에서 파일 선택해서 다운로드
- 파일명에 한글 들어 있는 경우 한글 출력 안 됨
  - 다운로드 컨트롤러에서 인코딩
    - String encodedFileName = new String (file.getBytes("UTF-8"), "ISO-8859-1");
- FileCopyUtils 클래스
  - 파일 및 스트림 복사를 위한 유틸리티 클래스
- FileCopyUtils.copy()
  - 스프링 프레임워크에 내장된 파일 다운로드 기능
  - InputStream의 내용을 지정한 OutputStream에 복사하고 스트림을 닫음
    - InputStream/OutputStream
      - 바이트 기반 입/출력 스트림 클래스
  - 스트림을 열고, 복사, flush, close 기능 수행
