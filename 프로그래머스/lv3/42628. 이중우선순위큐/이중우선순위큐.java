import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s : operations) {
            if(s.startsWith("I")) {
                int num = Integer.parseInt(s.replace("I ", ""));
                pq.add(num);
                pq2.add(num);
            } else if(s.equals("D -1")) {
                pq2.remove(pq.peek());
                pq.poll();
            } else {
                pq.remove(pq2.peek());
                pq2.poll();
            }
        }
        
        if(!pq.isEmpty()) {
            answer[0] = pq2.peek();
            answer[1] = pq.peek();
        }
        
        return answer;
    }
}