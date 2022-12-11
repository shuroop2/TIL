class Solution {
    public int solution(String s) {
        int l = s.length();
        int answer = l;
        
        for(int i=1; i<=l/2; i++) {
            int tmp = 0;
            
            for(int j=0; j+i<=l;) {
                int k = j + i, cnt = 1;
                String str = s.substring(j, j + i);
                
                while(k + i <= s.length() && str.equals(s.substring(k, k + i))) {
                    k += i;
                    cnt++;
                }
                
                if(cnt == 1)
                    tmp += i;
                else
                    tmp += i + String.valueOf(cnt).length();
                
                j = k;
            }
            if(l % i != 0)
                tmp += l % i;
            
            answer = Math.min(answer, tmp);
        }
        
        return answer;
    }
}