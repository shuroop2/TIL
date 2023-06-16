import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.contains("Z")) {
            String[] tmp = s.split(" ");
            for(int i=0; i<tmp.length; i++) {
                if(tmp[i].matches("-?[0-9]+"))
                    answer += Integer.parseInt(tmp[i]);
                else
                    answer -= Integer.parseInt(tmp[i - 1]);
            }
        } else {
            return Arrays.stream(Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray()).sum();
        }
        return answer;
    }
}