-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.NAME FROM ANIMAL_INS AS i LEFT JOIN ANIMAL_OUTS AS hwwwon ON i.ANIMAL_ID = hwwwon.ANIMAL_ID WHERE hwwwon.ANIMAL_ID IS NOT NULL ORDER BY DATEDIFF(hwwwon.DATETIME, i.DATETIME) DESC LIMIT  2;