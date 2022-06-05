# Java_Example_Class

1. SutdaCard클래스에 두 개의 생성자와 info()를 추가해서 실행결과와 같은 결과를 얻는 문제

   - | 타입    | 변수명  | 설명                         |
     | ------- | ------- | ---------------------------- |
     | int     | num     | 카드의 숫자(1~10사이의 정수) |
     | boolean | isKwang | 광이면 true, 아니면 false    |

     ```java
     public class Q6_01 {
     	public static void main(String[] args) {
     		SutdaCard card1 = new SutdaCard(3, false);
     		SutdaCard card2 = new SutdaCard();
     
     		System.out.println(card1.info());
     		System.out.println(card2.info());
     	}
     }
     
     class SutdaCard {
     	int num;
     	boolean isKwang;
     	
     	public SutdaCard() {
     		this(1, true);
     	}
     	
     	public SutdaCard(int num, boolean isKwang) {
     		this.num = num;
     		this.isKwang = isKwang;
     	}
     	
     	public String info() {
     		return num + (isKwang? "K" : "");
     	}
     }
     ```

   - 실행결과

     ```java
     3
     1K

2. Student클래스에 다음과 같이 정의된 두 개의 메서드 getTotal()과 getAverage()를 추가하는 문제

   1. 메서드명 : getTotal
      기 능 : 국어(kor), 영어(eng), 수학(math)의 점수를 모두 더해서 반환한다.
      반환타입 : int
      매개변수 : 없음

   2. 메서드명 : getAverage
     기 능 : 총점(국어점수+영어점수+수학점수)을 과목수로 나눈 평균을 구한다.
     소수점 둘째자리에서 반올림할 것.
     반환타입 : float
     매개변수 : 없음

     ```java
     import java.text.DecimalFormat;
     
     public class Q6_02 {
     	public static void main(String[] args) {
     		Student s = new Student();
     		DecimalFormat df = new DecimalFormat("0.0");
     		s.name = "홍길동";
     		s.ban = 1;
     		s.no = 1;
     		s.kor = 100;
     		s.eng = 60;
     		s.math = 76;
     
     		System.out.println("이름 : " + s.name);
     		System.out.println("총점 : " + s.getTotal());
     		System.out.println("평균 : " + df.format(s.getAverage()));
     	}
     }
     
     class Student {
     	String name;
     	int ban;
     	int no;
     	int kor;
     	int eng;
     	int math;
     
     	public int getTotal() {
     		return kor + eng + math;
     	}
     
     	public float getAverage() {
     		return (kor + eng + math) / 3f;
     	}
     }
     ```

3. 다음과 같은 실행결과를 얻도록 Student클래스에 생성자와 info()를 추가하는 문제

   ```java
   public class Q6_03 {
   	public static void main(String[] args) {
   		Student2 s = new Student2("홍길동", 1, 1, 100, 60, 76);
   
   		System.out.println(s.info());
   	}
   }
   
   class Student2 {
   	String stdName;
   	int stdYear;
   	int stdClass;
   	int stdKor;
   	int stdEng;
   	int stdMath;
   
   	public Student2(String stdName, int stdYear, int stdClass, int stdKor, int stdEng, int stdMath) {
   		this.stdName = stdName;
   		this.stdYear = stdYear;
   		this.stdClass = stdClass;
   		this.stdKor = stdKor;
   		this.stdEng = stdEng;
   		this.stdMath = stdMath;
   	}
   
   	int getTotal() {
   		return stdKor + stdEng + stdMath;
   	}
   
   	float getAverage() {
   		return (int) (getTotal() / 3f * 10 + 0.5f) / 10f;
   	}
   
   	public String info() {
   		return stdName + "," + stdYear + "," + stdClass + "," + stdKor + "," + stdEng
   				+ "," + stdMath + "," + getTotal()+ "," + getAverage();
   
   	}
   }
   ```

   - 실행결과

   ```java
   홍길동,1,1,100,60,76,236,78.7

4. 두 점의 거리를 계산하는 getDistance()를 생성

   ```java
   public class Q6_04 {
   	// 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.
   	static double getDistance(int x, int y, int x1, int y1) {
   		return Math.sqrt((x1 - x)*(x1 - x) + (y1 - y)*(y1 - y));
   	}
   
   	public static void main(String[] args) {
   		System.out.println(getDistance(1, 1, 2, 2));
   	}
   }
   ```

   - 실행결과

   ```java
   1.4142135623730951

5. 문제4에서 작성한 클래스메서드 getDistance()를 Mypoint클래스의 인스턴스메서드로 정의

   ```java
   class MyPoint {
   	int x;
   	int y;
   
   	MyPoint(int x, int y) {
   		this.x = x;
   		this.y = y;
   	}
   	public double getDistance(int a, int b) {
   		return Math.sqrt((x - a)*(x - a) + (y - b)*(y - b));
   	}
   }
   
   public class Q6_05 {
   	public static void main(String[] args) {
   		MyPoint p = new MyPoint(1, 1);
   		// p와 (2,2)의 거리를 구한다.
   		System.out.println(p.getDistance(2, 2));
   	}
   }
   ```

   - 실행결과

   ```java
   1.4142135623730951

