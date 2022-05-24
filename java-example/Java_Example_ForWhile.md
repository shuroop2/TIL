# Java_Example_ForWhile

1. 구구단을 출력

   ```java
   import java.util.Scanner;
   
   public class Q01 {
   
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int num;
   		
   		System.out.print("숫자를 입력해주세요 : ");
   		num = sc.nextInt();
   		for(int i=1; i<10; i++) {
   			System.out.println(num + " * " + i + " = " + num*i);
   		}
   		
   		sc.close();
   	}
   
   }
   ```

2. 1부터 N까지의 합

   ```java
   import java.util.Scanner;
   
   public class Q02 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int n, sum = 0;
   		n = sc.nextInt();
   
   		for (int i = 1; i <= n; i++)
   			sum += i;
   
   		System.out.println(sum);
   
   		sc.close();
   	}
   }

3. N부터 1까지 역순으로 출력

   ```java
   import java.util.Scanner;
   
   public class Q03 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int n;
   
   		n = sc.nextInt();
   		for (int i = n; i >= 1; i--)
   			System.out.println(i);
   
   		sc.close();
   	}
   }

4. A+B를 여러 번 출력하는 문제

   ```java
   import java.util.Scanner;
   
   public class Q04 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int a, b, c;
   
   		c = sc.nextInt();
   		for (int i = 1; i <= c; i++) {
   			a = sc.nextInt();
   			b = sc.nextInt();
   			System.out.println("Case #" + i + " : " + a + " + " + b + " = " + (a + b));
   		}
   
   		sc.close();
   	}
   }

5. 별을 찍는 문제 (오른쪽 정렬)

   ```java
   import java.util.Scanner;
   
   public class Q05 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int n;
   
   		n = sc.nextInt();
   		for (int i = 1; i <= n; i++) {
   			for (int j = n; j > i; j--)
   				System.out.print(" ");
   			for (int k = 1; k <= i; k++)
   				System.out.print("*");
   			System.out.println();
   		}
   
   		sc.close();
   	}
   }

6. X보다 작은수

   ```java
   import java.util.Scanner;
   
   public class Q06 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int a, b;
   		
   		a = sc.nextInt();
   		b = sc.nextInt();
   		int[] x = new int[a];
   		for(int i=0; i<a; i++) {
   			x[i] = sc.nextInt();
   			if(x[i] < b) 
   				System.out.print(x[i] + " ");
   		}
   		
   		sc.close();
   	}
   }

7. 0 0이 들어올 때까지 A+B를 출력

   ```java
   import java.util.Scanner;
   
   public class Q07 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int a, b;
   
   		while (true) {
   			a = sc.nextInt();
   			b = sc.nextInt();
   			if (a == 0 && b == 0) break;
   			System.out.println(a + b);
   		}
   		
   		sc.close();
   	}
   }