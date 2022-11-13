# TIL_Day_82

> 2022년 11월 13일

## 순열과 조합

### 순열(Permutation)

> 순열은 서로 다른 n개의 대상에서 r개를 뽑아 일렬로 배열한 것을 말하고(순서 고려), 그 경우의 수는 nPr으로 표현한다.(n은 r보다 커야한다) 그리고 n과 r이 같을 때 순열의 경우의 수는 팩토리얼(factorial, n!)이 된다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FcGzHUX%2FbtqDk53ZhaP%2Fl05TfddwWnvfRDpe2e1Z31%2Fimg.png)

#### 순열 알고리즘

1. Swap을 이용한 순열

   1. 배열의 첫 값부터 순서대로 하나씩 바꾸며 모든 값을 한 번씩 swap 한다.

   2. depth를 기준 인덱스로 하여 depth보다 인덱스가 작은 값들은 그대로 고정하고, depth 보다 인덱스가 큰 값들만 가지고 다시 swap을 진행한다.

      ![](https://github.com/ParkJiwoon/Algorithm/raw/master/Algorithm/image/perm_1.png)

2. Visited 배열을 이용한 순열

   | 변수    | 설명                                |
   | :------ | ----------------------------------- |
   | arr     | r 개를 뽑기 위한 n 개의 값          |
   | output  | 뽑힌 r 개의 값                      |
   | visited | 중복해서 뽑지 않기 위해 체크하는 값 |

   1. DFS를 돌면서 모든 인덱스를 방문하여 output에 값을 넣는다.

   2. 이미 들어간 값은 visited 값을 true로 바꾸어 중복하여 넣지 않도록 한다.

   3. depth 값은 output에 들어간 숫자의 길이이다.

   4. depth 값이 r만큼 되면 output에 들어있는 값을 출력한다.

      ![](https://github.com/ParkJiwoon/Algorithm/raw/master/Algorithm/image/perm_2.png)

#### JAVA로 구현

```java
public class Permutation {
    // 사전순으로 순열 구하기
    static void visitedPerm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            print(output, r);
            return;
        }

        for(int i=0; i<n; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                visitedPerm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    // 순열 구하기
    static void swapPerm(int[] arr, int depth, int n, int r) {
        if(depth == r) {
            print(arr, r);
            return;
        }

        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            swapPerm(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    // 배열 출력
    static void print(int[] arr, int r) {
        for(int i=0; i<r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        visitedPerm(arr, output, visited, 0, n, 3);
        System.out.println();
        swapPerm(arr, 0, n, 3);
    }
}
```

### 조합(Combination)

> 순열과 달리, 조합(Combination)은 같은 n개의 대상 중에 r개를 뽑는데 순서를 고려하지 않는다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FcUvE1R%2FbtqDk5JI7Vz%2FdH6B6K9TBu7puBqAgOKNBK%2Fimg.png)

#### 조합 알고리즘

배열을 처음부터 마지막까지 돌며

1. 현재 인덱스를 선택하는 경우
2. 현재 인덱스를 선택하지 않는 경우

이렇게 두가지로 모든 경우를 완전 탐색하면 된다.

| 변수   | 설명                          |
| ------ | ----------------------------- |
| arr    | 조합을 뽑아낼 배열            |
| output | 조합에 뽑혔는지 체크하는 배열 |
| n      | 배열의 길이                   |
| r      | 조합의 길이                   |

1. 백트래킹 이용하여 구현
   - `start` 변수는 기준입니다.
   - `start` 인덱스를 기준으로 `start` 보다 작으면 뽑을 후보에서 제외, `start` 보다 크면 뽑을 후보가 된다.
   - 예를 들어 `[1, 2, 3]` 배열이 있고 `start` 가 0 부터 시작한다.
   - 함수에 들어오면 먼저 `i` 가 `start` 부터 시작하는 `for` 문에 들어간다.
   - 만약 0 인덱스인 1을 뽑는다면 `visited[i]` 는 `true` 가 되고 뽑지 않는다면 `visited[i]` 는 `false` 이다.
   - 1을 선택한 경우와 선택하지 않은 경우 둘 다 봐야한다.
   - 하지만 더이상 1은 고려 대상이 아니기 때문에 다음 `for` 문은 무조건 `i+1` 부터 시작해주어야 한다.
2. 재귀 이용하여 구현
   - `depth` 변수는 현재 인덱스라고 생각하면 된다.
   - 현재 인덱스를 뽑는다면 `visited[depth] = true`
   - 뽑지 않는다면 `visited[depth] = false`
   - 역시 마찬가지로 뽑은 경우와 뽑지 않은 경우 모두 봐야하고, 그 때 이전에 본 값들은 더이상 고려 대상이 아니기 때문에 `depth` 은 무조건 1 씩 증가한다.
   - `depth == n` 이 되면 모든 인덱스를 다 보았으므로 재귀를 종료한다.

#### JAVA로 구현

```java
public class Combination {
    // 백트래킹 사용
    static void backComb(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            backComb(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 재귀 사용
    static void recuComb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        }
        
        if(depth == n)
            return;
        
        visited[depth] = true;
        recuComb(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        recuComb(arr, visited, depth + 1, n, r);
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        for(int i=0; i<n; i++) {
            if(visited[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];

        for(int i=1; i<=n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            recuComb(arr, visited, 0, n, i);
        }

        for(int i=1; i<=n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            backComb(arr, visited, 0, n, i);
        }
    }
}