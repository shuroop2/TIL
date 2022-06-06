# Java_Example_Object_oriented

> 2022년 06월 06일

1. 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck클래스)을 정의한 것이다. 섯다카드 20장을 담는 SutdaCard배열을 초기화하시오. 단, 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고, 숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다. 즉, SutdaCard의 인스턴스변수 isKwang의 값이 true이어야 한다.

   ```java
   class SutdaDeck {
   	final int CARD_NUM = 20;
   	SutdaCard[] cards = new SutdaCard[CARD_NUM];
   
   	SutdaDeck() {
   		for (int i = 0; i < cards.length; i++) {
   			int num = i % 10 + 1;
   			boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
   			
   			cards[i] = new SutdaCard(num, isKwang);
   		}
   	}
   }
   
   class SutdaCard {
   	int num;
   	boolean isKwang;
   
   	SutdaCard() {
   		this(1, true);
   	}
   
   	SutdaCard(int num, boolean isKwang) {
   		this.num = num;
   		this.isKwang = isKwang;
   	}
   
   	public String toString() {
   		return num + (isKwang ? "K" : "");
   	}
   }
   
   public class Q7_01 {
   	public static void main(String args[]) {
   		SutdaDeck deck = new SutdaDeck();
   		
   		for (int i = 0; i < deck.cards.length; i++) {
   			System.out.print(deck.cards[i] + ",");
   		}
   	}
   }
   ```

   -  실행결과

   ```java
   1K,2,3K,4,5,6,7,8K,9,10,1,2,3,4,5,6,7,8,9,10,

2. 문제7-1의 SutdaDeck클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트

   - 메서드명 : shuffle
     기 능 : 배열 cards에 담긴 카드의 위치를 뒤섞는다.(Math.random()사용)
     반환타입 : 없음
     매개변수 : 없음
   - 메서드명 : pick
     기 능 : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
     반환타입 : SutdaCard
     매개변수 : int index - 위치
   - 메서드명 : pick
     기 능 : 배열 cards에서 임의의 위치의 SutdaCard를 반환한다.(Math.random()사용)
     반환타입 : SutdaCard
     매개변수 : 없음

   ```java
   class SutdaDeck {
   	final int CARD_NUM = 20;
   	SutdaCard[] cards = new SutdaCard[CARD_NUM];
   
   	SutdaDeck() {
   		for (int i = 0; i < cards.length; i++) {
   			int num = i % 10 + 1;
   			boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
   			cards[i] = new SutdaCard(num, isKwang);
   		}
   	}
   
   	void shuffle() {
   		for (int i = 0; i < cards.length; i++) {
   			int rNum = (int) (Math.random() * cards.length);
   
   			SutdaCard tmp = cards[i];
   			cards[i] = cards[rNum];
   			cards[rNum] = tmp;
   		}
   	}
   
   	SutdaCard pick(int index) {
   		if (0 > index || index > CARD_NUM - 1)
   			return null;
   
   		return cards[index];
   	}
   
   	SutdaCard pick() {
   		int rNum = (int) (Math.random() * cards.length);
   		return pick(rNum);
   	}
   }
   
   class SutdaCard {
   	int num;
   	boolean isKwang;
   
   	SutdaCard() {
   		this(1, true);
   	}
   
   	SutdaCard(int num, boolean isKwang) {
   		this.num = num;
   		this.isKwang = isKwang;
   	}
   
   	public String toString() {
   		return num + (isKwang ? "K" : "");
   	}
   }
   
   public class Q7_02 {
   	public static void main(String args[]) {
   		SutdaDeck deck = new SutdaDeck();
   
   		System.out.println(deck.pick(0));
   		System.out.println(deck.pick());
   		deck.shuffle();
   
   		for (int i = 0; i < deck.cards.length; i++) {
   			System.out.print(deck.cards[i] + ",");
   		}
   
   		System.out.println();
   		System.out.println(deck.pick(0));
   	}
   }
   ```

   - 실행결과

   ```java
   1K
   7
   2,6,10,1K,7,3,10,5,7,8,5,1,2,9,6,9,4,8K,4,3K,
   2
   ```

3. MyTv2클래스의 멤버변수 isPowerOn, channel, volume을 클래스 외부에서 접근할 수 없도록 제어자를 붙이고 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록 getter와 setter메서드를 추가하고 이전 채널(previous channel)로 이동하는 기능의 메서드를 추가해서 실행결과와 같은 결과를 얻도록 하시오

   - 메서드명 : gotoPrevChannel
     기 능 : 현재 채널을 이전 채널로 변경한다.
     반환타입 : 없음
     매개변수 : 없음

   ```java
   class MyTv2 {
   	private boolean isPowerOn;
   	private int channel;
   	private int volume;
   	private int prevChannel;
   	final int MAX_VOLUME = 100;
   	final int MIN_VOLUME = 0;
   	final int MAX_CHANNEL = 100;
   	final int MIN_CHANNEL = 1;
   	
   	public boolean isPowerOn() {
   		return isPowerOn;
   	}
   	public void setPowerOn(boolean isPowerOn) {
   		this.isPowerOn = isPowerOn;
   	}
   	
   	public int getChannel() {
   		return channel;
   	}
   	public void setChannel(int channel) {
   		if(channel > MAX_CHANNEL || channel < MIN_CHANNEL)
   			return;
   		prevChannel = this.channel;
   		this.channel = channel;
   	}
   	public int getVolume() {
   		return volume;
   	}
   	public void setVolume(int volume) {
   		if(volume > MAX_VOLUME || volume < MIN_VOLUME)
   			return;
   		this.volume = volume;
   	}
   	public void gotoPrevChannel() {
   		setChannel(prevChannel);
   	}
   }
   
   public class Q7_03 {
   	public static void main(String args[]) {
   		MyTv2 t = new MyTv2();
   		t.setChannel(10);
   		System.out.println("CH:" + t.getChannel());
   		t.setVolume(20);
   		System.out.println("VOL:" + t.getVolume());
   		
   		t.setChannel(10);
   		System.out.println("CH:"+t.getChannel());
   		t.setChannel(20);
   		System.out.println("CH:"+t.getChannel());
   		t.gotoPrevChannel();
   		System.out.println("CH:"+t.getChannel());
   		t.gotoPrevChannel();
   		System.out.println("CH:"+t.getChannel());
   	}
   }
   ```

   - 실행결과

   ```java
   CH:10
   CH:20
   CH:10
   CH:20
   ```

4. 다음과 같은 실행결과를 얻도록 코드를 완성

   - 메서드명 : action
     기 능 : 주어진 객체의 메서드를 호출한다. DanceRobot인 경우, dance()를 호출하고, SingRobot인 경우, sing()을 호출하고, DrawRobot인 경우, draw()를 호출한다.
     반환타입 : 없음
     매개변수 : Robot r - Robot인스턴스 또는 Robot의 자손 인스턴스

   ```java
   public class Q7_04 {
   
   	public static void action(Robot r) {
   		if (r instanceof DanceRobot) {
   			DanceRobot dr = (DanceRobot) r;
   			dr.dance();
   		} else if (r instanceof SingRobot) {
   			SingRobot sr = (SingRobot) r;
   			sr.sing();
   		} else if (r instanceof DrawRobot) {
   			DrawRobot dr = (DrawRobot) r;
   			dr.draw();
   		}
   	}
   
   	public static void main(String[] args) {
   		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
   		for (int i = 0; i < arr.length; i++)
   			action(arr[i]);
   	}
   }
   
   class Robot {
   }
   
   class DanceRobot extends Robot {
   	void dance() {
   		System.out.println("춤을 춥니다.");
   	}
   }
   
   class SingRobot extends Robot {
   	void sing() {
   		System.out.println("노래를 합니다.");
   	}
   }
   
   class DrawRobot extends Robot {
   	void draw() {
   		System.out.println("그림을 그립니다.");
   	}
   }
   ```

   - 실행결과

   ```java
   춤을 춥니다.
   노래를 합니다.
   그림을 그립니다.

