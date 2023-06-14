import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] tmp = Arrays.stream(emergency).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        for(int i=0; i<tmp.length; i++) {
            for(int j=0; j<tmp.length; j++) {
                if(emergency[i] == tmp[j]) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}