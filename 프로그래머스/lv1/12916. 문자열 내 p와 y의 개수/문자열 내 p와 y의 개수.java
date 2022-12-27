class Solution {
    boolean solution(String s) {
        int cnt1 = 0, cnt2 = 0;
        s = s.toLowerCase();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'p')
                cnt1++;
            else if(s.charAt(i) == 'y')
                cnt2++;
        }

        return cnt1 == cnt2;
    }
}