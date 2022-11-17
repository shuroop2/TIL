import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville)
            pq.add(i);
        
        while(pq.peek() < K && !pq.isEmpty()) {
            int tmp = pq.poll();
            if(!pq.isEmpty()) {
                pq.add(tmp + pq.poll() * 2);
                answer++;
            } else {
                return -1;
            }
        }
        
        return answer;
    }
}