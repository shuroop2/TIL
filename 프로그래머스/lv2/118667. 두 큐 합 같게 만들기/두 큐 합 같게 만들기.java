import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        
        for(int i : queue1) {
            q1.add(i);
            sum1 += i;
        }
        
        for(int i : queue2) {
            q2.add(i);
            sum2 += i;
        }
        
        if((sum1 + sum2) % 2 == 1)
            return -1;
        
        long total = (sum1 + sum2) / 2;
        int cnt1 = 0, cnt2 = 0, limit = queue1.length * 2;
        
        while(cnt1 <= limit && cnt2 <= limit) {
            if(sum1 == total)
                return cnt1 + cnt2;
            
            if(sum1 > total) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
                cnt1++;
            } else {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
                cnt2++;
            }
        }
        
        return -1;
    }
}