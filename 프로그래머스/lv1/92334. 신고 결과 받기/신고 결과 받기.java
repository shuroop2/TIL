import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++) {
			HashSet<String> set = new HashSet<>();
			map1.put(id_list[i], set);
			map2.put(id_list[i], 0);
		}
        
        for(String s : report) {
			String[] arr = s.split(" ");
			map1.get(arr[1]).add(arr[0]);
		}
        
        for(String s : map2.keySet()) {
			HashSet<String> keySet = map1.get(s);
			if(keySet.size() >= k) {
				for(String key : keySet)
                    map2.put(key, map2.get(key) + 1);
			}
		}
        
        for(int i=0; i<id_list.length; i++)
			answer[i] = map2.get(id_list[i]);
        
        return answer;
    }
}