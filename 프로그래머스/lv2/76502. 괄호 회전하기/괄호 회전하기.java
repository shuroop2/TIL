import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String tmp = s;
        for(int i=0; i<s.length(); i++) {
            if(check(tmp))
                answer++;
            tmp = tmp.substring(1, s.length()) + tmp.charAt(0);
        }
        
        return answer;
    }
    
    public boolean check(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if(s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else if(s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else if(s.charAt(i) == ')') {
                if(stack.empty())
                    return false;
                if(stack.peek() != '(')
                    return false;
                stack.pop();
            } else if(s.charAt(i) == ']') {
                if(stack.empty())
                    return false;
                if(stack.peek() != '[')
                    return false;
                stack.pop();
            } else if(s.charAt(i) == '}') {
                if(stack.empty())
                    return false;
                if(stack.peek() != '{')
                    return false;
                stack.pop();
            }  
        }
        if(!stack.empty())
            return false;
        
        return true;
    }
}