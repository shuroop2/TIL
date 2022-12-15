import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<cards.length; i++) {
            int cnt = 0, tmp = i;
            
            while(true) {
                if(!visited[tmp]) {
                    visited[tmp] = true;
                    tmp = cards[tmp] - 1;
                    cnt++;
                } else {
                    list.add(cnt);
                    break;
                }
            }
        }
        
        if(list.size() == 1)
            return 0;
        
        list.sort((o1, o2) -> o2 - o1);
        
        return list.get(0) * list.get(1);
    }
}