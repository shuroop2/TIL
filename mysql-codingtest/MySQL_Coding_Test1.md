# MySQL_Coding_Test1

> 2022년 10월 12일

## LEVEL 1

### SELECT

1. 동물 보호소에 들어온 모든 동물의 정보를 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요.

   ```mysql
   SELECT * FROM ANIMAL_INS;

2. 동물 보호소에 들어온 모든 동물의 아이디와 이름을 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요.

   ```mysql
   SELECT ANIMAL_ID, NAME FROM ANIMAL_INS;
   ```

3. 동물 보호소에 가장 먼저 들어온 동물의 이름을 조회하는 SQL 문을 작성해주세요.

   ```mysql
   SELECT NAME FROM ANIMAL_INS ORDER BY DATETIME LIMIT 1;
   ```

4. 동물 보호소에 가장 먼저 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.

   ```mysql
   SELECT DATETIME FROM ANIMAL_INS ORDER BY DATETIME LIMIT 1;
   ```

5. 동물 보호소에 들어온 동물 중 아픈 동물의 아이디와 이름을 조회하는 SQL 문을 작성해주세요. 이때 결과는 아이디 순으로 조회해주세요.

   ```mysql
   SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION = 'Sick';
   ```

6. 동물 보호소에 들어온 모든 동물의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 ANIMAL_ID 역순으로 보여주세요.

   ```mysql
   SELECT NAME, DATETIME FROM ANIMAL_INS ORDER BY ANIMAL_ID DESC;
   ```

7. 동물 보호소에 들어온 동물 중 젊은 동물의 아이디와 이름을 조회하는 SQL 문을 작성해주세요. 이때 결과는 아이디 순으로 조회해주세요.

   ```mysql
   SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION NOT IN ('Aged');
   ```

8. 동물 보호소에 들어온 모든 동물의 아이디와 이름, 보호 시작일을 이름 순으로 조회하는 SQL문을 작성해주세요. 단, 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물을 먼저 보여줘야 합니다.

   ```mysql
   SELECT ANIMAL_ID, NAME, DATETIME FROM ANIMAL_INS ORDER BY NAME, DATETIME desc;

9. `FOOD_FACTORY` 테이블에서 강원도에 위치한 식품공장의 공장 ID, 공장 이름, 주소를 조회하는 SQL문을 작성해주세요. 이때 결과는 공장 ID를 기준으로 오름차순 정렬해주세요.

   ```mysql
   SELECT FACTORY_ID, FACTORY_NAME, ADDRESS FROM FOOD_FACTORY WHERE ADDRESS LIKE '%강원도%';

### IS NULL

1. 동물 보호소에 들어온 동물 중, 이름이 있는 동물의 ID를 조회하는 SQL 문을 작성해주세요. 단, ID는 오름차순 정렬되어야 합니다.

   ```mysql
   SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NOT NULL;
   ```

2. 동물 보호소에 들어온 동물 중, 이름이 없는 채로 들어온 동물의 ID를 조회하는 SQL 문을 작성해주세요. 단, ID는 오름차순 정렬되어야 합니다.

   ```mysql
   SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NULL;
   ```

3. `FOOD_WAREHOUSE` 테이블에서 경기도에 위치한 창고의 ID, 이름, 주소, 냉동시설 여부를 조회하는 SQL문을 작성해주세요. 이때 냉동시설 여부가 NULL인 경우, 'N'으로 출력시켜 주시고 결과는 창고 ID를 기준으로 오름차순 정렬해주세요.

   ```mysql
   SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IFNULL(FREEZER_YN, 'N') AS FREEZER_YN FROM FOOD_WAREHOUSE WHERE ADDRESS LIKE '%경기도%';
   ```

### SUM, MAX, MIN

1. 가장 최근에 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.

   ```mysql
   SELECT DATETIME FROM ANIMAL_INS ORDER BY DATETIME DESC LIMIT 1;
   ```