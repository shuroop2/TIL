# TIL_Day_68

> 2022년 10월 11일

## 힙 (Heap)

> 힙(heap)은 이진 힙(binary heap)이라고도 하며, 최댓값 및 최솟값을 찾아내는 연산을 빠르게 하기 위해 고안된 완전 이진트리(complete binary tree)를 기본으로 한 자료 구조이다.

힙은 다음과 같은 속성을 가지고 있다.

1. 완전 이진트리(Complete Binary Tree) 이다.
2. 부모 노드의 키값과 자식 노드의 키값 사이에는 대소관계가 성립한다.
   - 키값 대소관계는 오로지 부모자식 간에만 성립되며 형제사이에는 대소관계가 정해지지 않음

### 힙의 종류

#### 최대 힙 (Max Heap)

- 부모 키값이 자식 노드 키값보다 큰 힙
- Key(parent) >= Key(child)
- 가장 큰 값이 루트 노드에 있음

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FyXt2a%2Fbtq7ddSvksp%2FabjtbzX0kb5mbKWHgS84d1%2Fimg.png)

#### 최소 힙 (Min Heap)

- 부모 키값이 자식 노드 키값보다 작은 힙
- Key(parent) <= Key(child)
- 가장 작은 값이 루트 노드에 있음

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FLulip%2Fbtq66t3mygU%2FXhwpPwIBf7gl580EV5cLa0%2Fimg.png)

### 힙 표현

- 힙은 완전 이진트리이다. 힙은 일반적으로 배열로 표현한다.

- 개발 편의성과 가독성 때문에 배열 인덱스 1부터 사용한다.

- 루트 노드의 인덱스 i가 1인 경우 다음과 같은 속성이 있다.

  - 노드 i의 부모 노드 인덱스 : [i/2]
  - 노드 i의 왼쪽 자식 노드 인덱스 : 2*i
  - 노드 i의 오른쪽 자식 노드 인덱스 : 2*i + 1

  ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbRK3pg%2Fbtq67NfRt99%2FIkS2zcUeZp34sTDnSMHK41%2Fimg.png)

### 힙 연산

#### Heapify

> heapify는 이진트리에서 힙 속성을 유지하는 작업을 한다. 위에서 아래로 내려가면서 작업 한다.

- max heap에서 heapify의 작업은 다음과 같다.

  1. 요소 값과 자식 노드 값을 비교
  2. 만약 자식 노드 값이 크다면 왼쪽 오른쪽 자식 중 가장 큰 값으로 교환
  3. 힙 속성이 유지 될 때까지 1,2번 과정을 반복

- 값이 8인 노드에 대해 heapify를 수행하는 예시

  ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FY4nXi%2Fbtq7bht5z6Q%2FmXCNuinbNgPwx9Y399Slo0%2Fimg.png)

  1. 첫 번째 노드 값(8)이 자식보다 작으므로 자식 중 가장 큰 오른쪽 자식 값(20)과 교환
  2. 값이 8인 노드에서 heapify를 다시 시작. 8이 왼쪽 자식 노드 13보다 작기 때문에 교환
  3. 이제 8이 leaf node이므로 heapify를 추가로 호출해도 힙 구조에 영향을 주지 않음

##### 구현

```c
void max_heapify (int arr[], int i)
{
  int largest = i;  
  int left = 2*i;				//left child
  int right = 2*i + 1;			//right child
  
  // 현재 요소 i와 자식 노드의 값을 비교
  if(left <= size && arr[left] > arr[i] )
    largest = left;  
  if(right <= size && arr[right] > arr[largest] )
    largest = right;
  
  // 자식 노드의 값이 더 크다면 교환하고 교환된 자식 노드부터 heapify 진행
  if(largest != i ) {
    swap (arr[i] , arr[largest]);
    max_heapify (h, largest);
  } 
}
```

- 시간 복잡도 : O(logN)

#### Build heap

> 완전 이진트리를 heap 구조로 만드는 작업을 한다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fzl4UP%2Fbtq7d42cj7L%2FQxav7tZOICKrz7KJbYKPJ0%2Fimg.png)

- 배열로 표현된 힙은 n/2+1부터 n까지 leaf node라는 속성이 있다. (루트 노드가 1인 경우)

- leaf node를 제외한 나머지 노드 (1~n/2)에 heapify를 수행하면 heap 구조로 build 할 수 있다.

- max heap으로 build하는 작업은 다음과 같다.

  1. leaf node를 제외한 나머지 노드 중 마지막 노드(n/2)부터 루트 노드(1)까지 차례로 max_heapify를 수행한다.

  ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FS3Tqt%2Fbtq66k6jqvn%2FZLIwIycf6pSa1Ip9o5vD31%2Fimg.png)

##### 구현

```c
void build_maxheap (int arr[]) {
  int i = 0;
  for(i = size/2; i >=1; i--) {
    max_heapify(arr, i);
  }
}
```

- 시간 복잡도 : O(n)

#### Peek

> heap에 최대 요소를 반환하는 작업을 한다.

- max heap에서 최대 값은 항상 루트에 있으므로 루트 값을 반환한다.

##### 구현

```c
int peek (int arr[]) {
  return arr[1];
}
```

- 시간 복잡도 : O(1)

#### Extract

> extract는 heap에 최대 요소를 추출하는 작업을 한다.

- max heap에서 extract의 작업은 다음과 같다.

  1. heap의 최대 요소는 루트 노드에 있기 때문에 루트 노드의 값을 추출한다.
  2. heap 마지막 요소를 루트 노드에 배치한다.
  3. 마지막 요소를 루트 노드에 배치하면 heap 속성을 위배할 수 있으므로 루트 노드부터 max_heapify를 수행한다.

