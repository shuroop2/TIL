import java.util.*;

class Solution {
    static ArrayList<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        dfs(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()][];
        
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
    
    public void dfs(int n, int start, int mid, int end) {
        if(n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        
        dfs(n - 1, start, end, mid);
        
        list.add(new int[]{start, end});
        
        dfs(n - 1, mid, start, end);
    }
}