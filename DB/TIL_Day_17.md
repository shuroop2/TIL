# TIL_Day_17

> 2022년 06월 03일

## 데이터베이스 표준 질의어 SQL

### SQL 개요

#### 데이터베이스 질의어

> 데이터베이스를 구축하기 위한 도구

- 현대 정보시스템에서 매우 중요한 역할 담당
- 질의어 (Query Language)는 검색 언어라는 의미지만 데이터를 검색하는 역할 외에 데이터의 입력, 수정, 삭제, 제어, 병행 제어, 복구 등 다양한 기능을 제공하는 종합적인 언어

#### SQL (Structured Query Language)

> 관계형 데이터베이스 관리 시스템(DBMS)의 데이터를 관리하기 위해 설계된 특수 목적의 프로그래밍 언어

- '에스큐엘' 또는 '시퀄'로 읽음
- 1970년대 말 미국 IBM사의 한 연구소에서 데이터베이스 유형에 관계없이 사용자들이 편리하게 사용하게 사용할 수 있는 질의어를 만들기 위해 개발
- 초기에는 SEQUEL(Structured English Query Language, 구조 영어 질의어)이라는 이름으로 시작
- 많은 수의 데이터베이스 관련 프로그램들이 SQL을 표준으로 채택하면서 자신의 제품에 특화 시킨 SQL 사용

<img src="https://lh4.googleusercontent.com/rSvoap-5eTElL0hg6VYscLh6lDAuJ55pquXyXCwgBWjxcrHeMZHPHwEtW3H4OUk_u0zFECGw9AZ7wOFqj0S8lynvXBlql2s2yMLKADgIA3L19LSUzHqZuuQJ6GD0_8dupWTwk-E" alt="img" style="zoom:50%;" />

#### SQL 문의 기능별 분류

- 데이터 정의어 (DDL)

  - 데이터베이스 / 테이블이나 관계의 구조를 생성하는데 사용

  - CREATE / ALTER / DROP 문

    | SQL 문 | 설명                                         |
    | :----: | -------------------------------------------- |
    | CREATE | 데이터베이스 및 **객체 생성**                |
    | ALTER  | 기존에 존재하는 데이터베이스의 **객체 변경** |
    |  DROP  | 데이터베이스 및 **객체 삭제**                |

- 데이터 조작어 (DML)

  - 테이블의 데이터를 검색, 삽입, 수정, 삭제하는데 사용

  - SELECT / INSERT / DELETE / UPDATE 문

    | SQL 문 | 설명                                                   |
    | :----: | ------------------------------------------------------ |
    | INSERT | 데이터베이스 객체에 **데이터 입력**                    |
    | DELETE | 데이터베이스 객체에서 **데이터 삭제**                  |
    | UPDATE | 기존에 존재하는 데이터베이스 객체 내의 **데이터 수정** |
    | SELECT | 데이터베이스 객체로부터 **데이터 검색**                |

- 데이터 제어어 (DCL)

  - 데이터의 사용 권한을 관리하는 데 사용

  - GRANT / REVOKE / COMMIT / ROLLBACK 문

    | SQL 문 | 설명                                          |
    | :----: | --------------------------------------------- |
    | GRANT  | 데이터베이스 객체에 **권한 부여**             |
    | REVOKE | 이미 부여된 데이터베이스 객체의 **권한 취소** |

### 데이터 정의어 (DDL)

#### CREATE 문

> 테이블, 도메인, 뷰, 인덱스, 스키마 구조 정의하는 명령어

- **CREATE TABLE**
- **CREATE SCHEMA**
- CREATE DOMAIN
- CREATE INDEX
- CREATE VIEW

##### CREATE TABLE

```mysql
create table 테이블명(
	열이름 데이터타입 [제약조건, ...]
	[PRIMARY KEY 열이름]
	[FOREIGN KEY 열이름 REFERENCES 테이블(기본키)]
	[CONSTRAINT명] ...
);
```

- 테이블 구성

- 속성과 속성에 관한 제약 정의

- 기본키 : PRIMARY KEY

- 외래키 : FOREIGN KEY

  | 표기형식                 | 설명                                     |
  | ------------------------ | ---------------------------------------- |
  | NOT NULL                 | 빈 값 허용하지 않음                      |
  | DEFAULT                  | 기본값으로 설정                          |
  | PRIMARY KEY              | 기본키 설정                              |
  | FOREIGN KEY              | 외래키 설정                              |
  | REFERENCES               | 외래키가 참조할 테이블(부모 테이블) 설정 |
  | UNIQUE                   | 중복값이 없도록 설정 (대체키 설정 의미)  |
  | CHECK                    | 특정 내용의 제약 조건 설정               |
  | ON DELETE/ON UPDATE 옵션 | 참조되는 테이블의 행 삭제/갱신 시 옵션   |

