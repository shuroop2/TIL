class Solution {
    public int solution(int balls, int share) {
        return comb(balls, share);
    }
    
    public static int comb(int n, int r) {
        if(n == r || r == 0)
            return 1;
        else
            return comb(n - 1, r - 1) + comb(n - 1, r);
    }
}