import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        int tmp = 0;
        for(int i=0; i<weights.length-1; i++) {
            if(i > 0 && weights[i] == weights[i - 1]) {
                tmp--;
                answer += tmp;
                continue;
            }
            tmp = 0;
            for(int j=search(weights, weights[i], i + 1); j>i; j--)
                if(weights[i] == weights[j] || weights[i] * 2 == weights[j] || weights[i] * 3 == weights[j] * 2 || weights[i] * 4 == weights[j] * 3)
                    tmp++;
            
            answer += tmp;
        }
        
        return answer;
    }
    
    public int search(int[] weights, int num, int i) {
        int left = i;
        int right = weights.length - 1;
        
        while(left < right) {
            int mid = (left + right) / 2;
            if(weights[mid] > num * 2)
                return mid;
            else
                left = mid + 1;
        }
        
        return left;
    }
}