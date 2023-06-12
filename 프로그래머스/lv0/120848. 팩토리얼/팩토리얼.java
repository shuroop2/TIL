class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i=0; i<11; i++) {
            answer = 1;
            for(int j=1; j<=i; j++) {
                answer *= j;
                if(answer * (j + 1) > n)
                    return j;
            }
        }
        
        return answer;
    }
}