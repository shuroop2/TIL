class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] tmp = new int[number];
        
        for(int i=1; i<=number; i++)
            tmp[i-1] = countDivisors(i);
        
        for(int i : tmp) {
            if(i > limit)
                answer += power;
            else
                answer += i;
        }
                
        return answer;
    }
    
    static int countDivisors(int n) {
        int cnt = 0;
        
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n % i == 0) {
                if(n / i == i)
                    cnt++;
                else 
                    cnt += 2;
            }
        }
        
        return cnt;
    }
}