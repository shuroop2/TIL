class Solution {
    public String solution(String code) {
        String answer = "";
        boolean mode = false;
        for(int i=0; i<code.length(); i++) {
            if(code.charAt(i) != '1' && i % 2 == solv(mode))
                answer += code.charAt(i) + "";
            else if(code.charAt(i) == '1')
                mode = !mode;
        }
        return answer.length() == 0 ? "EMPTY" : answer;
    }
    
    public static int solv(boolean flag) {
        return flag ? 1 : 0;
    }
}