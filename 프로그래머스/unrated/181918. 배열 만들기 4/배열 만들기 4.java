import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length;) {
            if(list.isEmpty() || !list.isEmpty() && list.get(list.size() - 1) < arr[i])
                list.add(arr[i++]);
            else if(!list.isEmpty() && list.get(list.size() - 1) >= arr[i])
                list.remove(list.size() - 1);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}