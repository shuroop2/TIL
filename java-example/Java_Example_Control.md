# Java_Example_Control

> 2022년 06월 01일

1. 1부터 20까지 정수 중에서 2 또는 3의 배수가 아닌 수의 총합

   ```java
   public class Q4_01 {
   	public static void main(String[] args) {
   		int sum = 0;
   		for (int i = 1; i < 21; i++) {
   			if (i % 2 != 0 && i % 3 != 0) {
   				sum += i;
   			}
   		}
   		System.out.println(sum);
   	}
   }
   ```

2. 1+(1+2)+(1+2+3)+(1+2+3+4)+...(1+2+3+...+10)의 결과를 계산

   ```java
   public class Q4_02 {
   	public static void main(String[] args) {
   		int i = 1, sum = 0;
   		while (true) {
   			if (i % 2 == 0)
   				sum -= i;
   			else
   				sum += i;
   			if (sum >= 100)
   				break;
   			i++;
   		}
   		System.out.println(i);
   	}
   }
   ```

3. 1+(-2)+3+(-4)+... 과 같은 식으로 계쏙 더해나갔을 때, 몇까지 더해야 총합이 100이상이 되는지 계산

   ```java
   public class Q4_03 {
   	public static void main(String[] args) {
   		int i = 1, sum = 0;
   		while (true) {
   			if (i % 2 == 0)
   				sum -= i;
   			else
   				sum += i;
   			if (sum >= 100)
   				break;
   			i++;
   		}
   		System.out.println(i);
   	}
   }

4. 다음의 for문을 while문으로 변경

   ```java
   public class Q4_04 {
   	public static void main(String[] args) {
   		for(int i=0; i<=10; i++){
               for(int j=0; j<=10; j++)
                   System.out.print("*");
           	System.out.println();
   		}
   	}
   }
   ```

   ```java
   public class Q4_04 {
   	public static void main(String[] args) {
   		int i = 0;
   		while (i <= 10) {
   			int j = 0;
   			while (j <= i) {
   				System.out.print("*");
   				j++;
   			}
   			System.out.println();
   			i++;
   		}
   	}
   }

5. 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램 작성

   ```java
   public class Q4_05 {
   	public static void main(String[] args) {
   		for (int i = 1; i < 7; i++) {
   			for (int j = 1; j < 7; j++) {
   				if (i + j == 6) {
   					System.out.println(i + ", " + j);
   				}
   			}
   		}
   	}
   }

6. Math.random()을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는 문제

   ```java
   public class Q4_06 {
   	public static void main(String[] args) {
   		int value = (int) (Math.random() * 6 + 1);
   
   		System.out.println(value);
   	}
   }

7. 방정식 2x+4y=10의 모든 해를 구하시오. 단, x와  y는 정수이고 각각의 범위는 0<=x<=10, 0<=y<=10

   ```java
   public class Q4_07 {
   	public static void main(String[] args) {
   		for (int i = 0; i < 11; i++) {
   			for (int j = 0; j < 11; j++) {
   				if (2 * i + 4 * j == 10) {
   					System.out.println("x=" + i + ", y=" + j);
   				}
   			}
   		}
   	}
   }

8. 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 문제

   ```java
   public class Q4_08 {
   	public static void main(String[] args) {
   		String str = "12345";
   		int sum = 0;
   
   		for (int i = 0; i < str.length(); i++) {
   			sum += str.charAt(i) - '0';
   		}
   		System.out.println(sum);
   	}
   }

