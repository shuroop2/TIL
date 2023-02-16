import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int l1, l2, sum;
    
    public int[] solution(String[] maps) {
        l1 = maps.length;
        l2 = maps[0].length();
        List<Integer> list = new ArrayList<>();
        map = new int[l1][l2];
        visited = new boolean[l1][l2];
        
        for(int i=0; i<l1; i++) {
            char[] arr = maps[i].toCharArray();
            for(int j=0; j<l2; j++)
                map[i][j] = arr[j] == 'X' ? 0 : arr[j] - '0';
        }
        
        for(int i=0; i<l1; i++) {
            for(int j=0; j<l2; j++) {
                sum = 0;
                if(map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    if(sum != 0)
                        list.add(sum);
                }
            }
        }
        
        Collections.sort(list);
        
        return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(i -> i).toArray();
    }
    
    public void dfs(int x, int y) {
        visited[x][y] = true;
        sum += map[x][y];
        
        for(int i=0; i<4; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            
            if(dx >= 0 && dx < l1 && dy >= 0 && dy < l2)
                if(map[dx][dy] != 0 && !visited[dx][dy])
                    dfs(dx, dy);
        }
    }
}