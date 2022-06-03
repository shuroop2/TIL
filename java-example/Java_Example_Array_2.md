# Java_Example_Array_2

> 2022년 06월 03일

1. 배열 arr에 담긴 모든 값을 더하는 프로그램을 작성

   ```java
   public class Q5_01 {
   	public static void main(String[] args) {
   		int[] arr = {10, 20, 30, 40, 50};
   		int sum = 0;
   		
   		for(int i=0; i<arr.length; i++) {
   			sum += arr[i];
   		}
   		System.out.println(sum);
   	}
   }

2. 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 작성

   ```java
   public class Q5_02 {
   	public static void main(String[] args) {
   		int[][] arr = {{5,5,5,5,5},{10,10,10,10,10},{20,20,20,20,20},{30,30,30,30,30}};
   		int total = 0;
   		float average = 0;
   		
   		for(int i=0; i<arr.length; i++) {
   			for(int j=0; j<arr[i].length; j++) {
   				total += arr[i][j];
   			}
   		}
   		average = (float) total / (arr.length * arr[0].length);
   		System.out.println("total : " + total);
   		System.out.println("average : " + average);
   	}
   }

3. 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램을 작성
   
   ```java
   public class Q5_03 {
   	public static void main(String[] args) {
   		int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
   		int[] ball3 = new int[3];
   
   		// 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
   		for (int i = 0; i < ballArr.length; i++) {
   			int j = (int) (Math.random() * ballArr.length);
   			int tmp = 0;
   			
   			tmp = ballArr[i];
   			ballArr[i] = ballArr[j];
   			ballArr[j] = tmp;
   		}
   		
   		// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
   		System.arraycopy(ballArr, 0, ball3, 0, 3);
   		
   		for(int i=0; i<ball3.length; i++) {
   			System.out.print(ball3[i]);
   		}
   	}
   }
   
4. 변수 money의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력. 단, 가능한 한 적은 수의 동전으로 거슬러 주어야 함
   
   ```java
   public class Q5_04 {
   	public static void main(String[] args) {
   		// 큰 금액의 동전을 우선적으로 거슬러 줘야한다.
   		int[] coinUnit = {500, 100, 50, 10};
   		
   		int money = 2680;
   		System.out.println("money : " + money);
   		
   		for(int i=0; i<coinUnit.length; i++) {
   			System.out.println(coinUnit[i] + "원 : " + money/coinUnit[i]);
   			money %= coinUnit[i];
   		}
   	}
   }
   
5. 문제 4번에 동전의 개수를 추가한 프로그램. 금액을 입력받아 계산. 보유한 동전의 개수로 거스름돈을 지불할 수 없으면, '거스름 돈이 부족합니다.'라고 출력하고 종료. 지불할 돈이 충분히 있으면, 거스름돈을 지불한 만큼 가진 돈에서 빼고 남은 동전의 개수를 화면에 출력
   
   ```java
   public class Q5_05 {
   	public static void main(String[] args) {
   		
   		int money = 3300;
   		
   		System.out.println("money : " + money);
   		
   		int[] coinUnit = {500, 100, 50, 10};	// 동전의 단위
   		int[] coin = {5, 5, 5, 5}; 				// 단위별 동전의 개수
   		
   		for(int i=0; i<coinUnit.length; i++) {
   			int coinNum = 0;
   			// 1. 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)을 구한다
   			// 2. 배열 coin에서 coinNum만큼의 동전을 뺀다.
   			// 	  (만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다.)
   			// 3. 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺀다.
   			
   			coinNum = money / coinUnit[i];
   			if(coinNum < coin[i]) {
   				coinNum = money / coinUnit[i];
   			} else {
   				coinNum = 5;
   			}
   			coin[i] -= coinNum;
   			money -= coinNum * coinUnit[i];
   			
   			System.out.println(coinUnit[i] + "원 : " + coinNum);
   		}
   		
   		if(money > 0) {
   			System.out.println("거스름돈이 부족합니다.");
   			System.exit(0);
   		}
   		
   		System.out.println("=남은 동전의 개수 = ");
   		
   		for(int i=0; i<coinUnit.length; i++) {
   			System.out.println(coinUnit[i] + " 원 : " + coin[i]);
   		}
   	}
   }
   
6. 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 '*'을 찍어서 그래프를 그리는 프로그램을 작성
   
   ```java
   public class Q5_06 {
   	public static void main(String[] args) {
   		int[] answer = {1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2};
   		int[] counter = new int[4];
   		
   		for(int i=0; i<answer.length; i++) {
   			counter[answer[i]-1]++;
   		}
   		
   		for(int i=0; i<counter.length; i++) {
   			System.out.print(counter[i]);
   			for(int j=0; j<counter[i]; j++)
   				System.out.print("*");
   			System.out.println();
   		}
   	}
   }
   
