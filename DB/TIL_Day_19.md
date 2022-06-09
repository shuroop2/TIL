# TIL_Day_19

> 2022년 06월 08일

## 데이터베이스 표준 질의어 SQL

### 데이터 제어어 (DCL)

> 데이터의 사용 권한을 관리하는 데 사용

- 데이터베이스 트랜잭션 명시 (완료/취소)
- 권한 부여 및 취소
- GRANT : 데이터베이스 객체에 권한 부여

- REVOKE : 이미 부여된 데이터베이스 객체 권한 취소

##### 권한 (Privilege)

> 특정 유형의 SQL 문을 실행하거나 다른 사용자의 객체를 사용할 수 있는 권리

- 권한의 종류

  - 시스템 권한
  - 객체 권한

- 사용자 계정 생성

  - 계정 생성

    ```mysql
    CREATE USER 계정@호스트 identified by 비밀번호;

  - 비밀번호 변경

    ```mysql
    SET PASSWORD for '계정명'@호스트 = '새 비밀번호';

  - 계정 삭제

    ```mysql
    DROP USER '계정명'@호스트;

- 권한 조회

  ```mysql
  SHOW GRANTS FOR 계정명;

- 권한 부여 

  ```mysql
  -- 권한 부여
  GRANT 권한 데이터베이스.테이블 TO '계정명'@호스트;
   -- 모든 권한 부여
  GRANT all privileges ON *.* TO '계정명'@호스트;
  -- 특정 DB의 모든 테이블에 특정 권한 부여
  GRANT select, insert, update, delete ON 특정DB.* TO '계정명'@호스트;

- 권한 제거

  ```mysql
  -- 권한 삭제
  REVOKE 권한 ON 데이터베이스.테이블 FROM '계정명'@호스트;
  -- 모든 권한 삭제
  REVOKE all privileges ON 데이터베이스.테이블 FROM '계정명'@호스트;
  -- 특정 DB의 모든 테이블에 특정 권한 부여
  REVOKE select, insert, update, delete ON 특정DB.* FROM '계정명'@호스트;
  -- 특정 DB의 모든 테이블에 모든 권한 부여
  REVOKE all privileges ON 특정DB.* FROM '계정명'@호스트;

- 객체 권한

  - 특정 객체를 조작할 수 있는 권한
  - DML 사용 권한
    - SELECT / INSERT / UPDATE / DELETE

#### 백업 및 복구 (EXPORT / IMPORT)

- DB를 주기적으로 백업해두거나 다른 서버로 이관할 때 사용
- 백업 (EXPORT)
  - 전체 단위 백업
  - 사용자 단위 백업
  - 테이블 단위 백업
- 복구 (IMPORT)

## JDBC

### JDBC (Java Database Connectivity)

> 다양한 종류의 관계형 데이터베이스에 접근할 때 사용하는 자바 표쥰 SQL 인터페이스

- 자바 프로그램이 DBMS에 접근하여 작업할 수 있게 해주는 API를 제공하는 클래스 모음
- 모든 DBMS에서 공통적으로 사용할 수 있는 인터페이스와 클래스로 구성
- 실제 구현 클래스는 각 DBMS 벤더가 구현했기 때문에 거의 모든 벤더가 JDBC 드라이버 제공
- 각 DBMS에 맞는 JDBC 드라이버 사용

#### JDBC 드라이버

> JDBC 인터페이스를 구현한 클래스 파일 모음 (jar 파일)

- 각 DBMS 벤더에서 제공되는 구현 클래스

#### JDBC의 역할

- 응용프로그램과 DBMS 사이에서 연결 역할
- SQL문을 DBMS에 전달하고 그 결과값을 응용프로그램에 전달하는 역할

#### JDBC를 사용했을 때의 효용성

- 사용하는 RDBMS에 독립적인 프로그래밍이 가능
- 쉽게 RDBMS의 교체가 가능
- 자바는 단순히 문자열로 QUERY를 전달할 뿐이고 해석은 각 벤더가 구현한 DRIVER에서 담당하기 때문에 표준 SQL 뿐 아니라 각 JDBC Driver를 제공하는 DBMS 벤더별로 최적의 성능을 발휘할 수 있는 벤더 종속적인 SQL에 대한 처리도 가능

#### JDBC를 이용한 연결 과정

1. 드라이버 로드

   - Java에서 MySQL Driver를 사용하기 위해 드라이버를 JVM에 로딩하는 과정

   - 동적으로 MySQL JDBC Driver 클래스의 객체를 생성하서 런타임 시 메모리에 로딩

     ```java
     Class.forName("com.mysql.cj.jdbc.Driver");
     ```

2. Connection 객체 생성

   - DriverManager 클래스의 static 메소드인 getConnection() 메소드를 이용해서 Connection 객체를 얻어 옴

   - MySQL 서버 실제 연결

   - Connection 객체가 생성되면 DBMS 접속 성공

     ```java
     String url = "jdbc:mysql://localhost:3306/sqldb3?serverTimezone-UTC";
     String user = "root";
     String pwd = "1234";
     DriverManager.getConnection(url, user, pwd);
     ```

     - jdbc:mysql : JDBC 드라이버
       - jdbc : JDBC URL의 프로토콜 이름
       - mysql : MySQL JDBC 드라이버
     - localhost : MySQL이 설치된 IP (호스트 이름)
     - 3306 : MySQL 접속 포트
     - sqldb3 : 사용하는 데이터베이스(스키마) 이름

