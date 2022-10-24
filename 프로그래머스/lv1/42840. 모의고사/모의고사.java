class Solution {
    public int[] solution(int[] answers) {
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = {0, 0, 0};
        int result_cnt = 0;
        int max = 0;
        
        for(int i=0; i<answers.length; i++) {
            if(s1[i%s1.length] == answers[i])
                cnt[0]++;
            if(s2[i%s2.length] == answers[i])
                cnt[1]++;
            if(s3[i%s3.length] == answers[i])
                cnt[2]++;
        }
        
        for(int i=0; i<3; i++){
            if(max <= cnt[i])
                max = cnt[i];
        }

        for(int i=0; i<3; i++){
            if(max == cnt[i])
                result_cnt++;
        }

        int answer[] = new int[result_cnt];
        int tmp = 0;
        
        for(int i=0; i<3; i++){
            if(max == cnt[i])
                answer[tmp++]=i+1;
        }
        return answer;
    }
}