import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] tmp = my_string.toLowerCase().toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }
}