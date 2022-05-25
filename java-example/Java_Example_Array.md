# Java_Example_Array

1. 최솟값과 최댓값을 찾는 문제

   > N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

   ```java
   import java.util.Scanner;
   
   public class Q01 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int max = -1000000, min = 1000000;;
   		
   		int[] a = new int[sc.nextInt()];
   		
   		for(int i=0; i<a.length; i++) {
   			a[i] = sc.nextInt();
   			if(max < a[i])
   				max = a[i];
   			if(min > a[i])
   				min = a[i];
   		}
   		System.out.println(min + " " + max);
   		sc.close();
   	}
   }
   ```

2. 최댓값을 찾는 문제

   > 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.

   ```java
   import java.util.Scanner;
   
   public class Q02 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int[] a = new int[9];
   		int max = 0, num = 0;
   		
   		for(int i=0; i<a.length; i++) {
   			a[i] = sc.nextInt();
   			if(max < a[i]) {
   				max = a[i];
   				num = i + 1;
   			}
   		}
   		System.out.println(max + "\n" + num);
   		
   		sc.close();
   	}
   }

3. 평균을 조작하는 문제

   > 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
   >
   > 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
   >
   > 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.

   ```java
   import java.util.Scanner;
   
   public class Q03 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int max = 0, sum = 0;
   		float average;
   		
   		int[] a = new int[sc.nextInt()];
   		for(int i=0; i<a.length; i++) {
   			a[i] = sc.nextInt();
   			if(max < a[i]) 
   				max = a[i];
   			sum += a[i];
   		}
   		
   		average = (float) sum / a.length / max * 100;
   		System.out.println(average);
   		
   		sc.close();
   	}
   }

4. OX 퀴즈

   > "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
   >
   > "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
   >
   > OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

   ```java
   import java.util.Scanner;
   
   public class Q04 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   
   		String[] a = new String[sc.nextInt()];
   
   		for (int i = 0; i < a.length; i++) {
   			int cnt = 0, sum = 0;
   			a[i] = sc.next();
   			for (int j = 0; j < a[i].length(); j++) {
   				if (a[i].charAt(j) == 'O')
   					cnt++;
   				else
   					cnt = 0;
   
   				sum += cnt;
   			}
   			System.out.println(sum);
   		}
   
   		sc.close();
   
   	}
   }

5. 평균은 넘겠지

   > 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
   >
   > 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
   >
   > 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다

   ```java
   import java.text.DecimalFormat;
   import java.util.Scanner;
   
   public class Q05 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		DecimalFormat df = new DecimalFormat("0.000");
   		float average;
   		
   		int[] a = new int[sc.nextInt()];
   		for(int i=0; i<a.length; i++) {
   			int sum = 0;
   			int[] b = new int[sc.nextInt()];
   			for(int j=0; j<b.length; j++) {
   				b[j] = sc.nextInt();
   				sum += b[j];
   			}
   			average = (float) sum / b.length;
   			double cnt = 0;
   			
   			for(int j=0; j<b.length; j++) {
   				if(average < b[j])
   					cnt++;
   			}
   			System.out.println(df.format(cnt / b.length * 100) + "%");
   		}
   		
   		sc.close();
   	}
   }