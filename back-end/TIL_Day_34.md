# TIL_Day_34

> 2022년 07월 07일

## 스프링 프레임워크 (Spring Framework)

### Spring 데이터베이스 연동

#### MyBatis (마이바티스)

- ORM(Object Relational Mapping : 객체 관계 맵핑) 프레임워크
- 자바에서 JDBC를 이용할 경우 java 언어와 SQL 언어가 한 파일에 존재해서 재사용성이 좋지 않음
- MyBatis가 JDBC의 이런 단점을 개선하여 SQL 명령어를 별도의 XML 파일에 분리하고 SQL 명령어와 자바 객체를 맵핑해주는 기능을 제공
- SQL 재사용성 좋음
- 효율적이고 쉬움

##### MyBatis 특징

- SQL 명령어를 자바 코드에서 분리하여 XML 파일에서 관리

![img](https://lh3.googleusercontent.com/ThwQX5rMSo8JzvsoPuZ74coV69cetziyvXjS53rgM-qFydRRfLvZGCJHpFAjeKVGj5uP2h_q3F5riRDg4hnAR_zyO9OcLz8ZEMFsYB1TiRzi2KZMpq41FVx_UiKyDqsIKT0wxWIg)

#### MyBatis 연동 스프링 프로젝트 작성 순서

1. MVC 프로젝트 생성
2. pom.xml 기본 설정
   - Java : 11
   - Spring : 5.2.22.RELEASE
   - Maven : 1.8
3. 프로젝트 설정
   - Java Compiler
   - Java Build Path
   - Project Facets
4. pom.xml에 데이터베이스 의존성 설정
   - 라이브러리 추가
     - Spring JDBC 의존성 : spring-jdbc
     - Connection Pool 의존성 : commons-dbcp
     - MySQL 의존성 : mysql-connector
     - MyBatis / MyBatis-Spring 의존성 : mybatis / mybatis-spring
5. 데이터베이스 연결 정보 설정
   - jdbc.properties 파일 생성
     - jdbc.driverClassName
     - url / username / password
   - 스프링 설정 파일 생성 : application-config.xml
     - DataSource / Mapper 지정
   - web.xml에 변경된 내용 설정
6. 클래스 구성 : CRUD 기능 구현
   - 컨트롤러
   - 서비스 인터페이스 / 클래스
   - VO
   - DAO / Mapper (XML)
   - 뷰 페이지 작성
   - 패키지 생성
     - controller
     - dao
     - model
     - service

#### MyBatis 연동 스프링 프로젝트 생성 예제

1. MVC 프로젝트 생성

   - 프로젝트명 : spring_mvc_mybatis
   - 패키지명 : com.spring_mvc.mybatis

2. pom.xml 기본 설정

   - Java : 11
   - Spring : 5.2.22.RELEASE
   - Maven : 1.8

3. 프로젝트 설정

   - Java Compiler
   - Java Build Path
   - Project Facets
   - web.xml 한글 인코딩 코드 추가

4. pom.xml에 데이터베이스 의존성 설정

   - pom.xml의 dependency 추가
     - Spring JDBC : spring-jdbc
     - Connection Pool : commons-dbcp
     - MySQL : mysql-connector
     - MyBatis / MyBatis-Spring : mybatis / mybatis-spring

5. 데이터베이스 연결 정보 설정

   - src/main/resource 폴더에 database 폴더 생성하고 그 안에 jdbc.properties 파일 생성
     - 데이터 베이스 연결하기 위한 정보 설정
       - jdbc.driverClassName
       - url / username / password
   - 스프링 설정 파일 생성
     - src/main/resources 폴더에 spring 폴더 생성하고 그 안에 application-config.xml 생성
       - [Namespace]에서 beans / context / mybatis-spring 체크
       - DataSource / Mapper 지정
   - web.xml에서 변경된 내용 설정

6. 클래스 구성 : CRUD 기능 구현

   1. 패키지 생성

      - controller

      - dao

      - model

      - service

   2. 클래스 및 인터페이스 생성

      - ProductVO 클래스
      - IProductService 인터페이스 / ProductService 클래스
      - IProductDAO 인터페이스
        - MyBatis에서는 DAO 인터페이스 필수
      - ProductMapper.xml 생성
        - application-config.xml에 dao 패키지 추가
      - ProductController 클래스 생성
        - 인덱스 페이지 열기 요청 처리
      - view 폴더에 index.jsp 생성

   3. CRUD 기능 구현

      - ProductController에서 요청 받아서
      - ProductService 클래스의 메소드 호출
      - IProductDAO의 메소드 호출
        - ProductMapper에서 SQL 처리하고 결과 반환
      - ProductService에서 받아서 ProductController에게 반환
      - ProductController에서 View 페이지로 전달
      - 화면에 결과 출력

      1. 전체 상품 조회 (SELECT)
      2. 상품 등록 (INSERT)
      3. 상품 상세 정보 조회 (SELECT)
      4. 상품 정보 수정 (UPDATE)
      5. 상품 정보 삭제 (DELETE)

#### **이미지 출력**

- 이미지 저장
  - 프로젝트 내부에 저장하는 경우
    - webapp / resources 폴더 안에 저장
    - 프로젝트에서 사용하는 이미지
    - servlet-conext.xml의 `<resources>`에서 mapping 이름 변경 가능

- 프로젝트 외부에 저장하는 경우
  - 상품 이미지 (대량의 이미지)
  - 외부 폴더에 저장하고 외부 폴더에 접근할 수 있도록 설정 필요
  - servlet-conext.xml의 `<resources>`에 location 지정

#### 날짜 타입 처리

- ProductVO에서 Date 타입으로 설정할 경우
  - `<input>`에서 입력한 값이 문자열로 전송되기 때문에 Command 객체로 받을 때 입력한 모든 값이 VO 저장되는 순간 타입 오류 발생
  - 날짜 타입 오류 문제 방법
    - (1) String 타입으로 선언
    - (2) @DateTimeFormat() 어노테이션 사용
      - @DateTimeFormat(pattern="yyyy-MM-dd")
      - private Date prdDate;

#### 뷰 페이지 날짜 포맷

- JSTL 사용
  - <fmt:formatDate pattern="..." value="${prd.prdDate}" />
  - 수정 화면의 입력란
    - <input ... value="<fmt:formatDate pattern='...' value='${prd.prdDate}' /> ">

#### CDATA

- 파싱되지 않는 문자 데이터

- 쿼리를 작성할 때, <, >, <=, >=, &, || 등을 사용해야 하는 xml 태그로 인식해서 오류 발생할 수 있음

- xml 파싱 대상이 아닌 단순 문자열로 처리하라는 의미

- ```xml
  <select id="listAllProduct" resultMap="prdResult">
    <![CDATA[
   	SELECT * FROM product WHERE prdPrice >= 1000000 ORDER BY prdNo
    ]]>
  </select>
