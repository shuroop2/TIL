import java.util.*;

class Solution {
    static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        int area = 0;
        int max = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    area++;
                    max = Math.max(max, bfs(picture, i, j, m, n));
                }
            }
        }

        int[] answer = {area, max};
        
        return answer;
    }
    
    public int bfs(int[][] picture, int x, int y, int m, int n) {
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int i=0; i<4; i++) {
                int nx = tmp[0] + move[i][0];
                int ny = tmp[1] + move[i][1];
                
                if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if(!visited[nx][ny] && picture[nx][ny] == picture[tmp[0]][tmp[1]]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}