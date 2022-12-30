class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int num = storey % 10;
            if(num > 5) {
                storey += 10;
                answer += 10 - num;
            } else if(num == 5) {
                if(storey / 10 % 10 >= 5) {
                    storey += 10;
                    answer += 10 - num;
                } else {
                    answer += num;
                }
            } else if(num != 0) {
                answer += num;
            }
            storey /= 10;
        }
        
        return answer;
    }
}