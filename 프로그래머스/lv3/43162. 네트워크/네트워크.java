class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int start, int[][] computers, boolean[] visited) {
        visited[start] = true;
        for(int i=0; i<computers.length; i++) {
            if(!visited[i] && start != i && computers[start][i] == 1)
                dfs(i, computers, visited);
        }
    }
}