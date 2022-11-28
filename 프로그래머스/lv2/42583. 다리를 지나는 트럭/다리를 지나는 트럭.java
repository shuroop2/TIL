import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0, idx=0;
        Queue<Integer> q = new LinkedList<>();
        
        while(true) {
            if(idx == truck_weights.length)
                break;
            
            if(q.size() == bridge_length) {
                sum -= q.poll();                
            } else if(sum + truck_weights[idx] > weight) {
                q.add(0);
                answer++;           
            } else {
                q.add(truck_weights[idx]);
                sum += truck_weights[idx];
                answer++;
                idx++;
            }            
        }
        
        return answer + bridge_length;
    }
}