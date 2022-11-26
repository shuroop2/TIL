import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=1; i<=elements.length; i++) {
            int sum = 0;
            for(int j=0; j<elements.length; j++) {
                if(j == 0) {
                    for(int k=0; k<i; k++)
                        sum += elements[k];
                } else {
                    sum -= elements[j - 1];
                    sum += elements[(j + i - 1) % elements.length];
                }
                
                set.add(sum);
            }
        }
        
        return set.size();
    }
}