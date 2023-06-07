import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = Stream.of(my_string.replaceAll("\\D", "").split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(answer);
        return answer;
    }
}