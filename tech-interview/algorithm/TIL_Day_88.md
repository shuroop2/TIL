# TIL_Day_88

> 2022년 12월 03일

## 다익스트라(Dijkstra)

> 다익스트라 알고리즘은 도로 교통망 같은 곳에서 나타날 수 있는 그래프에서 꼭짓점 간의 최단 경로를 찾는 알고리즘이다. 원래의 다익스트라 알고리즘은 두 꼭짓점 간의 가장 짧은 경로를 찾는 알고리즘이지만, 더 일반적인 변형은 한 꼭짓점을 "소스" 꼭짓점으로 고정하고 그래프의 다른 모든 꼭짓점까지의 최단경로를 찾는 알고리즘으로 최단 경로 트리를 만드는 것이다.

### 다익스트라 동작 단계

1. 출발 노드와 도착 노드를 설정
2. 최단 거리 테이블을 초기화
3. 현재 위치한 노드의 인접 노드 중 방문하지 않은 노드를 구별하고, 방문하지 않은 노드 중 거리가 가장 짧은 노드를 선택 후 방문 처리
4. 해당 노드를 거쳐 다른 노드로 넘어가는 간선 비용(가중치)을 계산해 최단 거리 테이블을 업데이트
5. 3~4 과정 반복

최단 거리 테이블은 1차원 배열로, N개 노드까지 오는데 필요한 최단 거리를 기록한다.
N개(1부터 시작하는 노드 번호와 일치시키려면 N+1개) 크기의 배열을 선언하고 큰 값을 넣어 초기화시킨다.

노드 방문 여부 체크 배열은 방문한 노드인지 아닌지 기록하기 위한 배열로, 크기는 최단 거리 테이블과 같다. 
기본적으로는 false로 초기화하여 방문하지 않았음을 명시한다.

### 다익스트라 특징

- 방문하지 않은 노드 중 최단 거리인 노드를 선택하는 과정을 반복한다.
- 각 단계마다 탐색 노드로 한 번 선택된 노드는 최단 거리를 갱신하고, 그 뒤에는 더 작은 값으로 다시 갱신되지 않는다.
- 도착 노드는 해당 노드를 거쳐 다른 노드로 가는 길을 찾을 필요는 없다.
- 가중치가 양수일 때만 사용 가능하다.

### JAVA로 구현

1. 인접 행렬

   ```java
   public class Dijkstra {
   	public static void main(String[] args) {
           Graph g = new Graph(6); // 노드 수 만큼 그래프 생성
           
           // 시작, 끝, 간선 가중치 입력
           g.input(0, 1, 7);
           g.input(0, 2, 9);
           g.input(0, 5, 14);
           g.input(1, 2, 10);
           g.input(1, 3, 15);
           g.input(2, 3, 11);
           g.input(2, 5, 2);
           g.input(3, 4, 6);
           g.input(4, 5, 9);
           
           // 시작노드 기준 다익스트라 알고리즘 실행
           g.dijkstra(0);
   	}
   
   }
   
   
   class Graph {
       private int n;           // 노드들의 수
       private int[][] maps;    // 노드들간의 가중치 저장할 변수
    
       public Graph(int n) {
           this.n = n;
           maps = new int[n][n];
           
           // 인접행렬 모든 값 무한대로 초기화
           for(int i=0; i<n; i++) {
           	for(int j=0; j<n; j++)
           		maps[i][j] = Integer.MAX_VALUE;
           }
       }
       
       public void input(int i, int j, int w) {
           maps[i][j] = w;
           maps[j][i] = w;
       }
    
       public void dijkstra(int v) {
           int[] distance = new int[n];          // 최단 거리를 저장할 변수
           boolean[] check = new boolean[n];     // 해당 노드를 방문했는지 체크할 변수
            
           // distance값 초기화. 무한대를 int 자료형의 최대값으로 표현
           for(int i=0; i<n; i++)
               distance[i] = Integer.MAX_VALUE;
            
           // 시작노드값 초기화.
           distance[v] = 0;
           check[v] = true;
           
           // 결과값 출력
           for(int i=0; i<n; i++) {
           	if(distance[i] == 2147483647)
                   System.out.print("∞ ");
           	else
                   System.out.print(distance[i] + " ");
           }
           System.out.println("");
            
           // 연결노드 distance갱신
           for(int i=0; i<n; i++) {
               if(!check[i] && maps[v][i] != Integer.MAX_VALUE)
                   distance[i] = maps[v][i];
           }
           
           // 결과값 출력
           for(int i=0; i<n; i++) {
           	if(distance[i] == 2147483647)
                   System.out.print("∞ ");
           	else
                   System.out.print(distance[i] + " ");
           }
           System.out.println("");
            
           for(int a=0; a<n-1; a++) {
               // 원래는 모든 노드가 true될때까지 인데
               // 노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
               // 원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
               int min = Integer.MAX_VALUE;
               int min_index = -1;
               
               // 노드 최소값 찾기
               for(int i=0; i<n; i++) {
                   if(!check[i]) {
                       if(distance[i] < min) {
                           min = distance[i];
                           min_index = i;
                       }
                   }
               }
               
               // 다른 노드를 거쳐서 가는 것이 더 비용이 적은지 확인한다.
               check[min_index] = true;
               for(int i=0; i<n; i++) {
                   if(!check[i] && maps[min_index][i] != Integer.MAX_VALUE){
                       if(distance[min_index] + maps[min_index][i] < distance[i])
                           distance[i] = distance[min_index] + maps[min_index][i];
                   }
               }
               
               // 결과값 출력
               for(int i=0; i<n; i++) {
               	if(distance[i] == 2147483647)
                       System.out.print("∞ ");
               	else
                       System.out.print(distance[i] + " ");
               }
               System.out.println("");
           }
       }
   }
   ```

   - 결과

   ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FueXBg%2Fbtq2h2QMRIu%2FhELsdugD9HK1aLzgX03tkK%2Fimg.png)

