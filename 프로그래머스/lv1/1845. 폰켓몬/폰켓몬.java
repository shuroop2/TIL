import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int tmp = nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        
        if(set.size() < tmp)
            answer = set.size();
        else
            answer = tmp;
        
        return answer;
    }
}