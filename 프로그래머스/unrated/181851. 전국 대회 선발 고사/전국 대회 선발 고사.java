import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<rank.length; i++)
            if(attendance[i])
                map.put(i, rank[i]);
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));
        return 10000 * keySet.get(0) + 100 * keySet.get(1) + keySet.get(2);
    }
}