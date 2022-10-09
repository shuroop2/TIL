# TIL_Day_66

> 2022년 10월 9일

## 트리(Tree)

> 트리 구조란 그래프의 일종으로, 한 노드에서 시작해서 다른 정점들을 순회하여 자기 자신에게 돌아오는 순환이 없는 연결 그래프이다.

![](https://upload.wikimedia.org/wikipedia/commons/f/f7/Binary_tree.svg)

- 트리(Tree)는 **그래프의 일종으로 정점과 간선을 이용하여 데이터의 배치 형태를 추상화한 자료구조**이다.
- **서로 다른 두 노드를 연결하는 길이 하나 뿐인 그래프**를 트리라고 부른다.
- 힙(Heap)을 구현하는 방법 중 하나가 트리이다.

### 트리의 특징

- 트리 자료구조는 일반적으로 대상 정보의 각 항목들을 계층적으로 구조화할 때 사용하는 비선형 자료구조이다.
- 트리의 구조는 데이터 저장의 의미보다는 저장된 데이터를 더 효과적으로 탐색하기 위해서 사용된다.
- 리스트와 다르게 데이터가 단순히 나열되는 구조가 아니다.
  - 트리는 부모와 자식의 계층적인 관계로 표현된다.
- 트리는 사이클이 없다.
- 트리에서 루트 노드를 제외한 모든 노드는 단 하나의 부모 노드를 가진다.

### 트리 순회

> 트리의 순회란 트리의 각 노드를 체계적인 방법으로 탐색하는 과정을 의미한다. 노드를 탐색하는 순서에 따라 전위 순회, 중위 순회, 후위 순회 3가지로 분류된다.

#### 전위 순회 (Preorder)

- 전위 순회는 깊이 우선 순회(DFT, Depth-First-Traversal)이라고도 한다.
- 트리를 복사하거나, 전위 표기법을 구하는데 주로 사용된다.
  - 트리를 복사할 때 전위 순회를 사용하는 이유는 트리를 생성할 때 자식 노드보다 부모 노드가 먼저 생성되어야 하기 때문이다.
- 전위 순회는 다음과 같은 방법으로 진행된다.
  1. Root 노드를 방문한다.
  2. 왼쪽 서브 트리를 전위 순회한다.
  3. 오른쪽 서브 트리를 전위 순회한다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FqaUdk%2Fbtq16y96ZK5%2FHzgM9ijvptwnj6jxshGYbK%2Fimg.png)

- 위 트리에 전위 순회 결과는 다음과 같다.
  - A -> B -> D -> E -> C -> F -> G

#### 중위 순회 (Inorder)

- 중위 순회는 왼쪽 오른쪽 대칭 순서로 순회를 하기 때문에 대칭 순회(Symmetric Traversal)라고도 한다.
- 중위 순회는 이진 탐색트리(BST)에서 오름차순 또는 내림차순으로 값을 가져올 때 사용된다.
- 내림차순으로 값을 가져오기 위해서는 역순(오른쪽->Root->왼쪽)으로 중위 순회하면 된다.
- 중위 순회는 다음과 같은 방법으로 진행된다.
  1. 왼쪽 서브 트리를 중위 순회한다.
  2. Root 노드를 방문한다.
  3. 오른쪽 서브 트리를 중위 순회한다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FmJf2v%2Fbtq18DJBGdX%2FGX3tikbiJVXxMPVVYb82a1%2Fimg.png)

- 위 트리에 중위 순회 결과는 다음과 같다.
  - D -> B -> E -> A -> F -> C -> G

#### 후위 순회 (Postorder)

- 후위 순회는 트리를 삭제하는데 주로 사용된다.
  - 부모 노드를 삭제하기 전에 자식 노드를 삭제하는 순으로 노드를 삭제해야 하기 때문
- 후위 순회는 다음과 같은 방법으로 진행된다.
  1. 왼쪽 서브 트리를 후위 순회한다.
  2. 오른쪽 서브 트리를 후위 순회한다.
  3. Root 노드를 방문한다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fcj9NLm%2Fbtq18oMo4Wg%2FkmRXeo7LyIbUuwkWesmg1k%2Fimg.png)

- 위 트리에 후위 순회 결과는 다음과 같다.
  - D -> E -> B -> F -> G -> C -> A

### 이진 트리(Binary Tree)

- 트리 자료구조는 여러 가지 유형이 있는데, 그 중 가장 기본이 되는 트리는 이진 트리(Binary Tree) 구조이다.
- 이진 트리는 2개 이하의 자식 노드를 가진다.
  - 자식 노드가 없거나 1개의 자식 노드만 가지는 것도 가능하다.
- 2개의 자식 노드 중에서 왼쪽의 노드를 Left Node라고 하고, 오른쪽의 노드를 Right Node라고 한다.

#### 이진 트리의 종류

##### 편향 이진 트리 (Skewed Binary Tree)

![](https://velog.velcdn.com/images%2Fkimdukbae%2Fpost%2F349a3344-f85e-4a66-ab4e-5d16027f249c%2Fimage.png)

- 편향 이진 트리는 **하나의 차수로만 이루어져 있는 경우**를 의미한다.
- 이러한 구조는 배열(리스트)와 같은 선형 구조이므로 Leaf Node(가장 아래쪽에 위치한 노드) 탐색 시 모두 데이터를 전부 탐색해야 한다는 단점이 있어 효율적이지 못하다.
  - 이를 보완하기 위해 높이 균형 트리 라는 것이 있다.

##### 포화 이진 트리 (Full Binary Tree)

![](https://velog.velcdn.com/images%2Fkimdukbae%2Fpost%2F5ca863d7-202e-4fe2-9d71-5fab60dee42e%2Fimage.png)

- 포화 이진 트리는 **Leaf Node를 제외한 모든 노드의 차수가 2개로 이루어져 있는 경우**를 의미한다.
- 이 경우 해당 차수에 몇 개의 노드가 존재하는지 바로 알 수 있으므로 노드의 개수를 파악할 때 용이한 장점이 있다.

##### 완전 이진 트리 (Complete Binary Tree)

![](https://velog.velcdn.com/images%2Fkimdukbae%2Fpost%2F6a9d01ed-de21-41cd-971f-14faaee17946%2Fimage.png)

- 포화 이진 트리와 같은 개념으로 트리를 생성하지만, **모든 노드가 왼쪽부터 차근차근 생성되는 이진 트리를 의미**한다.
- 힙(Heap)은 완전 이진 트리의 일종이다.