import java.util.*;

class Solution {
    public int solution(int n, long l, long r) {
        return (int) (getCnt(r) - getCnt(l - 1));
    }
    
    public long getCnt(long num) {
        int[] arr = {0, 1, 2, 2, 3, 4};
        
        if(num <= 5)
            return arr[(int) num];
        
        int i = 1;
        
        while(num > Math.pow(5, i + 1))
            i++;
        
        long quotient = num / (long) Math.pow(5, i);
        long remainder = num % (long) Math.pow(5, i);
        long cnt = quotient * (long) Math.pow(4, i);
        
        if(quotient >= 3)
            cnt -= Math.pow(4, i);

        if(quotient == 2)
            return cnt;
        else
            return cnt + getCnt(remainder);
    }
}