6. 다음과 같이 정의된 메서드를 작성하고 테스트

   - 메서드명 : shuffle
     기 능 : 주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다.
     처리한 배열을 반환한다.
     반환타입 : int[]
     매개변수 : int[] arr - 정수값이 담긴 배열

   ```java
   public class Q6_06 {
   
   	public static int[] shuffle(int[] arr) {
   		for(int i = 0; i < arr.length; i++) {
   			int j = (int) (Math.random() * arr.length);
   			int tmp = arr[i];
   			arr[i] = arr[j];
   			arr[j] = tmp;
   		}
   		return arr;
   	}
   
   	public static void main(String[] args) {
   		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
   		System.out.println(java.util.Arrays.toString(original));
   		int[] result = shuffle(original);
   		System.out.println(java.util.Arrays.toString(result));
   
   	}
   }
   ```

   - 실행결과

   ```java
   [1, 2, 3, 4, 5, 6, 7, 8, 9]
   [7, 6, 5, 8, 9, 4, 1, 3, 2]

7. Tv클래스를 주어진 로직대로 완성하고, 실행해서 주어진 실행결과와 일치하는지 확인

   ```java
   class MyTv {
   	boolean isPowerOn;
   	int channel;
   	int volume;
   	final int MAX_VOLUME = 100;
   	final int MIN_VOLUME = 0;
   	final int MAX_CHANNEL = 100;
   	final int MIN_CHANNEL = 1;
   
   	void turnOnOff() {
   		// (1) isPowerOn의 값이 true면 false로 false면 true로 바꾼다
   		isPowerOn = !isPowerOn;
   	}
   
   	void volumeUp() {
   		// (2) volume의 값이 MAX_VOLUME보다 작을 때만 값을 1 증가시킨다
   		if(volume < MAX_VOLUME)
   			volume--;
   	}
   
   	void volumeDown() {
   		// (3) volume의 값이  MIN_VOLUME보다 클 때만 값을 1 감소시킨다
   		if(volume < MIN_VOLUME)
   			volume++;
   	}
   
   	void channelUp() {
   		// (4) channel의 값을 1 증가시킨다
   		// 만일 channel이 MAX_CHANNEL이면, channel의 값을 MIN_CHANNEL로 바꾼다
   		if(channel == MAX_CHANNEL)
   			channel = MIN_CHANNEL;
   		else
   			channel++;
   	}
   
   	void channelDown() {
   		// (5) channel의 값을 1 감소시킨다
   		// 만일 channel이 MIN_CHANNEL이면, channel의 값을 MAX_CHANNEL로 바꾼다
   		if(channel == MIN_CHANNEL)
   			channel = MAX_CHANNEL;
   		else
   			channel--;
   	}
   }
   
   public class Q6_07 {
   	public static void main(String[] args) {
   		MyTv t = new MyTv();
   		
   		t.channel = 100;
   		t.volume = 0;
   		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
   		
   		t.channelDown();
   		t.volumeDown();
   		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
   		
   		t.volume = 100;
   		t.channelUp();
   		t.volumeUp();
   		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
   	}
   }
   ```

   - 실행결과

   ```java
   CH:100, VOL:0
   CH:99, VOL:0
   CH:100, VOL:100

8. 다음과 같이 정의된 메서드를 작성하고 테스트

   - 메서드명 : isNumber
     기 능 : 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
     모두 숫자로만 이루어져 있으면 true를 반환하고,
     그렇지 않으면 false를 반환한다.
     만일 주어진 문자열이 null이거나 빈문자열“”이라면 false를 반환한다.
     반환타입 : boolean
     매개변수 : String str - 검사할 문자열

   ```java
   public class Q6_08 {
   
   	public static boolean isNumber(String str) {
   		if(str.equals(null) || str.equals("")) 
   			return false;
   		
   		for(int i=0; i<str.length(); i++) {
   			char ch = str.charAt(i);
   			if('0' > ch || ch > '9')
   				return false;
   		}
   		return true;
   	}
   	
   	public static void main(String[] args) {
   		String str = "123";
   		System.out.println(str + "는 숫자입니까? "+ isNumber(str));
   		
   		str = "1234o";
   		System.out.println(str + "는 숫자입니까? "+ isNumber(str));
   	}
   }
   ```

   - 실행결과

   ```java
   123는 숫자입니까? true
   1234o는 숫자입니까? false

9. 다음과 같이 정의된 메서드를 작성하고 테스트

   - 메서드명 : max
     기 능 : 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다.
     만일 주어진 배열이 null이거나 크기가 0인 경우, -999999를 반환한다.
     반환타입 : int
     매개변수 : int[] arr - 최대값을 구할 배열

   ```java
   public class Q6_09 {
   	
   	public static int max(int[] arr) {
   		int max = 0;
   		if(arr == null || arr.length == 0)
   			return -999999;
   		
   		for(int i=0; i<arr.length; i++) {
   			if(max < arr[i]) {
   				max = arr[i];
   			}
   		}
   		return max;
   	}
   	
   	public static void main(String[] args) {
   		int[] data = { 3, 2, 9, 4, 7 };
   		System.out.println(java.util.Arrays.toString(data));
   		System.out.println("최대값:" + max(data));
   		System.out.println("최대값:" + max(null));
   		System.out.println("최대값:" + max(new int[] {})); // 크기가 0인 배열
   	}
   }
   ```

   - 실행결과

   ```java
   [3, 2, 9, 4, 7]
   최대값:9
   최대값:-999999
   최대값:-999999

10. 다음과 같이 정의된 메서드를 작성하고 테스트

    - 메서드명 : abs
      기 능 : 주어진 값의 절대값을 반환한다.
      반환타입 : int
      매개변수 : int value

    ```java
    public class Q6_10 {
    	
    	public static int abs(int value) {
    		return value >= 0 ? value : -value;
    	}
    	
    	public static void main(String[] args) {
    		int value = 5;
    		System.out.println(value + "의 절대값:" + abs(value));
    		value = -10;
    		System.out.println(value + "의 절대값:" + abs(value));
    	}
    }
    ```

    - 실행결과

    ```java
    5의 절대값:5
    -10의 절대값:10