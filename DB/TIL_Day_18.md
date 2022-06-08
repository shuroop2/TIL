# TIL_Day_18

> 2022년 06월 08일

## 데이터베이스 표준 질의어 SQL

### 데이터 조작어 (DML)

#### INSERT 문

> 테이블에 새로운 행을 삽입하는 명령어

```mysql
INSERT INTO 테이블명 (열이름 리스트) VALUES (값리스트); -- 특정 열에 값 저장
INSERT INTO 테이블명 VALUES (값리스트); -- 모든 열에 값 저장
-- ex)
INSERT INTO student (stdNo, stdName, stdYear, dptNo) VALUES ('2002001', '홍길동', 4, '1');
```

- 데이터 임포트
  - CSV 파일을 읽어서 테이블 생성 및 데이터 입력
  - 파일 임포트 시 제약조건 없어짐

#### UPDATE 문

> 특정 열의 값을 수정하는 명령어

```mysql
UPDATE 테이블명 SET 열=값 WHERE 조건;

-- ex) 상품번호가 5인 행의 상품명을 'UHD TV'로 수정
UPDATE product SET prdName='UHD TV' WHERE prdNo='5';
```

- 조건에 맞는 행을 찾아서 열의 값 수정

#### DELETE 문

> 테이블에 있는 기존 행을 삭제하는 명령어

```mysql
DELETE FROM 테이블명 WHERE 조건; -- 조건에 맞는 행 삭제
DELETE FROM 테이블명; -- 모든 행 삭제

-- ex) 상품명이 '그늘막 텐트'인 행 삭제
DELETE FROM product WHERE prdName='그늘막 텐트';
```

#### SELECT 문

> 테이블에서 조건에 맞는 행 검색

```MYSQL
SELECT [ALL|DISTINCT] 열이름 리스트 FROM 테이블명 
[WHERE 검색조건(들)]
[GROUP BY 열이름]
[HAVING 검색조건(들)]
[ORDER BY 열이름 [ASC|DESC]]
```

| 기능            | 설명                                                         |
| --------------- | ------------------------------------------------------------ |
| SELECT 열이름   | 검색할 열 기술                                               |
| FROM 테이블명   | 데이터를 검색할 테이블명 기술                                |
| WHERE 조건      | 질의 결과에 포함될 행들이 만족해야 할 조건 기술              |
| ORDER BY 열이름 | 특정 열의 값을 기준으로 질의 결과 정렬<br>ASC : 오름차순, DESC : 내림차순 |
| GROUP BY 열이름 | 그룹 질의를 기술할 때 사용<br>특정 열로 그룹화한 후 각 그룹에 대해 한 행씩 질의 결과 생성 |
| HAVING 조건     | GROUP BY 절에 의해 구성된 그룹들에 대해 적용할 조건 기술     |

```mysql
-- 도서(book) 테이블에서 모든 행 검색하여 반환
-- 모든(*) 열 포함
SELECT * FROM book;

-- 도서(book) 테이블에서 모든 행을 검색하여 도서명과 가격만 반환
SELECT bookName, bookPrice FROM book;

-- 도서(book) 테이블에서 가격이 30000이상인 행을 검색하여 도서명과 가격만 반환
SELECT bookName, bookPrice FROM book WHERE bookPrice >= 30000;
```

- 중복 제거

  - `*`모든 열 출력
  - DISTINCT
    - 속성값이 중복되는 것이 있으면 한 번만 출력

- WHERE

  | 종류                     | 연산자               | 설명 / 예                                                    |
  | ------------------------ | -------------------- | ------------------------------------------------------------ |
  | 비교                     | =, <, >, <=, >=, !=  | 값의 크기를 비교하여 질의 검색<br>price >= 10000             |
  | 범위                     | BETWEEN              | 검사 값이 기술된 두 값 사이에 속하는지 검사하여 질의 처리<br>price BETWEEN 10000 AND 20000 |
  | 리스트에 포함            | IN, NOT IN           | 검사 값이 주어진 값의 리스트에 속하는지 여부를 검사<br>price IN (10000, 20000, 30000) |
  | NULL                     | IS NULL, IS NOT NULL | price IS NULL                                                |
  | 논리                     | AND, OR              | 단순 탐색 조건을 결합하여 질의 처리<br>(price <= 10000) AND (name LIKE '김%') |
  | 패턴 매칭<br>문자열 검색 | LIKE                 | 문자열의 일부가 일치하는 데이터 검색<br>prdNAME LIKE '%프린터%' |

