import java.util.*;

class Solution {
    static HashSet<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        boolean visited[] = new boolean[user_id.length];
        
        dfs(user_id, banned_id, 0, visited);
        
        return set.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id, int idx, boolean[] visited) {
        if(idx == banned_id.length) {
            String s = "";
            for(int i=0; i<user_id.length; i++)
                if(visited[i])
                    s += i;
            set.add(s);
            return ;
        }
        
        for(int i=0; i<user_id.length; i++) {
            if(!visited[i]) {
                boolean flag = true;
                if(user_id[i].length() == banned_id[idx].length()) {
                    for(int j=0; j<user_id[i].length(); j++) {
                        if(banned_id[idx].charAt(j) == '*')
                            continue;
                        
                        if(user_id[i].charAt(j) != banned_id[idx].charAt(j)) {
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag) {
                        visited[i] = true;
                        dfs(user_id, banned_id, idx + 1, visited);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}