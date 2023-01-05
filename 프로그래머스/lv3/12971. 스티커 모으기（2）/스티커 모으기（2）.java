class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int l = sticker.length;
        
        if(l == 1)
            return sticker[0];
        
        int[] dp = new int[l];
        
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for(int i=2; i<l-1; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        
        answer = dp[l - 2];
        
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i=2; i<l; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);

        return Math.max(answer, dp[l - 1]);
    }
}