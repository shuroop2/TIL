-- 코드를 입력하세요
SELECT YEAR(s.SALES_DATE) AS YEAR,MONTH(s.SALES_DATE) AS MONTH, COUNT(DISTINCT s.USER_ID) AS PUCHASED_USERS, ROUND(COUNT(DISTINCT s.USER_ID) / (
    SELECT COUNT(USER_ID)
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021), 1) AS PUCHASED_RATIO
FROM USER_INFO AS i
JOIN ONLINE_SALE AS s
ON i.USER_ID = s.USER_ID
WHERE YEAR(i.JOINED) = 2021
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH