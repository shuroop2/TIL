import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        for(int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            if(s.chars().filter(c -> c == tmp).count() == 1)
                answer += s.charAt(i) + "";
        }
        char[] tmp = answer.toCharArray();
        Arrays.sort(tmp);
        return String.valueOf(tmp);
    }
}