9. int타입의 변수 num이 있을 때, 각 자리의 합을 더한 결과를 출력하는 문제

   ```java
   public class Q4_09 {
   	public static void main(String[] args) {
   		int num = 12345;
   		int sum = 0;
   
   		while (num > 0) {
   			sum += num % 10;
   			num /= 10;
   		}
   
   		System.out.println(sum);
   	}
   }

10. 1과 1부터 시작하는 피보나치 수열의 10번째 수는 무엇인지 계산하는 문제

    ```java
    public class Q4_10 {
    	public static void main(String[] args) {
    		// 피보나치 수열의 시작의 첫 두 숫자를 1, 1로 한다
    		int num1 = 1;
    		int num2 = 1;
    		int num3 = 0; // 세번째 값
    		System.out.print(num1 + ", " + num2);
    		
    		for(int i=0; i<8; i++) {
    			num3 = num1 + num2;
    			num1 = num2;
    			num2 = num3;
    			System.out.print(", " + num3);
    		}
    	}
    }
    ```

11. 구구단의 일부분을 다음과 같이 출력

    ```
    2*1=2	3*1=3	4*1=4	
    2*2=4	3*2=6	4*2=8	
    2*3=6	3*3=9	4*3=12	
    
    5*1=5	6*1=6	7*1=7	
    5*2=10	6*2=12	7*2=14	
    5*3=15	6*3=18	7*3=21	
    
    8*1=8	9*1=9
    8*2=16	9*2=18
    8*3=24	9*3=27
    ```

    ```java
    public class Q4_11 {
    	public static void main(String[] args) {
    		for (int i = 1; i < 10; i++) {
    			for (int j = 1; j < 4; j++) {
    				int x = i <= 3 ? 1 + j : (i <= 6 ? 4 + j : 7 + j);
    				int y = i % 3 == 0 ? 3 : i % 3;
    				if (x >= 10) {
    					break;
    				}
    				System.out.print(x + "*" + y + "=" + x * y + "\t");
    			}
    			System.out.println();
    			if (i % 3 == 0)
    				System.out.println();
    		}
    	}
    }

12. 주어진 문자열(value)이 숫자 인지 판별하는 프로그램

    ```java
    public class Q4_12 {
    	public static void main(String[] args) {
    		String value = "12o34";
    		boolean isNumber = true;
    		
    		// 반복문과 charAt(int i)를 이용해서 문자열의 문자를 하나씩 읽어서 검사한다.
    		for(int i=0; i<value.length(); i++) {
    			if('0' <= value.charAt(i) && value.charAt(i) <= '9') {
    				isNumber = false;
    				break;
    			}
    		}
    		
    		if(isNumber) {
    			System.out.println(value + "는 숫자입니다.");
    		} else {
    			System.out.println(value + "는 숫자가 아닙니다.");
    		}
    	}
    }

13. 1과 100사이의 값을 반복적으로 입력해서 컴퓨터가 생각한 값을 맞추는 게임. 사용자가 값을 입력하면, 컴퓨터는 자신이 생각한 값과 비교해서 결과를 알려준다. 사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고 몇 번 만에 숫자를 맞췄는지 알려준다.

    ```java
    public class Q4_13 {
    	public static void main(String[] args) {
    		// 1~100 사이의 임의의 값을 얻어서 answer에 저장한다
    		int answer = (int) (Math.random() * 100 + 1);
    		int input = 0;	// 사용자 입력을 저장할 공간
    		int count = 0;	// 시도횟수를 세기위한 변수
    		
    		// 화면으로 부터 사용자 입력을 받기 위해서 Scanner 클래스 사용
    		Scanner s = new Scanner(System.in);
    		do {
    			count++;
    			System.out.print("1과 100사이의 값을 입력하세요 : ");
    			input = s.nextInt();	// 입력받은 값을 변수 input에 저장한다.
    			
    			if(answer > input) {
    				System.out.println("더 큰 수를 입력하세요.");
    			} else if (answer < input) {
    				System.out.println("더 작은 수를 입력하세요.");
    			} else {
    				System.out.println("맞췄습니다.");
    				System.out.println("시도횟수는 " + count + "번입니다.");
    				s.close();
    				break;
    			}
    			
    		} while(true);	// 무한반복문
    	}
    }

14. 회문수를 구하는 프로그램

    ```java
    public class Q4_14 {
    	public static void main(String[] args) {
    		int number = 12321;
    		int tmp = number;
    		
    		int result = 0;	// 변수 number를 거꾸로 변환해서 담을 변수
    		
    		while(tmp != 0) {
    			result = result * 10 + tmp % 10;
    			tmp /= 10;
    		}
    		if(number == result)
    			System.out.println(number + "는 회문수 입니다.");
    		else
    			System.out.println(number + "는 회문수가 아닙니다.");
    	}
    }