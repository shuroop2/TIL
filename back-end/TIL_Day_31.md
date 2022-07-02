# TIL_Day_31

> 2022년 06월 30일

## 표현언어와 JSTL

### 표현 언어 : EL (Expression Language)
- JSP 발전 과정
  - 초기 : HTML 태그를 중심으로 자바를 이용해 화면 구현
  - 화면에 대한 요구 사항이 복잡해지면서 자바 코드를 대체하는 액션 태그 등장
  - 복잡 자바 코드를 제거하는 방향으로 발전
    - 복잡한 자바 코드로 인해 화면 작업 어려움
  - 현재 JSP 페이지는 스크립트 요소보다 표현 언어나 JSTL 사용

#### EL (Expression Language)

- 표현 언어
- 자바 코드가 들어가는 표현식을 좀 더 편리하게 사용하기 위해 JSP 2.0부터 도입된 데이터 출력 기능
- 표현식 또는 액션 태그 대신 값을 표현
- <%= 값 %>  => ${값}
- parameter : ${ param.이름 }
- `<jsp:getProperty>` 대신 사용
- <jsp:getProperty name="member" property="id" /> => ${member.id}

#### EL 연산자

- 산술 연산자 : +, -, \*, /, %, (div, mod)
- 관계 연산자 : >, >=, <, <=, ==, !=
  - (gt, ge, lt, le, eq, ne)
- 논리 연산자 : &&, ||, !, (and, or, not)
- 조건 연산자 : 수식 ? 참일때 값 : 거짓일때 값
- empty 연산자
  - 값이 null 이거나 길이가 0이면 참 (true)
  - ${empty 변수} : 변수가 null 이거나 0이면 참
  - ${not empty 변수} : 변수가 null 이 아니거나 0이 아니면 참

#### EL 내장 객체