- extract를 수행하는 예시

  ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbiLr9R%2Fbtq7bgWfv1J%2FeqB3zOK1DgZJZgimrXkr01%2Fimg.png)

  1. 루트 노드 값(20)을 추출
  2. heap 마지막 요소(13)를 루트 노드에 배치
  3. 루트 노드부터 heapify를 수행

##### 구현

```C
int extract_max (int arr[]) {
  if(size == 0) {
    printf("empty\n");
  }
  
  // 루트 노드 값을 리턴값에 저장한 뒤, 마지막 요소를 루트노드에 배치함
  int max = arr[1];
  arr[1] = arr[size];
  size --;

  // 루트 노드부터 heapify 수행
  max_heapify(arr, 1);
  
  return max;
}
```

- 시간 복잡도 : O(logN)

#### Increase Value

> increase value는 max_heap에서 사용하는 작업으로 어느 노드의 값을 증가시키는 작업을 한다. (min heap에서는 decrease value를 사용) 만약 heap 속성을 위배하는 경우 부모 노드가 더 큰 값이 될 때까지 부모 노드와 값을 바꾸는 작업을 한다.

- heapfiy 작업은 필요가 없다.

  - max heap 구조에서는 노드의 값을 증가시켜도 항상 자식 노드보다 크다는 것이 보장되기 때문
  - min heap 구조에서는 노드의 값을 감소시키면 항상 자식 노드보다 작다는 것이 보장되기 때문

- increase value 작업은 다음과 간다.

  1. 어느 노드의 값을 증가시킨다.
  2. 부모 노드와 비교하여 heap 속성을 위배하는 경우 부모 노드와 값을 바꾼다.
  3. 힙 속성이 유지될 때까지 2번 작업을 반복한다.

- increase value 수행 예시

  ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcSTl5P%2Fbtq65Z2wTEk%2F01KiYBXCwj9f5VjslY9wy0%2Fimg.png)

  1. 값이 5인 노드를 30으로 증가시킨다.
  2. 부모 노드와 값을 비교한다. 부모 노드가 더 작아 heap 속성을 위배하므로 부모 노드와 값을 바꾼다.
  3. 값이 30인 노드에서 다시 부모 노드와 값을 비교한다.
     - 부모 노드가 더 작아 heap 속성을 위배하므로 부모 노드와 값을 바꾼다.
  4. 더 이상 heap 속성을 위배하지 않기 때문에 종료한다.

##### 구현

```C
// i index에 있는 노드 값을 val로 변경함.
void increase_value (int arr[], int i, int val) {
  // 변경하려는 값이 현재 값보다 작으면 안됨.
  if (val < arr[i]) { 
    printf("New value is less then current value, can't be inserted\n");
    return;
  }
  
  // 현재 값을 val값으로 변경
  arr[i] = val;
  
  // 부모 노드가 더 작다면 교환하고 부모 노드부터 다시 비교, 힙속성을 유지할 때까지 반복함. 
  while(i > 1 && arr[i/2] < arr[i]) {
    swap(arr[i/2], arr[i]);
    i = i/2;
  }
}
```

- 시간 복잡도 : O(logN)

#### Insert

- 힙에 요소를 삽입하는 작업은 다음과 같다.

  1. 힙의 끝에 최솟값을 삽입한다.
  2. increase value 함수를 호출하여 추가된 값을 삽입할 값으로 증가시키고 힙 속성을 유지한다.

- 요소 17를 삽입하는 예시

  ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fv9AbB%2Fbtq64Mbqear%2Fiy0RO2oDPQLczVq2lKEyZk%2Fimg.png)

  1. 힙의 끝에 최솟값을 삽입한다.
  2. increase value 함수를 호출한다.
     - 추가된 최솟값을 17로 증가시킨다.
     - 부모 노드와 값을 비교한다. 부모 노드값이 더 작기 때문에 교환한다.
  3. 값이 17인 노드와 부모 노드를 비교한다. 힙 속성을 위배하지 않으므로 종료한다.

##### 구현

```C
void insert_key(int arr[], int val)
{
  int last = 0; 
  if (size == MAX_LEN) { // 배열에 공간이 없으면 실패
    printf("Overflow: Could not insertKey\n");
  }
  
  // 힙 끝에 최소값 삽입.
  size ++;
  last = size;
  arr[last] = INT_MIN;

  // 마지막 요소값을 val로 증가 시키고 heap 속성을 유지하는 작업을 함.
  increase_value(arr, last, val);
}
```

- 시간 복잡도 : O(logN)

#### Delete

- 힙에서 요소를 삭제하는 작업은 다음과 같다.

  1. increase value를 수행하여 삭제할 요소를 max 값으로 증가시키고 루트 노드에 위치시킨다.
  2. extract를 수행하여 루트 노드에 값을 추출한다.

- 요소 15를 삭제하는 예시

  ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FemrNmu%2Fbtq65r537uq%2FvyeDeN4VoL6uBuHkUOeZ1K%2Fimg.png)

  1. increase value를 수행한다.
     1. 값 15를 max 값으로 증가시킨다.
     2. max 값을 루트 노드에 위치시킨다.
  2. extract를 수행한다.
     3. 힙의 마지막 요소 13을 루트로 이동시킨다.
     4. 루트 노드부터 max_heapify를 수행한다.

##### 구현

```c
//i index에 위치한 요소를 삭제
void delete_key (int arr[], int i) {
  increase_value(arr, i, INT_MAX);
  extract_max(h);
}
```

- 시간 복잡도 : O(logN)

### 사용 사례

- 우선순위 큐
- Dijkstra 알고리즘
- 힙 정렬