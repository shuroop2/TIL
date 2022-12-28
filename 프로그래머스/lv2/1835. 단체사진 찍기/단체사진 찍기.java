class Solution {
    static int answer;
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    
    public int solution(int n, String[] data) {
        answer = 0;
        boolean[] visited = new boolean[8];
        
        dfs(data, visited, "");
        
        return answer;
    }
    
    public void dfs(String[] data, boolean[] visited, String str) {
        if(str.length() == 8) {
            if(check(data, str))
                answer++;
            return;
        }
        
        for(int i=0; i<8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(data, visited, str + friends[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(String[] data, String str) {
        for(String s : data) {
            int tmp1 = str.indexOf(s.substring(0, 1));
            int tmp2 = str.indexOf(s.substring(2, 3));
            
            if(s.charAt(3) == '=') {
                if(Math.abs(tmp1 - tmp2) != Integer.parseInt(s.substring(4, 5)) + 1)
                    return false;
            } else if(s.charAt(3) == '>') {
                if(Math.abs(tmp1 - tmp2) <= Integer.parseInt(s.substring(4, 5)) + 1)
                    return false;
            } else if(s.charAt(3) == '<') {
                if(Math.abs(tmp1 - tmp2) >= Integer.parseInt(s.substring(4, 5)) + 1)
                    return false;
            }
        }
        
        return true;
    }
}