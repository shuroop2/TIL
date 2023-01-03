import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        List<int[]> list = new ArrayList<>();
        
        for(int[] route : routes)
            list.add(route);
        
        while(!list.isEmpty()) {
            int tmp = list.get(0)[1];
            
            for(int i=0; i<list.size();) {
                if(list.get(i)[0] <= tmp)
                    list.remove(i);
                else
                    i++;
            }
            
            answer++;
        }
        
        return answer;
    }
}