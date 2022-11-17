import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(String s : record) {
            String[] tmp = s.split(" ");
            if(s.charAt(0) == 'E') {
                list.add(tmp[1]);
                list.add("님이 들어왔습니다.");
            } else if(s.charAt(0) == 'L') {
                list.add(tmp[1]);
                list.add("님이 나갔습니다.");
            }
        }
        
        for(String s : record) {
            if(s.charAt(0) == 'E' || s.charAt(0) == 'C') {
                String[] tmp = s.split(" ");
                map.put(tmp[1], tmp[2]);
            }
        }
        
        String[] answer = new String[list.size()/2];
        for(int i=0; i<list.size(); i+=2)
            answer[i/2] = map.get(list.get(i)) + list.get(i + 1);
        
        return answer;
    }
}