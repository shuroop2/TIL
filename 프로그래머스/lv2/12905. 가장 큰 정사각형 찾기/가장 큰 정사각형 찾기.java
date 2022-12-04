class Solution {
    public int solution(int[][] board) {
        int[][] tmp = new int[board.length + 1][board[0].length + 1];
        int max = 0;
        
        for(int i=1; i<=board.length; i++) {
	        for(int j=1; j<=board[0].length; j++) {
		        if(board[i-1][j-1] != 0) {
			        int min = Math.min(tmp[i - 1][j], Math.min(tmp[i][j - 1], tmp[i - 1][j - 1]));
			        tmp[i][j] = min + 1;
			        max = Math.max(max, min + 1);
		        }
	        }
        }

        return max * max;
    }
}