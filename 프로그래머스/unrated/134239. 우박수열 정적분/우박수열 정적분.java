class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        int cnt = count(k);
        double[] tmp = new double[cnt + 1];
        tmp[0] = k;
        double[] area = new double[tmp.length];
        double[] sum = new double[tmp.length];
        
        for(int i=1; i<tmp.length; i++)
            tmp[i] = collatz(tmp[i - 1]);
        
        for(int i=1; i<area.length; i++)
            area[i] = (tmp[i] + tmp[i - 1]) / 2;
        
        for(int i=1; i<sum.length; i++)
            sum[i] = area[i] + sum[i - 1];
        
        for(int i=0; i<ranges.length; i++) {
            int a = ranges[i][0];
            int b = cnt + ranges[i][1];
            
            if(a < b)
                answer[i] = sum[b] - sum[a];
            else if(a > b)
                answer[i] = -1;
            else
                answer[i] = 0;
        }
        
        return answer;
    }
    
    public int count(int num) {
        int cnt = 0;
        while (num > 1) {
            if(num % 2 == 0)
                num = num / 2;
            else
                num = (num * 3) + 1;
            cnt++;
        }
        return cnt;
    }
    
    public double collatz(double num) {
        if(num % 2 == 0)
            return num / 2;
        else
            return num * 3 + 1;
    }
}