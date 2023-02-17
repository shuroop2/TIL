import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> q2 = new LinkedList<>(Arrays.asList(cards2));
        
        for(int i=0; i<goal.length; i++) {
            if(goal[i].equals(q1.peek()))
                q1.poll();
            else if (goal[i].equals(q2.peek()))
                q2.poll();
            else
                return "No";
        }
        
        return "Yes";
    }
}