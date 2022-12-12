import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1; i<=order.length; i++) {
            if(i != order[answer]) {
                stack.push(i);
                continue;
            }
            
            answer++;
            
            while(!stack.empty() && order[answer] == stack.peek()) {
                stack.pop();
                answer++;
            }
        }
        
        return answer;
    }
}