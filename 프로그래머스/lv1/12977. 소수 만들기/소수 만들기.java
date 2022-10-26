class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    int cnt = 0;
                    int sum = nums[i] + nums[j] + nums[k];
                    for(int l=1; l<=sum; l++) {
                        if(sum%l == 0)
                            cnt++;
                    }
                    
                    if(cnt == 2)
                        answer++;
                }
            }
        }
        

        return answer;
    }
}