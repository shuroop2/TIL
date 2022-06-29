# TIL_Day_29

> 2022년 06월 28일

## Framework 기반의 서비스 프로그래밍

### 웹 개념

웹 프로그래밍의 개요

- 웹 프로그래밍은 기본적으로 클라이언트 / 서버 방식
- 정적인 HTML만으로는 데이터가 실시간으로 변화하는 것을 처리하거나 저장하기에는 불가능
- 동적으로 변화하는 데이터를 처리하고 표시하기 위해 개발된 언어들이 CGI, ASP, PHP, JSP, Servlet, ...
- 정적 웹 프로그래밍
- 동적 웹 프로그래밍

#### 정적 웹 프로그래밍 

- 웹 서버에 미리 보여줄 HTML 페이지, CSS, 이미지, 자바스크립트 파일 등을 저장해 놓고 브라우저에서 요청할 경우 그대로 전달하는 방식
- 사용자는 페이지가 변경되지 않는 한 고정된 웹 페이지를 보게 됨 (물론 페이지 레이아웃 등이 동적으로 변경 가능)
- 주로 화면의 디자인을 구성하거나 클라이언트의 이벤트를 처리함
- 실시간 데이터 처리 또는 데이터 저장 등을 표현하거나 다루는데 적합하지 않은 방식

##### 정적 웹 프로그래밍의 구성 요소

- 클라이언트 (웹 브라우저)
  - 인터넷으로 서버에 접속한 후 서버로부터 서비스를 제공받는 컴퓨터와 소프트웨어 (웹 브라우저)
- 웹 서버
  - 각 클라이언트로부터 요청을 받고 서비스를 제공하는 컴퓨터와 소프트웨어
- HTTP 프로토콜 (통신 규약)
  - Hyper Text Transfer Protocol
  - WWW(World Wide Web) 서비스를 제공하는 프로토콜을 이용해서 정보를 주고 받음
  - 통신 규약 : 통신을 위해 미리 정해놓은 규칙
- HTML
  - WWW 서비스를 제공하기 위한 표준 언어
- 자바스크립트
  - HTML 웹 페이지의 여러 가지 동적인 기능을 제공하기 위한 스크립트 언어
- CSS
  - HTML 페이지의 디자인 관련 기능 처리하기 위한 언어

#### 동적 웹 프로그래밍

- 정적 웹 프로그래밍에서 관리자의 역할을 웹 애플리케이션 서버가 수행
- 웹 애플리케이션 : Web Application Server : WAS
- 클라이언트의 요청이 있을 때마다 데이터베이스에 접근해서 실시간 정보를 얻어와서 클라이언트에게 전송
- 초기 동적 웹 프로그램에서 사용하는 방식
  - CGI (Common Gate Interface : 공용 게이트웨이 인터페이스)
    - 대표적인 CGI 언어 : 펄(Perl)
  - 프로세스(Process) 방식으로 실행됨
  - 프로세스 마다 메모리에 로드하는 방식으로 메모리에 과부하 발생하는 문제
- 이런 문제를 해결하면서 기술들이 JSP, ASP, PHP
  - 브라우저 요청 시 스레드 방식으로 실행하므로 CGI보다 효율적으로 기능을 수행함
  - 클라이언트 요구를 처리하는 기능은 최초 한 번만 메모리에 로드
  - 동일한 기능 요구 시 기존에 사용한 기능을 재사용
  - 따라서 프로세스 방식으로 동작하는 것보다 훨씬 빠르게 수행

#### 웹 서비스

- 인터넷을 기반으로 제공되는 서비스

##### 웹 서비스의 구성 요소

- 웹 브라우저 : 클라이언트, 사용자의 작업 창
- 웹 서버 : 웹 브라우저의 요청을 받아들이는 곳
- 웹 애플리케이션 서버 (WAS)
  - 요청된 페이지의 로직 및 데이터베이스와의 연동을 처리하는 부분
  - Apache Tomcat
- 데이터베이스 : 데이터의 저장소

##### 웹 서비스 구조 및 처리 순서

- <img src="https://lh5.googleusercontent.com/57dB6vBYAGCfVi10Jnoqr2dGIiXl4BcXOmmrYEumXJ2fau85PsR5lgYSZIasgTb6fXGaiprDeO97gV87ZmdBBXuUa7_JfVVcLgyHKgZZembxvEtnMlHp47A0oiSzHWpInlDw0G0" alt="img" style="zoom:50%;" />

