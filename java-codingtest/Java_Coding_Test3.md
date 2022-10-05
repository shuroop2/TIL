# Java_Coding_Test3

> 2022년 10월 5일

1. 최댓값과 최솟값

   - 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최솟값과 최댓값을 찾아 이를 "(최솟값) (최댓값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
   - 예를 들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

   ```java
   class Solution {
       public String solution(String s) {
           String answer = "";
           String[] arr = s.split("\\s");
           int max = Integer.parseInt(arr[0]), min = Integer.parseInt(arr[0]);
           for(int i=1; i<arr.length; i++) {
               if(max < Integer.parseInt(arr[i]))
                   max = Integer.parseInt(arr[i]);
               if(min > Integer.parseInt(arr[i]))
                   min = Integer.parseInt(arr[i]);
           }
           answer = min + " " + max;
           return answer;
       }
   }

2. JadenCase 문자열 만들기

   - JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)

   - 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해 주세요.

   - 제한 조건

     - s는 길이 1 이상 200 이하인 문자열
     - s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있다.
       - 숫자는 단어의 첫 문자로만 나온다.
       - 숫자로만 이루어진 단어는 없다.
       - 공백문자가 연속해서 나올 수 있다.

   - 입출력 예

     - | s                       | return                  |
       | ----------------------- | ----------------------- |
       | "3people unFollowed me" | "3people Unfollowed Me" |
       | "for the last week"     | "For The Last Week"     |

   ```java
   class Solution {
       public String solution(String s) {
           String answer = "";
           char[] tmp = s.toLowerCase().toCharArray();
           int num = 0;
           for(int i=0; i<tmp.length; i++) {
               tmp[num] = Character.toUpperCase(tmp[num]);
               if(tmp[i] == ' ')
                   num = i + 1;
           }
           answer = String.valueOf(tmp);
   
           return answer;
       }
   }
   ```

3. 최솟값 만들기

   - 길이가 같은 배열 A, B 두 개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
   - 배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다. 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다. (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)
   - 예를 들어 A = `[1, 4, 2]` , B = `[5, 4, 4]` 라면
     - A에서 첫 번째 숫자인 1, B에서 첫 번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)
     - A에서 두 번째 숫자인 4, B에서 세 번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)
     - A에서 세 번째 숫자인 2, B에서 두 번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)
   - 즉, 이 경우가 최소가 되므로 **29**를 return 합니다.
   - 배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.

   ```java
   import java.util.Arrays;
   
   class Solution
   {
       public int solution(int []A, int []B)
       {
           int answer = 0;
   
           Arrays.sort(A);
           Arrays.sort(B);
   
           for(int i=0; i<A.length; i++) {
               answer += A[i] * B[A.length - 1 - i];
           }
           return answer;
       }
   }
   ```

4. 이진 변환 반복하기

   - 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
     1. x의 모든 0을 제거합니다.
     2. x의 길이를 c라고 하면, x를 "c를 이진법으로 표현한 문자열"로 바꿉니다.
   - 예를 들어, `x = "0111010"`이라면, x에 이진 변환을 가하면 `x = "0111010" -> "1111" -> "100"` 이 됩니다.
   - 0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

   ```java
   class Solution {
       public int[] solution(String s) {
           int cnt = 0, num = 0;
   
           while(!s.equals("1")) {
               for(int i=0; i<s.length(); i++) {
                   if(s.charAt(i) == '0') {
                       cnt++;
                   }
               }
               s = s.replaceAll("0", "");
               s = Integer.toBinaryString(s.length());
               num++;
           }
           int[] answer = {num, cnt};
           return answer;
       }
   }
   ```

5. 올바른 괄호

   - 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
     - "()()" 또는 "(())()" 는 올바른 괄호입니다.
     - ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
   - '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

   ```java
   class Solution {
       boolean solution(String s) {
           boolean answer = true;
           int cnt = 0;
           for(int i=0; i<s.length(); i++) {
               if(s.charAt(i) == '(')
                   cnt++;
               else
                   cnt--;
               if(cnt < 0)
                   answer = false;
           }
           if(cnt != 0)
               answer = false;
           return answer;
       }
   }
   ```