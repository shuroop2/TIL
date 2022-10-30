class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        char[] tmp = dartResult.toCharArray();
        int idx = -1;
        
        for(int i=0; i<tmp.length; i++) {
            if(tmp[i] >= '0' && tmp[i] <= '9') {
                idx++;
                if(i+1 != tmp.length-1 && tmp[i] == '1' && tmp[i+1] == '0') {
                    score[idx] = 10;
                    i++;
                } else {
                    score[idx] += Integer.parseInt(String.valueOf(tmp[i]));
                }
            } else if(tmp[i] == 'D') {
                score[idx] *= score[idx];
            } else if(tmp[i] == 'T') {
                score[idx] *= score[idx] * score[idx];
            } else if(tmp[i] == '*') {
                if(idx > 0)
                    score[idx - 1] *= 2;
                score[idx] *= 2;
            } else if(tmp[i] == '#') {
                score[idx] *= -1;
            }
        }
        for(int i=0; i<3; i++) {
            answer += score[i];
        }
        return answer;
    }
}