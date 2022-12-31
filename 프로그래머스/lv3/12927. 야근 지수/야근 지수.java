import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        works = Arrays.stream(works)
            .boxed().sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue).toArray();
        int cnt = 0;
        int sum = 0;
        
        for(int i : works)
            sum += i;
        if(sum < n)
            return 0;
        
        while(true) {
            for(int i=1; i<works.length; i++) {
                if(works[cnt] == works[i])
                    cnt = i;
            }
            
            if(cnt >= n)
                break;
            
            for(int i=0; i<=cnt; i++) {
                works[i]--;
                n--;
            }
        }
        
        for(int i=0; i<n; i++)
            works[i]--;
        
        for(int i=0; i<works.length; i++)
            answer += Math.pow(works[i], 2);

        return answer;
    }
}