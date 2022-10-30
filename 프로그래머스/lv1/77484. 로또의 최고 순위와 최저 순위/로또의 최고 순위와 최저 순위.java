class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zero = 0;
        int[] result = {6, 6, 5, 4, 3, 2, 1};

        for(int i=0; i<6; i++) {
            if(lottos[i] == 0)
                zero++;
            for(int j=0; j<6; j++) {
                if(lottos[i] == win_nums[j])
                    cnt++;
            }
        }

        answer[0] = result[zero+cnt];
        answer[1] = result[cnt];
        return answer;
    }
}