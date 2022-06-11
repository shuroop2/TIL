# Java_Coding_Test1

> 2022년 06월 11일

1. 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 `numbers`가 매개변수로 주어집니다. `numbers`에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

   ```java
   class Solution {
       public int solution(int[] numbers) {
           int answer = 45;
           for(int num : numbers) {
           	answer -= num;
           }   
           return answer;
       }
   }
   ```

2. 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
   별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

   ```java
   import java.util.Scanner;
   
   public class Test2 {
   	public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int a = sc.nextInt();
   		int b = sc.nextInt();
   		
   		for(int i=0; i<b; i++) {
   			for(int j=0; j<a; j++) {
   				System.out.print("*");
   			}
   			System.out.println();
   		}
   		sc.close();
   	}
   }
   ```

3. 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

   ```java
   class Solution {
       public long[] solution(long x, int n) {
           long[] answer = new long[n];
           for(int i=0; i<n; i++){
               answer[i] = x * (i+1);
           }
           return answer;
       }
   }
   ```

4. 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

   ```java
   class Solution {
       public int[][] solution(int[][] arr1, int[][] arr2) {
           int[][] answer = new int [arr1.length][arr1[0].length];
           
           
           
           for(int i=0; i<arr1.length; i++) {
   	        	for(int j=0; j<arr1[0].length; j++) {
   	        		answer[i][j] = arr1[i][j] + arr2[i][j];
   	        	}
   	        }
           return answer;
       }
   }
   ```

5. 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
   전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 `*`으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

   ```java
   class Solution {
       public String solution(String phone_number) {
           String answer = phone_number.substring(phone_number.length()-4);
           String star = "";
           for(int i=0; i<phone_number.length()-4; i++) {
           	star += "*";
           }
           answer = star + answer;
           return answer;
       }
   }
   ```

6. 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

   ```java
   class Solution {
       public boolean solution(int x) {
           boolean answer = true;
   		int tmp = x;
   		int cnt = 0;
   		int sum = 0;
   		while (tmp > 0) {
   			tmp /= 10;
   			cnt++;
   		}
   		
   		int[] num = new int[cnt];
   		tmp = x;
   		for(int i=0; i<num.length; i++) {
   			num[i] = tmp % 10;
   			sum += num[i];
   			tmp /= 10;
   		}
   		if(x % sum == 0)
   			answer = true;
   		else
   			answer = false;
   		
   		return answer;
       }
   }