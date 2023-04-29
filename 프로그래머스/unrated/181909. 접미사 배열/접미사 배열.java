import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        int l = my_string.length();
        String[] answer = new String[l];
        for(int i=1; i<=l; i++)
            answer[i - 1] = my_string.substring(l - i, l);
        Arrays.sort(answer);
        return answer;
    }
}