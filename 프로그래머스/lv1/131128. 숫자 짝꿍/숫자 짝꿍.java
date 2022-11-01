import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        
        for(int i=0; i<X.length(); i++) {
            int index = X.charAt(i) - '0';
            arrX[index]++;
        }
        for(int i=0; i<Y.length(); i++) {
            int index = Y.charAt(i) - '0';
            arrY[index]++;
        }
        for(int i=arrX.length-1; i>=0; i--) {
            while(arrX[i] >= 1 && arrY[i] >= 1) {
                arrX[i]--;
                arrY[i]--;
                answer.append(i);
            }
        }
        if(answer.toString().equals(""))
            return "-1";
        else if(answer.toString().charAt(0) == '0')
            return "0";
        
        return answer.toString();
    }
}