- 패턴 매칭 (LIKE)

  | 와일드카드 문자 |               설명               |     예     |
  | :-------------: | :------------------------------: | :--------: |
  |        %        |  0개 이상의 문자를 가진 문자열   | LIKE '홍%' |
  |        _        | 단일 문자(수 만큼의 문자로 구성) | LIKE '__'  |

  | 문자열 연산 예 | 설명                                                       |
  | -------------- | ---------------------------------------------------------- |
  | '홍%'          | '홍'으로 시작하는 문자열 검색                              |
  | '%길%'         | '길을 포함하는 문자열 ('길' 앞, 뒤에 아무 문자나 와도 됨') |
  | '%동'          | '동'으로 끝나는 문자열                                     |
  | '____'         | 4개의 문자로 구성된 문자열(밑줄문자 1개가 문자 1개를 의미) |

- ORDER BY

  > 특정 열의 값을 기준으로 질의 결과 정렬

  - ASC : 오름차순 (생략 가능)

  - DESC : 내림차순

  - LIMIT

    > 출력의 개수를 제한

    ```mysql
    SELECT * FROM 테이블명 ORDER BY 열이름 [LIMIT N ][OFFSET A]
    -- A-1부터 상위 N개 출력
    ```

    - 상위 N개만 출력

- 집계 함수

  - SUM() : 합계
  - AVG() : 평균
  - COUNT() : 선택된 열의 행 수 (NULL 값은 제외)
  - COUNT(*) : 전체 행의 수
  - MAX() : 최대
  - MIN() : 최소

- GROUP BY

  > 그룹 질의를 기술할 때 사용

  - 특정 열로 그룹화한 후 각 그룹에 대해서 한 행씩 질의 결과 생성
  - 주의 : SELECT 절에는 GROUP BY에서 사용한 열과 집계 함수만 나올 수 있음

- HAVING 

  > GROUP BY 절에 의해 구성된 그룹들에 대해 적용할 조건 기술

  - SUM, AVG, MAX, MIN, COUNT 등의 집계 함수와 함께 사용
  - 주의 : 반드시 GROUP BY 절과 같이 사용하며 위치는 WHERE 절 보다 뒤에 있어야 함
  - <검색 조건>에는 집계 함수만 사용 가능

### DDL / DML 정리

#### DDL (Data Definition Language, 데이터 정의어)

- CREATE / ALTER / DROP
- 데이터베이스, 테이블, 뷰, 인덱스 등의 데이터베이스 개체를 생성 / 삭제 / 변경 하는 역할
- 직접 데이터베이스의 테이블에 영향을 미치기 때문에 DDL 명령어를 입력하는 순간 처리 작업이 즉시 완료
- AUTO COMMIT
- 따라서 작업 취소(ROLLBACK)이나 완료(COMMIT)을 수행할 필요 없음

#### DML (Data Manipulation Language, 데이터 조작어)

- INSERT / UPDATE / DELETE / SELECT
- 데이터를 삽입 / 수정 / 삭제 / 조회 하는데 사용
- 대상은 테이블의 행
- 조작 작업이 메모리 버퍼에서 수행되어 실시간으로 테이블에 영향을 미치지 않음 (실수가 있었을 경우 작업 취소 가능) - 트랜잭션 발생
- DML 명령어가 실제 테이블에 반영되게 하기 위해서는 COMMIT 명령어를 입력하여 작업을 종료해야 함

#### 트랜잭션 (Transaction)

> DBMS에서 데이터를 다루는 논리적인 작업의 단위

- 데이터베이스 관리 시스템에서 회복 및 병행 수행 시 처리되는 작업의 논리적 단위로 사용
- 하나의 트랜잭션은 정상적으로 종료될 경우 COMMIT 연산이 수행되고, 비정상적으로 종료될 경우 ROLLBACK 연산 수행해서 작업을 취소

#### COMMIT 연산

> 트랜잭션 처리가 정상적으로 종료되어 트랜잭션이 수행하는 변경 내용을 데이터베이스에 반영하는 연산