#### 웹 애플리케이션

- 웹을 기반으로 작동되는 프로그램
- 웹 프로그래밍을 통해 구현

##### 웹 애플리케이션 서버 (WAS)

- 웹 서버로부터 오는 동적인 요청을 처리하는 서버
- 웹 서버 기능 + 웹 컨테이너 기능
- 기타 기능
  - 트랜잭션, 보안, 트래픽 관리, DB 커넥션 풀, 사용자 관리 등 다양한 기능 제공
- Apache Tomcat은 WAS

#### 웹 서버

- 웹에서 서버 기능을 수행하는 프로그램
- HTTP 포로토콜 기반
- 웹 플라이언트(웹 브라우저)로부터 요청을 서비스(제공)하는 기능 담당
- 정적인 콘텐츠 (HTML, JPG, CSS 등) 제공
- 동적인 콘텐츠(데이터 처리) 요청은 웹 컨테이너(WAS에 포함)에게 보내고 웹 컨테이너가 처리한 결과를 클라이언트에게 응답

##### 웹 서버 종류

- Apache (리눅스 / 유닉스 / 윈도우)
- IIS (Internet Information Server) : MS

#### 웹 컨테이너 (Web Container)

- 웹 애플리케이션을 실행할 수 있는 컨테이너
- JSP와 Servlet(서블릿)을 실행시킬 수 있는 소프트웨어
- 웹 서버가 서블릿 자체를 실행하지 못하므로 JVM을 내장한 컨테이너라는 서블릿 실행 환경이 필요
- 서블릿과 JSP에 대한 실행 환경 제공
- 물론, 정적 페이지에 대한 요청도 처리 가능
- 웹 서버에서 JSP를 요청하면 톰켓(웹서버 + 컨테이너)에서 JSP 파일을 서블릿으로 변환하여 컴파일을 수행하고 서블릿 수행결과를 웹 서버에게 전달 -> 클라이언트에게 전달
- 웹 애플리케이션 당 한 개의 SevletContext 객체 생성

##### 웹 컨테이너가 사용자의 요청에 응답하는 순서

1. 클라이언트가 HTTP request를 HTTP service(웹 서버)에게 전송
2. 웹 서버가 요청 데이터를 웹 컨테이너에게 전송
3. 웹 컨테이너는 HttpServletRequest 객체와 HttpServletResponse 객체 생성
4. 웹 컨테이너는 요청된 Servlet의 service() 메소드를 호출하여 Servlet을 활성화 시킴
5. 웹 컨테이너는 Servlet에 의해 생성된 응답 데이터를 웹 서버(HTTP service)에게 전송
6. 웹 서버는 Http response를 클라이언트에게 전송

#### JSP와 Servlet

- JSP (Java Server Page)
  - 서버측 스크립트 언어
  - 형식 : HTML 내에 Java 언어를 삽입한 문서 형태.jsp
- Servlet(Server + Applet)
  - Java 언어로 이루어진 웹 프로그래밍 문서
  - 자바 코드에 의존적
  - .java

##### JSP 페이지의 실행 과정

- <img src="https://lh3.googleusercontent.com/rLpQkNYh9sXJLe5PGGHLuTloNhfiBhXY_I-sfnqbBpMG2DfNkgG5bI5WbqqzxigQDeZEd0D75ELlRFn9TTroBtQPWgZprfG7Tll7ikEoYCCHpa1SnQPLuvajY4zyU0lsunQ3SbE" alt="img" style="zoom:50%;" />

### 서블릿 (Servlet)

- 서버 측에서 실행되면서 클라이언트의 요청에 따라 동적으로 서비스를 제공하는 자바 클래스 (응답 : HTML 형식)
- 자바 플랫폼에서 컴포넌트 기반의 웹 애플리케이션을 개발하는 핵심 기술 (동적 웹 애플리케이션 컴포넌트)
- 컨테이너 종류에 상관없이 실행됨 (플랫폼 독립적)
- 독자적으로 실행되지 못하고 톰캣과 같은 JSP/Servlet 컨테이너에서 실행
- 자바로 만들어져 자바의 특징(객체 지향)을 가짐스레드 기반
- JSP 페이지처럼 화면에 내용을 표시할 목적으로 사용하는 것이 아니라 MVC 패턴에서 로직인 모델(Model)과 화면에 결과를 표시하는 View 사이에서 제어를 하는 컨트롤러로 사용됨
- java 파일이기 때문에 src/main/java 폴더에 위치
  - webapp 폴더 - HTML 문서
