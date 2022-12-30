class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n > s)
            return new int[]{-1};
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = s / n;
            n--;
            s -= answer[i];
        }
        
        return answer;
    }
}