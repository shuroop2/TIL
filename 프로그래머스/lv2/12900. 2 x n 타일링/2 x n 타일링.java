class Solution {
    public int solution(int n) {
        int answer = 0;
        int num1 = 1, num2 = 2;

        for(int i=3; i<=n; i++) {
            answer = (num1 + num2) % 1000000007;
            num1 = num2;
            num2 = answer;
        }
        
        return answer;
    }
}