- Servlet 많이 사용하는 이유 : 빠른 응답 속도 때문
  - 서블릿은 최초 요청 시 객체가 만들어져 메모리에 로드되고 이후 요청 시에는 기존의 객체 재활용
  - 따라서 동작 속도가 빠름

#### 서블릿 현황

- 서블릿은 현재 현업에서 새로이 개발하는데 많이 사용되지 않음
- 소수 사용
  - 2000년 중반에 구축한 시스템(Servlet과 JSP로 사용해 구축)들이 아직 사용
  - 최신 시스템으로 변환하는데 비용이 많이 들기 때문
  - 개발자 - 유지보수
- 웹 서버와 브라우저의 동작 및 Spring 이해에 도움HTTP request와 HTTP response는 스프링에서도 사용

#### 서블릿 학습 내용

- 서블릿 개요 및 처리 순서
- 서블릿 맵핑 (Get/Post 처리)
- 폼에서 입력한 데이터 처리
- 웹 페이지로 데이터 전송
- 서블릿 포워딩

#### 서블릿 처리 순서

- 클라이언트에서 서블릿 요청이 들어오면
- 서버에서 서블릿 컨테이너를 만들고 스레드 생성
- (요청 시 마다 스레드 생성)
- 서블릿 컨테이너는 스레드를 가동하여 서블릿 객체 생성
- 서블릿 객체의 실행이 종료되면 스레드 종료되고 반환
- 서블릿 실행 결과가 웹 서버에 전송
- 이 결과를 웹 서버가 웹 브라우저에게 전송
- <img src="https://lh5.googleusercontent.com/F3qwjjm4I9Ad7r3o98ovhFflmkpD_sBt3pjw96zcYQLB2aqNhfE_-3HXohAt0LKVjV44UeOsyiElVDaI5YWaxOA1_RCxXD1d5Xq3CJIPeAEcxtLy5H_tEZd9JdFVTUrUKFuKi54" alt="img" style="zoom:50%;" />
- 같은 Servlet class에 대한 요청을 처리하는 모든 thread는 같은 Servlet 객체 공유
- 로컬 변수가 각 요청 스레드마다 각 스택영역에 저장되어 동시성 문제를 발생시키지 않음

#### 서블릿 라이프 사이클 (생명주기)

<img src="https://lh3.googleusercontent.com/VzjkszRO7ggI7JUuSR6oGxgFQe9mrXBN39z-GydK4eKWak8QqIxUjCYQe17qVuNgzChiqL_0fTbjXUbKLk5z-hxz2qCZ0FFvhVR1VG9-rnL1DBOkQQLUDheN4Ts9r1tPs_JHBWg" alt="img" style="zoom:50%;" />

#### 서블릿 패키지와 클래스

- 서블릿 패키지
  - javax.servlet.\*
    - 서블릿 작성을 위한 인터페이스와 클래스 제공
  - javax.servlet.http.\*
    - HTTP 프로토콜을 이용한 서블릿 작성에 필요한 인터페이스 제공 (GET/POST)
- 서블릿 클래스
  - Servlet 인터페이스
  - GenericServlet 추상 클래스
  - HttpServlet 클래스를 상속 받음

#### 서블릿 장점

- 신뢰성
- 확장성 - 기능 확장 용이
- 플랫폼과 서버에 독립적 (자바 기반)
  - 한 번 개발된 애플리케이션은 다양한 서버 환경에서 실행 가능
- Java에서 제공되는 다른 기술을 같이 사용 가능
  - 예 : Servlet과 JDBC 연동

#### 서블릿 생성 과정

<img src="https://lh5.googleusercontent.com/9gbJDxd0ewhfPI1CEZE-sptXKbYFi5yfYOgWkTrPnaYXI8DswjlDq3mqBoLzGyPqiUKOsYrPUJVuZx_Xwu_Ohy1h9nqaaQmLyAsizC4PNrUOiJixJFubaQzhqlEi8KRpawQVQk0" alt="img" style="zoom:50%;" />

#### 서블릿 맵핑 (Mapping)

- 서블릿 경로 연결
- 서블릿 파일 경로 노출로 인한 보안 문제를 없애고 url을 간단하게 줄일 수 있음
- 웹 브라우저에서 서블릿을 요청하기 위해서는 서블릿 맵핑 필요
- 서블릿 매핑 방법
  1. web.xml 에서 설정
  2. 어노테이션 이용 : 이클립스에서 자동 지정
     - 변경 가능
     - 변경해서 사용하는 방법

