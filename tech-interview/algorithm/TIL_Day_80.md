# TIL_Day_80

> 2022년 11월 11일

## 계수 정렬(Counting Sort)

> 계수 정렬 또는 카운팅 소트는 컴퓨터 과학에서 정렬 알고리즘의 하나로서, 작은 양의 정수들인 키에 따라 객체를 수집하는 것, 즉 정수 정렬 알고리즘의 하나이다. 구별되는 키 값들을 소유하는 객체의 수를 계수하고 출력 시퀀스에 각 키 값의 위치를 결정하기 위한 해당 계수에 전위합을 적용함으로써 동작한다. 실행 시간은 항목의 수, 그리고 최대 키 값과 최소 키 값의 차이에 선형적이므로 키의 다양성이 항목의 수보다 상당히 크지 않은 상황에서 직접 사용하는 데에만 적절하다. 더 큰 키들을 더 효율적으로 처리할 수 있는 다른 정렬 알고리즘인 기수 정렬의 서브루틴에 종종 사용된다.

### 계수 정렬 알고리즘

1. 정렬할 배열 내의 원소 중 최댓값(max)을 구한다.
2. 각 값의 개수를 세기 위한 (max+1) 크기의 배열(counting_arr)을 만든다.
3. 정렬할 배열 내의 원소의 값이 counting_arr의 인덱스와 동일하면 해당 인덱스의 값을 +1 증가
4. counting_arr을 정렬하고 싶은 순서로, counting_arr의 값이 1 이상인 인덱스에 대해, 차례대로 인덱스 값을 출력한다. 출력과 동시에 해당 counting_arr의 인덱스의 값을 하나 씩 감소

### 계수 정렬의 특징

- 최댓값과 최솟값을 알아야 쓸 수 있다.
- 안정 정렬이다.
- 시간 복잡도는 O(n+k)로 O(n) 또는 O(k)를 갖는다. (n은 input의 개수, k는 input으로 들어온 n의 범위)
  - n이 k보다 클 수 있고, k가 n보다 클 수 있기 때문
- 공간 복잡도는 O(k)로 배열에서 등장하는 최댓값인 k 만큼의 Counting 배열을 추가로 만들어야 한다.
- 배열 사이즈인 n 만큼 탐색할 때, 증가시켜주는 Counting 배열의 크기가 크다. 즉 메모리 낭비가 심한 단점이 있다.
- 점수나 알파벳 같은 좁은 범위의 데이터를 정렬할 때 많이 쓰인다.

### JAVA로 구현

```java
import java.util.*;

public class Main {
	static void countingSort(int[] arr) {
		//단점 : 카운팅 배열의 사이즈 범위를 가능한 값의 범위 만큼 설정함
		int max = 123;
		int counting[] = new int[max+1];
		
		//배열의 값을 카운팅 배열에 넣어서 1씩 증가시키기
		for(int i=0; i<arr.length; i++) {
			counting[arr[i]]++;
		}
		
		int idx = 0;
		for(int i=0; i<counting.length; i++) {
			while(counting[i]-- > 0) {
				arr[idx++] = i;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr= {22, 16, 123, 6, 1, 23, 23, 5, 4, 2, 3, 13, 25, 78, 97, 65, 52, 45};
		countingSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
```

![](https://mblogthumb-phinf.pstatic.net/MjAyMDA2MjhfODgg/MDAxNTkzMzU0MDM3NjUw.d_ipMNxXlDCYupuqotXjHu_AMLMaeaHRbv23NLNygBsg.m5_DN-qYtN8tAaPgfJo_Zpc58EL8TGghMFHZgruP7Z0g.PNG.adamdoha/image.png?type=w800)