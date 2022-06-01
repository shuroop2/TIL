# Java_Example_Operator

> 2022년 06월 01일

1. 변수 num의 값에 따라 '양수', '음수', '0'을 출력하는 문제

   ```java
   public class Q3_01 {
   	public static void main(String[] args) {
   		int num = 10;
   		System.out.println(num > 0 ? "양수" : (num < 0 ? "음수" : "0"));
   	}
   }

2. 백의 자리 이하를 버리는 문제

   ```java
   public class Q3_02 {
   	public static void main(String[] args) {
   		int num = 456;
   		System.out.println(num / 100 * 100);
   	}
   }
   ```

3. 변수 num의 값 중에서 일의 자리를 1로 바꾸는 문제

   ```java
   public class Q3_03 {
   	public static void main(String[] args) {
   		int num = 333;
   		System.out.println(num / 10 * 10 + 1);
   	}
   }

4. 변수 num의 값보다 크면서도 가장 가까운 10의 배수에서 변수 num의 값을 뺀 나머지를 구하는 문제

   ```java
   public class Q3_04 {
   	public static void main(String[] args) {
   		int num = 24;
   		System.out.println(10 - num % 10);
   	}
   }

5. 화씨를 섭씨로 변환하는 문제 (변환공식 C = 5/9 * (F - 32)), 소수점 셋째자리에서 반올림

   ```java
   public class Q3_05 {
   	public static void main(String[] args) {
   		int F = 100;
   		float C = (int) ((5 / 9f * (F - 32)) * 100 + 0.5) / 100f;
   		
   		System.out.println("Fahrenheit : " + F);
   		System.out.println("Celcius : " + C);
   	}
   }

6. 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만 변수 b의 값이 true가 되도록 하는 문제

   ```java
   public class Q3_06 {
   	public static void main(String[] args) {
   		char ch = 'z';
   		boolean b = ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ('0' <= ch && ch <= '9');
   		
   		System.out.println(b);
   	}
   }

7. 대문자를 소문자로 변경하는데, 문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경

   ```java
   public class Q3_07 {
   	public static void main(String[] args) {
   		char ch = 'A';
   		char lowerCase = ('A' <= ch && ch <= 'Z') ? (char) (ch + 32) : ch;
   		
   		System.out.println("ch : " + ch);
   		System.out.println("ch to lowerCase : " + lowerCase);
   	}
   }