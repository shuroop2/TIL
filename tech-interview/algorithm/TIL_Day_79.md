# TIL_Day_79

> 2022년 11월 10일

## 기수 정렬(Radix Sort)

> 기수 정렬은 기수 별로 비교 없이 수행하는 정렬 알고리즘이다. 기수로는 정수, 낱말, 천공카드 등 다양한 자료를 사용할 수 있으나 크기가 유한하고 사전순으로 정렬할 수 있어야 한다. 버킷 정렬의 일종으로 취급되기도 한다.

### 기수 정렬 알고리즘

1. 가장 큰 자릿수 값 구하기
2. 가장 작은 자릿수부터, 가장 큰 자릿수까지 해당 자릿수만을 보고 계수 정렬(Counting Sort)를 진행한다.
   1. 가장 작은 1의 자리 숫자만 비교하여 정렬
   2. 10의 자리 숫자만 비교하여 정렬
   3. ...
   4. 가장 큰 자릿수인 N의 자릿수를 기준으로 정렬

### 기수 정렬의 특징

- 시간 복잡도는 O(dn)
  - d는 정렬할 숫자의 자릿수
- 문자열, 정수 정렬이 가능하다. (자릿수를 비교해서 정렬하는 방식)
- 같은 두 수가 있어도 순서가 섞이지 않는 안정 정렬이다.
- 빠른 성능
- 자릿수가 없는 것은 정렬할 수가 없다. (부동 소수점과 같은 것)
- 중간 결과를 저장할 bucket 공간이 필요하다.

### JAVA로 구현

```java
import java.util.*;

public class Main {
	public static void countSort(int[] arr, int n, int exp) {
		int buffer[] = new int[n];
		int counting[] = new int[10];
		
		//exp의 자릿수에 해당하는 count를 증가
		for(int i=0; i<n; i++)
			counting[(arr[i] / exp) % 10]++;
        
		//누적합을 이용하여, 원소가 들어갈 위치를 미리 계산
		for(int i=1; i<=9; i++)
            counting[i] += counting[i - 1];
		
		//위와 같은 방식으로 하면, 임의의 순서대로 들어오는 값도 의도한 자리에 위치하도록 할 수 있다.
		for(int i=n-1; i>=0; i--) {
			//현재 원소의 해당 자리수의 값을 확인
			int res = arr[i] / exp;
			//10으로 나눈 나머지를 가져오는 이유는 만약 232라는 숫자에서
			//10의 자리수는 3이므로, 나눈 뒤 가장 마지막의 숫자만을 가져오기 위함
			res %= 10;
			//이 값이 들어갈 마지막 위치를 가져온다.
			int idx = counting[res];
			//인덱스는 0부터 시작하므로, -1을 해주었다.
			buffer[idx - 1] = arr[i];
			//하나를 배치하였으므로, 개수를 하나 빼준다.
			counting[res]--;
		}
		
		for(int i=0; i<n; i++)
			arr[i] = buffer[i];
	}
	
	public static void radixSort(int[] arr, int n) {
		//최댓값 자리만큼 돌기
		int max=0;
		for(int i=0; i<n; i++)
            max = Math.max(max,arr[i]);
		
		//최댓값을 나눴을 때, 0이 나오면 모든 숫자가 i 아래
		for(int i=1; max/i>0; i*=10) {
			System.out.println(i + "의 자리에 대해 정렬합니다.");
			countSort(arr,n,i);
			System.out.println("정렬 결과");
			System.out.println(Arrays.toString(arr));
		}
	}
	public static void main(String[] args) {
		int[] arr= {222, 96, 123, 1, 23, 5, 2, 17, 28};
		radixSort(arr, arr.length);
		System.out.println("최종 정렬 결과");
		System.out.println(Arrays.toString(arr));
	}
}
```

![](https://mblogthumb-phinf.pstatic.net/MjAyMDA2MjlfMTQ5/MDAxNTkzMzc0ODAyNzM5.L0cgg2Owigrch_kJhts6YKhbWVgNzpy-alA15fZLXlYg.nvZogCEayKmo76TGz40y8xqR31EDOWjOIynrwpReDhQg.PNG.adamdoha/image.png?type=w800)