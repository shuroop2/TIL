class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board.length; j++)
                if(board[i][j] == 1)
                    check(j, i, board);
        
        for(int[] arr : board)
            for(int i : arr)
                if(i == 0)
                    answer++;
        
        return answer;
    }
    
    public void check(int column, int row, int[][] board) {
        for(int i=row-1; i<=row+1; i++)
            if(i >= 0 && i < board.length)
                for(int j=column-1; j<=column+1; j++)
                    if(j >= 0 && j < board.length)
                        if(board[i][j] != 1)
                            board[i][j] = 2;
    }
}