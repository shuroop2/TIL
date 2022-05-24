# Java_Example_If

1. 두 수를 비교한 결과를 출력

   ```java
   import java.util.Scanner;
   
   public class Q01 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int A, B;
   
   		System.out.print("두 숫자를 입력해주세요 : ");
   		A = sc.nextInt();
   		B = sc.nextInt();
   
   		if (A < B)
   			System.out.println("<");
   		else if (A > B)
   			System.out.println(">");
   		else
   			System.out.println("==");
   
   		sc.close();
   	}
   }
   ```

2. 시험 점수를 성적으로 변환

   ```java
   import java.util.Scanner;
   
   public class Q02 {
   
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int score;
   		
   		System.out.print("시험 점수 입력 : ");
   		score = sc.nextInt();
   		if(score>=90)
   			System.out.println("A");
   		else if(score>=80)
   			System.out.println("B");
   		else if(score>=70)
   			System.out.println("C");
   		else if(score>=60)
   			System.out.println("D");
   		else
   			System.out.println("F");
   		
   		sc.close();
   	}
   
   }
   ```

3. 윤년을 판별

   ```java
   import java.util.Scanner;
   
   public class Q03 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int year;
   		
   		System.out.print("연도 입력 : ");
   		year = sc.nextInt();
   		
   		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
   			System.out.println("1");
   		else
   			System.out.println("0");
   		
   		sc.close();
   	}
   }
   ```

4. 점이 어느 사분면에 있는지 구분

   ```java
   import java.util.Scanner;
   
   public class Q04 {
   
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int x, y;
   		
   		System.out.println("좌표 입력");
   		x = sc.nextInt();
   		y = sc.nextInt();
   		
   		if(x>0 && y>0)
   			System.out.println("1");
   		else if(x<0 && y>0)
   			System.out.println("2");
   		else if(x<0 && y<0)
   			System.out.println("3");
   		else
   			System.out.println("4");
   		
   		sc.close();
   	}
   
   }

5. 시간 계산

   ```java
   import java.util.Scanner;
   
   public class Q05 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int h, m;
   		
   		System.out.print("입력 시간 : ");
   		h = sc.nextInt();
   		m = sc.nextInt();
   		
   		
   		if(h >= 0 && m >= 45)
   			System.out.println(h + " " + (m-45));
   		else if(h >= 1 && m < 45)
   			System.out.println((h-1) + " " + (m+15));
   		else 
   			System.out.println("23 " + (m+15));
   		
   		sc.close();
   	}
   }

6. 범위가 더 넓은 시간 계산

   ```java
   import java.util.Scanner;
   
   public class Q06 {
   
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int hour, min, cookTime, cookTimeHour, cookTimeMin;
   		
   		System.out.print("시간 입력 : ");
   		hour = sc.nextInt();
   		min = sc.nextInt();
   		
   		System.out.print("조리 시간 입력 : ");
   		cookTime = sc.nextInt();
   		
   		if(cookTime >= 60) {
   			cookTimeHour = cookTime / 60;
   			cookTimeMin = cookTime % 60;
   		}else {
   			cookTimeHour = 0;
   			cookTimeMin = cookTime;
   		}
   		
   		if(hour + cookTimeHour >= 23 && min + cookTimeMin >= 60) 
   			System.out.println((hour + cookTimeHour - 23) + " " + (min + cookTimeMin - 60));
   		else if(hour + cookTimeHour >= 24 && min + cookTimeMin < 60)
   			System.out.println((hour + cookTimeHour - 24) + " " + (min + cookTimeMin));
   		else if(hour + cookTimeHour < 23 && min + cookTimeMin >= 60)
   			System.out.println((hour + cookTimeHour + 1) + " " + (min + cookTimeMin - 60));
   		else
   			System.out.println((hour + cookTimeHour) + " " + (min + cookTimeMin));
   		
   		sc.close();	
   	}
   
   }

7. 조건에 따라 상금을 계산

   ```java
   import java.util.Scanner;
   
   public class Q07 {
   
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int[] num = new int[3];
   		int prize;
   
   		System.out.println("주사위 눈 입력");
   		num[0] = sc.nextInt();
   		num[1] = sc.nextInt();
   		num[2] = sc.nextInt();
   
   		if (num[0] == num[1] && num[0] == num[2])
   			prize = 10000 + num[0] * 1000;
   		else if (num[0] == num[1] && num[0] != num[2])
   			prize = 1000 + num[0] * 100;
   		else if (num[0] == num[2] && num[0] != num[1])
   			prize = 1000 + num[0] * 100;
   		else if (num[1] == num[2] && num[0] != num[1])
   			prize = 1000 + num[1] * 100;
   		else {
   			int max = 0;
   			for (int i = 0; i < num.length; i++)
   				if (max < num[i])
   					max = num[i];
   			prize = max * 100;
   		}
   		System.out.println(prize);
   
   		sc.close();
   	}
   
   }