- PRIMARY KEY 제약조건

  - 기본키 제약조건

  - 열에 지정

  - 중복 안 됨

  - 빈 값 안 됨

    ```mysql
    CREATE TABLE product(
    	prdNo VARCHAR(10) NOT NULL,
    	prdName VARCHAR(30) NOT NULL,
    	prdPrice INT,
    	prdCompany VARCHAR(30),
    	CONSTRAINT PK_product_prdNo PRIMARY KEY (prdNO)
    );
    ```

- 외래키 제약 조건 설정

  - 출판사 (출판사번호, 출판사명, 전화, ...)
  - 도서 (도서번호, 도서명, 가격, 발행일, 출판사번호(FK))

- 테이블 생성 순서 주의

  - 참조되는 테이블(부모 테이블) 먼저 만들어야 함

- 테이블 생성 후 데이터 입력 시 주의

  - 외래키 값을 입력할 때는 참조되는 테이블의 기본키로서의 값과 동일해야 함 (참조 무결성 제약조건 때문)

- 테이블 삭제 시 주의

  - 외래키로 사용 중인 경우에는 참조되는 테이블(부모 테이블)의 기본키를 삭제할 수 없음 (참조 무결설 제약조건 때문)

- 자동 증가
  - AUTO_INCREMENT
    - 속성 값을 자동으로 증가
  - AUTO_INCREMENT = 100
    - 기본값 100부터 증가
  - SET @@AUTO_INCREMENT_INCREMENT = 3
    - 3씩 증가
  - 자동 증가 수정
    - SET @COUNT = 0;
    - UPDATE board SET boardNo = @COUNT :=@COUNT+1;

#### ALTER 문 (테이블 수정)

> 테이블에 대한 정의 변경하는 명령어

- 새로운 열 추가, 특정 열의 디폴트 값 변경, 특정 열 삭제 등 수행

- ALTER TABLE

  - ADD : 열 추가
  - RENAME COLUMN : 열의 이름 변경
  - MODIFY : 열의 데이터 형식 변경
  - CHANGE : 열의 이름과 데이터 형식 변경
  - DROP : 여러 개의 열 삭제
  - DROP COLUMN : 열 삭제
  - DROP PRIMARY KEY : 기본키 삭제
  - DROP CONSTRAINT : 제약조건 삭제

  ```mysql
  ALTER TABLE ADD 열이름 타입(크기);
  ```

- 제약조건 삭제

  - 기본키 / 외래키 제약조건 추가 / 삭제

    ```mysql
    ALTER TABLE 테이블명 DROP PRIMARY KEY;
    ```

  - ON DELETE CASCADE 

    - 기준 테이블(기본키를 갖고 있는 테이블)의 데이터가 삭제되었을 때 이 값을 사용하고 있는 테이블의 외래키 데이터도 자동으로 삭제되도록 설정

  - CHECK 제약조건 추가 / 삭제 

    - 삭제 시 제약조건 이름 필요

    - 제약조건 확인

      ```mysql
      SELECT * FROM information_schema.table_constraints WHERE table_schema="스키마명" and table_name = "테이블명";
      ```
  
  - DEFAULT 제약조건 추가 / 삭제 / 수정

    - default 삭제 후 null 설정 안 하면 입력 시 default값 입력하라는 오류 발생

    - default 수정

      ```MYSQL
    ALTER TABLE 테이블명 SET

#### Drop 문 (테이블 삭제)

> 테이블 구조와 데이터 모두 삭제하는 명령어

- 데이터만 삭제 시 delete문 사용 - DML

- 테이블 삭제 시 주의

  - 외래키 제약조건이 설정되어 있는 기준 테이블 삭제 시 오류 발생
  - 외래키 제약조건이 설정되어 있는 테이블 먼저 삭제 후
  - 외래키 제약 조건 삭제 후
  - 기준 테이블 삭제 가능

-  테이블 삭제 시 외래키 제약조건 확인할 필요 없도록 설정 : 바로 삭제되도록

  ```mysql
  SET foreign_key_checks = 0;
  ```

  - 외래키 제약조건 검사 해제하고 테이블 바로 삭제        

  ```mysql
  SET foreign_key_checks = 1;
  ```

  - -외래키 제약조건 검사하도록 재설정
