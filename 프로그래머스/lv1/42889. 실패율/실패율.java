import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] clear = new int[N];
        int[] total = new int[N];
        double[][] fail = new double[N][2];
        
        for(int i=0; i<stages.length; i++) {
            for(int j=1; j<=N; j++) {
                if(stages[i] > j)
                    clear[j-1]++;
                if(stages[i] >= j)
                    total[j-1]++;
            }
        }
        
        for(int i=0; i<N; i++) {
            fail[i][0] = i+1;
            fail[i][1] = (total[i] - clear[i]) / (double) total[i];
        }
        
        for(int i=0; i<fail.length; i++) {
            for(int j=i+1; j<fail.length; j++) {
                if(fail[i][1] < fail[j][1]) {
                    double[] tmp = fail[i];
                    fail[i] = fail[j];
                    fail[j] = tmp;
                }
                if(fail[i][1] == fail[j][1] && fail[i][0] > fail[j][0]) {
                    double[] tmp = fail[i];
                    fail[i] = fail[j];
                    fail[j] = tmp;
                }
            }
        }
        
        for(int i=0; i<N; i++) {
            answer[i] = (int) fail[i][0];
        }
        
        return answer;
    }
}