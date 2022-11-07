# TIL_Day_76

> 2022년 11월 07일

## 퀵 정렬(Quick Sort)

> 퀵 정렬은 찰스 앤터니 리처드 호어가 개발한 정렬 알고리즘이다. 다른 원소와의 비교만으로 정렬을 수행하는 비교 정렬에 속한다. 분할 정복 알고리즘을 사용하며 평균적으로 매우 빠른 수행 속도를 자랑하는 정렬 방법이다.

### 퀵 정렬의 특징

- 시간 복잡도는 최선의 경우에는 O(nlogn), 최악의 경우에는O(n²)
- 평균적으로 가장 빠른 정렬 알고리즘
- 정렬하고자 하는 배열 내에서 교환하는 방식이므로 별도의 메모리 공간을 필요로 하지 않음
- 불안정 정렬(Unstable Sort)
- 정렬된 배열에 대해서는 불균형 분할에 의해 오히려 수행 시간이 더 걸림

### 퀵 정렬 알고리즘

1. 배열 가운데서 하나의 원소를 고른다. (고른 원소를 피벗이라 함)
2. 피벗 앞에서 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록 피벗 기준으로 배열을 둘로 나눈다. (분할 정복)
3. 분할된 두 개의 배열에 대해 재귀적으로 1, 2번을 반복한다.

### JAVA로 구현

```java
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int arr[] = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2 };

		System.out.println("정렬 전");
		for(int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();

		quickSort(arr, 0, arr.length-1);
		
		System.out.println("정렬 후");
		for(int value : arr) {
			System.out.print(value + " ");
		}
	}

	public static void quickSort(int[] array, int left, int right) {
		if(left >= right)
			return;

		// 분할
		int pivot = partition(array, left, right);

		// 피벗은 제외한 2개의 부분 배열을 대상으로 순환 호출
		quickSort(array, left, pivot - 1); // 정복(Conquer)
		quickSort(array, pivot + 1, right); // 정복(Conquer)
	}
	
	public static int partition(int[] array, int left, int right) {
		int pivot = array[left]; // 가장 왼쪽값을 피벗으로 설정
		int i = left, j = right;

		while(i < j) {
			while(pivot < array[j]) {
				j--;
			}
			while(i < j && pivot >= array[i]) {
				i++;
			}
			swap(array, i, j);
		}
		array[left] = array[i];
		array[i] = pivot;

		return i;
	}

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
```

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FVWyiX%2FbtrlTlCYvaj%2F0CN8MfqO5bpadm4m7EFlI0%2Fimg.png)