import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++) {
            answer[i] = -1;
            
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                answer[stack.pop()] = numbers[i];
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}