7. 주어진 배열을 시계방향으로 90도 회전시켜서 출력하는 프로그램을 작성
   
   ```java
   public class Q5_07 {
   	public static void main(String[] args) {
   		char[][] star = {
   				{'*', '*', ' ', ' ', ' '},
   				{'*', '*', ' ', ' ', ' '},
   				{'*', '*', '*', '*', '*'},
   				{'*', '*', '*', '*', '*'}
   		};
   		
   		char[][] result = new char[star[0].length][star.length];
   		
   		for(int i=0; i<star.length; i++) {
   			for(int j=0; j<star[i].length; j++) {
   				System.out.print(star[i][j]);
   			}
   			System.out.println();
   		}
   		System.out.println();
   		
   		for(int i=0; i<star.length; i++) {
   			for(int j=0; j<star[i].length; j++) {
   				result[j][3-i] = star[i][j];
   			}
   			System.out.println();
   		}
   		
   		for(int i=0; i<result.length; i++) {
   			for(int j=0; j<result[i].length; j++) {
   				System.out.print(result[i][j]);
   			}
   			System.out.println();
   		}
   	}
   }
   
8. 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램을 작성
   
   ![](C:\Users\kingd\OneDrive\사진\11.JPG)

   ```java
   public class Q5_08 {
   	public static void main(String[] args) {
   		char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[',
   				']', '{', '}', ';', ':', ',', '.', '/' };
   		// 0 1 2 3 4 5 6 7 8 9
   		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
   		String src = "abc123";
   		String result = "";
   
   		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
   		for (int i = 0; i < src.length(); i++) {
   			char ch = src.charAt(i);
   			
   			if('a' <= ch && ch <= 'z') {
   				ch = abcCode[ch - 'a'];
   			} else if('0' <= ch && ch <= '9') {
   				ch = numCode[ch - '0'];
   			}
   			result += ch;
   			
   			
   		}
   		System.out.println("src:" + src);
   		System.out.println("result:" + result);
   	}
   }
   
   ```
   
9. 주어진 2차원 배열의 데이터보다 가로와 세로로 1이 더 큰 배열을 생성해서 배열의 행과 마지막 요소에 각 열과 행의 총합을 저장하고 출력하는 프로그램을 작성

   ```java
   public class Q5_09 {
   	public static void main(String[] args) {
   		int[][] score = {
   				{ 100, 100, 100 },
   				{ 20, 20, 20 },
   				{ 30, 30, 30 },
   				{ 40, 40, 40 },
   				{ 50, 50, 50 }
   			};
   		int[][] result = new int[score.length + 1][score[0].length + 1];
   		for (int i = 0; i < score.length; i++) {
   			for (int j = 0; j < score[i].length; j++) {
   				result[i][j] = score[i][j];			
   				result[i][score[0].length] += result[i][j];
   				result[score.length][j] += result[i][j];
   				result[score.length][score[0].length] += result[i][j];
   				}
   		}
   		for (int i = 0; i < result.length; i++) {
   			for (int j = 0; j < result[i].length; j++) {
   				System.out.printf("%4d", result[i][j]);
   			}
   			System.out.println();
   		}
   	}
   }

10. 단어의 글자위치를 섞어서 보여주고 원래의 단어를 맞추는 문제

    ```java
    import java.util.Scanner;
    
    public class Q5_10 {
    	public static void main(String[] args) {
    		String[] words = { "television", "computer", "mouse", "phone" };
    		Scanner scanner = new Scanner(System.in);
    		for (int i = 0; i < words.length; i++) {
    			char[] question = words[i].toCharArray(); // String을 char[]로 변환
    			
    			for(int j=0; j<question.length; j++) {
    				int randomNum = (int) (Math.random()*question.length);
    				char randomWord = question[i];
    				question[i] = question[randomNum];
    				question[randomNum] = randomWord;
    			}			
    			System.out.printf("Q%d. %s의 정답을 입력하세요.>", i + 1, new String(question));
    			String answer = scanner.nextLine();
    			
    			// trim()으로 answer의 좌우 공백을 제거한 후, equals로 word[i]와 비교
    			if (words[i].equals(answer.trim()))
    				System.out.printf("맞았습니다.%n%n");
    			else
    				System.out.printf("틀렸습니다.%n%n");
    		}
    		scanner.close();
    	}
    }

