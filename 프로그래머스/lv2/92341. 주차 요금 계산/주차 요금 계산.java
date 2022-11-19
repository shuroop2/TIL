import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> timeMap = new HashMap<>();
        HashMap<Integer, Integer> feeMap = new HashMap<>();
        
        for(String s : records) {
            int num = Integer.parseInt(s.substring(6, 10));
            int time = Integer.parseInt(s.substring(3, 5)) + Integer.parseInt(s.substring(0, 2)) * 60;
            
            if(s.substring(11, 13).equals("IN"))
                timeMap.put(num, time);
            else {
                feeMap.put(num, feeMap.getOrDefault(num, 0) + time - timeMap.get(num));
                timeMap.remove(num);
            }
        }
        
        for(int key : timeMap.keySet())
            feeMap.put(key, feeMap.getOrDefault(key, 0) + 23 * 60 + 59 - timeMap.get(key));
        
        for(int key : feeMap.keySet())
            pq.add(key);
        
        int[] answer = new int[feeMap.size()];
        for(int i=0; i<feeMap.size(); i++) {
            int time = feeMap.get(pq.poll()) - fees[0];
            if(time < 0)
                time = 0;
            answer[i] = fees[1] + (int) Math.ceil(time / (double) fees[2]) * fees[3];
        }
        
        return answer;
    }
}