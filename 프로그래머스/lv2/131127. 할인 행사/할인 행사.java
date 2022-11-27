import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        ArrayList<String> tmp = new ArrayList<>(Arrays.asList(want));
        int l = discount.length;
        
        for(int i=0; i<l; i++) {
            int[] buy = new int[number.length];
            for(int j=i; l-i<10 ? j<l : j<i+10; j++) {
                if(tmp.contains(discount[j])) {
                    buy[tmp.indexOf(discount[j])]++;
                }
            }
            if(Arrays.equals(buy, number))
                answer++;
        }
        
        return answer;
    }
}