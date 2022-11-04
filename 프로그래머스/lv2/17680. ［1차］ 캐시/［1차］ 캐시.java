import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return 5 * cities.length;
        
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toUpperCase();
            
            if(cache.remove(city)) {
                cache.addFirst(city);
                answer += 1;
            } else {
                int currentSize = cache.size();
                
                if(currentSize == cacheSize)
                    cache.pollLast();
                
                cache.addFirst(city);
                answer += 5;
            }
        }
        return answer;
    }
}