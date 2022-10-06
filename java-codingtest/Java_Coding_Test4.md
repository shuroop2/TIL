# Java_Coding_Test4

> 2022년 10월 6일

1. 숫자의 표현

   - Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
     - 1 + 2 + 3 + 4 + 5 = 15
     - 4 + 5 + 6 = 15
     - 7 + 8 = 15
     - 15 = 15
   - 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.

   ```java
   class Solution {
       public int solution(int n) {
           int answer = 0;
           
           for(int i=1; i<=n; i++) {
               if(n % i == 0){
                   if(i % 2 == 1)
                       answer++;
               }
           }
           
           return answer;
       }
   }
   ```

2. 피보나치 수

   - 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

     예를들어

     - F(2) = F(0) + F(1) = 0 + 1 = 1
     - F(3) = F(1) + F(2) = 1 + 1 = 2
     - F(4) = F(2) + F(3) = 1 + 2 = 3
     - F(5) = F(3) + F(4) = 2 + 3 = 5

   - 와 같이 이어집니다.

   - 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

   ```java
   class Solution {
       public int solution(int n) {
           int answer = 0;
           int[] tmp = new int[n+1];
           tmp[0] = 0;
           tmp[1] = 1;
           for(int i=2; i<=n; i++) {
               tmp[i] = tmp[i-1] % 1234567 + tmp[i-2] % 1234567;
           }
           answer = tmp[n] % 1234567;
   
           return answer;
       }
   }
   ```

3. 다음 큰 숫자

   - 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
     - 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
     - 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
     - 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
   - 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
   - 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

   ```java
   class Solution {
       public int solution(int n) {
           int answer = n + 1;
           String binaryN = Integer.toBinaryString(n);
           while(true) {
               String binaryAnswer = Integer.toBinaryString(answer).replace("0", "");
               binaryN = binaryN.replace("0", "");
               if(binaryN.equals(binaryAnswer))
                   break;
               else
                   answer++;
           }
   
           return answer;
       }
   }
   ```

4. 카펫

   - Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.

   ![](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b1ebb809-f333-4df2-bc81-02682900dc2d/carpet.png)

   - Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
   - Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
   - 제한사항
     - 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
     - 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
     - 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

   ```java
   class Solution {
       public int[] solution(int brown, int yellow) {
           int a = (brown + 4) / 2;
           int b = yellow + brown;
           int[] answer = {(int)(a + Math.sqrt(a * a - 4 * b)) / 2,(int)(a - Math.sqrt(a * a - 4 * b)) / 2};
           return answer;
       }
   }
   ```

5. 영어 끝말잇기

   - 1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.
     1. 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
     2. 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
     3. 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
     4. 이전에 등장했던 단어는 사용할 수 없습니다.
     5. 한 글자인 단어는 인정되지 않습니다.
   - 다음은 3명이 끝말잇기를 하는 상황을 나타냅니다.
   - tank → kick → know → wheel → land → dream → mother → robot → tank
   - 위 끝말잇기는 다음과 같이 진행됩니다.
     - 1번 사람이 자신의 첫 번째 차례에 tank를 말합니다.
     - 2번 사람이 자신의 첫 번째 차례에 kick을 말합니다.
     - 3번 사람이 자신의 첫 번째 차례에 know를 말합니다.
     - 1번 사람이 자신의 두 번째 차례에 wheel을 말합니다.
     - (계속 진행)
   - 끝말잇기를 계속 진행해 나가다 보면, 3번 사람이 자신의 세 번째 차례에 말한 tank 라는 단어는 이전에 등장했던 단어이므로 탈락하게 됩니다.
   - 사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때, 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.

   ```java
   class Solution {
       public int[] solution(int n, String[] words) {
           int[] answer = {};
   
           for(int i=1; i<words.length; i++) {
               if(words[i].length() == 1) {
                   answer[0] = i%n+1;
                   answer[1] = i/n+1;
                   return answer;
               } else if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
                   answer[0] = i%n+1;
                   answer[1] = i/n+1;
                   return answer;
               }
               for(int j=0; j<i; j++) {
                   if(words[j].equals(words[i])) {
                       answer[0] = i%n+1;
                       answer[1] = i/n+1;
                       return answer;
                   }
               }
           }
           return answer;
       }
   }
   ```