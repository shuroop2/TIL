# Java_Coding_Test2

> 2022년 06월 16일

1. 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요

   - arr은 길이 1 이상, 100 이하인 배열
   - arr의 원소는 -10000 이상 10000 이하인 정수

   ```java
   class Solution {
       public double solution(int[] arr) {
           int sum = 0;
           for(int i=0; i<arr.length; i++) {
               sum += arr[i];
           }
           double answer = (double) (sum) / arr.length;
           return answer;
       }
   }

2. 1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다.

   ```
   1-1. 입력된 수가 짝수라면 2로 나눕니다. 
   1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
   2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다. 
   ```

   예를 들어, 주어진 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이 됩니다. 위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요. 단, 주어진 수가 1인 경우에는 0을, 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환해 주세요.

   ```java
   class Solution {
       public int solution(long num) {
           int answer = 0;
           while(answer < 500) {
               if(num == 1) {
                   return answer;
               } else if(num % 2 == 0) {
                   num /= 2;
                   answer++;
               } else if(num % 2 == 1) {
                   num = num * 3 + 1;
                   answer++;
               } else if(num == 1) {
                   return 0;
               }
           } return -1;
       }
   }
   ```

3. 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

   ```java
   class Solution {
       public int[] solution(int n, int m) {
           int[] answer = new int[2];
           int min = (n < m) ? n : m;
           
           for(int i=1; i<=min; i++) {
               if(m % i == 0 && n % i == 0) {
                   answer[0] = i;
               }
           }
           answer[1] = m * n / answer[0];
           
           return answer;
       }
   }
   ```

4. 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.

   ```java
   class Solution {
       public String solution(int num) {
           String answer = "";
           if(num % 2 == 0)
               answer = "Even";
           else
               answer = "Odd";
           return answer;
       }
   }
   ```

5. 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

   ```java
   import java.util.ArrayList;
   
   class Solution {
       public int[] solution(int[] arr) {
           int[] answer = {};
   		int tmp = 0, min = arr[0];
   		ArrayList<Integer> list = new ArrayList<Integer>();
   		if (arr.length == 1) {
   			answer = new int[1];
   			answer[0] = -1;
   		} else {
   			answer = new int[arr.length-1];
   			for(int i=0; i<arr.length; i++) {
   				list.add(arr[i]);
   				if(min > arr[i]) {
   					min = arr[i];
   					tmp = i;
   				}
   			}
   			list.remove(tmp);
   			for(int i=0; i<arr.length-1; i++) {
   				answer[i] = list.get(i);
   			}
   		}
   		return answer;
       }
   }
   ```

6. 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
   n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

   ```java
   class Solution {
       public long solution(long n) {
           long answer = 0;
           if((int) Math.sqrt(n) == Math.sqrt(n)) {
   			answer = (long) ((Math.sqrt(n)+1)*(Math.sqrt(n)+1));
   		} else {
   			answer = -1;
   		}
           return answer;
       }
   }
   ```