2. 우선순위 큐

   ```java
   import java.util.PriorityQueue;
   
   public class Dijkstra {
   	public static void main(String[] args) {
           Graph g = new Graph(6); // 노드 수 만큼 그래프 생성
           
           // 시작, 끝, 간선 가중치 입력
           g.input(0, 1, 7);
           g.input(0, 2, 9);
           g.input(0, 5, 14);
           g.input(1, 2, 10);
           g.input(1, 3, 15);
           g.input(2, 3, 11);
           g.input(2, 5, 2);
           g.input(3, 4, 6);
           g.input(4, 5, 9);
           
           // 시작노드 기준 다익스트라 알고리즘 실행
           g.dijkstra(0);
   	}
   
   }
   
   
   class Graph {
       private int n;           // 노드들의 수
       private int[][] maps;    // 노드들간의 가중치 저장할 변수
    
       public Graph(int n) {
           this.n = n;
           maps = new int[n][n];
           
           // 인접행렬 모든 값 무한대로 초기화
           for(int i=0; i<n; i++) {
           	for(int j=0; j<n; j++)
           		maps[i][j] = Integer.MAX_VALUE;
           }
       }
       
       class Node implements Comparable<Node> {
       	private int weight;
       	private int index;
       	
       	public Node(int weight, int index) {
       		this.weight = weight;
       		this.index = index;
       	}
       	
       	@Override
           public int compareTo(Node node) {
               return Integer.compare(this.weight, node.weight);
           }
       }
       
       public void input(int i, int j, int w){
           maps[i][j] = w;
           maps[j][i] = w;
       }
    
       public void dijkstra(int v) {
           PriorityQueue<Node> pq = new PriorityQueue<>();     // 노드까지의 거리를 저장할 우선순위 큐
           int[] distance = new int[n];          // 최단 거리를 저장할 변수
           boolean[] check = new boolean[n];     // 해당 노드를 방문했는지 체크할 변수
           
           // distance값 초기화. 무한대를 int 자료형의 최대값으로 표현했다.
           for(int i=0; i<n; i++)
               distance[i] = Integer.MAX_VALUE;
            
           // 시작노드값 초기화.
           pq.add(new Node(v, 0));
           distance[v] = 0;
           check[v] = true;
           
           // 결과값 출력
           for(int i=0; i<n; i++) {
           	if(distance[i] == 2147483647)
                   System.out.print("∞ ");
           	else
                   System.out.print(distance[i] + " ");
           }
           System.out.println("");
            
           // 연결노드 distance갱신
           for(int i=0; i<n; i++) {
               if(!check[i] && maps[v][i] != Integer.MAX_VALUE) {
               	distance[i] = maps[v][i];
                   pq.add(new Node(maps[v][i], i));
               }
           }
           
           // 결과값 출력
           for(int i=0; i<n; i++) {
           	if(distance[i] == 2147483647)
                   System.out.print("∞ ");
           	else
                   System.out.print(distance[i] + " ");
           }
           System.out.println("");
            
           while(!pq.isEmpty()) {
               // 원래는 모든 노드가 true될때까지 인데
               // 노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
               // 원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
               int min = Integer.MAX_VALUE;
               int min_index = -1;
               
               // 노드 최소값 꺼내기
               Node node = pq.poll();
               min = node.weight;
               min_index = node.index;
               
               // 다른 노드를 거쳐서 가는 것이 더 비용이 적은지 확인한다.
               check[min_index] = true;
               for(int i=0; i<n; i++) {
                   if(!check[i] && maps[min_index][i] != Integer.MAX_VALUE) {
                       if(distance[min_index] + maps[min_index][i] < distance[i]) {
                           distance[i] = distance[min_index] + maps[min_index][i];
                           pq.add(new Node(distance[i], i));
                       }
                   }
               }
               
               // 결과값 출력
               for(int i=0; i<n; i++) {
               	if(distance[i] == 2147483647)
                       System.out.print("∞ ");
               	else
                       System.out.print(distance[i] + " ");
               }
               System.out.println("");
           }
       }
   }
   ```

   - 결과

   ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FACVvt%2Fbtq2nhTsamC%2F1GgqnbIiyc0rqG5MBNAU71%2Fimg.png)

