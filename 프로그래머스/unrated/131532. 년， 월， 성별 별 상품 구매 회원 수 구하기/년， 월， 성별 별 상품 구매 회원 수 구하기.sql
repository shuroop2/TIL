-- 코드를 입력하세요
SELECT YEAR(s.SALES_DATE) AS YEAR, MONTH(s.SALES_DATE) AS MONTH, u.GENDER, COUNT(DISTINCT u.USER_ID) AS USERS
FROM USER_INFO AS u
JOIN ONLINE_SALE AS s ON u.USER_ID = s.USER_ID
WHERE u.GENDER IS NOT NULL
GROUP BY YEAR(s.SALES_DATE), MONTH(s.SALES_DATE), u.GENDER
ORDER BY YEAR(s.SALES_DATE), MONTH(s.SALES_DATE), u.GENDER