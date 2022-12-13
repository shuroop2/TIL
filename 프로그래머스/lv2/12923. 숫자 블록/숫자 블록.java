class Solution {
    public int[] solution(long begin, long end) {
        int b = (int) begin, e = (int) end;
        int[] answer = new int[e - b + 1];
        
        for(int i=0; i<answer.length; i++)
            answer[i] = prime(b++);

        return answer;
    }
    
    public int prime(int num) {
        if(num < 2)
            return 0;
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0 && num / i <= 10000000)
                return num / i;
        }
        
        return 1;
    }
}