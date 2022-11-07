# TIL_Day_75

> 2022년 11월 07일

## 삽입 정렬(Insertion Sort)

> 삽입 정렬은 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여, 자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘이다.

### 삽입 정렬의 특징

- 시간 복잡도는 최선의 경우에는 n, 최악의 경우에는 n²
- 알고리즘 자체가 간단하며 안정 정렬(Stable Sort)임
- 배열이 거의 정렬되어 있는 경우엔 효율적
- 비교적 많은 배열 값들의 이동을 포함하므로 배열 길이가 길어질수록 비효율적

### JAVA로 구현

```java
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int num[] = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		System.out.println("정렬 전");
		for(int i=0; i<N; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();

		// 삽입 정렬
		for(int i=1; i<N; i++) {
			int target = num[i];
			int j = i - 1;
			while (j >= 0 && target < num[j]) {
				num[j+1] = num[j];
				j--;
			}
			num[j+1] = target;
		}
		
		System.out.println("정렬 후");
		for(int i=0; i<N; i++) {
			System.out.print(num[i] + " ");
		}
	}
}
```

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FvcIYV%2Fbtrle6s47lN%2FhT6ofNWUGFwGnSTN2UEFkK%2Fimg.png)