import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    
    public int solution(String[][] relation) {
        for(int i=0; i<relation[0].length; i++) {
            boolean[] visited = new boolean[relation[0].length];
            dfs(relation, visited, 0, i + 1, 0);
        }
        
        return list.size();
    }
    
    public void dfs(String[][] relation, boolean[] visited, int start, int end, int column) {
        if(end == column) {
            ArrayList<Integer> tmpList = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            String str = "";
            
            for(int i=0; i<visited.length; i++) {
                if(visited[i]) {
                    str += String.valueOf(i);
                    tmpList.add(i);
                }
            }
            
            for(int i=0; i<relation.length; i++) {
                String s = "";
                
                for(int j : tmpList)
                    s += relation[i][j];
                
                if(map.containsKey(s))
                    return;
                else
                    map.put(s, 0);
            }
            
            for(String s : list) {
                int cnt = 0;
                
                for(int i=0; i<str.length(); i++) {
                    if(s.contains(str.substring(i, i + 1)))
                        cnt++;
                }
                if(cnt == s.length())
                    return;
            }
            list.add(str);
            
            return;
        }
        
        for(int i=start; i<visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(relation, visited, i, end, column + 1);
                visited[i] = false;
            }
        }
    }
}