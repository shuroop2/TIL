# TIL_Day_73

> 2022년 11월 05일

## 거품 정렬(Bubble Sort)

> 거품 정렬은 두 인접한 원소를 검사하여 정렬하는 방법이다. 시간 복잡도가 O(n²)로 상당히 느리지만, 코드가 단순하기 때문에 자주 사용된다. 원소의 이동이 거품이 수면으로 올라오는 듯한 모습을 보이기 때문에 지어진 이름이다. 양방향으로 번갈아 수행하면 칵테일 정렬이 된다.

### 알고리즘

- 앞에서부터 현재 원소와 다음 원소의 크기를 비교
- 현재 원소가 다음 원소보다 클 시 교환
- 다음 원소로 이동하여 1번부터 다시 진행

```
arr[1]와 arr[2], arr[2]와 arr[3], ...... , arr[n-1]와 arr[n]을 비교하고 그다음엔
arr[1]와 arr[2], arr[2]와 arr[3], ...... , arr[n-2]와 arr[n-1] 비교,
arr[1]와 arr[2], arr[2]와 arr[3], ...... , arr[n-3]와 arr[n-2] 비교,

...

arr[1]와 arr[2] 비교 후 종료되는 방식이다.
```

#### JAVA로 구현

```java
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 길이 입력 : ");
		int N = sc.nextInt();
		
		int arr[] = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
        }
		
		// Bubble Sort
		for (int i=N-1; i>=0; i--) {
			for (int j=0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		// 출력
		System.out.println("오름차순으로 정렬됨");
		for (int i=0; i<N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
```

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FErGUw%2FbtrhOIhmn4w%2FL453dZ438uFIdYQKCggKX1%2Fimg.png)