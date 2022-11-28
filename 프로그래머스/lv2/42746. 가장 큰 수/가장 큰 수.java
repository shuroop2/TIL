import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] tmp = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++)
            tmp[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(tmp, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(tmp[0].equals("0"))
            return "0";
        
        for(int i=0; i<tmp.length; i++)
            answer += tmp[i];
        
        return answer;
    }
}