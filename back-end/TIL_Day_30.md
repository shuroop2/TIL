# TIL_Day_30

> 2022년 06월 29일

## JSP

### JSP (Java Server Page)

- 서버 사이드 스크립트 언어
- Java 기반으로 HTML 문서 내에 자바코드를 삽입해서 웹 서버에서 동적으로 웹 페이지를 생성해서 클라이언트에게 반환
- JSP를 통해 HTML과 동적으로 생성된 컨텐츠를 혼합해서 사용
- Servlet을 보완한 스크립트 방식 표준
  - Servlet 기능 + 추가 기능
- JSP는 실행되면 Servlet(.java)으로 변환되어 컴파일되서 클래스(.class) 파일로 만들어져 실행
- View를 담당하는 페이지로 사용

#### JSP와 서블릿과 차이점

- JSP
  - HTML 내부에 Java 소스코드가 들어 있는 형식
  - 사용하기 편리 : 쉬움
- Servlet
  - Java 코드 내에 HTML 코드 포함
  - 읽고 쓰기 불편

#### JSP 페이지의 구조

- 정적페이지 + 동적페이지
- 정적 페이지 구현 : HTML 태그
- 동적 페이지 구현 : 스크립트 사용
  - <%@ %>
  - <% %>
  - <%! %>
  - <%= %>

#### JSP 페이지의 기본 구성 요소

