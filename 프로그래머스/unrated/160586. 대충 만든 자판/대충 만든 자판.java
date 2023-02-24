import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for(String s : keymap)
            for(int i=0; i<s.length(); i++)
                map.put(s.charAt(i), Math.min(i + 1, map.getOrDefault(s.charAt(i), s.length())));
        
        for(int i=0; i<targets.length; i++) {
            for(int j=0; j<targets[i].length(); j++) {
                if(!map.containsKey(targets[i].charAt(j))) {
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += map.get(targets[i].charAt(j));
                }
            }
        }
        
        return answer;
    }
}