import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        int[][] arr = new int[n + 1][n + 1];
        
        for(int i=0; i<wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            arr[a][b] = 0;
            arr[b][a] = 0;
            answer = Math.min(answer, bfs(n, arr, a));
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        
        return answer;
    }
    
    public int bfs(int n, int[][] arr, int start) {
        int[] visited = new int[n + 1];
        int cnt = 1;
        
        Queue <Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            visited[tmp] = 1;
            
            for(int i=1; i<=n; i++) {
                if(visited[i] == 1)
                    continue;
                if(arr[tmp][i] == 1) {
                    queue.add(i);
                    cnt++;
                }
            }
        }
        
        return (int) Math.abs(n - 2 * cnt);
    }
}