- 내용을 변경한 트랜잭션이 완료되면 그 트랜잭션에 의해 데이터베이스는 새롭게 일관된 상태로 변경되고 이 상태는 시스템에 오류가 발생되더라도 취소되지 않음

#### ROLLBACK 연산

> 하나의 트랜잭션 처리가 비정상적으로 종료되어 데이터베이스에 일관성이 깨졌을 때 트랜잭션이 행한 모든 변경 작업을 취소하고 이전 상태로 되돌리는 연산

### 조인 (JOIN)

> 여러 개의 테이블을 결합하여 조건에 맞는 행 검색

#### 조인의 종류

- INNER JOIN (내부 조인)

  ```mysql
  SELECT 열리스트 FROM 테이블명1 INNER JOIN 테이블명2 ON 조인조건 (기본키=외래키);
  ```

  - 공통되는 열이 있을 때 **공통 속성의 속성값이 동일한 튜플**만 반환

  <img src="https://lh5.googleusercontent.com/_0aQ6k9At8eoYlDVQA2Kh3BZDnc8nAqFBnlpXmToqZ2BvVUWmRP46w1Bx93FMruQ25Kiznq_ryGpB8LvrbUuPrOHxnr9T3RNQcn3ue-KFUJyiWvymxWpzNbDi7PbwOUcKI-JSC0" alt="img" style="zoom:50%;" />

- OUTER JOIN (외부 조인)

  - 공통되는 열이 없을 때 공통된 속성을 매개로 하는 정보가 없더라도 버리지 않고 연산의 결과를 릴레이션에 표시
  - 값이 없는 대응 속성에는 NULL 값을 채워서 반환

  1. 좌측 외부 조인 (Left Outer JOIN)
     - 좌측 릴레이션의 정보 유지
     - 좌측 테이블에는 있지만 우측 테이블에 없는 값은 NULL로 출력
  2. 우측 외부 조인 (Right Outer JOIN)
     - 우측 릴레이션의 정보 유지
     - 우측 테이블에는 있지만 좌측 테이블에 없는 값은 NULL로 출력
  3. 완전 외부 조인 (Full Outer JOIN)
     - 두 릴레이션의 모든 정보 유지

  <img src="https://lh5.googleusercontent.com/yLVqj9Z00kP2ibN9VN8LrpG9coKHM1dS4r9pYC7BiWifza73fwifptk-m93kXkCTOBlQx7MFndyCdjf4eyo21NM-J4MNguIF9IrO0Xn5ukgDAQMn2jKoTYPBc8cmLiqG4tfH35A" alt="img" style="zoom:50%;" />

- 3개 테이블 결합

  - 조인 조건 2개

  <img src="https://lh3.googleusercontent.com/wddPtpSG6vO-1mGHnzfFDoBogBlAKsmv7jaI7vq2nfq0RaAWvWSJ1YU_uU8PjTAHT6tiP8Jr6bsSQrfvsw6oHVO0RGuD6ER3ysJtNwLMvyrY5UW6vN-Ztbgx1KwzlX7cXlskBe4" alt="img" style="zoom:50%;" />

#### 다양한 조인 문 표기 방식

1. WHERE 조건 사용

   - 양쪽 테이블에 공통되는 열 이름 앞에 테이블명 표기 (모호성을 없애기 위해)
   - 테이블이 없으면 오류 발생

   - 예시

     ```mysql
     SELECT client.clientNo, clientName, bsQty FROM client, bookSale
     WHERE client.clientNo = bookSale.clientNo;

2. 양쪽 테이블에 공통되지는 않지만 모든 열 이름에 테이블명 표기

   - 서버에게 찾고자 하는 열의 정확한 위치를 알려주므로 성능이 향상

   - 예시

     ```mysql
     SELECT client.clientNo, client.clientName, bookSale.bsQty FROM client, bookSale 
     WHERE client.clientNo = bookSale.clientNo;

3. 테이블명 대신 별칭(Alias) 사용

   - 테이블명 대신 별칭(Alias) 사용

   - 예시

     ```mysql
     SELECT C.clientNo, C.clientName, BS.bsQty FROM client C, bookSale BS
     WHERE C.clientNo = BS.clientNo;

4. JOIN ON 명시

   - 예시

     ```mysql
     SELECT C.clientNo, C.clientName, BS.bsQty FROM bookSale BS
     JOIN client C ON C.clientNo = BS.clientNo;

