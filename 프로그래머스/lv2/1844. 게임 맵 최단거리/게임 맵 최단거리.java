import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int m = maps.length, n = maps[0].length;
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] visited = new int[m][n];
        int[] start = {0, 0};    
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            
            for(int i=0; i<4; i++) {
                int x = tmp[0] + move[i][0];
                int y = tmp[1] + move[i][1];
                
                if(x >= 0 && x < m && y >= 0 && y < n && visited[x][y] == 0 && maps[x][y] == 1) {
                    int[] moved = {x, y};
                    q.add(moved);
                    visited[x][y] = visited[tmp[0]][tmp[1]] + 1;
                }
            }
        }
        
        int answer = visited[m-1][n-1];
        
        return answer > 0 ? answer : -1;
    }
}