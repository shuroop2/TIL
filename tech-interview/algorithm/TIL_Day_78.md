# TIL_Day_78

> 2022년 11월 08일

## 힙 정렬(Heap Sort)

> 힙 정렬이란 최대 힙 트리나 최소 힙 트리를 구성해 정렬을 하는 방법으로서, 내림차순 정렬을 위해서는 최소 힙을 구성하고 오름차순 정렬을 위해서는 최대 힙을 구성하면 된다.

### 힙 정렬 알고리즘

1. n개의 노드에 대한 완전 이진 트리를 구성한다. 이 때 루트 노드부터 부모노드, 왼쪽 자식노드, 오른쪽 자식노드 순으로 구성한다.
2. 최대 힙을 구성한다. 최대 힙이란 부모노드가 자식노드보다 큰 트리를 말하는데, 단말 노드를 자식노드로 가진 부모노드부터 구성하며 아래부터 루트까지 올라오며 순차적으로 만들어 갈 수 있다.
3. 가장 큰 수(루트에 위치)를 가장 작은 수와 교환한다.
4. 2와 3을 반복한다.

### 힙 정렬의 특징

- 시간 복잡도가 좋은 편이다.
  - 힙 트리의 전체 높이가 거의 log₂n(완전 이진 트리이므로)이므로 하나의 요소를 힙에 삽입하거나 삭제할 때 힙을 재정비하는 시간이 log₂n만큼 소요된다.
  - 요소의 개수가 n개 이므로 전체적으로 O(nlog₂n)의 시간이 걸린다.
- 힙 정렬이 가장 유용한 경우는 전체 자료를 정렬하는 것이 아니라 **가장 큰 값 몇 개만 필요할 때** 이다.

### JAVA로 구현

```java
public static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
}

public static void heapify(int[] arr, int parent, int size) {
    int temp_parent = parent;
    int left_child = parent * 2 + 1;
    int right_child = parent * 2 + 2;
    
    if(left_child < size && arr[temp_parent] > arr[left_child])
        temp_parent = left_child;
    if(right_child < size && arr[temp_parent] > arr[right_child])
        temp_parent = right_child;
    if(parent != temp_parent) {
        Swap(arr, parent, temp_parent);
        Heapify(arr, temp_parent, size);
    }
}

public static void heapSort(int[] arr) {
    int n = arr.length;
    
    // i의 초기값은 배열의 제일 끝 자식노드의 부모노드부터 시작(O(N)으로 수행)
    for(int i=n/2-1; i>=0; i--) {
        heapify(arr, i, n);
    }
    for(int i=n-1; i>0; i--) {
        swap(arr, 0, i);	// 루트 노드와 마지막 노드를 교환
        heapify(arr, 0, i);	// 루트 노드를 기준으로 다시 힙 속성을 만족하도록 구축
    }
}

public static void main(String[] args) {
    int[] arr = {7, 3, 22, 6, 2, 14, 1};
	
    heapSort(arr);
    
    System.out.println(Arrays.toString(arr));
}
```