5. **INNER JOIN ON 명시**

   - 가장 많이 사용되는 방법

   - 예시

     ```mysql
     SELECT C.clientNo, C.clientName, BS.bsQty FROM bookSale BS
     INNER JOIN client C ON C.clientNo = BS.clientNo;

#### 서브 쿼리 (Subquery)

> 하나의 SQL 문 안에 다른 SQL 문이 중첩(nested)

- 하위 질의 또는 부속 질의라고 함

- 쿼리를 1차 수행한 다음, 반환값(결과)을 다음 쿼리에 포함시켜서 사용

- 메인 쿼리와 서브 쿼리로 구성

- 다른 테이블에서 가져온 데이터로 현재 테이블에 있는 정보를 찾거나 가공할 때 사용

  <img src="https://lh4.googleusercontent.com/iAxUzH8oSylYiHT1mAILdefLgtGUXJtTGSFGrc8ZoRljc0cE-dOJOpHIiUd8RsQdRJi2xiqSn8stBQCLbJ8-IerMhM1iH_zDs8I4FOMcfvS_k9yIGOKKO6ycR1KHAyJY_qKehGk" alt="img" style="zoom:50%;" />

- 단일 행 서브 쿼리

  - 서브 쿼리 결과 같이 단일 행

  - = 연산자 사용

- 다중 행 서브 쿼리

  - 서브 쿼리 결과 값이 여러 행
  - IN, ANY, ALL, EXISTS 연산자 사용
  - 단일 행 서브 쿼리처럼 결과가 1개이어도 IN을 쓰면 오류가 없기 때문에 서브 쿼리를 쓸 때 항상 IN을 쓰면 됨

- 중첩 서브 쿼리

  - 한 번의 서브 쿼리로 원하는 결과를 찾지 못할 때 중첩해서 사용 가능

- 서브 쿼리 연산자

  - WHERE 절에서 사용

  - 데이터를 선택하는 조건 또는 술어와 같이 사용

    | 연산 | 연산자                          | 반환 행 |
    | ---- | ------------------------------- | ------- |
    | 비교 | =, >, <, >=, <=, !=             | 단일    |
    | 집합 | IN, NOT IN                      | 다중    |
    | 존재 | EXISTS, NOT EXISTS              | 다중    |
    | 한정 | ALL (모두), ANY (최소 하나라도) | 다중    |

##### 조인 vs 서브 쿼리

- 조인
  - 여러 테이블의 데이터를 모두 합쳐서 연산
  - 카티전곱 (15 x 3 = 45행 반환) 후 조건에 맞는 튜플 검색
    - 데이터가 15행이 있는 테이블과 3행이 있는 테이블의 카티전곱 결과는 45행
  - 카티전곱 연산 + SELECT 연산
- 서브 쿼리
  - 필요한 데이터만 찾아서 제공
  - 15행을 검색한 결과를 가지고 3행에서 검색
    - 총 15 + 3 = 18행 검색
  - 경우에 따라 조인보다 성능이 더 좋을 수 있지만, 대량의 데이터에서 서브 쿼리를 수행할 때 성능이 더 나쁠 수 있음

##### 다중 행 서브 쿼리

- IN / NOT IN
  - 서브 쿼리에서 조건에 해당되는 행의 열을 비교하여 값 확인
  - 서브 쿼리의 결과 값을 메인 쿼리에 대입하여 조건 비교 후 결과 출력
  - IN 쿼리 -> 메인 쿼리
  - 서브 쿼리 결과에 NULL값은 제외하고 공백은 포함
- EXISTS / NOT EXISTS
  - 서브 쿼리에서 조건에 해당되는 행의 존재 여부만 확인(TRUE/FALSE 반환)
  - 따라서 IN에 비해 성능 좋음
  - EXISTS 키워드 앞에 속성명, 수식 등 올 수 없음
  - WHERE 절에 외래키 제약조건 지정
  - 서브 쿼리의 결과가 행을 반환하면 참이 되는 연산자
  - IN과 달리 서브 쿼리 결과에 NULL값 포함
- ALL / ANY, SOME 
  - 관계 연산자 뒤에 위치
  - ALL
    - 검색 조건이 서브 쿼리의 결과의 모든 값에 만족하면 참이 되는 연산자
    - 조건 > ALL (서브 쿼리 결과)
  - ANY, SOME
    - 검색 조건이 서브 쿼리의 결과 중에서 하나 이상 만족하면 참이 되는 연산자
    - 조건 > ANY (서브 쿼리 결과)

##### 서브 쿼리 유형

| 명칭             | 사용 위치     | 영문 및 동의어                        | 설명                                                |
| ---------------- | ------------- | ------------------------------------- | --------------------------------------------------- |
| 스칼라 서브 쿼리 | **SELECT 절** | Scalar Subquery<br>열이름 위치에 표기 | **단일 열** 반환                                    |
| 인라인 뷰        | **FROM 절**   | Inline View<br>테이블명 위치에 표기   | 결과를 뷰 형태로 반환(가상 테이블)                  |
| 중첩 서브 쿼리   | **WHERE 절**  | Nested Subquery                       | 술어와 같이 사용<br>**결과를 한정**시키기 위해 사용 |

- 스칼라 서브 쿼리 (Scalar Subquery)

  - SELECT 절에서 사용

  - 결과 값을 단일 열의 스칼라 값으로 반환

  - 스칼라 값이 들어갈 수 있는 모든 곳에서 사용 가능

  - 일반적으로 SELECT 문과 UPDATE 문에서 사용

    <img src="https://lh3.googleusercontent.com/b7aflEYhaSIKa60IT9qy3lyTfLA9i-sAo_BCBiD_spXffFhR99U10TeNbfbz2DOH13XnGN_ZpAyLNCiHlt6MSgQ3Zkn6KyRYF9qVpcs7ko2dSW5E5KHhQn7Gsqi_wjOApHTCagI" alt="img" style="zoom:50%;"/>

- 인라인 뷰 (Inline View)

  - FROM 절에서 사용

  - 테이블명 대신 인라인 뷰 서브 쿼리 결과 (가상 테이블) 사용

  - 쿼리 결과로 반환되는 데이터는 다중 행, 다중 열이어도 상관 없음

  - 가상의 뷰 형태로 제공

  - 개발 중에 뷰가 필요한 모든 경우에 뷰를 생성하면 관리할 양이 너무 많아 트랜잭션 관리나 성능에 문제 발생할 수 있는 경우에 인라인 뷰 사용

    <img src="https://lh6.googleusercontent.com/ieh8jHjLFsBfcAZvEu-TCrI7NwIyy7MxUsFyYbFcpajAVDlSgaZPH6NJHFJ8VM84EeDt_qai64L-wO71h8RS9bUbvitNgc6qXOFYgVPskbyxii2i8K5TJLmNO9mqlpBY91kmjik" alt="img" style="zoom:50%;" />

#### MySQL 내장 함수

- 수학 함수
  - ROUND()
    - 자릿수가 양수이면 소수점 오른쪽을 나타내고, 음수이면 소수점 왼쪽을 나타냄
  - RANK()
    - 값의 순위 반환 (동일 순위 개수만큼 증가)
  - DENSE_RANK()
    - 값의 순위 반환 (동일 순위 상관 없이 1 증가)
  - ROW_NUMBER()
    - 행의 순위 반환
- 문자 함수
  - REPLACE()
    - 문자열을 치환하는 함수
  - CHAR_LENGTH()
    - 글자의 수를 반환하는 함수
  - LENGTH()
    - 바이트 수 반환하는 함수
  - SUBSTR()
    - 지정한 길이만큼의 문자열을 반환하는 함수
- 날짜 함수
  - DATE()
    - 지정한 날의 날짜를 반환
  - NOW()
    - 현재의 날짜, 시간 모두 반환
  - TIME()
    - 지정한 시점의 시간을 반환
  - YEAR() / MONTH() / HOUR() / MINUTE() / SECOND()
  - DATEDIFF()
- LOAD_FILE()
  - TXT 파일
  - JPG 파일
  - MP4 파일

#### 테이블 복사

```mysql
CREATE TABLE 새 테이블명 AS SELECT 복사할 열 FROM 원본 테이블명 [WHERE 절]
```

- 주의 : 기본 키 제약조건은 복사 안되니 복사 후 기본키 제약조건 설정해야 함