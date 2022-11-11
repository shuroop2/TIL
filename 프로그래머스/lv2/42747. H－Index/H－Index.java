import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++) {
            int cnt = 0;
            if(citations[i] == 0)
                continue;
            for(int j=i; j<citations.length; j++) {
                if(citations[i] <= citations[j])
                    cnt++;
            }
            if(citations[i] < cnt)
                cnt = citations[i];
            if(answer < cnt)
                answer = cnt;
        }
        
        return answer;
    }
}