#### 요청 처리 객체 / 응답 처리 객체

![img](https://lh4.googleusercontent.com/5m_5aRAWQqwGkmPzTvCDInpHoVrx_vYdvkeV3orf7XlAPgHhjK-D9SNoZHOmYLXTVlKWUNP1kJIPKM1qYQ2iQVxZnh3-COxOR0IFzlVRIoNDz7vbKyIMoJglQ1ELnYDokTxi-CM)

- 톰캣에서 request 객체와 response 객체 생성해서 doGet() 메소드 안에 인자 값으로 넣어 줌
- request 객체 : 요청 처리 객체
  - 클라이언트에서 입력한 데이터가 request 객체에 담겨서 서버로 전달
- response 객체 : 응답 처리 객체
  - 서버 측에서 처리한 결과를 response 객체에 담아서클라이언트로 전달
- doGet()과 doPost() 메소드 둘 다 매개변수로 request/response 객체를 가짐

#### **예제에서의 서블릿 동작 과정**

- http://localhost:8080/Servlet01/first 로 요청
- FirstServlet이 메모리에 존재하는지 체크없으면 FirstServlet을 메모리에 로드
- init() 메소드 호출
- doGet() 또는 doPost() 메소드 호출
  - method 지정하지 않으면 doGet() 디폴트
- 클라이언트에게 결과 응답
  - 예제에서는 웹페이지로 응답하지 않고 콘솔에 출력
- <img src="https://lh5.googleusercontent.com/P0JJFQzSnCzyieROAaGIw_evEr2BQbte2fBm4nG_r1deLFS5SNKyiDSOtz8_AjRpsObZVqNgvUML4t2tEKElLFqk61TZkSVQsZ5c_JtscEzhOqLT24j0VgdVuagikKdutfJWUtA" alt="img" style="zoom:50%;" />

#### 컨텍스트 (Context)

- 톰캣의 server.xml에 등록하는 웹 애플리케이션을 컨텍스트라고 함
- 즉, 톰캣 입장에서 인식하는 한 개의 웹 애플리케이션임
- 웹 애플리케이션 당 하나의 컨텍스트가 등록됨
- 웹 애플리케이션 이름과 같을 수도 다를 수도 있음
- 컨텍스트 이름은 중복되면 안 됨
- 웹 애플리케이션의 의미를 가장 잘 나타낼 수 있는 명사형으로 지정
- 대소문자 구분
- server.xml에 등록
  - 모든 설정 정보를 xml로 저장한 후 실행 시 정보를 읽어와 설정대로 실행함
- 이클립스에서 프로젝트를 생성하면 자동으로 server.xml에 추가
- ![img](https://lh5.googleusercontent.com/8gYejW4qQPC5qts4Lcd871nQbc0ALimSY4jpTUokb8TEC7JrE2IEWK5gSzEQXpdJHNAakZ8phs3r6wYwgfaMMzk3h1c2Khkj0hf-hu1BEjDEfF46FPLzl8d5l_69FlM7kTGpc78)

#### URL / URI / ContextPath / ServletPath

- URL : 전체 주소
  - http://localhost:8080/Servlet01/first
  - 프로토콜 + IP + 포트번호 + URI
- URI : ContextPath + ServletPath
  - /Servlet01/first
  - 프로젝트명 + 서블릿 맵핑 이름
- ContextPath : 프로젝트명
  - /Servlet01
- 서블릿 맵핑 이름
  - /first
- ![img](https://lh4.googleusercontent.com/xYEvCJ9CxBr03lW4ya0c7WfJAIZPZj4_F8ijYZcKlXoCAaBNk_5BUND5_QZ7Ff_wBW-eqKw4VlI2QEgyDB-wcFreHMEn5c8OJthDqz-fR3nGD1PU2zwbXGpC6si5BZN4u3vMX1s)
  - URI (Uniform Resource Identifier) : 통합 자원 식별자
    - 특정 리소스를 구분하는 식별자
    - 논리적 또는 물리적 리소스 (접글할 리소스 위치를 알 수 있음)
    - 인터넷, 모바일 기기 등 다양한 곳에서 사용
  - URL (Uniform Resource Locator) : 웹 주소
    - 리소스 위치
    - URI가 서브넷

#### 서블릿 요청 API

- 서블릿 기본 기능
  1. 클라이언트로부터 요청을 받음
     - 서블릿 요청과 응답 수행 API
     - javax.servlet.http 패키지에 포함
     - 요청과 관련된 API
       - javax.servlet.http.HttpServletRequest 클래스
     - 응답과 관련된 API
       - javax.servlet.http.HttpServletResponse 클래스
  2. 데이터베이스 연동과 같은 비즈니스 로직을 처리함
  3. 처리된 결과를 클라이언트에 응답

- `<form>` 태그로 서블릿 요청
  - 서블릿 데이터를 웹 브라우저를 통해서 전송하는 방법
  - `<form>` 태그를 사용해서 브라우저에서 서블릿으로 사용자의 요청이나 데이터를 전송
- `<form>` 태그
  - action 속성 : 서블릿 또는 JSP 이름 지정
  - method : GET 또는 POST (디폴트 : GET)
- `<input>` 태그
  - 데이터 입력 받아서 전송
  - name 속성 사용
  - name 속성명과 속성값 쌍으로 전송

#### 서블릿에서 클라이언트의 요청 받기

- HttpServletRequest 클래스의 여러 가지 메소드를 이용해서 전송된 데이터를 받음
- `<form>` 태그로 전송된 데이터를 받아오는 메소드
- ![img](https://lh5.googleusercontent.com/mSoBF1W7eiaS8TPl-HodED0ewNGLEk1sGYyQQmHcGE0GOEHlxn4Ygtd9opcK4P6SzywZISs-T3mN_ipHPsG6ZJZzONuJmSW35rSpOuKTFFmKW2eN52_cWMtFaLjpC0Iv-ESQuvw)

#### Get 방식과 Post 방식

##### Get 방식

- 데이터를 전송할 때 데이터가 URL 뒤에 name=value 형태로 전송
- 여러 개의 데이터를 전송할 때는 &로 구분해서 전송
- 전송 데이터 노출 : 보안 취약
- 전송 데이터 길이 제한 : 최대 255자
- 기본 전송 방식
- 서블릿에서는 doGet() 이용해서 데이터 처리
- 웹 브라우저에서 직접 url에 입력해서 doGet() 메소드 호출 가능

##### Post 방식

- 데이터를 전송할 때 TCP/IP 프로토콜 데이터의 HEAD 영역에 숨겨서 전송됨
- 보안에 유리
- 전송 데이터 길이 : 용량이 무제한
- 서블릿에서는 doPost() 메소드 이용해서 데이터 처리GET 방식보다 느림

#### 주의할 점

- 폼에 입력되어 서버로 전송되는 값들은 모두 문자열로 전송 (연산이 필요한 경우 숫자로 형변환 필요)
- 1개의 값을 받을 경우 : getParameter() 메소드 사용
- 여러 개의 값을 받을 경우 (동일한 name 값이 여러 개인 경우 : checkbox name이 다 동일한 경우)
  - getParameterValues() 메소드 사용
  - 반환되는 값이 배열이므로 배열 처리해서 사용
- 참고
  - 라디오버튼인 경우 한 그룹의 라디오 버튼 이름이 다 동일해도 1개의 값만 전송되므로 getParameter() 메소드 사용

#### 서블릿 응답 처리

##### 서블릿의 응답 처리 방법

- doGet()이나 doPost() 메소드 안에서 처리함

- javax.servlet.http.HttpServletResponse 객체를 이용함

- 클라이언트에게 전송할 데이터 타입 인코딩

  - resonpse.setContextType("text/html;charset=utf-8");
  - MIME-TYPE
    - HTML로 전송 시 : text/html
    - 일반 텍스트로 전송 시 : text/plain
    - XML 데이터로 전송 시 : application/xml

- 클라이언트(웹 브라우저)와 서블릿의 통신은 자바 I/O의 스트림 이용

  - PrintWriter 클래스 사용

    - ```java
      PrintWriter out = response.getWriter();
      out.print(data); // 웹 브라우저로 보내는 데이터
      ```

##### 서블릿의 응답 처리 순서

<img src="https://lh5.googleusercontent.com/vyvj0mCqZ1-PtUzz1j7M4U_eOFY6TJxMi3egVrDjfMsJVFpesEixuCjZ9Os_G-ffqmOgq2elyeKbZuuJ92AO9Ndw7aP681KekL8EoYH8bLk72c-m-lFUFWVov79OuGtKwKuPeiQ" alt="img" style="zoom:50%;" />

#### doGet() / doPost() 방식 둘 다 처리

- 일반적으로 doHandle() 또는 doProcess() 메소드를 새로 추가해서 doGet() / doPost() 방식 둘 다 처리
- doGet() 또는 doPost() 방식으로 요청이 들어오면 doGet() 또는 doPost() 메소드에서 doHandle() 호출하고 request와 response 객체 전달
- doHandle() 메소드에서 처리

#### 서블릿에 요청 방법

1. 자바스크립트로 서블릿에 요청 

   - DOM 사용

   - name 속성 사용

2. jQuery 사용해서 서블릿에 요청

#### 서블릿 포워딩

- 포워딩
  - 서블릿에서 다른 서블릿이나 JSP 페이지로 요청을 전달하는 기능
- 포워딩 용도
  - 요청에 대한 추가 작업을 다른 서블릿에서 수행
  - 요청에 포함된 정보를 다를 서블릿이나 JSP 페이지와 공유
  - 요청에 정보를 포함시켜 다른 서블릿으로 전달
  - 컨트롤러에서 뷰로 데이터 전달
- 서블릿에서 포워딩 방법 4가지
  1. redirect 방법
     - 웹 브라우저에 재요청하는 방식
     - HttpServletResponse 객체의 sendRedirect() 메소드 이용
     - 형식 : sendRedirect("포워드할 서블릿 또는 JSP");
  2. Refresh 방법
     - 웹 브라우저에게 재요청하는 방식
     - HttpServletResponse 객체의 addHeader() 메소드 이용
     - 형식 : addHeader(“Refresh”, “경과시간(초);url=요청할 서블릿 또는 JSP”);
  3. location 방법
     - 자바스크립트에서 재요청하는 방식
     - 자바스크립트의 location 객체의 href 속성 이용
     - 형식 : location.href = “요청할 서블릿 또는 JSP”;
  4. dispatch 방법
     - 서블릿이 직접 요청하는 방식 (일반적으로 포워딩 기능 지칭)
     - RequestDipatcher dis = request.getRequestDispatcher(“포워드할 서블릿 또는 JSP);
     - dis.forward(request, response);
- 포워딩 방법들의 차이점
  - redirect, Refresh, location 방법
    - 서블릿이 웹 브라우저를 거쳐서 다른 서블릿이나 JSP에게 요청하는 방법
  - dispatch 방법
    - 클라이언트를 거치지 않고 서블릿에서 바로 다른 서블릿에게 요청하는 방법
    - url이 바뀌지 않음 (즉, 클라이언트 측에서는 포워드가 진행되었는지 알 수 없음)

- 포워딩 하면서 데이터 전달
  - response.sendRedirect(“second04?name=kim”);
  - String name = request.getParameter(“name”);
    - FirstServlet04.java : /first04
    - SecondServlet04 : /second04
  - 실행은 FirstServlet04.java
    1. 값 지정해서 전달
    2. 변수 사용 : 변수값이 전달되도록
    3. 한글 인코딩 : URLEncoder.encode() 사용

#### 바인딩

- 수십 개 또는 많은 양의 회원 정보나 상품 정보를 전달해야 할 경우 포워딩 방식만 사용할 경우 문제
- 서블릿에서 다른 서블릿 또는 JSP로 대량의 데이터를 공유하거나 전달할 때 바인딩(binding) 기능 사용

##### 바인딩 방법

- 포워딩할 때 setAttribute(“바인딩이름”, 데이터) 메소드를 사용해서 바인딩 이름과 데이터를 묶어서 설정한 후 포워딩된 문서에서 getAtrribute(“바인딩이름”) 메소드를 사용해서 바인딩된 데이터를 추출해서 사용
- redirect 방식으로는 전송 안 되고 dispatch 포워딩 방식 사용

#### **DTO vs VO**
##### DTO (Data Transfer Object)

- 데이터 저장 담당 클래스 (Model)
- Controller, Service, View 등 계층간 데이터 교환을 위해 사용되는 객체
- 비즈니스 로직을 갖지 않는 순수한 데이터 객체
- Getter / Setter 메소드만 포함
- 가변의 성격 (Setter : 값을 설정 (값이 바뀜)

##### VO (Value Object)

- 데이터 저장 담당 클래스 (Model)
- DTO와 혼용해서 사용되지만 VO는 값(value)을 위해 사용되는 객체로 불변(read only)의 속성
- 보통 Getter의 기능만 포함
- 그러나 일반적으로 스프링에서 VO로 사용되지만 Getter/Setter 기능 다 사용하는 경우도 있음

