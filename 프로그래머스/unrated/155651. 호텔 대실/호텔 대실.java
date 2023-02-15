import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<book_time.length; i++) {
            int time = getTime(book_time[i][0]);
            
            if(!pq.isEmpty() && pq.peek() + 10 <= time)
                pq.poll();
            else
                answer++;
            
            pq.add(getTime(book_time[i][1]));
        }
        
        return answer;
    }
    
    public int getTime(String s) {
        return Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
    }
}