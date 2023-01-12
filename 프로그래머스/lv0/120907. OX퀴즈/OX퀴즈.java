class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length; i++) {
            String[] tmp = quiz[i].split(" ");
            if(tmp[1].equals("-"))
                answer[i] = Integer.parseInt(tmp[0]) - Integer.parseInt(tmp[2]) == Integer.parseInt(tmp[4]) ? "O" : "X";
            else if(tmp[1].equals("+"))
                answer[i] = Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[2]) == Integer.parseInt(tmp[4]) ? "O" : "X";
        }
        
        return answer;
    }
}