class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        int max = Integer.MAX_VALUE;
        
        for(int i=x+1; i<y+1; i++) {
            int a = i / 2 > 0 && i % 2 == 0 && x <= i / 2 ? dp[i / 2] : max;
            int b = i / 3 > 0 && i % 3 == 0 && x <= i / 3 ? dp[i / 3] : max;
            int c = x <= i - n ? dp[i - n] : max;
            int d = Math.min(a, Math.min(b, c));
            dp[i] = d < max ? d + 1 : max;
        }
        
        return dp[y] < max ? dp[y] : -1;
    }
}