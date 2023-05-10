import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = Arrays.stream(myString.split("x"))
            .filter(s -> (s != null && s.length() > 0))
            .toArray(String[]::new);
        Arrays.sort(answer);
        return answer;
    }
}