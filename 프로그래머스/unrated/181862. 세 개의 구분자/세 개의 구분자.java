import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        if(myStr.replaceAll("[abc]", "").length() == 0)
            return new String[]{"EMPTY"};
        return Arrays.stream(myStr.split("[abc]"))
            .filter(s -> (s != null && s.length() > 0))
            .toArray(String[]::new);
    }
}