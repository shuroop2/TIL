class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++) {
            if(my_string.charAt(i) >= 'a')
                answer += my_string.substring(i, i + 1).toUpperCase();
            else
                answer += my_string.substring(i, i + 1).toLowerCase();
        }
        return answer;
    }
}