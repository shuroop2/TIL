import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        List<Double> list = new ArrayList<>();
        
        for(int i=0; i<dots.length; i++) {
            for(int j=i+1; j<dots.length; j++) {
                double tmp = (double) (dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]);
                
                if(list.contains(tmp))
                    return 1;
                else
                    list.add(tmp);
            }
        }
        
        return 0;
    }
}