import java.util.*;

class Solution {
    static int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];
        
        comb(users, emoticons, discount, 0);
        
        return answer;
    }
    
    public void comb(int[][] users, int[] emoticons, int[] discount, int start) {
        if(start == discount.length) {
            calc(users, emoticons, discount);
            return ;
        }
        
        for(int i=10; i<=40; i+=10) {
            discount[start] = i;
            comb(users, emoticons, discount, start + 1);
        }
    }
    
    public void calc(int[][] users, int[] emoticons, int[] discount) {
        int[] tmp = new int[2];
        
        for(int i=0; i<users.length; i++) {
            int sum = 0;
            
            for(int j=0; j<emoticons.length; j++)
                if(users[i][0] <= discount[j])
                    sum += emoticons[j] * (100 - discount[j]) / 100;
            
            if(sum >= users[i][1])
                tmp[0]++;
            else
                tmp[1] += sum;
        }
        
        if(tmp[0] > answer[0])
            answer = tmp;
        else if(tmp[0] == answer[0] && tmp[1] > answer[1])
            answer = tmp;
    }
}