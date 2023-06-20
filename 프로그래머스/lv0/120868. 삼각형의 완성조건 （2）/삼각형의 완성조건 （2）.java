class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        for(int i=Math.abs(sides[0]-sides[1])+1; i<sides[0]+sides[1]; i++)
            if(i + Math.min(sides[0], sides[1]) > Math.max(sides[0], sides[1]) || sides[0] + sides[1] > i)
                answer++;
        return answer;
    }
}