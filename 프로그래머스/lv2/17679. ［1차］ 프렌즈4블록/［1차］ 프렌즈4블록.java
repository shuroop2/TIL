import java.util.*;

class Solution {
    static int answer = 0;
    static char[][] arr;
    public int solution(int m, int n, String[] board) {
        arr = new char[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++)
                arr[i][j] = board[i].charAt(j);
        }
        
        while(update(m, n));
        
        return answer;
    }
    
    public boolean update(int m, int n) {
        boolean[][] b = new boolean[m][n];
        int cnt = 0;
        
        for(int i=0; i<m-1; i++) {
            for(int j=0; j<n-1; j++) {
                if(arr[i][j] == '0')
                    continue;
                if(check(i, j) == true) {
					b[i][j] = true;
                    b[i][j+1] = true;
					b[i+1][j] = true;
                    b[i+1][j+1] = true;
				}
            }
        }
        
        for(int i=0; i<n; i++) {
			List<Character> tmp = new ArrayList<>();
			for(int j=m-1; j>=0; j--) {
				if(b[j][i] == true) {
					cnt++;
					continue;
				}
				tmp.add(arr[j][i]);
			}
			
			for(int j=m-1, k=0; j>=0; j--, k++) {
				if(k < tmp.size())
                    arr[j][i] = tmp.get(k);
				else
                    arr[j][i] = '0';
			}
		}
        answer += cnt;
		return cnt > 0 ? true : false;
    }
    
    public boolean check(int i, int j) {
        char tmp = arr[i][j];
        
        if(arr[i][j+1] == tmp && arr[i+1][j] == tmp && arr[i+1][j+1] == tmp)
            return true;
        else
            return false;
    }
}