class Solution {
    public long solution(int n) {
        int num = 1000000007;
        long[] tmp = new long[5000];
        tmp[0] = 1;
        tmp[2] = 3;
        
        for(int i=4; i<=n; i+=2)
            tmp[i] = (tmp[i - 2] * 4 % num - tmp[i - 4] % num + num) % num;
        
        return tmp[n];
    }
}