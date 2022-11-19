import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] arr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        HashMap<String, Integer> map = new HashMap<>();
        int l = 27;
        
        for(int i=0; i<arr.length; i++)
            map.put(arr[i], i+1);
        
        for(int i=0; i<msg.length(); i++) {
            String str = "";
            while(i < msg.length() && map.containsKey(str + msg.charAt(i))) {
                str += msg.charAt(i);
                i++;
            }
            
            list.add(map.get(str));
            
            if(i < msg.length()) {
                map.put(str + msg.charAt(i), l++);
                i--;
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}