3. Statement 객체 생성

   - 쿼리문 전송을 위한 Statement 객체 생성

   - 또는 PreparedStatement 객체 생성

   - Statement 인터페이스

     - Connection 인터페이스의 createStatement() 메소드를 사용하여 객체 생성

     ```java
     Statement stmt = con.createStatement();
     PreparedStatement pstmt = con.prepareStatement(sql);
     ```

   - Statement 객체를 통해 SQL 전송 가능

   - SQL 쿼리 전송에 사용되는 메소드

     - executeQuery() / executeUpdate()

4. 쿼리 수행

   - SQL 쿼리 전송에 사용되는 메소드

     ```java
     pstmt.executeUpdate();
     pstmt.executeQuery();
     ```

     1. executeQuery()

        ```java
        String sql = "select ...";
        ResultSet rs = pstmt.executeQuery(sql);
        ```

        - select 구문의 경우 사용
        - ResultSet 객체로 반환 (select 문 결과에 해당되는 여러행 반환)

     2. executeUpdate()

        - 쿼리문이 insert, update, delete 구문인 경우 사용

        - 영향을 받은 행의 수 반환

          ```java
          String sql = "insert ...";
          int result = pstmt.executeUpdate(sql);
          ```

          - result가 0보다 크면 insert 성공
          - result가 0이면 insert 실패

     - 2가지로 구분하는 이유
       - SQL 문 실행 결과가 다르기 때문

5. SQL 문에 결과 반환이 있는 경우 ResultSet 객체 생성 (결과 획득)

   - select 구문의 경우

     - executeQuery() 메소드 결과로 ResultSet 반환

     - ResultSet에서 데이터 추출

       - ResultSet의 next() 메소드를 사용해서 논리적 커서를 이동해가며 각 열의 데이터를 바인딩해 옴

         ```java
         ResultSet rs = pstmt.executeQuery(sql);
         boolean b = rs.next(); 
         // 여러 행인 경우 반복 사용
         boolean b = while(rs.next) { … };
         ```

   - ResultSet 메소드

     - next()

       - 커서를 이동하면서 다음 행 지정
       - 시작 시 첫 번째 행 이전에 위치해 있다가 next()메소드가 호출되면 이동하면서 첫 데이터를 가리킴
       - 리턴 타입은 boolean
         - 다음 행이 있으면 true, 없으면 false 반환
         - 모든 행을 가져오려면 반복문 사용

     - getXXX()

       - 실제 값을 가져오는 메소드

       - 데이터 타입에 맞춰 사용

       - getString() / getInt() / getDate()

       - 예시

         ```java
         String bookNo = rs.getString(1);
         int bookPrice = rs.getInt(2);
         Date bookDate = rs.getDate(3);

6. 모든 객체(자원) close()

   - ResultSet
   - Statement(PreparedStatement)
   - Connection (접속 종료)
   - rs.close() / pstmt.close() / con.close() 순서대로

<img src="https://lh5.googleusercontent.com/urn6EnEAkXZzbXm1eaIb_qtlZLrx0PIXWIp63_GFR2JSsGiJvdoZH5N3hUGX5dMXqMDm7uJWYH7Xlk02u5zGP8Q4PO1bRk6NZvzI7FnzqeJHvhHx0CTBPf4bbjoxuSrXvP_9JEA" alt="img" style="zoom:50%;" />

- 패키지 import

  - JDBC는 java.sql 패키지에 포함되어 있음

    <img src="https://lh4.googleusercontent.com/smphu4kqakyKix4LvkfwZ4MWi1LOR0Nd-EELxo1KGojQTte2MsOJVdoo3b6iCwZN5_nuaFPzBHFXtc8_AzzGkbz2dp5hAznQujPOBQ6KRhpQMIXHrfWeSg6m3VwMg3cteQ052IE" alt="img" align='left' style="zoom:50%;" />

  - JDBC는 데이터베이스에 접속하기 위해 한 개의 클래스 (java.sql.DriverManager)와 두 개의 인터페이스 (java.sql.Driver, java.sql.Connection)를 사용

- DTO / DAO

  - DTO (Data Transfer Object)
    - 데이터 저장용 클래스
    - 데이터베이스에 데이터 저장하거나 데이터베이스로부터 데이터를 조회할 때 데이터를 **저장하기** 위해 사용
    - 멤버 필드 / 생성자 / Getter&Setter
  - DAO (Data Access Object)
    - 데이터베이스에 액세스하는 클래스
    - 데이터베이스에 데이터를 저장하거나 데이터베이스로부터 데이터를 가져올 때 사용
    - DB 연결 (DBConnect라고 DB 연결 담당 클래스 사용해도 됨)
    - select() / insert() / update() / delete() 기능의 메소드 포함