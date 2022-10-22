class Solution {
    public String solution(String s) {
        String answer = "";
        String[] tmp = s.toLowerCase().split("");
        int idx = 0;
        
        for(int i=0; i<tmp.length; i++) {
            if(tmp[i].equals(" "))
                idx = 0;
            else {
                if(idx % 2 == 0)
                    tmp[i] = tmp[i].toUpperCase();
                idx++;
            }
            answer += tmp[i];
        }
        return answer;
    }
}