import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        for(int i=0; i<query.length; i++) {
            if(i % 2 == 0) {
                while(list.size() > query[i] + 1) {
                    list.remove(query[i] + 1);
                }
            } else {
                for(int j=0; j<query[i]; j++)
                    list.remove(0);
            }
        }
            
        return list.stream().mapToInt(i -> i).toArray();
    }
}