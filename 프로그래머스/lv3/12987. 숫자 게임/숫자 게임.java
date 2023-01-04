import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        List<Integer> listA = Arrays.stream(A).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(B).boxed().collect(Collectors.toList());
        
        for(int i=0; i<listA.size(); i++) {
            for(int j=0; j<listB.size();) {
                if(listA.get(i) < listB.get(j)) {
                    answer++;
                    listA.remove(i);
                    listB.remove(j);
                } else {
                    j++;
                }
            }
        }
        
        return answer;
    }
}