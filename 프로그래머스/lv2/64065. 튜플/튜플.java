import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<String> list = new ArrayList<>();
        String[] tmp = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(tmp, (s1, s2) -> s1.length() - s2.length());
        
        for(int i=0; i<tmp.length; i++) {
            for(String str : tmp[i].split(",")) {
                if(!list.contains(str))
                    list.add(str);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        return answer;
    }
}