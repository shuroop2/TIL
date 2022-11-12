# TIL_Day_81

> 2022년 11월 12일

## 이진 탐색(Binary Search)

> 이진 탐색은 오름차순으로 정렬된 리스트에서 특정한 값의 위치를 찾는 알고리즘이다. 처음 중간의 값을 임의의 값으로 선택하여, 그 값과 찾고자 하는 값의 크고 작음을 비교하는 방식을 채택하고 있다. 처음 선택한 중앙값이 만약 찾는 값보다 크면 그 값은 새로운 최댓값이 되며, 작으면 그 값은 새로운 최솟값이 된다.

### 이진 탐색 알고리즘

1. 배열의 중간 값을 가져온다.
2. 중간 값과 검색 값을 비교한다.
   1. 중간 값이 검색 값과 같다면 종료 (mid = key)
   2. 중간 값보다 검색 값이 크다면 중간 값 기준 배열의 오른쪽 구간을 대상으로 탐색 (mid < key)
   3. 중간 값보다 검색 값이 작다면 중간 값 기준 배열의 왼쪽 구간을 대상으로 탐색 (mid > key)
3. 값을 찾거나 간격이 비어있을 때까지 반복

### 이진 탐색의 특징

- 시간 복잡도는 O(logn)
- 정렬된 리스트에만 사용할 수 있음
- 검색이 반복될 때 마다 목표 값을 찾을 확률은 두 배가 되므로 속도가 빠름

### JAVA로 구현

```java
public class Main {
	// 재귀적 탐색
	public static int binarySearch1(int[] arr, int key, int low, int high) {
		int mid;
		
		if(low <= high) {
			mid = (low + high) / 2;
		
			if(key == arr[mid]) // 탐색 성공 
				return mid;
			else if(key < arr[mid])
				return binarySearch1(arr, key ,low, mid-1); // 왼쪽 부분 탐색 
			else
				return binarySearch1(arr, key, mid+1, high); // 오른쪽 부분 탐색 
		}
		return -1; // 탐색 실패 
	}
	
	// 반복적 탐색
	public static int binarySearch2(int[] arr, int key, int low, int high) {
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			
			if(key == arr[mid])
				return mid;
			else if(key < arr[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1; // 탐색 실패 
	}
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};
		System.out.println("1. 순환 호출을 이용한 이진 탐색");
		System.out.println(binarySearch1(arr, 5, 0, arr.length-1)); // 2
		
		System.out.println("\n2. 반복을 이용한 이진 탐색");
		System.out.println(binarySearch2(arr, 20, 0, arr.length-1)); // 6
		
	}
}