5. 다음은 물건을 구입하는 사람을 정의한 Buyer클래스이다. 이 클래스는 멤버변수로 돈(money)과 장바구니(cart)를 가지고 있다. 제품을 구입하는 기능의 buy메서드와 장바구니에 구입한 물건을 추가하는 add메서드, 구입한 물건의 목록과 사용금액, 그리고 남은 금액을 출력하는 summary메서드를 완성하시오.

   - 메서드명 : buy
     기 능 : 지정된 물건을 구입한다. 가진 돈(money)에서 물건의 가격을 빼고, 장바구니(cart)에 담는다.
     만일 가진 돈이 물건의 가격보다 적다면 바로 종료한다.
     반환타입 : 없음
     매개변수 : Product p - 구입할 물건
   2. 메서드명 : add
   기 능 : 지정된 물건을 장바구니에 담는다.
   만일 장바구니에 담을 공간이 없으면, 장바구니의 크기를 2배로 늘린 다음에 담는다.
   반환타입 : 없음
   매개변수 : Product p - 구입할 물건
   3. 메서드명 : summary
   기 능 : 구입한 물건의 목록과 사용금액, 남은 금액을 출력한다.
   반환타입 : 없음
   매개변수 : 없음

   ```java
   public class Q7_04 {
   	public static void main(String args[]) {
   		Buyer b = new Buyer();
   		b.buy(new Tv());
   		b.buy(new Computer());
   		b.buy(new Tv());
   		b.buy(new Audio());
   		b.buy(new Computer());
   		b.buy(new Computer());
   		b.buy(new Computer());
   		b.summary();
   	}
   }
   
   class Buyer {
   	int money = 1000;
   	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
   	int i = 0; // Product배열 cart에 사용될 index
   
   	void buy(Product p) {
   		// (1) 아래의 로직에 맞게 코드를 작성하시오. 
   		
   		// 1.1 가진 돈과 물건의 가격을 비교해서 가진 돈이 적으면 메서드를 종료한다. 
   		if(money < p.price) {
   			System.out.println("잔액이 부족하여 " + p + "을/를 살수 없습니다.");
   			return;
   		}
   		// 1.2 가진 돈이 충분하면, 제품의 가격을 가진 돈에서 빼고 
   		money -= p.price;
   		// 1.3 장바구니에 구입한 물건을 담는다.(add메서드 호출)
   		add(p);
   	}
   
   	void add(Product p) {
   		// (2) 아래의 로직에 맞게 코드를 작성하시오. 
   		
   		//  1.1 i의 값이 장바구니의 크기보다 같거나 크면 
   		if(i >= cart.length) {
   		//  	1.1.1 기존의 장바구니보다 2배 큰 새로운 배열을 생성한다.
   			Product[] tmp = new Product[cart.length*2];
   		//  	1.1.2 기존의 장바구니의 내용을 새로운 배열에 복사한다.
   			System.arraycopy(cart, 0, tmp, 0, cart.length);
   		//  	1.1.3 새로운 장바구니와 기존의 장바구니를 바꾼다.
   			cart = tmp;
   		}
   		//  1.2 물건을 장바구니(cart)에 저장한다. 그리고 i의 값을 1 증가시킨다.
   		cart[i++]=p;
   	} // add(Product p)
   
   	void summary() {
   		// (3) 아래의 로직에 맞게 코드를 작성하시오. 
   		String list = "";
   		int sum = 0;
   		// 1.1 장바구니에 담긴 물건들의 목록을 만들어 출력한다. 
   		for(int i=0; i<cart.length; i++) {
   			list += cart[i] + ", ";
   		// 1.2 장바구니에 담긴 물건들의 가격을 모두 더해서 출력한다. 
   			sum += cart[i].price;
   		}
   		// 1.3 물건을 사고 남은 금액(money)를 출력한다.
   		System.out.println("구입한 물건 : " + list);
   		System.out.println("사용한 금액 : " + sum);
   		System.out.println("남은 금액 : " + money);
   	} // summary()
   }
   
   class Product {
   	int price; // 제품의 가격
   
   	Product(int price) {
   		this.price = price;
   	}
   }
   
   class Tv extends Product {
   	Tv() {
   		super(100);
   	}
   
   	public String toString() {
   		return "Tv";
   	}
   }
   
   class Computer extends Product {
   	Computer() {
   		super(200);
   	}
   
   	public String toString() {
   		return "Computer";
   	}
   }
   
   class Audio extends Product {
   	Audio() {
   		super(50);
   	}
   
   	public String toString() {
   		return "Audio";
   	}
   }
   ```

   - 실행결과

   ```java
   잔액이 부족하여 Computer을/를 살수 없습니다.
   구입한 물건:Tv,Computer,Tv,Audio,Computer,Computer,
   사용한 금액:850
   남은 금액:150

6. 아래는 도형을 정의한 Shape클래스이다. 이 클래스를 조상으로 하는 Circle클래스와 Rectangle클래스를 작성하시오. 이 때, 생성자도 각 클래스에 맞게 적절히 추가해야한다.

   - 클래스명 : Circle
     조상클래스 : Shape
     멤버변수 : double r - 반지름
   - 클래스명 : Rectangle
     조상클래스 : Shape
     멤버변수 : double width - 폭
     double height - 높이
     - 메서드명 : isSquare
       기 능 : 정사각형인지 아닌지를 알려준다.
       반환타입 : boolean
       매개변수 : 없음

   ```java
   abstract class Shape {
   	Point p;
   
   	Shape() {
   		this(new Point(0, 0));
   	}
   
   	Shape(Point p) {
   		this.p = p;
   	}
   
   	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드
   
   	Point getPosition() {
   		return p;
   	}
   
   	void setPosition(Point p) {
   		this.p = p;
   	}
   }
   
   class Circle extends Shape {
   	double r;
   
   	public Circle(double r) {
   		this.r = r;
   	}
   
   	@Override
   	double calcArea() {
   		return r * r * Math.PI;
   	}
   }
   
   class Rectangle extends Shape {
   	double width;
   	double height;
   
   	public Rectangle(double width, double height) {
   		this.width = width;
   		this.height = height;
   	}
   
   	@Override
   	double calcArea() {
   		return width * height;
   	}
   
   	public boolean isSquare() {
   		return (width == 0 || height == 0) && (width == height);
   	}
   }
   
   class Point {
   	int x;
   	int y;
   
   	Point() {
   		this(0, 0);
   	}
   
   	Point(int x, int y) {
   		this.x = x;
   		this.y = y;
   	}
   
   	public String toString() {
   		return "[" + x + "," + y + "]";
   	}
   }
   ```

7. 문제 7-6에서 정의한 클래스들의 면적을 구하는 메서드를 작성하고 테스트

   - 메서드명 : sumArea
     기 능 : 주어진 배열에 담긴 도형들의 넓이를 모두 더해서 반환한다.
     반환타입 : double
     매개변수 : Shape[] arr

   ```java
   public class Q7_07 {
   	
   	public static double sumArea(Shape[] arr) {
   		double sum = 0;
   		
   		for(int i=0; i<arr.length; i++) {
   			sum += arr[i].calcArea();
   		}
   		
   		return sum; 
   	}
   	
   	public static void main(String[] args) {
   		Shape[] arr = { new Circle(5.0), new Rectangle(3, 4), new Circle(1) };
   		System.out.println("면적의 합:" + sumArea(arr));
   	}
   }
   ```
   
   - 실행결과
   
   ```java
   면적의 합:93.68140899333463
   ```
   
8. Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.
   ```java
   class Outer {
   	class Inner {
   		int iv = 100;
   	}
   }
   
   public class Q7_08 {
   	public static void main(String[] args) {
   		Outer outer = new Outer();
   		Outer.Inner inner = outer.new Inner();
   		System.out.println(inner.iv);
   	}
   }
   ```
   
   - 실행결과
   
   ```java
   100
   ```
   
9. Outer2클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.

   ```java
   class Outer2{
   	static class Inner {
   		int iv = 200;
   	}
   }
   public class Q7_09 {
   	public static void main(String[] args) {
   		Outer2.Inner inner = new Outer2.Inner();
   		System.out.println(inner.iv);
   	}
   }
   ```
   
   - 실행결과
   
   ```java
   200
   ```
   
10. 다음과 같은 실행결과를 얻도록 코드를 완성

   ```java
   class Outer3 {
   	int value = 10;
   
   	class Inner {
   		int value = 20;
   		
   		void method1() {
   			int value = 30;
   			
   			System.out.println(value);
   			System.out.println(this.value);
   			System.out.println(Outer3.this.value);
   		}
   	} // Inner클래스의 끝
   } // Outer클래스의 끝
   
   class Q7_10 {
   	public static void main(String args[]) {
   		Outer3 outer = new Outer3();
   		Outer3.Inner inner = outer.new Inner();
   		inner.method1();
   	}
   }
   ```

   - 실행결과

   ```java
   30
   20
   10
   ```