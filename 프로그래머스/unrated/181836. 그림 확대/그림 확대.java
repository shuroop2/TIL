class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        for(int i=0; i<answer.length; i++) {
            answer[i] = "";
            for(int j=0; j<picture[0].length()*k; j++)
                answer[i] += picture[i / k].charAt(j / k) + "";
        }
        return answer;
    }
}