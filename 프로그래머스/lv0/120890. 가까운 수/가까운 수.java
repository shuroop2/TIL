import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0, min = 999;
        Arrays.sort(array);
        for(int i : array) {
            if(Math.abs(i - n) < min) {
                min = Math.abs(i - n);
                answer = i;
            }
        }
        return answer;
    }
}