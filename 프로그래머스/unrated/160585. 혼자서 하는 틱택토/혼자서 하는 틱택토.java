class Solution {
    public int solution(String[] board) {
        int[] cnt = new int[2];
        
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(board[i].charAt(j) == 'O')
                    cnt[0]++;
                else if(board[i].charAt(j) == 'X')
                    cnt[1]++;
        
        if(cnt[0] < cnt[1] || cnt[0] - cnt[1] > 1)
            return 0;
        
        if(win(board, 'O'))
            if(win(board, 'X'))
                return 0;
            else
                return cnt[0] - cnt[1] == 1 ? 1 : 0;
        
        if(win(board, 'X'))
            return cnt[0] - cnt[1] == 0 ? 1 : 0;
        
        return 1;
    }
    
    public boolean win(String[] board, char c) {
        for(int i=0; i<3; i++) {
            boolean flag = true;
            for(int j=0; j<3; j++)
                if(board[i].charAt(j) != c)
                    flag = false;
            if(flag)
                return true;
        }
        
        for(int i=0; i<3; i++) {
            boolean flag = true;
            for(int j=0; j<3; j++)
                if(board[j].charAt(i) != c)
                    flag = false;
            if(flag)
                return true;
        }
        
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c)
            return true;
        
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c)
            return true;
                
        return false;
    }
}