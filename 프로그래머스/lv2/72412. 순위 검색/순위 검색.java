import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i=0; i<info.length; i++)
            comb(info[i].split(" "), "", 0);
        
        for(String key : map.keySet())
            Collections.sort(map.get(key));
        
        for(int i=0; i<query.length; i++) {
            String[] arr = query[i].replace(" and ", "").split(" ");
            answer[i] = map.containsKey(arr[0]) ? binarySearch(arr[0], Integer.parseInt(arr[1])) : 0;
        }
        
        return answer;
    }
    
    public int binarySearch(String key, int score) {
        ArrayList<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(score > list.get(mid))
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return list.size() - start;
    }
    
    public void comb(String[] arr, String str, int cnt) {
        if(cnt == 4) {
            if(!map.containsKey(str)) {
                ArrayList<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(arr[4]));
            return;
        }
        comb(arr, str + "-", cnt + 1);
        comb(arr, str + arr[cnt], cnt + 1);
    }
}