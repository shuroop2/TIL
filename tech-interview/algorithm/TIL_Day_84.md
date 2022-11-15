# TIL_Day_84

> 2022년 11월 15일

## 깊이 우선 탐색(DFS, Depth-First Search)

> 맹목적 탐색 방법의 하나로 탐색 트리의 최근에 첨가된 노드를 선택하고, 이 노드에 적용 가능한 동작자 중 하나를 적용하여 트리에 다음 수준(level)의 한 개의 자식 노드를 첨가하며, 첨가된 자식 노드가 목표 노드일 때까지 앞의 자식 노드의 첨가 과정을 반복해 가는 방식이다.

- 미로를 탐색할 때 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면 다시 가장 가까운 갈림길로 돌아와서 이곳으로부터 다른 방향으로 다시 탐색을 진행하는 방법과 유사하다.
- 즉, 넓게(wide) 탐색하기 전에 깊게(deep) 탐색하는 것이다.
- 사용하는 경우 : **모든 노드를 방문** 하고자 하는 경우에 이 방법을 선택한다.
- 깊이 우선 탐색(DFS)이 너비 우선 탐색(BFS)보다 좀 더 간단하다.
- 단순 검색 속도 자체는 너비 우선 탐색(BFS)에 비해서 느리다.

### 깊이 우선 탐색의 과정

![](https://gmlwjd9405.github.io/images/algorithm-dfs-vs-bfs/dfs-example.png)

1. a 노드(시작 노드)를 방문한다.
   - 방문한 노드는 방문했다고 표시한다.
2. a와 인접한 노드들을 차례로 순회한다.
   - a와 인접한 노드가 없다면 종료한다.
3. a와 이웃한 노드 b를 방문했다면, a와 인접한 또 다른 노드를 방문하기 전에 b의 이웃 노드들을 전부 방문해야 한다.
   - b를 시작 정점으로 DFS를 다시 시작하여 b의 이웃 노드들을 방문한다.
4. b의 분기를 전부 완벽하게 탐색했다면 다시 a에 인접한 정점들 중에서 아직 방문이 안 된 정점을 찾는다.
   - 즉, b의 분기를 전부 완벽하게 탐색한 뒤에야 a의 다른 이웃 노드를 방문할 수 있다는 뜻이다.
   - 아직 방문이 안 된 정점이 없으면 종료한다.
   - 있으면 다시 그 정점을 시작 정점으로 DFS를 시작한다.

### 깊이 우선 탐색 알고리즘

**스택 자료구조**를 이용

1. 탐색 시작 노드를 스택에 삽입하고, 방문 처리한다.
2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리하고, 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
3. 위의 1, 2번 과정을 더 이상 수행할 수 없을 때까지 반복한다.

### 깊이 우선 탐색의 특징

- 자기 자신을 호출하는 **순환 알고리즘의 형태**를 가지고 있다.
- 전위 순회(Pre-Order Traversals)를 포함한 다른 형태의 트리 순회는 모두 DFS의 한 종류이다.
- 이 알고리즘을 구현할 때 가장 큰 차이점은, 그래프 탐색의 경우 **어떤 노드를 방문했었는지 여부를 반드시 검사** 해야 한다는 것이다.
  - 이를 검사하지 않을 경우 무한 루프에 빠질 위험이 있다.
- 시간 복잡도
  - DFS는 그래프(정점의 수 : n, 간선의 수 : e)의 모든 간선을 조회한다.
    - 인접 리스트로 표현된 그래프 : O(n+e)
    - 인접 행렬로 표현된 그래프 : O(n^2)
  - 즉, 그래프 내에 적은 숫자의 간선만을 가지는 희소 그래프(Sparse Graph)의 경우 인접 행렬보다 인접 리스트를 사용하는 것이 유리하다.

### JAVA로 구현

1. 재귀 함수를 통해 깊이 우선 탐색 구현

```java
public class DFS_Recursion {
    // 각 노드가 방문된 정보를 1차원 배열로 표현
    public static boolean[] visited = {false, false, false, false, false, false, false, false, false};
    // 각 노드가 연결된 정보를 2차원 배열로 표현
    public static int[][] graph = {{}, {2, 3, 8}, {1, 7}, {1, 4, 5}, {3, 5}, {3, 4}, {7}, {2, 6, 8}, {1, 7}};
    
    public static void dfs(int start) {
        // 현재 노드 방문 처리
        visited[start] = true;
        // 방문 노드 출력
        System.out.print(start + " ");
        // 인접 노드 탐색
        for(int i : graph[start]) {
            if(visited[i] == false)
                dfs(i);
        }
    }
    
    public static void main(String[] args) {
        int start = 1; // 시작 노드
        dfs(start);
    }
}
```

2. Stack을 통해 깊이 우선 탐색 구현

```java
public class DFS_Stack {
    void dfs(int[][] graph, int start, boolean[] visited) {
        //시작 노드 방문 처리
        visited[start] = true;
        //방문 노드 출력
        System.out.print(start + " ");
        
        Deque<Integer> stack = new LinkedList<>();
        //시작 노드를 스택에 입력
        stack.push(start);
        while(!stack.isEmpty()) {
            int now = stack.peek();
            // 방문하지 않은 인접 노드가 있는지 확인
            boolean hasNearNode = false;
            // 인접한 노드를 방문하지 않았을 경우 스택에 넣고 방문 처리
            for(int i : graph[now]) {
                if(!visited[i]) {
                    hasNearNode = true;
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(i + " ");//방문 노드 출력
                    break;
                }
            }
            // 방문하지 않은 인접 노드가 없는 경우 해당 노드 꺼내기
            if(hasNearNode == false)
                stack.pop();
            }
    }
    
    public static void main(String[] args) {
        //각 노드가 방문된 정보를 1차원 배열로 표현
        boolean[] visited = {false, false, false ,false ,false ,false ,false ,false, false};
        //각 노드가 연결된 정보를 2차원 배열로 표현
        int[][] graph = {{}, {2, 3, 8}, {1, 7}, {1, 4, 5}, {3, 5}, {3, 4}, {7}, {2, 6, 8}, {1, 7}};
        
        //정의된 DFS 함수 호출
        DFS_Stack dfsExam = new DFS_Stack();
        dfsExam.dfs(graph, 1, visited);
    }
}
```

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbqijpM%2FbtqUvD4O2A0%2F2mgaoD9ZLsOI98HTArY8zk%2Fimg.png)