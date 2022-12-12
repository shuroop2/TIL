import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        set.add(topping[0]);

        for(int i=1; i<topping.length; i++)
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        
        for(int i=1; i<topping.length; i++) {
            set.add(topping[i]);
            
            if(map.get(topping[i]) > 1)
                map.put(topping[i], map.get(topping[i]) - 1);
            else
                map.remove(topping[i]);
            
            if(map.size() == set.size())
                answer++;
        }
        
        return answer;
    }
}