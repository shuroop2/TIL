class Solution {
    int solution(int[][] land) {
        int l = land.length;
        
        for(int i=1; i<l; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        
        return Math.max(Math.max(land[l-1][0], land[l-1][1]), Math.max(land[l-1][2], land[l-1][3]));
    }
}