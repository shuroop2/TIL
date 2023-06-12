import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] tmp1 = before.toCharArray();
        char[] tmp2 = after.toCharArray();
        Arrays.sort(tmp1);
        Arrays.sort(tmp2);
        
        return Arrays.equals(tmp1, tmp2) ? 1 : 0;
    }
}