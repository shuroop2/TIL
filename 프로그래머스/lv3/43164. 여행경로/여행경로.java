import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(tickets, 0, "ICN", "ICN");
        
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    public void dfs(String[][] tickets, int cnt, String start, String route) {
        if(cnt == tickets.length) {
            list.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, cnt + 1, tickets[i][1], route + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}