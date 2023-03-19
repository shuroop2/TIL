import java.util.*;

class Solution {
    public int solution(String[] board) {
        int m = board.length, n = board[0].length();
        char[][] map = new char[m][n];
        boolean[][] visited = new boolean[m][n];
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = board[i].charAt(j);
                if(board[i].charAt(j) == 'R') {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            
            if(map[tmp[0]][tmp[1]] == 'G')
                return tmp[2];
            
            for(int i=0; i<4; i++) {
                int dx = tmp[0], dy = tmp[1], cnt = tmp[2];
                while(true) {
                    dx += move[i][0];
                    dy += move[i][1];
                    if(dx < 0 || dx >= m || dy < 0 || dy >= n || map[dx][dy] == 'D') {
                        dx -= move[i][0];
                        dy -= move[i][1];
                        break;
                    }
                }
                
                if(!visited[dx][dy]) {
                    visited[dx][dy] = true;
                    q.add(new int[]{dx, dy, cnt + 1});
                }
            }
        }
        
        return -1;
    }
}