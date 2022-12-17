class Solution {
    public int solution(String s) {
        int answer = 0;
        
        while(s.length() != 0) {
            int cnt1 = 1, cnt2 = 0;
            answer++;
            for(int i=1; i<s.length(); i++) {
                if(s.charAt(i) == s.charAt(0))
                    cnt1++;
                else
                    cnt2++;
                if(cnt1 == cnt2)
                    break;
            }
            s = s.substring(cnt1 + cnt2);
        }   
        return answer;
    }
}