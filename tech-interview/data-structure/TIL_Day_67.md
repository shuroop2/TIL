# TIL_Day_67

> 2022년 10월 10일

## 이진 탐색 트리(BST, Binary Search Tree)

- 이진 탐색 트리란 다음과 같은 특징을 갖는 이진 트리를 말한다.
  1. 각 노드에 중복되지 않는 키(key)가 있다.
  2. 루트 노드의 왼쪽 서브 트리는 해당 노드의 키보다 작은 키를 갖는 노드들로 이루어져 있다.
  3. 루트 누드의 오른쪽 서브 트리는 해당 노드의 키보다 큰 키를 갖는 노드들로 이루어져 있다.
  4. 좌우 서브 트리도 모두 이진 탐색 트리여야 한다.
- 이러한 이진 탐색 트리의 특성 때문에 효율적인 검색이 가능하다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbCe3QD%2Fbtq2ytHuN1Z%2FAi82KHYBlgY01j9hbwjOO1%2Fimg.png)

### 이진 탐색 트리 생성 예시

- 50, 15, 62, 80, 7, 54, 11 이라는 요소를 사용하여 BST를 생성하는 과정은 다음과 같다.

  1. 50을 트리의 루트로 트리에 삽입한다.
  2. 다음 요소를 읽고 루트 노드 요소보다 작으면 왼쪽 서브 트리의 루트로 삽입한다.
  3. 그렇지 않으면 오른쪽 서브 트리의 오른쪽 루트로 삽입한다.

  ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcexmJD%2Fbtq2z1DLANG%2FZFiFmM5657r46N4hKKzv91%2Fimg.png)

### 이진 탐색 트리의 특징

1. 이진 탐색 트리에 중위 순회를 수행하여 모든 키를 정렬된 순서로 가져올 수 있다.

   ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fcg5ezX%2Fbtq2y4AZEqe%2FBIKAzOf74qQmD4vqEN6lP1%2Fimg.png)

   - 위 트리에 중위 순회 결과는 다음과 같다.
     - 7, 11, 15, 50, 54, 62, 80

2. 이진 탐색 트리의 검색에 대한 시간복잡도는 균형 상태이면 O(logN)의 시간이 걸리고 불균형 상태라면 최대 O(N) 시간이 걸린다.

   ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fb5AX6Z%2Fbtq2BDbA4Sw%2FCDSV3lITsUrDIiss7ODMLk%2Fimg.png)

### 이진 탐색 트리의 연산

#### 검색(Search)

> 이진 탐색 트리에서 특정 요소의 위치를 찾는다.

1. 루트에서 시작한다.
2. 검색 값을 루트와 비교한다. 루트보다 작으면 왼쪽에 대해 재귀하고, 크다면 오른쪽으로 재귀한다.
3. 일치하는 값을 찾을 때까지 절차를 반복한다.
4. 검색 값이 없으면 null을 반환한다.

##### key=60을 찾는 과정

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbDH5Xq%2Fbtq2D4F3nRp%2FUFt8cFNCzqfeytVgtvVLuk%2Fimg.png)

##### 구현

```c
struct node* search (struct node* root, int key)
{
// root값이 null이거나 key값과 같다면 종료한다.
  if (root == NULL || root->data == key)
    return root;

// key가 root->data 보다 작으면 왼쪽 서브트리로 재귀한다.
  if (root->data > key)
    return search(root->left, key)

// key가 root->data 보다 크면 오른쪽 서브트리로 재귀한다. 
  return search(root->left, key)
}
```

#### 삽입 (Insert)

> 이진 탐색 트리에 데이터를 삽입하는 작업을 한다. (중복은 허용하지 않는다.)
>
> 새 키는 항상 리프 노드에 삽입된다.

