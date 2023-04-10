class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int p1 = 0, p2 = 0;
        int sum = sequence[0];
        if(sum == k)
            return answer;
        
        while(p1 < sequence.length - 1 && p2 < sequence.length - 1) {
            while(p2 <= sequence.length - 1 && sum < k)
                sum += sequence[++p2];
            while(p1 <= sequence.length - 1 && sum > k)
                sum -= sequence[p1++];
            
            while(sum == k) {
                if(answer[1] == 0)
                    answer = new int[]{p1, p2};
                else if(answer[1] - answer[0] > p2 - p1)
                    answer = new int[]{p1, p2};
                
                sum -= sequence[p1++];
            }
            if(answer[1] != 0 && answer[0] == answer[1])
                return answer;
        }
        
        return answer;
    }
}