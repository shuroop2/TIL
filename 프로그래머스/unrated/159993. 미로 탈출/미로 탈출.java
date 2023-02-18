import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int m = maps.length, n = maps[0].length();
        char[][] map = new char[m][n];
        boolean[][] visited = new boolean[m][n];
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean flag = false;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<m; i++) {
            char[] tmp = maps[i].toCharArray();
            for(int j=0; j<n; j++) {
                map[i][j] = tmp[j];
                if(tmp[j] == 'S') {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0], y = tmp[1], cnt = tmp[2];
            
            if(map[x][y] == 'L') {
                q.clear();
                visited = new boolean[m][n];
                visited[x][y] = true;
                flag = true;
            }
            
            if(map[x][y] == 'E' && flag)
                return cnt;
            
            for(int i=0; i<4; i++) {
                int dx = x + move[i][0];
                int dy = y + move[i][1];
                
                if(dx >= 0 && dx < m && dy >= 0 && dy < n) {
                    if(map[dx][dy] != 'X' && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        q.add(new int[]{dx, dy, cnt + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}