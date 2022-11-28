import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++)
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        
        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        
        while(k > 0) {
            for(int i : keySet) {
                k -= map.get(i);
                answer++;
                if(k <= 0)
                    break;
            }
        }
        
        return answer;
    }
}