class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String tmp = "";
        int num = 0;
        
        while(tmp.length() < m * t)
            tmp += Integer.toString(num++, n);

        for(int i=p-1; i<m*t; i+=m)
            answer += tmp.charAt(i);

        return answer.toUpperCase();
    }
}