import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for(int i=l; i<=r; i++) {
            boolean flag = true;
            String tmp = String.valueOf(i);
            for(int j=0; j<tmp.length(); j++) {
                if(tmp.charAt(j) != '0' && tmp.charAt(j) != '5') {
                    flag = false;
                    break;
                }
            }
            if(flag) list.add(i);
        }
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(i -> i).toArray();
    }
}