# MySQL_Coding_Test2

> 2022년 10월 12일

## LEVEL 2

### SUM, MAX, MIN

1. 동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문을 작성해주세요.

   ```mysql
   SELECT COUNT(*) FROM ANIMAL_INS;

2. 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회하는 SQL 문을 작성해주세요. 이때 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나로 칩니다.

   ```mysql
   SELECT COUNT(DISTINCT NAME) FROM ANIMAL_INS WHERE NAME IS NOT NULL;

3. 동물 보호소에 가장 먼저 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.

   ```mysql
   SELECT DATETIME FROM ANIMAL_INS ORDER BY DATETIME LIMIT 1;
   ```

4. `FOOD_PRODUCT` 테이블에서 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 조회하는 SQL문을 작성해주세요.

   ```mysql
   SELECT * FROM FOOD_PRODUCT ORDER BY PRICE DESC LIMIT 1;
   ```

### GROUP BY

1. 동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요. 이때 고양이를 개보다 먼저 조회해주세요.

   ```mysql
   SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) AS COUNT FROM ANIMAL_INS GROUP BY ANIMAL_TYPE ORDER BY ANIMAL_TYPE;

2. 동물 보호소에 들어온 동물 이름 중 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수를 조회하는 SQL문을 작성해주세요. 이때 결과는 이름이 없는 동물은 집계에서 제외하며, 결과는 이름 순으로 조회해주세요.

   ```mysql
   SELECT NAME, COUNT(NAME) AS COUNT FROM ANIMAL_INS GROUP BY NAME HAVING COUNT(NAME) > 1 ORDER BY NAME;

3. 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 09:00부터 19:59까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 이때 결과는 시간대 순으로 정렬해야 합니다.

   ```mysql
   SELECT HOUR(DATETIME) AS 'HOUR', COUNT(HOUR(DATETIME)) AS COUNT from ANIMAL_OUTS WHERE HOUR(DATETIME) BETWEEN 9 AND 20 GROUP BY HOUR ORDER BY HOUR;
   ```

### String, Sate

1. 보호소에 돌아가신 할머니가 기르던 개를 찾는 사람이 찾아왔습니다. 이 사람이 말하길 할머니가 기르던 개는 이름에 'el'이 들어간다고 합니다. 동물 보호소에 들어온 동물 이름 중, 이름에 "EL"이 들어가는 개의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 이때 결과는 이름 순으로 조회해주세요. 단, 이름의 대소문자는 구분하지 않습니다.

   ```mysql
   SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE NAME LIKE '%EL%' AND ANIMAL_TYPE = 'Dog' ORDER BY NAME;
   ```

2. `ANIMAL_INS` 테이블에 등록된 모든 레코드에 대해, 각 동물의 아이디와 이름, 들어온 날짜[1](https://school.programmers.co.kr/learn/courses/30/lessons/59414#fn1)를 조회하는 SQL문을 작성해주세요. 이때 결과는 아이디 순으로 조회해야 합니다.

   ```mysql
   SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS '날짜' FROM ANIMAL_INS;
   ```

3. 동물 보호소에 들어온 동물 중 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의 아이디와 이름, 성별 및 중성화 여부를 조회하는 SQL 문을 작성해주세요.

   ```mysql
   SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE FROM ANIMAL_INS WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty');
   ```

4. 보호소의 동물이 중성화되었는지 아닌지 파악하려 합니다. 중성화된 동물은 `SEX_UPON_INTAKE` 컬럼에 'Neutered' 또는 'Spayed'라는 단어가 들어있습니다. 동물의 아이디와 이름, 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요. 이때 중성화가 되어있다면 'O', 아니라면 'X'라고 표시해주세요.

   ```mysql
   SELECT ANIMAL_ID, NAME,
   CASE
       WHEN SEX_UPON_INTAKE like '%Neutered%' THEN 'O'
       WHEN SEX_UPON_INTAKE like '%Spayed%' THEN 'O'
       ELSE 'X'
   END as '중성화'
   FROM ANIMAL_INS;

### IS NULL

1. 입양 게시판에 동물 정보를 게시하려 합니다. 동물의 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요. 이때 프로그래밍을 모르는 사람들은 NULL이라는 기호를 모르기 때문에, 이름이 없는 동물의 이름은 "No name"으로 표시해 주세요.

   ```mysql
   SELECT ANIMAL_TYPE, IFNULL(NAME, "No name") AS NAME, SEX_UPON_INTAKE FROM ANIMAL_INS ORDER BY ANIMAL_ID;
   ```

### SELECT

1. `MEMBER_PROFILE` 테이블에서 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문을 작성해주세요. 이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고, 결과는 회원ID를 기준으로 오름차순 정렬해주세요.

   ```mysql
   SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_OF_BIRTH FROM MEMBER_PROFILE WHERE TLNO IS NOT NULL AND MONTH(DATE_OF_BIRTH) = 3 AND GENDER = 'W';