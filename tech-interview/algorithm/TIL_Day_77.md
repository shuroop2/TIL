# TIL_Day_77

> 2022년 11월 07일

## 합병 정렬(Merge Sort)

> 합병 정렬 또는 병합 정렬은 O(nlogn) 비교 기반 정렬 알고리즘이다. 일반적인 방법으로 구현했을 때 이 정렬은 안정 정렬에 속하며, 분할 정복 알고리즘의 하나이다.

### 합병 정렬 알고리즘

#### n-way 합병 정렬

1. 정렬되지 않은 리스트를 각각 하나의 원소만 포함하는 n개의 부분 리스트로 분할한다. (한 원소만 든 리스트는 정렬된 것과 같으므로)
2. 부분 리스트가 하나만 남을 때까지 반복해서 병합하며 정렬된 부분 리스트를 생성한다. 마지막 남은 부분 리스트가 정렬된 리스트이다.

#### 하향식 2-way 합병 정렬

1. 리스트의 길이가 1 이하이면 이미 정렬된 것으로 본다. 그렇지 않은 경우에는
2. 분할(divide) : 정렬되지 않은 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
3. 정복(conquer) : 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
4. 결합(combine) : 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다. 이 때 정렬 결과가 임시 배열에 저장된다.
5. 복사(copy) : 임시 배열에 저장된 결과를 원래 배열에 복사한다.

### 합병 정렬의 특징

- 시간 복잡도는 데이터의 분포에 상관없이 항상 O(nlogn)을 고정
  - 배열의 요소가 1 개가 될 때까지 분할 -> n번 호출
  - 배열을 반 씩 분할해가며 정렬 -> logn 만큼 호출
- 안정 정렬
- 데이터가 배열로 구성된 경우 추가적인 임시 배열 필요
- 데이터 크기가 큰 경우 비효율적

### JAVA로 구현

```java
package ex_packege;

import java.util.*;

public class Main {
	public static int tmp[] = new int[8];

	public static void merge(int arr[], int left, int mid, int right) {
		int i, j, k;
		i = left; // 정렬된 왼쪽 리스트에 대한 인덱스
		j = mid + 1; // 정렬된 오른쪽 리스트에 대한 인덱스
		k = left; // 정렬될 리스트에 대한 인덱스

		// 분할 정렬된 list의 합병
		while(i <= mid && j <= right) {
			if(arr[i] <= arr[j])
				tmp[k++] = arr[i++];
			else
				tmp[k++] = arr[j++];
		}

		// 남아있는 값 넣기
		if(i > mid) {
			for(int l=j; l<=right; l++) {
				tmp[k++] = arr[l];
			}
		} else { // (j > right)
			for(int l=i; l<=mid; l++) {
				tmp[k++] = arr[l];
			}
		}

		// 임시배열 tmp를 arr로 복사
		for(int l=left; l<=right; l++) {
			arr[l] = tmp[l];
		}
	}

	public static void mergeSort(int arr[], int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int arr[] = { 6, 5, 3, 1, 8, 7, 2, 4 };

		mergeSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));
	}
}
```

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbrMoHO%2FbtrnEJJCo6K%2FKwZ2nhOuJw3FxgmqRPA4KK%2Fimg.png)