class Solution {
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        dfs(begin, target, words, visited, 0);
        
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] visited, int cnt) {
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(!visited[i] && check(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        
        int cnt = 0;
        for(int i=0; i<s1.length(); i++)
            if(s1.charAt(i) != s2.charAt(i))
                cnt++;
        
        return cnt == 1;
    }
}