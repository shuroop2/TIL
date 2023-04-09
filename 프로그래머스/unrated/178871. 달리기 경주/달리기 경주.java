import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new TreeMap<>();
        
        for(int i=0; i<players.length; i++) {
            map1.put(players[i], i + 1);
            map2.put(i + 1, players[i]);
        }
        
        for(int i=0; i<callings.length; i++) {
            int idx = map1.get(callings[i]);
            String tmp = map2.get(idx - 1);
            
            map1.put(callings[i], idx - 1);
            map1.put(tmp, idx);
            
            map2.put(idx - 1, callings[i]);
            map2.put(idx, tmp);
        }
        
        int idx = 0;
        for(int key : map2.keySet())
            answer[idx++] = map2.get(key);
        
        return answer;
    }
}