import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++)
            answer[i] = check(places[i]);
        
        return answer;
    }
    
    public int check(String[] arr) {
        int result = 1;
        char[][] tmp = new char[7][7];
        
        for(int i=1; i<6; i++) {
            for(int j=1; j<6; j++)
                tmp[i][j] = arr[i - 1].charAt(j - 1);
        }
        
        for(int i=1; i<6; i++) {
            for(int j=1; j<6; j++) {
                if(tmp[i][j] == 'P') {
                    if(countP(tmp, i, j) != 0)
                        return 0;
                } else if(tmp[i][j] == 'O') {
                    if(countP(tmp, i, j) > 1)
                        return 0;
                }
            }
        }
        
        return result;
    }
    
    public int countP(char[][] tmp, int a, int b) {
        int cnt = 0;
        if(tmp[a + 1][b] == 'P')
            cnt++;
        if(tmp[a - 1][b] == 'P')
            cnt++;
        if(tmp[a][b + 1] == 'P')
            cnt++;
        if(tmp[a][b - 1] == 'P')
            cnt++;
        
        return cnt;
    }
}