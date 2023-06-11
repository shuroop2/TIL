class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] tmp = letter.split(" ");
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(int i=0; i<tmp.length; i++)
            for(int j=0; j<morse.length; j++)
                if(tmp[i].equals(morse[j]))
                    answer += (char) ('a' + j);
        return answer;
    }
}