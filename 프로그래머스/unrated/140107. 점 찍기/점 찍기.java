class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(long i=0; i<=d/k; i++) {
            long y = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i * k, 2)) / k;
            answer += 1 + y;
        }
        
        return answer;
    }
}