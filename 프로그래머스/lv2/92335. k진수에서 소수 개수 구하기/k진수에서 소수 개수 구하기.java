import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] nums = new StringBuffer(Integer.toString(n, k)).toString().split("0");
        
        for(String num : nums) {
            if(num.equals(""))
                continue;
            if(isPrime(Long.parseLong(num)))
                answer++;
        }
        return answer;
    }
    
    public boolean isPrime(long num) {
        if(num <= 1)
            return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}