- JSP 페이지 내용
  - HTML 문서 내용
  - JSP 태그
    - <% 로 시작하고 %> 로 종료
    - @, !, =, -- 문자를 추가하여 태그의 의미 부여
    - ![img](https://lh4.googleusercontent.com/3tkRd4k3Biw2AaDQQ-_aJIGQHzUVyPp1g_dF6x96H8Vc8axrB9c0N-aR7EvxFZk-n_cW7HbuDwiNEjb6LkK7GEtNxBu7LrLjcmsVatzG1sykkcJ3D2LE_NnjXBUndwGCzXt-Hjhh)
  - 자바 코드
- JSP 페이지 구성
  - 지시어 : page, include, taglib
  - 스크립트 요소
    - 선언문
    - 표현식
    - 스크립트릿
  - 액션 태그

#### 지시어 (Directive Tag)

- JSP 페이지의 전체적인 속성을 지정할 때 사용
- JSP 컨테이너에게 전달하는 JSP 페이지 관련 메시지
- <%@ 지시어 속성1=값1 속성2=값2 ... %>
- ![img](https://lh4.googleusercontent.com/-0hyP16eXUffhGjbkRcp3wO7raME5CNQCPP9IRERZE4ieLoHoPKaswIu3O2DB0KJ6-1pIEdtKSte8vy3R74tZsLAXVfFtOQjWAk1-cYsa3rzuSfwZXPVPjMCcEuUaonsWzr1HwGv)

##### 지시어 종류

- page 지시어
  - <%@ page ... %>
  - JSP 페이지에 대한 속성 설정
- include 지시어
  - <%@ include file="포함될 파일의 url" %>
  - 공통적으로 포함될 내용을 가진 파일을 해당 JSP 페이지 내에 삽입하는 기능을 제공
  - 복사 & 붙여넣기 방식으로 두 개의 파일이 하나의 파일로 합쳐진 후 하나의 파일로서 변환되고 컴파일
- taglib 지시어
- <%@ taglib prefix="c" uri="http:....."  %>
- 표현 언어 (EL : Expression Language), JSTL(JSP Standard Tag Library)를 JSP 페이지 내에서 사용할 사용

#### 선언문 (Declaration)

- JSP 페이지의 멤버 필드 선언 또는 메소드를 정의할 때 사용

- 선언문에서 선언된 변수는 페이지 전체에서 사용 가능 (전역 변수 의미)

- 형식 : <%! 선언 %>

- 예 

  - ```jsp
    <%! int a = 20; %> 
    <%! 
    	int a = 10;
        String str = "문자열";
    %>

#### 표현식 (Expression)

- 변수 값, 계산 결과, 함수 호출 결과를 직접 출력하기 위해 사용

- <%= 값 | 자바 변수 | 자바 식 %>

- 예

  - ```jsp
    <%= 3\*5 %>
    <%! String name = “홍길동”; %>
    <%= name %>
    ```

#### 스크립트릿 (Scriptlet)

- 자유롭게 자바 코드를 기술할 수 있는 영역
- <% 자바코드 %>
- 스크립트릿에서 선언된 변수는 지역 변수의 개념
  - 선언된 이후부터 사용 가능

#### JSP 내장 객체

- 내장 객체
  - 클라이언트에서 웹 서버에게 JSP 페이지를 요청하면 자동으로 생성
  - 객체 생성하지 않고 바로 사용 가능
- 내장 객체 종류
  - 입출력 : request / response / out
  -  서블릿 : page / config
  - 컨텍스트 : session / application / pageContext
  - 예외 처리 : exception
- ![img](https://lh6.googleusercontent.com/lkIveLMSrYkXSHuiEaw5nE1f1ggD4e0dV02Yxi4bqKIu0Qf1smiG_f8bwmI4C-i38RgdR8qBqt-jA8EipN9Zy2CaHfZnDDi_MjDS9ap1KivFRFYhk2v1CM9ZM4Zl3bgSZ2i5IpnK)
- request 객체의 파라미터 관련 메소드
  - ![img](https://lh3.googleusercontent.com/MePYhU2aC-2gMhZwWDsmy-CYb1MxlQf-ijtucy5fE5ctcX3vnuz744QHR_0WT9SgALPhLL4Blb08k2gnUdAnXpQpwS1ePddZ3XIKUnt8aLWaXHB_AfZqUC_OH4JFVaGfGHbnBeI5)
- response 객체
  - JSP 페이지에서 처리한 결과를 웹 브라우저에 응답할 때 사용
  - 헤더 설정, 코드 상태, 쿠키 등 정보 포함되어 있음
  - 응답 콘텐츠 설정, 응답 헤더 설정, 상태 코드 설정과 관련된 메소드 제공
  - ![img](https://lh3.googleusercontent.com/uI2KPLnuNPPH_jEjh7bVpakiJOV-OF5B85k3KXz979iepJY_uwgibPn073pyPQ-c0A0oZpYrNcZJ9i34xnjCzfmqiF5AqOZyZmfIwH7nlTTCmlADuyacxfL3d-DsOf0XekxxHHl4)
- out 객체
  - 웹 서버에서 웹 브라우저에게 출력 스트림으로 응답하기 위해 사용
  - out.println("출력 문자열");
  - 표현식 <%= 출력문자열 %>과 동일
  - println() : 줄바꿈 적용되지 않음
    - print()와 동일한 결과 (스페이스 한 칸 정도 차이)
    - 줄바꿈 하기 위해서는 `<br>` 태그 사용

#### 액션 태그

- JSP 페이지 내에서 어떤 동작을 지시하는 태그
- 어떤 동작 또는 액션이 일어나는 시점에 페이지와 페이지 사이에서의 제어 이동 또는 다른 페이지의 실행 결과를 현재 페이지에 포함하는 기능 제공

##### 액션 태그 종류

- include
  - `<jsp:include>`
  - <jsp:include page=”포함될 페이지” flush=”true” />
  - 다른 페이지의 실행 결과를 현재 페이지에 포함시킬 때 사용
  - 페이지를 모듈화할 때 사용
  - page 속성 : 결과가 포함될 페이지
  - flush 속성
    - 포함될 페이지로 제어가 이동될 때 현재 포함하는 페이지가 지금까지 출력 버퍼에 저장한 결과를 처리하는 방법을 결정
    - true
      - 현재 페이지가 지금까지 버퍼에 저장한 내용을 웹 브라우저에 출력하고 버퍼를 비움
  - ![img](https://lh5.googleusercontent.com/0WkpaWQwdB0mspsRk1_xQJYqYABhtgFtvrAU--YVzKi6AtPbJPMh0tc2GuOdcGagC7lUqcmF3Qqk6X8WbwabOQaI6OAybsAL9eiMg_ZfSdvz66QsRgEsrNDji7LN2qSw63bwpNVw)
  - ![img](https://lh3.googleusercontent.com/iCwCiKsgPy8i9rTLgDpFB4q4GQOilHkO23TC0PF6iRaTetdaHEzzHk4xL2d-Y5t-LHiAs7Lx8jTelHX6PlZu3RGmZeZY0ZRryNWSBrEUBAqHpxTACqJi_V8uiAhYgeEwAcSKtyXz)
- forward
  - `<jsp:foward>`
  - <jsp:forward page=”포워딩할 JSP 페이지” />
  - 현재 페이지에서 다른 특정 페이지로 전환
  - 웹 페이지 간의 제어를 이동시킬 때 사용

- param
  - `<jsp:param>`
  - 이동하는 페이지에 파라미터 값을 전달할 때 사용
- useBean
  - `<jsp:useBean>`
  - <jsp:useBean id="빈 이름" class="패키지 이름을 포함한 자바 빈 클래스" [scope="접근범위"] />
  - 자바 빈을 JSP 페이지에서 이용할 때 사용
  - DTO / VO 에 해당
- setProperty
  - `<jsp:setProperty>`
  - <jsp:setProperty name="자바 빈 이름" property="속성 이름" value="값" />
  - useBean의 프로퍼티의 값을 세팅할 때 사용
  - setter
- getProperty
  - `<jsp:getProperty>`
  - <jsp:getProperty name="자바 빈 이름" property="속성 이름" />
  - useBean의 프로퍼티의 값을 가져올 때 사용
  - getter
- plug-in

##### 자바 빈 (Java Bean)

- DTO / VO 와 같은 개념
- 데이터를 다루기 위해 자바로 작성되는 소프트웨어 컴포넌트로 재사용 가능
- 입력 폼의 데이터와 데이터베이스의 데이터 처리 부분에서 활용
- 클래스로 작성
  - 멤버 필드로 속성(property)이 있고
  - 멤버 메소드로 Getter/Setter 메소드 포함
  - setXXX() : 프로퍼티에 값 저장
  - getXXX() : 프로퍼티 값 반환
- 액션 태그를 이용해서 빈 사용
- 속성 접근 제어자는 private
- Getter/Setter 메소드와 클래스는 public
- 자바 빈 관련 액션 태그
  - useBean
  - setProperty
    - 데이터 설정(저장)
    - 모든 속성을 한꺼번에 설정
      - form의 `<input>` 태그 속성명을 클래스 필드명과 동일하게 지정하고 <jsp:setProperty property="\*".. />로 설정
  - getProperty