1. 루트에서 시작한다.
2. 삽입 값을 루트와 비교한다. 루트보다 작으면 왼쪽으로 재귀하고, 크다면 오른쪽으로 재귀한다.
3. 리프 노드에 도달한 후 노드보다 크다면 오른쪽에, 작다면 왼쪽에 삽입한다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FmiB91%2Fbtq2DsUG16h%2FZBlqV9bktKWCSDfIfQYxT1%2Fimg.png)

##### 구현

```C
struct node {
  int data;
  struct node *left, *right;
};

// 새로운 BST node 생성
struct node* newNode (int key) {
  struct node* temp = (struct *node)malloc(sizeof(struct node));
  temp->data = key;
  temp->left = NULL;
  temp->right = NULL;
  return temp;
}

struct node* insert(struct node *root, int key) {
  // 트리가 비어있다면 새로운 노드를 만든다.
  if (root == NULL)
    return newNode(key);

  // 루트값보다 크면 오른쪽으로 재귀하고, 작다면 왼쪽으로 재귀한다.
  if (key > root->data)
    root->right = insert(root->right, key);
  else if (key < root->data)
    root->left = insert(root->left, key); 
  // 같은 값을 가지고 있는 경우 삽입을 하지 않는다.(중복 불가)
  return root;
}
```

#### 삭제 (Delete)

> 이진 탐색 트리에서 특정 노드를 삭제한다. 이진 탐색 트리에는 노드를 삭제하는 세 가지 상황이 있다.

1. 삭제할 노드가 리프 노드인 경우

   - 이 경우 노드를 삭제하기만 하면 된다.

   ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FeudyFG%2Fbtq2GXflqdC%2FTvIXkjTgEWoVoyvOv4xQN1%2Fimg.png)

2. 삭제할 노드가 자식이 하나만 있는 경우

   - 노드를 삭제하고 자식 노드를 삭제된 노드의 부모에 직접 연결한다.

   ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fd9YABr%2Fbtq2y4HJBqp%2FDbafbadT1SL5WSnKO6AFLK%2Fimg.png)

3. 삭제할 노드에 자식이 둘 있는 경우

   - 자식이 둘 있는 경우 successor 노드를 찾는 과정이 추가된다.
     - successor 노드란
       - 오른쪽 서브 트리의 최솟값
       - 즉, 중위 순회에서 다음 노드를 말한다.
   - 삭제 과정은 다음과 같다.
     1. 삭제할 노드를 찾는다.
     2. 삭제할 노드의 successor 노드를 찾는다.
     3. 삭제할 노드와 successor 노드의 값을 바꾼다.
     4. successor 노드를 삭제한다.

   ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FkYDgz%2Fbtq2BCDKWPR%2FT5wAjm1PwyAAKq9NNYctV0%2Fimg.png)

##### 구현

```C
struct node {
    int data;
    struct node *left, *right;
};

// 노드의 최소값을 가져오는 함수
struct node* minValueNode (struct node* node){
    struct node* current = node;
    
    while(current && current->left != NULL)
        current = current->left;

    return current;
}

struct node* deleteNode (struct node* root, int key) {
	// base case
    if(root == NULL)
    	return root;
	// 삭제할 노드를 찾는다.
    if (key < root->data)
        root->left = deleteNode(root->left,key);
    else if (key > root->data)
        root->right = deleteNode(root->right, key);
	// 삭제할 노드를 찾은 경우
    else {
        struct node* temp;
        // 노드에 자식이 하나 이거나 없는 경우
        if (root->left == NULL) {
            temp = root->right;
            free(root);
            return temp;
        } else if (root->right == NULL) {
            temp = root->left;
            free(root);
            return temp;
        }
        // 노드에 자식이 둘 있는 경우
        // successor 노드를 찾는다.
        temp = minValueNode(root->right);
        // successor 노드 키와 삭제할 노드 키를 바꾼다.
        root->key = temp->key;
        // 노드를 삭제한다.
        root->right = deleteNode(root->right, temp->key);
    }
    return root;
}