- ![img](https://lh3.googleusercontent.com/RcLp-fR9ltPS8v2_Pv1hNYr2KEoTBxaJEky2U4mQ4UxDVWtRibupXovpy3e1VAo6n5rPXA_JNCIUh-2MVLHViK7BGgrA24aTW9kxYTJJ0pI4NGKnRJRrDImWT6OdupbBYHuDleN8)

- pageContext 내장 객체

  - 컨텍스트 이름 (프로젝트명) 출력

  - getContextPath() 메소드 이용해서 컨텍스트 이름 가져오기

  - ```jsp
    <a href="/JSP01/el/login.jsp">로그인</a>
    <a href="<%=request.getContextPath()%>/el/login.jsp">로그인</a>
    <a href="${pageContext.request.contextPath}/el/login.jsp">로그인</a>

#### EL로 바인딩 속성 출력

- request, session, application 내장 객체에 속성을 바인딩한 다른 서블릿이나 JSP에 전달 가능
- 자바 코드 사용하지 않고 바인딩된 속성 이름으로 바로 값 출력
- request.setAttribute("바인딩이름", 값); => ${바인딩이름}

#### 스코프 (scope) 우선순위

- request, session, application 내장 객체에는 데이터를 바인딩해서 다른 JSP로 전달
- 각 내장 객체에 바인딩하는 속성 이름이 같은 경우 각 내장 객체에 지정된 출력 우선순위에 따라 순서대로 속성에 접근
  - 우선순위는 page > request > session > application
- pageScope : 현재 페이지 영역의 변수
- requestScope : 이전 페이지에서 받아온 영역의 변수
- sessionScope : session 영역의 변수
- applicationScope : application 영역의 변수

### JSTL (JSP Standard Tag Library)

- JSP 표준 태그 라이브러리

- JSP와 HTML을 같이 사용함으로써 가독성이 떨어지는 것을 보완하고자 만들어진 태그 라이브러리

- JSP 페이지 내에서 자바 코드를 사용하지 않고 태그를 사용하도록 함

- JSP 페이지의 로직을 담당하는 부분인 제어문 및 데이터베이스 처리 등을 표준 커스텀 태그 제공

- 사용하기 위해서는 라이브러리 별도 필요

- ```jsp
  <%@ taglib uri="..." prefix=""/>

#### JSTL 라이브러리

![img](https://lh5.googleusercontent.com/Zmg5RwDBvUr0KtkA48yFyflf1cYLnCeKaBE16wIZegRbIFwkTKrOVUWQ69pP5riJtarMiKfEzC7vhclZGbaYN5RtQN3IFvvTRqg4Ekgez2Z0W_Cg2S6eG6XzNIbJNkCDEANjXKtg)

##### Core (코어)

- 자바의 import문처럼 코어 태그 라이브러리를 사용하려면 반드시 JSP 페이지 상단에 taglib 지시문을 추가

  - ```jsp
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

- 제공 기능
  - 변수의 선언 및 삭제 등의 변수와 관련된 작업
  - if, for 문 등과 같은 제어문
  - url 처리 및 그밖에 예외처리 및 화면 출력

- 태그
  - `<c:set>`
    - JSP의 setAttribute()와 같은 역할
    
    - (page|request|session|application) 범위의 변수(속성)를 설정
    
    - ```jsp
      <c:set var="변수명" value="변수값" [scope] />
      ```
    
  - `<c:remove>`
    
    - JSP의 removeAttribute()와 같은 역할
    
    - (page|request|session|application) 범위의 변수(속성)를 제거
    
    - ```jsp
      <c:remove var="변수명" [scope] />
      ```
    
  - `<c:out>` 
    - 화면 출력
    - JSP의 표현식 대체
    
  - `<c:redirect>`
    - response.sendRedirect()를 대체하는 태그로 지정한 다른 페이지로 이동
    
    - 매개변수 전달 가능
    
    - ```jsp
      <c:redirect url="redirect할 url">
      	...
      </c:redirect>
    
  - `<c:if>`
    
    - 조건문을 사용할 때 사용 (else 없을 때)
    
    - ```jsp
      <c:if test="${조건식}" [scope]/>
    
  - `<c:choose>`
    - 자바의 switch 문과 같지만, 조건에 문자열 비교도 가능하고 쓰임의 범위가 넓음.
    
    - 서브 태그로 `<when>`과 `<otherwise>`를 가짐
    
    - else가 필요할 때
    
    - ```jsp
      <c:choose>
          <c:when test="${조건식1}" >내용1</c:when>
          <c:when test="${조건식2}" >내용2</c:when>
          ...
          <c:otherwise>내용n</c:otherwise>
      </c:choose>
    
  - `<c:when>`
    - choose의 서브 태그로 조건의 비교 시에 조건을 만족한 경우에 사용
    
  - `<c:otherwise>`
    - 조건을 만족하지 못한 경우에 사용
    
  - `<c:forEach>`
    - 객체 전체에 걸쳐 반복 실행을 할 때 사용
    
    - ```jsp
      <c:forEach var="변수명" items="반복할객체명" begin="시작값" end="마지막값" step="증가값" varStatus="반복상태변수명">
      	...
      </c:forEach>
      ```
    
    - varStatus의 여러 가지 속성
    
      - | 속성  | 값      | 설명                                                    |
        | ----- | ------- | ------------------------------------------------------- |
        | index | int     | items에서 정의한 항목을 가리키는 index 번호. 0부터 시작 |
        | count | int     | 몇 번째 반복인지 표시. 1부터 시작                       |
        | first | boolean | 첫 번째 반복인지 표시                                   |
        | last  | boolean | 마지막 반복인지 표시                                    |
    
  - `<c:forToken>`
    - 자바의 StringTokenizer 클래스를 사용하는 것과 같음
    
  - `<c:catch>`
    
    - body 위치에서 실행되는 코드의 예외를 잡아내는 역할을 담당
    
  - `<c:import>`
    
    - 웹 애플리케이션 내부의 자원 접근은 물론이고, http, ftp 같은 외부에 있는 자원(html, jsp등)을 가져옴
    
  - `<c:param>`
    - 파라미터 사용 시 필요. 
    - `<import>` 태그의 URL뒤에 파라미터로 붙여서 사용되기도 함
    
  - ` <c:url>` 
    - 쿼리 파라미터로부터 URL을 생성
    
    - url 정보 저장
    
    - ```jsp
      <c:url var="변수명" value="URL경로" [scope]>
      		<c:param name="매개변수명" value="전달값" />
      		...
      </c:url>
      ```

##### Format

- 숫자 및 날짜와 관련된 포매팅 태그 라이브러리

- ```jsp
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  ```

- 형식

  - ```jsp
    <fmt:formatNumber> </fmt:formatNumber>
    <fmt:formatDate> </fmt:formatDate>
    <fmt:timeZone> </fmt:timeZone>
    ```

##### Functions

- 함수 기능

- ```jsp
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  ```

  - length()
  - toUpperCase()
  - indexOf()
  - contains()
  - trimg()
  - substring()
