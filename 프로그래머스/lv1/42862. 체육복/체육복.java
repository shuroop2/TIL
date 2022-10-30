import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        int[] lostArr = new int[lost.length];
        int[] reserveArr = new int[reserve.length];
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lostArr[i] = 1;
                    reserveArr[j] = 1;
                    answer++;
                    break;
                }
            }
        }
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                int gap = Math.abs(lost[i] - reserve[j]);
                if(gap == 1 && lostArr[i] == 0 && reserveArr[j] == 0){
                    answer++;
                    lostArr[i] = 1;
                    reserveArr[j] = 1;
                    break; 
                }             
            }
        }
        return answer;
    }
}