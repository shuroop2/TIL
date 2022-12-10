import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<String> list = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for(int idx : course) {
            for(String order : orders)
                comb("", order, idx);
            
            if(!map.isEmpty()) {
                ArrayList<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);

                if(max > 1) {
                    for(String key : map.keySet()) {
                        if(map.get(key) == max)
                            list.add(key);
                    }
                }
                map.clear();
            }
        }
                
        Collections.sort(list);
        String[] answer = new String[list.size()];
        
        for(int i=0; i<answer.length; i++)
            answer[i] = list.get(i);

        return answer;

    }
    
    public void comb(String order, String s, int count) {
        if(count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        
        for(int i=0; i<s.length(); i++)
            comb(order + s.charAt(i), s.substring(i + 1), count - 1);
    }
}