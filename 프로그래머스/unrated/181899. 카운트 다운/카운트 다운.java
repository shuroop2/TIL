class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[start - end + 1];
        for(int i=start, j=0; i>=end; i--)
            answer[j++] = i;
        return answer;
    }
}