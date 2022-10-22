class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += " ";
                continue;
            }
            char tmp = s.charAt(i);
            int num;
            if(Character.isUpperCase(tmp)) {
                num = tmp + n;
                if(num > 90)
                    num = 64 + num - 90;
            } else {
                num = tmp + n;
                if(num > 122)
                    num = 96 + num - 122;
            }
            answer += Character.toString((char)num);
        }
        return answer;
    }
}