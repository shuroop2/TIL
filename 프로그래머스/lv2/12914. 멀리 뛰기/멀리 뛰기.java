class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] tmp = new long[n];
        tmp[0] = 1;
        if(n > 1) {
            tmp[1] = 2;
            for(int i=2; i<n; i++) {
                tmp[i] = (tmp[i-2] + tmp[i-1]) % 1234567;
            }
        }
        answer = tmp[n-1];
        return answer;
    }
}