import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            String parts = cloth[1];
            map.put(parts, map.getOrDefault(parts, 0) + 1);
        }

        Iterator<Integer> it = map.values().iterator();
        int answer = 1;
        
        while(it.hasNext())
            answer *= it.next().intValue() + 1;

        return answer - 1;
    }
}