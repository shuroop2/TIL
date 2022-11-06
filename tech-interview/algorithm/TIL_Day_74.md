# TIL_Day_74

> 2022년 11월 06일

## 선택 정렬(Selection Sort)

> 선택 정렬은 제자리 정렬 알고리즘의 하나이다. 비교하는 것이 상수 시간에 이루어진다는 가정 아래, n개의 주어진 리스트를 이와 같은 방법으로 정렬하는 데에는 O(n²) 만큼의 시간이 걸린다. 선택 정렬은 알고리즘이 단순하며 사용할 수 있는 메모리가 제한적인 경우에 사용 시 성능 상의 이점이 있다.

### 선택 정렬의 특징

- 시간 복잡도는 n²
- 자료 이동 횟수가 미리 정해져있다.
- 값이 같은 레코드가 있을 경우 **상대적인 위치가 변경**될 수 있고 이러한 이유로 **안정성을 만족하지 않는다.**

### 알고리즘

1. 주어진 리스트 중에서 최솟값을 찾는다.
2. 그 최솟값을 맨 앞 값과 교체한다.
3. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.

### JAVA로 구현

```java
import java.util.*;

public class Main {
	public static void selection_sort(int a[]) {
		for (int i=0; i<a.length; i++) {
			int idx = i;
			for (int j=i; j<a.length; j++) {
				if(a[idx] > a[j])
                    idx = j;
			}
			int tmp = a[idx];
			a[idx] = a[i];
			a[i] = tmp;
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int arr[] = {9,1,6,8,4,3,2,0};
		
		System.out.println("정렬 전");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
		
		selection_sort(arr);
		
		System.out.println("정렬 후");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
	}
}
```

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fvf8Ah%2Fbtrh0DAh1pC%2FaitMAGBcAzzMUQtQG172J0%2Fimg.png)