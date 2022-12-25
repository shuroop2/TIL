import java.util.*;

class Solution {
    public String solution(String s) {
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        
        return new StringBuilder(new String(tmp)).reverse().toString();
    }
}