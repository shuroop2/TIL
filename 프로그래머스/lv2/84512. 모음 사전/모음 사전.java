import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] dif = {781, 156, 31, 6, 1};
        String[] arr = word.split("");
        answer += arr.length;
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("A", 0);
        map.put("E", 1);
        map.put("I", 2);
        map.put("O", 3);
        map.put("U", 4);

        for(int i=0, k=0; i<arr.length; i++)
            answer += dif[k++] * map.get(arr[i]);
        
        return answer;
    }
}