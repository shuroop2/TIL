import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<intStrs.length; i++)
            if(Integer.parseInt(intStrs[i].substring(s, s + l)) > k )
                list.add(Integer.parseInt(intStrs[i].substring(s, s + l)));
        return list.stream().mapToInt(i -> i).toArray();
    }
}