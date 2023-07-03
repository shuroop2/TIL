class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int row = 0, col = 0, num = 1;

        for(int i=0; i<n; i++)
            answer[row][col++] = num++;

        col--;

        for(int i=n-1; i>=1; i--) {
            for(int j=1; j<=i; j++) {
                row = row + (i % 2 == n % 2 ? -1 : 1);
                answer[row][col] = num++;
            }

            for(int j=1; j<=i; j++) {
                col = col + (i % 2 == n % 2 ? 1 : -1);
                answer[row][col] = num++;
            }
        }
        
        return answer;
    }
}