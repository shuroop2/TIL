import java.util.*;

class Solution {
    static boolean[] visited;
    static boolean[][] connect;
    
    public int solution(int n, int[][] edge) {
        visited = new boolean[n];
        connect = new boolean[n][n];
        
        return bfs(edge);
    }
    
    public int bfs(int[][] edge) {
        int result = 0;
        
        for(int i=0; i<edge.length; i++) {
            connect[edge[i][0] - 1][edge[i][1] - 1] = true;
            connect[edge[i][1] - 1][edge[i][0] - 1] = true;
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int node = q.poll();
                for(int j=0; j<visited.length; j++) {
                    if(!visited[j] && connect[node][j]) {
                        visited[j] = true;
                        q.add(j);
                    }
                }
            }
            result = size;
        }
        
        return result;
    }
}