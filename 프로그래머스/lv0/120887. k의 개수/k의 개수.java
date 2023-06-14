class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int l=i; l<=j; l++)
            answer += String.valueOf(l).chars().filter(c -> c == (char) ('0' + k)).count();
        return answer;
    }
}