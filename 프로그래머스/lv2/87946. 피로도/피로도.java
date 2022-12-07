class Solution {
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
          
        return perm(k, dungeons, visited, 0);
    }
    
    public int perm(int k, int[][] dungeons, boolean[] visited, int count) {
        for(int i=0; i<dungeons.length; i++){
			if(k >= dungeons[i][0] && !visited[i]) {
				visited[i] = true;
				perm(k - dungeons[i][1], dungeons, visited, count + 1);
				visited[i] = false;
			}
		}
        
		answer = Math.max(answer, count);
		
		return answer;
    }
}