# TIL_Day_82

> 2022년 11월 13일

## 순열

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