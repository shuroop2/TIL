class Solution {
    public String solution(String p) {
        String answer = "";
        String u = "", v = "";
        int cnt = 0;
        
        if(p.equals(""))
            return "";
        
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(')
                cnt++;
            else
                cnt--;

            if(cnt == 0) {
                u = p.substring(0, i + 1);
                if(i != p.length() - 1)
                    v = p.substring(i + 1, p.length());
                break;
            }
        }
        
        if(check(u))
            return u + solution(v);
        else {
            answer += "(" + solution(v) + ")";
            String tmp = u.substring(1, u.length() - 1);
            for(char c : tmp.toCharArray()) {
                if(c == '(')
                    answer += ")";
                else
                    answer += "(";
            }
        }
        
        return answer;
    }
    
    public boolean check(String s) {
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '(')
                cnt++;
            else
                cnt--;
            
            if(cnt < 0)
                return false;
        }

        return cnt == 0;
    }
}